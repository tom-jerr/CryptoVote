package com.ruoyi.system.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.AppHxpeople;
import com.ruoyi.system.domain.AppRoom;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * 房间大厅Service接口
 * 
 * @author ChrisGai
 * @date 2023-05-11
 */
public interface IAppRoomService 
{

    List<Map<String,Object>> showtpulist(String room_id);

    int addtoupiao(String tp_user_id,String hx_people_id,String room_id);

    int addhxpeople(AppHxpeople appHxpeople);

    String roomidbyhx_peopleid(String id);



    /**
     * 查询房间大厅
     * 
     * @param roomId 房间大厅主键
     * @return 房间大厅
     */
    public AppRoom selectAppRoomByRoomId(Long roomId);

    /**
     * 查询房间大厅列表
     * 
     * @param appRoom 房间大厅
     * @return 房间大厅集合
     */
    public List<AppRoom> selectAppRoomList(AppRoom appRoom);

    /**
     * 新增房间大厅
     * 
     * @param appRoom 房间大厅
     * @return 结果
     */
    public int insertAppRoom(AppRoom appRoom);

    int updatehxpeople(AppHxpeople appHxpeople);

    public int selectcountroomtitle(String room_title);

    String selectroomid(String room_title);

    int countroompass(String room_id, String room_pass);

    List<Map<String,Object>> hxpeoplelist(String room_id);
    List<String> hxpeoplename(String room_id);
    String ticketscount(String room_id);
    List<Map<String,Object>> resultlist(String room_id, String n);
    String hxpeopleticketnum(String id);

    /**
     * 修改房间大厅
     * 
     * @param appRoom 房间大厅
     * @return 结果
     */
    public int updateAppRoom(AppRoom appRoom);

    /**
     * 批量删除房间大厅
     * 
     * @param roomIds 需要删除的房间大厅主键集合
     * @return 结果
     */
    public int deleteAppRoomByRoomIds(String roomIds);

    /**
     * 删除房间大厅信息
     * 
     * @param roomId 房间大厅主键
     * @return 结果
     */
    public int deleteAppRoomByRoomId(Long roomId);

    Map<String ,Object> selectroomMap(String room_id);


    List<Map<String, Object>> introlist(String room_id);
}
