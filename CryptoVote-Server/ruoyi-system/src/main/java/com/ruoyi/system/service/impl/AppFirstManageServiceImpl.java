package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AppFirstManageMapper;
import com.ruoyi.system.domain.AppFirstManage;
import com.ruoyi.system.service.IAppFirstManageService;
import com.ruoyi.common.core.text.Convert;

/**
 * 首页管理Service业务层处理
 * 
 * @author chris
 * @date 2023-04-13
 */
@Service
public class AppFirstManageServiceImpl implements IAppFirstManageService 
{
    @Autowired
    private AppFirstManageMapper appFirstManageMapper;

    /**
     * 查询首页管理
     * 
     * @param newsId 首页管理主键
     * @return 首页管理
     */
    @Override
    public AppFirstManage selectAppFirstManageByNewsId(Long newsId)
    {
        return appFirstManageMapper.selectAppFirstManageByNewsId(newsId);
    }

    @Override
    public List<Map<String, Object>> selectpictureurl() {
        return appFirstManageMapper.selectpictureurl();
    }

    @Override
    public String selectshztcount(String user_id) {
        return appFirstManageMapper.selectshztcount(user_id);
    }

    /**
     * 查询首页管理列表
     * 
     * @param appFirstManage 首页管理
     * @return 首页管理
     */
    @Override
    public List<AppFirstManage> selectAppFirstManageList(AppFirstManage appFirstManage)
    {
        return appFirstManageMapper.selectAppFirstManageList(appFirstManage);
    }

    /**
     * 新增首页管理
     * 
     * @param appFirstManage 首页管理
     * @return 结果
     */
    @Override
    public int insertAppFirstManage(AppFirstManage appFirstManage)
    {
        return appFirstManageMapper.insertAppFirstManage(appFirstManage);
    }

    /**
     * 修改首页管理
     * 
     * @param appFirstManage 首页管理
     * @return 结果
     */
    @Override
    public int updateAppFirstManage(AppFirstManage appFirstManage)
    {
        return appFirstManageMapper.updateAppFirstManage(appFirstManage);
    }

    /**
     * 批量删除首页管理
     * 
     * @param newsIds 需要删除的首页管理主键
     * @return 结果
     */
    @Override
    public int deleteAppFirstManageByNewsIds(String newsIds)
    {
        return appFirstManageMapper.deleteAppFirstManageByNewsIds(Convert.toStrArray(newsIds));
    }

    /**
     * 删除首页管理信息
     * 
     * @param newsId 首页管理主键
     * @return 结果
     */
    @Override
    public int deleteAppFirstManageByNewsId(Long newsId)
    {
        return appFirstManageMapper.deleteAppFirstManageByNewsId(newsId);
    }
}
