package com.ruoyi.web.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.KamUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.AppShenhe;
import com.ruoyi.system.domain.AppZixun;
import com.ruoyi.system.domain.AppuserInfo;
import com.ruoyi.system.service.IAppShenheService;
import com.ruoyi.system.service.IAppZixunService;
import com.ruoyi.system.service.IAppuserInfoService;
import org.apache.shiro.authc.AuthenticationException;
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
import com.ruoyi.system.domain.AppFirstManage;
import com.ruoyi.system.service.IAppFirstManageService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 首页管理Controller
 * 
 * @author chris
 * @date 2023-04-13
 */
@Controller
@RequestMapping("/system/manage")
public class AppFirstManageController extends BaseController
{
    private String prefix = "system/manage";

    @Autowired
    private IAppFirstManageService appFirstManageService;

    @Autowired
    private IAppShenheService appShenheService;


    @Autowired
    private IAppuserInfoService appuserInfoService;


    @Autowired
    private IAppZixunService appZixunService;



    /**
     * 添加评论
     */
    @ResponseBody
    @RequestMapping(value = "/updatedianzan", produces = "text/html;charset=UTF-8")
    public String updateDianzan(AppZixun appZixun){

        try {
            int flag = appZixunService.updateDianzan(appZixun);
            if (flag > 0) {
                return KamUtil.returnSuccess();
            }
            return KamUtil.returnError();
        } catch (Exception e) {
            e.printStackTrace();
            return KamUtil.returnError();
        }
    }


    /**
     * 查看评论
     */
    @ResponseBody
    @RequestMapping(value = "/selectcommentinfo", produces = "text/html;charset=UTF-8")
    public String selectcommentinfo(String  zixun_id){

        try {
            List<Map<String ,Object>> list = appZixunService.selectcommentinfo(zixun_id);

            return KamUtil.returnSuccess(list);

        } catch (Exception e) {
            e.printStackTrace();
            return KamUtil.returnError();
        }
    }


    /**
     * 添加评论
     */
    @ResponseBody
    @RequestMapping(value = "/insertComment", produces = "text/html;charset=UTF-8")
    public String insertComment(AppZixun appZixun){

        try {
            int flag = appZixunService.insertComment(appZixun);
            if (flag > 0) {
                return KamUtil.returnSuccess();
            }
            return KamUtil.returnError();
        } catch (Exception e) {
            e.printStackTrace();
            return KamUtil.returnError();
        }
    }


    /**
     * 删除我得咨询
     */
    @ResponseBody
    @RequestMapping(value = "/deleteappzixun", produces = "text/html;charset=UTF-8")
    public String deleteAppZixunByZixunId(String zixun_id,Long zixunId){
        zixunId = Long.parseLong(zixun_id);
        try {
            int flag = appZixunService.deleteAppZixunByZixunId(zixunId);
            if (flag > 0) {
                return KamUtil.returnSuccess();
            }
            return KamUtil.returnError();
        } catch (Exception e) {
            e.printStackTrace();
            return KamUtil.returnError();
        }
    }



    /**
     * 轮播图
     */
    @ResponseBody
    @RequestMapping(value = "/selectpictureurl", produces = "text/html;charset=UTF-8")
    public String selectpictureurl(){

        try {
            List<Map<String ,Object>> list = appFirstManageService.selectpictureurl();
            return KamUtil.returnSuccess(list);
        } catch (Exception e) {
            e.printStackTrace();
            return KamUtil.returnError();
        }
    }


    /**
     * 审核状态
     */
    @ResponseBody
    @RequestMapping(value = "/selectshztcount", produces = "text/html;charset=UTF-8")
    public String selectshztcount(String user_id){
        if (StringUtils.isEmpty(user_id)) {
            return KamUtil.returnError("user_id 不能为空");
        }
        try {
            String type = appFirstManageService.selectshztcount(user_id);
            if (type.equals("1")) {
                return KamUtil.returnSuccess("审核通过");
            }
            return KamUtil.returnSuccess("待审核");
        } catch (Exception e) {
            e.printStackTrace();
            return KamUtil.returnError();
        }
    }


