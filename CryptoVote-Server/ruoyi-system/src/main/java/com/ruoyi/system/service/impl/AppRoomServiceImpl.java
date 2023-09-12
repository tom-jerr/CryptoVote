package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.AppHxpeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AppRoomMapper;
import com.ruoyi.system.domain.AppRoom;
import com.ruoyi.system.service.IAppRoomService;
import com.ruoyi.common.core.text.Convert;

/**
 * 房间大厅Service业务层处理
 * 
 * @author ChrisGai
 * @date 2023-05-11
 */
@Service
public class AppRoomServiceImpl implements IAppRoomService 
{
    @Autowired
    private AppRoomMapper appRoomMapper;

    @Override
    public List<Map<String, Object>> showtpulist(String room_id) {
        return appRoomMapper.showtpulist(room_id);
    }

    @Override
    public int addtoupiao(String tp_user_id, String hx_people_id,String room_id) {
        return appRoomMapper.addtoupiao(tp_user_id,hx_people_id,room_id);
    }

    @Override
    public int addhxpeople(AppHxpeople appHxpeople) {
        return appRoomMapper.addhxpeople(appHxpeople);
    }

    @Override
    public String roomidbyhx_peopleid(String id) {
        return appRoomMapper.roomidbyhx_peopleid(id);
    }

    /**
     * 查询房间大厅
     * 
     * @param roomId 房间大厅主键
     * @return 房间大厅
     */
    @Override
    public AppRoom selectAppRoomByRoomId(Long roomId)
    {
        return appRoomMapper.selectAppRoomByRoomId(roomId);
    }

    /**
     * 查询房间大厅列表
     * 
     * @param appRoom 房间大厅
     * @return 房间大厅
     */
    @Override
    public List<AppRoom> selectAppRoomList(AppRoom appRoom)
    {
        return appRoomMapper.selectAppRoomList(appRoom);
    }

    /**
     * 新增房间大厅
     * 
     * @param appRoom 房间大厅
     * @return 结果
     */
    @Override
    public int insertAppRoom(AppRoom appRoom)
    {
        return appRoomMapper.insertAppRoom(appRoom);
    }

    @Override
    public int updatehxpeople(AppHxpeople appHxpeople) {
        return appRoomMapper.updatehxpeople(appHxpeople);
    }

    @Override
    public int selectcountroomtitle(String room_title) {
        return appRoomMapper.selectcountroomtitle(room_title);
    }

    @Override
    public String selectroomid(String room_title) {
        return appRoomMapper.selectroomid(room_title);
    }

    @Override
    public int countroompass(String room_id, String room_pass) {
        return appRoomMapper.countroompass(room_id,room_pass);
    }

    @Override
    public List<Map<String, Object>> hxpeoplelist(String room_id) {
        return appRoomMapper.hxpeoplelist( room_id);
    }

    @Override
    public List<String> hxpeoplename(String room_id) {
        return appRoomMapper.hxnamelist(room_id);
    }

    @Override
    public String ticketscount(String room_id) {
        return appRoomMapper.ticketscount(room_id);
    }

    @Override
    public List<Map<String, Object>> resultlist(String room_id, String n) {
        return appRoomMapper.resultlist(room_id, n);
    }

    @Override
    public String hxpeopleticketnum(String id) {
        return appRoomMapper.hxpeopleticketnum(id);
    }

    /**
     * 修改房间大厅
     * 
     * @param appRoom 房间大厅
     * @return 结果
     */
    @Override
    public int updateAppRoom(AppRoom appRoom)
    {
        return appRoomMapper.updateAppRoom(appRoom);
    }

    /**
     * 批量删除房间大厅
     * 
     * @param roomIds 需要删除的房间大厅主键
     * @return 结果
     */
    @Override
    public int deleteAppRoomByRoomIds(String roomIds)
    {
        return appRoomMapper.deleteAppRoomByRoomIds(Convert.toStrArray(roomIds));
    }

    /**
     * 删除房间大厅信息
     * 
     * @param roomId 房间大厅主键
     * @return 结果
     */
    @Override
    public int deleteAppRoomByRoomId(Long roomId)
    {
        return appRoomMapper.deleteAppRoomByRoomId(roomId);
    }

    @Override
    public Map<String, Object> selectroomMap(String room_id) {
        return appRoomMapper.selectroomMap(room_id);
    }

    @Override
    public List<Map<String, Object>> introlist(String room_id) {
        return appRoomMapper.introlist(room_id);
    }
}
