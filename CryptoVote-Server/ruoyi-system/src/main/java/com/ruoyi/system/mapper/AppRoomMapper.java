package com.ruoyi.system.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.AppHxpeople;
import com.ruoyi.system.domain.AppRoom;
import com.ruoyi.system.domain.AppTpeople;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 房间大厅Mapper接口
 * 
 * @author ChrisGai
 * @date 2023-05-11
 */
@Mapper
public interface AppRoomMapper 
{

    int addtoupiao(@Param("tp_user_id") String tp_user_id,@Param("hx_people_id") String hx_people_id,@Param("room_id") String room_id);

    int addhxpeople(AppHxpeople appHxpeople);

    int updatehxpeople(AppHxpeople appHxpeople);
    /**
     * 查询房间大厅
     * 
     * @param roomId 房间大厅主键
     * @return 房间大厅
     */
    public AppRoom selectAppRoomByRoomId(Long roomId);

    List<Map<String,Object>> hxpeoplelist(String room_id);
    List<String> hxnamelist(String room_id);
    List<Map<String,Object>> introlist(String room_id);
    String ticketscount(String room_id);
    List<Map<String,Object>> resultlist(@Param("room_id") String room_id, @Param("n") String n);

    List<Map<String,Object>> showtpulist(String room_id);

    String roomidbyhx_peopleid(String id);

    String hxpeopleticketnum(String id);


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

    int countroompass(@Param("roomId") String roomId,@Param("roomPass") String roomPass);

    public int selectcountroomtitle(@Param("room_title") String room_title);

    String selectroomid(String room_title);

    /**
     * 修改房间大厅
     * 
     * @param appRoom 房间大厅
     * @return 结果
     */
    public int updateAppRoom(AppRoom appRoom);

    /**
     * 删除房间大厅
     * 
     * @param roomId 房间大厅主键
     * @return 结果
     */
    public int deleteAppRoomByRoomId(Long roomId);

    /**
     * 批量删除房间大厅
     * 
     * @param roomIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppRoomByRoomIds(String[] roomIds);

    Map<String ,Object> selectroomMap(String room_id);
}