    /**
     * app登录
     */
    @PostMapping("/loginapp")
    @ResponseBody
    public String ajaxLoginapp(AppuserInfo appuserInfo)
    {
        System.out.println("123");
        try
        {
            if (StringUtils.isEmpty(appuserInfo.getUserphone())) {
                return KamUtil.returnError("手机号不能为空");
            }
            if(StringUtils.isEmpty(appuserInfo.getPassword())){
                return KamUtil.returnError("密码不能为空");
            }
            int flag = appuserInfoService.selectappuser(appuserInfo);

            List<AppuserInfo> userinfo = appuserInfoService.selectAppuserInfoList(appuserInfo);
            userinfo.get(0).getUserId();

            if (flag > 0) {
                Map<String, Object> map = new HashMap<>();
                map.put("user_id",userinfo.get(0).getUserId());
                return KamUtil.returnSuccess(map);
            }

            return KamUtil.returnError();
        }
        catch (AuthenticationException e)
        {
            e.printStackTrace();
            return KamUtil.returnError();
        }
    }

    /**
     * 查询
     */
    @ResponseBody
    @RequestMapping(value = "/seletcinfo", produces = "text/html;charset=UTF-8")
    public String seletcInfo(String user_id){

        if (StringUtils.isEmpty(user_id)) {
            return KamUtil.returnParamError("user_id 不能为空!");
        }
        try {

            Map<String ,Object> map = appuserInfoService.findappuser(user_id);

            return KamUtil.returnSuccess(map);
        } catch (Exception e) {
            e.printStackTrace();
            return KamUtil.returnError();
        }

    }

    /**
     * 修改用户管理
     */
    @ResponseBody
    @RequestMapping("/updateappuser")
    public String editapp( AppuserInfo appuserInfo)
    {
        if (StringUtils.isEmpty(appuserInfo.getUser_id().toString())) {
            return KamUtil.returnParamError("user_id 不能为空!");
        }
        appuserInfo.setUserId(appuserInfo.getUser_id());
        int flag = appuserInfoService.updateAppuserInfo(appuserInfo);
        if (flag>0) {

            Map<String ,Object> map = appuserInfoService.findappuser(appuserInfo.getUser_id().toString());
            return KamUtil.returnSuccess(map);

        }return KamUtil.returnError();
    }


    /**
     * 注册用户
     */
    @ResponseBody
    @RequestMapping("/appregdituser")
    public String regdit( AppuserInfo appuserInfo)
    {
        if (StringUtils.isEmpty(appuserInfo.getUserphone())) {
            return KamUtil.returnParamError("userphone 不能为空!");
        }
        if (StringUtils.isEmpty(appuserInfo.getPassword())) {
            return KamUtil.returnParamError("passowrd 不能为空!");
        }
        int cflag = appuserInfoService.countappuser(appuserInfo.getUserphone());
        if (cflag > 0) {
            return KamUtil.returnError("此号已注册～");
        }
        try {
            int flag = appuserInfoService.insertAppuserInfo(appuserInfo);
            if (flag > 0) {
                Thread.sleep(300);
                List<AppuserInfo> userinfo = appuserInfoService.selectAppuserInfoList(appuserInfo);
                userinfo.get(0).getUserId();
                Map<String, Object> map = new HashMap<>();
                map.put("user_id",userinfo.get(0).getUserId());
                return KamUtil.returnSuccess(map);
            }

        }catch (Exception e){
            e.printStackTrace();
            return KamUtil.returnError();
        }
        return KamUtil.returnError();
    }





    /**
     * 查询首页
     */
    @ResponseBody
    @RequestMapping(value = "/selectfirstinfo", produces = "text/html;charset=UTF-8")
    public String selectfirstinfo(){

        try {
            List<Map<String ,Object>> list = appuserInfoService.selectfirstinfo();
            return KamUtil.returnSuccess(list);
        } catch (Exception e) {
            e.printStackTrace();
            return KamUtil.returnError();
        }
    }



    /**
     * 查询咨询
     */
    @ResponseBody
    @RequestMapping(value = "/selectzixunxinfo", produces = "text/html;charset=UTF-8")
    public String selectzixunxinfo(AppZixun appZixun){

        try {
            List<Map<String ,Object>> list = appZixunService.selectAppZixunListapp(appZixun);
//            List<Map<String ,Object>> list = appuserInfoService.selectfirstinfo();
            return KamUtil.returnSuccess(list);
        } catch (Exception e) {
            e.printStackTrace();
            return KamUtil.returnError();
        }
    }


