package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AppShenheMapper;
import com.ruoyi.system.domain.AppShenhe;
import com.ruoyi.system.service.IAppShenheService;
import com.ruoyi.common.core.text.Convert;

/**
 * 报名审核Service业务层处理
 * 
 * @author chris
 * @date 2023-04-13
 */
@Service
public class AppShenheServiceImpl implements IAppShenheService 
{
    @Autowired
    private AppShenheMapper appShenheMapper;

    /**
     * 查询报名审核
     * 
     * @param id 报名审核主键
     * @return 报名审核
     */
    @Override
    public AppShenhe selectAppShenheById(Long id)
    {
        return appShenheMapper.selectAppShenheById(id);
    }

    /**
     * 查询报名审核列表
     * 
     * @param appShenhe 报名审核
     * @return 报名审核
     */
    @Override
    public List<AppShenhe> selectAppShenheList(AppShenhe appShenhe)
    {
        return appShenheMapper.selectAppShenheList(appShenhe);
    }

    /**
     * 新增报名审核
     * 
     * @param appShenhe 报名审核
     * @return 结果
     */
    @Override
    public int insertAppShenhe(AppShenhe appShenhe)
    {
        return appShenheMapper.insertAppShenhe(appShenhe);
    }

    @Override
    public int countbmsh(String user_id) {
        return appShenheMapper.countbmsh(user_id);
    }

    /**
     * 修改报名审核
     * 
     * @param appShenhe 报名审核
     * @return 结果
     */
    @Override
    public int updateAppShenhe(AppShenhe appShenhe)
    {
        return appShenheMapper.updateAppShenhe(appShenhe);
    }

    /**
     * 批量删除报名审核
     * 
     * @param ids 需要删除的报名审核主键
     * @return 结果
     */
    @Override
    public int deleteAppShenheByIds(String ids)
    {
        return appShenheMapper.deleteAppShenheByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除报名审核信息
     * 
     * @param id 报名审核主键
     * @return 结果
     */
    @Override
    public int deleteAppShenheById(Long id)
    {
        return appShenheMapper.deleteAppShenheById(id);
    }
}
