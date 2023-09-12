package com.ruoyi.web.controller.system;


import java.math.BigInteger;
import java.util.*;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ruoyi.algorithm.BloomFilterXor.BloomFilterXor;
import com.ruoyi.algorithm.HashFuncDeserializer;
import com.ruoyi.algorithm.JsonCompression;
import com.ruoyi.algorithm.Paillier;
import com.ruoyi.algorithm.SBTandSEP.SBT_receive;
import com.ruoyi.algorithm.SBTandSEP.SBT_send;
import com.ruoyi.algorithm.SBTandSEP.SEP_receive;
import com.ruoyi.algorithm.SBTandSEP.SEP_send;

import com.ruoyi.algorithm.hash.HashFunc;

import com.ruoyi.algorithm.vote.VoteAlgorithm;
import com.ruoyi.common.utils.KamUtil;
import com.ruoyi.system.domain.AppHxpeople;

import io.swagger.models.auth.In;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.AppRoom;
import com.ruoyi.system.service.IAppRoomService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 房间大厅Controller
 * 
 * @author ChrisGai
 * @date 2023-05-11
 */
@Controller
@RequestMapping("/system/room")
public class AppRoomController extends BaseController
{
    private final String prefix = "system/room";

    @Autowired
    private IAppRoomService appRoomService;
    // 存放所有用户的GBF
    //TODO:将filters放入数据库，否则重启服务器，数据均丢失
    static Map<String, List<BloomFilterXor>> filters = new HashMap<>();


    @RequiresPermissions("system:room:view")
    @GetMapping()
    public String room()
    {
        return prefix + "/room";
    }

