package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AppShenhe;

/**
 * 报名审核Service接口
 * 
 * @author chris
 * @date 2023-04-13
 */
public interface IAppShenheService 
{
    /**
     * 查询报名审核
     * 
     * @param id 报名审核主键
     * @return 报名审核
     */
    public AppShenhe selectAppShenheById(Long id);

    /**
     * 查询报名审核列表
     * 
     * @param appShenhe 报名审核
     * @return 报名审核集合
     */
    public List<AppShenhe> selectAppShenheList(AppShenhe appShenhe);

    /**
     * 新增报名审核
     * 
     * @param appShenhe 报名审核
     * @return 结果
     */
    public int insertAppShenhe(AppShenhe appShenhe);

    int countbmsh(String user_id);

    /**
     * 修改报名审核
     * 
     * @param appShenhe 报名审核
     * @return 结果
     */
    public int updateAppShenhe(AppShenhe appShenhe);

    /**
     * 批量删除报名审核
     * 
     * @param ids 需要删除的报名审核主键集合
     * @return 结果
     */
    public int deleteAppShenheByIds(String ids);

    /**
     * 删除报名审核信息
     * 
     * @param id 报名审核主键
     * @return 结果
     */
    public int deleteAppShenheById(Long id);
}
