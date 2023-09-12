package com.ruoyi.system.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.AppFirstManage;

/**
 * 首页管理Service接口
 * 
 * @author chris
 * @date 2023-04-13
 */
public interface IAppFirstManageService 
{
    /**
     * 查询首页管理
     * 
     * @param newsId 首页管理主键
     * @return 首页管理
     */
    public AppFirstManage selectAppFirstManageByNewsId(Long newsId);

    List<Map<String ,Object>> selectpictureurl();

    String selectshztcount(String user_id);

    /**
     * 查询首页管理列表
     * 
     * @param appFirstManage 首页管理
     * @return 首页管理集合
     */
    public List<AppFirstManage> selectAppFirstManageList(AppFirstManage appFirstManage);

    /**
     * 新增首页管理
     * 
     * @param appFirstManage 首页管理
     * @return 结果
     */
    public int insertAppFirstManage(AppFirstManage appFirstManage);

    /**
     * 修改首页管理
     * 
     * @param appFirstManage 首页管理
     * @return 结果
     */
    public int updateAppFirstManage(AppFirstManage appFirstManage);

    /**
     * 批量删除首页管理
     * 
     * @param newsIds 需要删除的首页管理主键集合
     * @return 结果
     */
    public int deleteAppFirstManageByNewsIds(String newsIds);

    /**
     * 删除首页管理信息
     * 
     * @param newsId 首页管理主键
     * @return 结果
     */
    public int deleteAppFirstManageByNewsId(Long newsId);
}
