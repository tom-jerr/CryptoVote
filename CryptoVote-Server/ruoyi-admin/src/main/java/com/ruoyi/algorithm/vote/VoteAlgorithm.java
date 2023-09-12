package com.ruoyi.algorithm.vote;

import com.ruoyi.common.utils.KamUtil;
import com.ruoyi.system.domain.AppHxpeople;
import com.ruoyi.system.service.IAppRoomService;
import org.springframework.beans.factory.annotation.Autowired;

public class VoteAlgorithm {
    public VoteAlgorithm(IAppRoomService appRoomService) {
        this.appRoomService = appRoomService;
    }

    @Autowired
    private IAppRoomService appRoomService;
    public String addtoupiao(String tp_user_id, String hx_people_id, AppHxpeople appHxpeople) {
        try {
            //给多人投票
            if (hx_people_id.contains(",")) {
                String hxid[] = hx_people_id.split(",");
                for (int i = 0; i < hxid.length; i++) {
                    //根据候选人id查找房间id
                    String room_id = appRoomService.roomidbyhx_peopleid(hxid[i]);

                    int flag = appRoomService.addtoupiao(tp_user_id,hxid[i],room_id);
                    if (flag > 0) {
                        //投票后加票
                        String hx_num = appRoomService.hxpeopleticketnum(hxid[i]);
                        int h_num = Integer.parseInt(hx_num);
                        int s = h_num+1;
                        String ansnum = s+"";
                        appHxpeople.setHx_num_piao(ansnum);
                        appHxpeople.setId(hxid[i]);
                        appRoomService.updatehxpeople(appHxpeople);
                        System.out.println("success one~");
                    }
                }return KamUtil.returnSuccess();
            }else{

                //根据候选人id查找房间id
                String room_id = appRoomService.roomidbyhx_peopleid(hx_people_id);

                int flag = appRoomService.addtoupiao(tp_user_id,hx_people_id,room_id);
                if (flag > 0) {
                    //投票后加票
                    String hx_num = appRoomService.hxpeopleticketnum(hx_people_id);
                    int h_num = Integer.parseInt(hx_num);
                    int s = h_num+1;
                    String ansnum = s+"";
                    appHxpeople.setHx_num_piao(ansnum);
                    appHxpeople.setId(hx_people_id);
                    appRoomService.updatehxpeople(appHxpeople);
                    return KamUtil.returnSuccess();
                }
            }

            return KamUtil.returnError();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return KamUtil.returnError();
    }
}
