package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.AppZixun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AppuserInfoMapper;
import com.ruoyi.system.domain.AppuserInfo;
import com.ruoyi.system.service.IAppuserInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-13
 */
@Service
public class AppuserInfoServiceImpl implements IAppuserInfoService
{
    @Autowired
    private AppuserInfoMapper appuserInfoMapper;

    @Override
    public int selectappuser(AppuserInfo appuserInfo) {
        return appuserInfoMapper.selectappuser(appuserInfo);
    }

    @Override
    public int countappuser(String userphone) {
        return appuserInfoMapper.countappuser(userphone);
    }

    @Override
    public int insertzixunInfo(AppZixun appZixun) {
        return appuserInfoMapper.insertzixunInfo(appZixun);
    }

    @Override
    public Map<String, Object> findappuser(String user_id) {
        return appuserInfoMapper.findappuser(user_id);
    }

    @Override
    public Map<String, Object> zixun_info_map(String zixun_id) {
        return appuserInfoMapper.zixun_info_map(zixun_id);
    }

    @Override
    public List<Map<String, Object>> selectfirstinfo() {
        return appuserInfoMapper.selectfirstinfo();
    }

    /**
     * 查询用户管理
     * 
     * @param userId 用户管理主键
     * @return 用户管理
     */
    @Override
    public AppuserInfo selectAppuserInfoByUserId(Long userId)
    {
        return appuserInfoMapper.selectAppuserInfoByUserId(userId);
    }

    /**
     * 查询用户管理列表
     * 
     * @param appuserInfo 用户管理
     * @return 用户管理
     */
    @Override
    public List<AppuserInfo> selectAppuserInfoList(AppuserInfo appuserInfo)
    {
        return appuserInfoMapper.selectAppuserInfoList(appuserInfo);
    }

    /**
     * 新增用户管理
     * 
     * @param appuserInfo 用户管理
     * @return 结果
     */
    @Override
    public int insertAppuserInfo(AppuserInfo appuserInfo)
    {
        return appuserInfoMapper.insertAppuserInfo(appuserInfo);
    }

    /**
     * 修改用户管理
     * 
     * @param appuserInfo 用户管理
     * @return 结果
     */
    @Override
    public int updateAppuserInfo(AppuserInfo appuserInfo)
    {
        return appuserInfoMapper.updateAppuserInfo(appuserInfo);
    }

    /**
     * 批量删除用户管理
     * 
     * @param userIds 需要删除的用户管理主键
     * @return 结果
     */
    @Override
    public int deleteAppuserInfoByUserIds(String userIds)
    {
        return appuserInfoMapper.deleteAppuserInfoByUserIds(Convert.toStrArray(userIds));
    }

    /**
     * 删除用户管理信息
     * 
     * @param userId 用户管理主键
     * @return 结果
     */
    @Override
    public int deleteAppuserInfoByUserId(Long userId)
    {
        return appuserInfoMapper.deleteAppuserInfoByUserId(userId);
    }
}
