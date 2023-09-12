package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PictureUrl;

/**
 * 轮播图Mapper接口
 * 
 * @author chris
 * @date 2023-04-09
 */
public interface PictureUrlMapper 
{
    /**
     * 查询轮播图
     * 
     * @param id 轮播图主键
     * @return 轮播图
     */
    public PictureUrl selectPictureUrlById(Long id);

    /**
     * 查询轮播图列表
     * 
     * @param pictureUrl 轮播图
     * @return 轮播图集合
     */
    public List<PictureUrl> selectPictureUrlList(PictureUrl pictureUrl);

    /**
     * 新增轮播图
     * 
     * @param pictureUrl 轮播图
     * @return 结果
     */
    public int insertPictureUrl(PictureUrl pictureUrl);

    /**
     * 修改轮播图
     * 
     * @param pictureUrl 轮播图
     * @return 结果
     */
    public int updatePictureUrl(PictureUrl pictureUrl);

    /**
     * 删除轮播图
     * 
     * @param id 轮播图主键
     * @return 结果
     */
    public int deletePictureUrlById(Long id);

    /**
     * 批量删除轮播图
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePictureUrlByIds(String[] ids);
}
