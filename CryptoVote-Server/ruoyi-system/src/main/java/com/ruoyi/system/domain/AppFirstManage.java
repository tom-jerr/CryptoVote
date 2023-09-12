package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 首页管理对象 app_first_manage
 * 
 * @author chris
 * @date 2023-04-13
 */
public class AppFirstManage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long newsId;

    /** 标题 */
    @Excel(name = "标题")
    private String newsTitle;

    /** 图片链接 */
    @Excel(name = "图片链接")
    private String picurl;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 0:征兵 1:新闻 */
    @Excel(name = "0:征兵 1:新闻")
    private String type;

    public void setNewsId(Long newsId) 
    {
        this.newsId = newsId;
    }

    public Long getNewsId() 
    {
        return newsId;
    }
    public void setNewsTitle(String newsTitle) 
    {
        this.newsTitle = newsTitle;
    }

    public String getNewsTitle() 
    {
        return newsTitle;
    }
    public void setPicurl(String picurl) 
    {
        this.picurl = picurl;
    }

    public String getPicurl() 
    {
        return picurl;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("newsId", getNewsId())
            .append("newsTitle", getNewsTitle())
            .append("picurl", getPicurl())
            .append("content", getContent())
            .append("type", getType())
            .toString();
    }
}
