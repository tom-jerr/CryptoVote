package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AppZixunMapper;
import com.ruoyi.system.domain.AppZixun;
import com.ruoyi.system.service.IAppZixunService;
import com.ruoyi.common.core.text.Convert;

/**
 * 咨询管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-13
 */
@Service
public class AppZixunServiceImpl implements IAppZixunService 
{
    @Autowired
    private AppZixunMapper appZixunMapper;

    @Override
    public int updateDianzan(AppZixun appZixun) {
        return appZixunMapper.updateDianzan(appZixun);
    }

    /**
     * 查询咨询管理
     * 
     * @param zixunId 咨询管理主键
     * @return 咨询管理
     */
    @Override
    public AppZixun selectAppZixunByZixunId(Long zixunId)
    {
        return appZixunMapper.selectAppZixunByZixunId(zixunId);
    }

    /**
     * 查询咨询管理列表
     * 
     * @param appZixun 咨询管理
     * @return 咨询管理
     */
    @Override
    public List<AppZixun> selectAppZixunList(AppZixun appZixun)
    {
        return appZixunMapper.selectAppZixunList(appZixun);
    }

    @Override
    public List<Map<String ,Object>> selectAppZixunListapp(AppZixun appZixun) {
        return appZixunMapper.selectAppZixunListapp(appZixun);
    }

    @Override
    public List<Map<String, Object>> selectcommentinfo(String zixun_id) {
        return appZixunMapper.selectcommentinfo(zixun_id);
    }

    /**
     * 新增咨询管理
     * 
     * @param appZixun 咨询管理
     * @return 结果
     */
    @Override
    public int insertAppZixun(AppZixun appZixun)
    {
        return appZixunMapper.insertAppZixun(appZixun);
    }

    @Override
    public int insertComment(AppZixun appZixun) {
        return appZixunMapper.insertComment(appZixun);
    }

    /**
     * 修改咨询管理
     * 
     * @param appZixun 咨询管理
     * @return 结果
     */
    @Override
    public int updateAppZixun(AppZixun appZixun)
    {
        return appZixunMapper.updateAppZixun(appZixun);
    }

    /**
     * 批量删除咨询管理
     * 
     * @param zixunIds 需要删除的咨询管理主键
     * @return 结果
     */
    @Override
    public int deleteAppZixunByZixunIds(String zixunIds)
    {
        return appZixunMapper.deleteAppZixunByZixunIds(Convert.toStrArray(zixunIds));
    }

    /**
     * 删除咨询管理信息
     * 
     * @param zixunId 咨询管理主键
     * @return 结果
     */
    @Override
    public int deleteAppZixunByZixunId(Long zixunId)
    {
        return appZixunMapper.deleteAppZixunByZixunId(zixunId);
    }
}
