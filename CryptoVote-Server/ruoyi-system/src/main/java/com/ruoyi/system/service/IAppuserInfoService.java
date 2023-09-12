package com.ruoyi.system.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.AppZixun;
import com.ruoyi.system.domain.AppuserInfo;

/**
 * 用户管理Service接口
 * 
 * @author ruoyi
 * @date 2023-04-13
 */
public interface IAppuserInfoService 
{
    int selectappuser(AppuserInfo appuserInfo);

    int countappuser(String  userphone);

    int insertzixunInfo(AppZixun appZixun);

    Map<String ,Object> findappuser(String user_id);

    Map<String ,Object> zixun_info_map(String zixun_id);

    List<Map<String ,Object>> selectfirstinfo();




    /**
     * 查询用户管理
     * 
     * @param userId 用户管理主键
     * @return 用户管理
     */
    public AppuserInfo selectAppuserInfoByUserId(Long userId);

    /**
     * 查询用户管理列表
     * 
     * @param appuserInfo 用户管理
     * @return 用户管理集合
     */
    public List<AppuserInfo> selectAppuserInfoList(AppuserInfo appuserInfo);

    /**
     * 新增用户管理
     * 
     * @param appuserInfo 用户管理
     * @return 结果
     */
    public int insertAppuserInfo(AppuserInfo appuserInfo);

    /**
     * 修改用户管理
     * 
     * @param appuserInfo 用户管理
     * @return 结果
     */
    public int updateAppuserInfo(AppuserInfo appuserInfo);

    /**
     * 批量删除用户管理
     * 
     * @param userIds 需要删除的用户管理主键集合
     * @return 结果
     */
    public int deleteAppuserInfoByUserIds(String userIds);

    /**
     * 删除用户管理信息
     * 
     * @param userId 用户管理主键
     * @return 结果
     */
    public int deleteAppuserInfoByUserId(Long userId);
}