    // 结束投票时调用
    @PostMapping("/SEP")
    @ResponseBody
    public String SEP(String room_id) throws Exception {
        List<String> namelist = appRoomService.hxpeoplename(room_id);
        if(filters == null) {
            return KamUtil.returnError("GBF丢失");
        }
        int n = filters.get(room_id).size();            // 投票人人数
        int m = namelist.size();                        // 候选人人数
        int SIZE = 100;                                 // 布隆过滤器的装载大小

        BigInteger[][] retelement = new BigInteger[m][n];       // 根据候选人字符串hash去得到加密后的结果
        int i1 = 0, j1 = 0;
        for(String name:namelist) {
            for(BloomFilterXor filter:filters.get(room_id)) {
                retelement[i1][j1] = filter.retElement(name);
                j1 += 1;
            }
            i1 += 1;
            j1 = 0;
        }
        Paillier p = new Paillier();
        // SEP使用的值
        // 使用的哈希函数的个数
        BigInteger K = new BigInteger("3");
        SEP_send[][] sends = new SEP_send[m][n];

        for(int i = 0; i < m;++i) {
            for(int j = 0; j < n; ++j) {
                sends[i][j] = new SEP_send(K,p.Encryption(BigInteger.ONE),retelement[i][j]);
            }
        }

        BigInteger[][][] integers = new BigInteger[m][n][];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                integers[i][j] = sends[i][j].calculate_2xita();
            }
        }

        // SEP接收端
        SEP_receive[][] receives = new SEP_receive[m][n];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n;++j) {
                receives[i][j] = new SEP_receive(integers[i][j]);
            }
        }
        BigInteger[][][] emius = new BigInteger[m][n][SIZE];
        for(int i = 0; i < m;++i) {
            for(int j = 0; j < n;++j) {
                emius[i][j] = receives[i][j].calculate();
            }
        }

        BigInteger[][] results = new BigInteger[m][n];
        for(int i = 0; i <m;++i) {
            for(int j = 0; j <n;++j) {
                results[i][j] = sends[i][j].calculate_result(emius[i][j]);
            }
        }

        // 每个候选人的票数(m个候选者)
        BigInteger[] totals = new BigInteger[m];
        for(int i =0; i < m;++i) {
            totals[i] = p.Encryption(BigInteger.ZERO);
        }
        for(int i =0; i < m;++i) {
            for(int j =0 ; j < n;++j) {
                totals[i] = p.cipher_add(totals[i], results[i][j]);
            }
        }
        // DEBUG
        for(BigInteger total:totals) {
            System.out.println(p.Decryption(total).toString());
        }

        /*
         *  安全比较协议
         */
        SBT_send[] sbtSends = new SBT_send[m];
        BigInteger[] exitas = new BigInteger[m];
        SBT_receive[] sbtReceives = new SBT_receive[m];
        BigInteger[] sep_emius = new BigInteger[m];
        // 半数票数
        BigInteger flag = p.Encryption(new BigInteger(String.valueOf((n+1)/2)));

        for(int i = 0; i < m; ++i) {
            sbtSends[i] = new SBT_send(K,flag, totals[i]);
        }
        BigInteger[] finalres = new BigInteger[m];
        List<Integer> deletename = new ArrayList<>();
        for(int i = 0; i < m; ++i) {
            exitas[i] = sbtSends[i].calculate();
            sbtReceives[i] = new SBT_receive(exitas[i]);
            sep_emius[i] = sbtReceives[i].calculate();
            finalres[i] = sbtSends[i].calculate_result(sep_emius[i]);
            System.out.println("是否超过半数票数:\t" +(finalres[i].toString().equals("1")));
            if(!finalres[i].toString().equals("1")) {
                deletename.add(i);
            }
        }
        // 删掉该候选者姓名
        for(Integer i : deletename) {
            namelist.remove(i);
        }
        List<Map<String, Object>> resultlist = appRoomService.hxpeoplelist(room_id);
        List<Integer> deletenum = new ArrayList<>();
        for(int i = 0; i < resultlist.size();++i) {
            boolean delete = true;
            Object name = resultlist.get(i).get("hx_name");
            for(String names : namelist) {
                if(name.equals(names))
                {
                    delete = false;
                    break;
                }
            }
            if(delete) {
                deletenum.add(i);
            }
        }
        for(Integer i : deletenum) {
            resultlist.remove(i);
        }
        System.out.println(resultlist);
        return KamUtil.returnSuccess(resultlist);
    }

    // 个人投票时调用
    @PostMapping("/GBF")
    @ResponseBody
    public String GBF(String stream, String room_id) throws Exception {

        String json = JsonCompression.decompress(stream);
        Gson gson2 = new GsonBuilder()
                .serializeNulls()
                .registerTypeAdapter(HashFunc.class, new HashFuncDeserializer())
                .create();
        System.out.println(json);
        BloomFilterXor newfilter = gson2.fromJson(json, BloomFilterXor.class);
        if(newfilter == null) {
            return KamUtil.returnError();
        }
        if(newfilter != null) {
          if(filters.get(room_id) == null) {
              List<BloomFilterXor> filter = new ArrayList<>();
              filter.add(newfilter);
              filters.put(room_id, filter);
          }  else {
              filters.get(room_id).add(newfilter);
          }

          return KamUtil.returnSuccess("success send!");
        }
        return KamUtil.returnError();
    }

    // 创建房间
    @PostMapping("/addroom")
    @ResponseBody
    public String addRoom(AppRoom appRoom)
    {
        try {
            String romtitle = appRoom.getRoomTitle();
            int flag_rt = appRoomService.selectcountroomtitle(romtitle);
            if (flag_rt > 0) {
                return KamUtil.returnError("此房间名称以创建");
            }
            int flag = appRoomService.insertAppRoom(appRoom);

            if (flag>0){
                String roomid = appRoomService.selectroomid(romtitle);
                return KamUtil.returnSuccess(roomid);
            }
            return KamUtil.returnError();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return KamUtil.returnError();
    }



    /**
     * 加入房间
     * @param roomId
     * @return
     */
    @PostMapping("/addinroom")
    @ResponseBody
    public String addinroom(String roomId, String roomPass)
    {
        try {
            int flag = appRoomService.countroompass(roomId,roomPass);
            if (flag > 0) {
                Map<String ,Object> map = appRoomService.selectroomMap(roomId);
                return KamUtil.returnSuccess(map);
            }
            return KamUtil.returnError();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return KamUtil.returnError();
    }

    /**
     * 房间列表
     * @param appRoom
     * @return
     */
    @PostMapping("/roomlist")
    @ResponseBody
    public String roomlist(AppRoom appRoom)
    {
        try {
            List<AppRoom> list = appRoomService.selectAppRoomList(appRoom);

            return KamUtil.returnSuccess(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return KamUtil.returnError();
    }


    /**
     * 候选人列表
     * @param
     * @return
     */
    @PostMapping("/hxpeoplelist")
    @ResponseBody
    public String hxpeoplelist(String room_id)
    {
        try {
            List<Map<String,Object>> list = appRoomService.hxpeoplelist(room_id);

            return KamUtil.returnSuccess(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return KamUtil.returnError();
    }

    //添加候选人
    @PostMapping("/addhxpeople")
    @ResponseBody
    public String addhxpeople(AppHxpeople appHxpeople)
    {
        try {
            appHxpeople.setHx_num_piao("0");
            int flag = appRoomService.addhxpeople(appHxpeople);
            if (flag > 0) {
                return KamUtil.returnSuccess();
            }
            return KamUtil.returnError();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return KamUtil.returnError();
    }

    //投票
    @PostMapping("/addtoupiao")
    @ResponseBody
    public String addtoupiao(String tp_user_id,String hx_people_id,AppHxpeople appHxpeople)
    {
        VoteAlgorithm ptr = new VoteAlgorithm(appRoomService);
        return ptr.addtoupiao(tp_user_id, hx_people_id, appHxpeople);
    }

    @PostMapping("/introlist")
    @ResponseBody
    public String introlist(String room_id) {
        List<Map<String, Object>> resultlist = appRoomService.introlist(room_id);
        if(resultlist.size()>0) {
            return KamUtil.returnSuccess(resultlist);
        }
        return KamUtil.returnError();
    }

    @PostMapping("/resultlist")
    @ResponseBody
    public String resultlist(String room_id) {
        try {
            String val = appRoomService.ticketscount(room_id);

            String n = String.valueOf((Integer.parseInt(val) + 1)/2);
            List<Map<String, Object>> resultlist = appRoomService.resultlist(room_id, n);
            if (resultlist.size() >= 0) {
                return KamUtil.returnSuccess(resultlist);
            }
            return KamUtil.returnError();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return KamUtil.returnError();
    }
    //投票人列表
    @PostMapping("/showtpulist")
    @ResponseBody
    public String showtpulist(String room_id)
    {
        try {

            List<Map<String,Object>> list = appRoomService.showtpulist(room_id);
            if (list.size() > 0) {
                return KamUtil.returnSuccess(list);
            }
            return KamUtil.returnError();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return KamUtil.returnError();
    }

    //修改房间状态
    @PostMapping("/updateroom")
    @ResponseBody
    public String updateroom(AppRoom appRoom)
    {
        try{

            int flag = appRoomService.updateAppRoom(appRoom);
            if (flag > 0) {
                return KamUtil.returnSuccess();
            }

        }catch (Exception e){
            e.printStackTrace();
            return KamUtil.returnError();
        }

        return KamUtil.returnError();
    }



    /**
     * 查询房间大厅列表
     */
    @RequiresPermissions("system:room:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AppRoom appRoom)
    {
        startPage();
        List<AppRoom> list = appRoomService.selectAppRoomList(appRoom);
        return getDataTable(list);
    }

    /**
     * 导出房间大厅列表
     */
    @RequiresPermissions("system:room:export")
    @Log(title = "房间大厅", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AppRoom appRoom)
    {
        List<AppRoom> list = appRoomService.selectAppRoomList(appRoom);
        ExcelUtil<AppRoom> util = new ExcelUtil<AppRoom>(AppRoom.class);
        return util.exportExcel(list, "房间大厅数据");
    }

    /**
     * 新增房间大厅
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存房间大厅
     */
    @RequiresPermissions("system:room:add")
    @Log(title = "房间大厅", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AppRoom appRoom)
    {
        return toAjax(appRoomService.insertAppRoom(appRoom));
    }

    /**
     * 修改房间大厅
     */
    @RequiresPermissions("system:room:edit")
    @GetMapping("/edit/{roomId}")
    public String edit(@PathVariable("roomId") Long roomId, ModelMap mmap)
    {
        AppRoom appRoom = appRoomService.selectAppRoomByRoomId(roomId);
        mmap.put("appRoom", appRoom);
        return prefix + "/edit";
    }

    /**
     * 修改保存房间大厅
     */
    @RequiresPermissions("system:room:edit")
    @Log(title = "房间大厅", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AppRoom appRoom)
    {
        return toAjax(appRoomService.updateAppRoom(appRoom));
    }

    /**
     * 删除房间大厅
     */
//    @RequiresPermissions("system:room:remove")
    @Log(title = "房间大厅", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(appRoomService.deleteAppRoomByRoomIds(ids));
    }
}