    /**
     * 咨询详情
     */
    @ResponseBody
    @RequestMapping(value = "/zixun_info_map", produces = "text/html;charset=UTF-8")
    public String zixun_info_map(String  zixun_id){

        try {
                Map<String ,Object> map = appuserInfoService.zixun_info_map(zixun_id);
            return KamUtil.returnSuccess(map);
        } catch (Exception e) {
            e.printStackTrace();
            return KamUtil.returnError();
        }
    }

    /**
     * 发布咨询
     */
    @ResponseBody
    @RequestMapping(value = "/insertzixunInfo", produces = "text/html;charset=UTF-8")
    public String insertzixunInfo(AppZixun appZixun){

        try {
            int flag = appuserInfoService.insertzixunInfo(appZixun);
            if (flag > 0) {
                Thread.sleep(300);
                List<Map<String ,Object>> map = appZixunService.selectAppZixunListapp(appZixun);
                return KamUtil.returnSuccess(map);
            }
            return KamUtil.returnError();
        } catch (Exception e) {
            e.printStackTrace();
            return KamUtil.returnError();
        }
    }




    /**
     * 报名审核
     */
    @ResponseBody
    @RequestMapping(value = "/insertAppShenhe", produces = "text/html;charset=UTF-8")
    public String  insertAppShenhe(AppShenhe appShenhe,String user_id)
    {
        appShenhe.setUserId(user_id);
        if (StringUtils.isEmpty(appShenhe.getUserId())) {
            return KamUtil.returnParamError("user_id 不能为空!");
        }

        int flagc =appShenheService.countbmsh(user_id);
        if (flagc > 0) {
            return KamUtil.returnError("已报名");
        }
        try {

            int flag = appShenheService.insertAppShenhe(appShenhe);
            if (flag > 0) {
                return KamUtil.returnSuccess();
            }
            return KamUtil.returnError();
        }catch (Exception e){
            e.printStackTrace();
            return KamUtil.returnError();
        }
    }





















    @RequiresPermissions("system:manage:view")
    @GetMapping()
    public String manage()
    {
        return prefix + "/manage";
    }

    /**
     * 查询首页管理列表
     */
    @RequiresPermissions("system:manage:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AppFirstManage appFirstManage)
    {
        startPage();
        List<AppFirstManage> list = appFirstManageService.selectAppFirstManageList(appFirstManage);
        return getDataTable(list);
    }

    /**
     * 导出首页管理列表
     */
    @RequiresPermissions("system:manage:export")
    @Log(title = "首页管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AppFirstManage appFirstManage)
    {
        List<AppFirstManage> list = appFirstManageService.selectAppFirstManageList(appFirstManage);
        ExcelUtil<AppFirstManage> util = new ExcelUtil<AppFirstManage>(AppFirstManage.class);
        return util.exportExcel(list, "首页管理数据");
    }

    /**
     * 新增首页管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存首页管理
     */
    @RequiresPermissions("system:manage:add")
    @Log(title = "首页管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AppFirstManage appFirstManage)
    {
        return toAjax(appFirstManageService.insertAppFirstManage(appFirstManage));
    }

    /**
     * 修改首页管理
     */
    @RequiresPermissions("system:manage:edit")
    @GetMapping("/edit/{newsId}")
    public String edit(@PathVariable("newsId") Long newsId, ModelMap mmap)
    {
        AppFirstManage appFirstManage = appFirstManageService.selectAppFirstManageByNewsId(newsId);
        mmap.put("appFirstManage", appFirstManage);
        return prefix + "/edit";
    }

    /**
     * 修改保存首页管理
     */
    @RequiresPermissions("system:manage:edit")
    @Log(title = "首页管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AppFirstManage appFirstManage)
    {
        return toAjax(appFirstManageService.updateAppFirstManage(appFirstManage));
    }

    /**
     * 删除首页管理
     */
    @RequiresPermissions("system:manage:remove")
    @Log(title = "首页管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(appFirstManageService.deleteAppFirstManageByNewsIds(ids));
    }





}
