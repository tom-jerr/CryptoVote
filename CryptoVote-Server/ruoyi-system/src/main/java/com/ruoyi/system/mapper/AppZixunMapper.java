package com.ruoyi.system.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.AppZixun;

/**
 * 咨询管理Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-13
 */
public interface AppZixunMapper 
{
    /**
     * 查询咨询管理
     * 
     * @param zixunId 咨询管理主键
     * @return 咨询管理
     */
    public AppZixun selectAppZixunByZixunId(Long zixunId);

    /**
     * 查询咨询管理列表
     * 
     * @param appZixun 咨询管理
     * @return 咨询管理集合
     */
    public List<AppZixun> selectAppZixunList(AppZixun appZixun);

    public List<Map<String ,Object>> selectAppZixunListapp(AppZixun appZixun);

    public List<Map<String ,Object>> selectcommentinfo(String  zixun_id);

    /**
     * 新增咨询管理
     * 
     * @param appZixun 咨询管理
     * @return 结果
     */
    public int insertAppZixun(AppZixun appZixun);
    public int insertComment(AppZixun appZixun);

    public int updateDianzan(AppZixun appZixun);

    /**
     * 修改咨询管理
     * 
     * @param appZixun 咨询管理
     * @return 结果
     */
    public int updateAppZixun(AppZixun appZixun);

    /**
     * 删除咨询管理
     * 
     * @param zixunId 咨询管理主键
     * @return 结果
     */
    public int deleteAppZixunByZixunId(Long zixunId);

    /**
     * 批量删除咨询管理
     * 
     * @param zixunIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppZixunByZixunIds(String[] zixunIds);
}
