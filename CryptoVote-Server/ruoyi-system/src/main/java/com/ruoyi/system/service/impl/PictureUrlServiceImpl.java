package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PictureUrlMapper;
import com.ruoyi.system.domain.PictureUrl;
import com.ruoyi.system.service.IPictureUrlService;
import com.ruoyi.common.core.text.Convert;

/**
 * 轮播图Service业务层处理
 * 
 * @author chris
 * @date 2023-04-09
 */
@Service
public class PictureUrlServiceImpl implements IPictureUrlService 
{
    @Autowired
    private PictureUrlMapper pictureUrlMapper;

    /**
     * 查询轮播图
     * 
     * @param id 轮播图主键
     * @return 轮播图
     */
    @Override
    public PictureUrl selectPictureUrlById(Long id)
    {
        return pictureUrlMapper.selectPictureUrlById(id);
    }

    /**
     * 查询轮播图列表
     * 
     * @param pictureUrl 轮播图
     * @return 轮播图
     */
    @Override
    public List<PictureUrl> selectPictureUrlList(PictureUrl pictureUrl)
    {
        return pictureUrlMapper.selectPictureUrlList(pictureUrl);
    }

    /**
     * 新增轮播图
     * 
     * @param pictureUrl 轮播图
     * @return 结果
     */
    @Override
    public int insertPictureUrl(PictureUrl pictureUrl)
    {
        return pictureUrlMapper.insertPictureUrl(pictureUrl);
    }

    /**
     * 修改轮播图
     * 
     * @param pictureUrl 轮播图
     * @return 结果
     */
    @Override
    public int updatePictureUrl(PictureUrl pictureUrl)
    {
        return pictureUrlMapper.updatePictureUrl(pictureUrl);
    }

    /**
     * 批量删除轮播图
     * 
     * @param ids 需要删除的轮播图主键
     * @return 结果
     */
    @Override
    public int deletePictureUrlByIds(String ids)
    {
        return pictureUrlMapper.deletePictureUrlByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除轮播图信息
     * 
     * @param id 轮播图主键
     * @return 结果
     */
    @Override
    public int deletePictureUrlById(Long id)
    {
        return pictureUrlMapper.deletePictureUrlById(id);
    }
}
