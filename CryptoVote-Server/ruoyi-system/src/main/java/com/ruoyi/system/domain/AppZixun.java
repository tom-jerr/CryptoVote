package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 咨询管理对象 app_zixun
 * 
 * @author ruoyi
 * @date 2023-04-13
 */
public class AppZixun extends BaseEntity
{
    private static final long serialVersionUID = 1L;



    private Long comment_id;
    private String comment_info;
    private String com_systime;
    private String dianzan;


    /** id */
    private Long zixunId;
    private Long zixun_id;

    /** 咨询标题 */
    @Excel(name = "咨询标题")
    private String title;

    /** 图片1 */
    @Excel(name = "图片1")
    private String img1;

    /** 图片2 */
    @Excel(name = "图片2")
    private String img2;

    /** 图片3 */
    @Excel(name = "图片3")
    private String img3;

    /** 标签 */
    @Excel(name = "标签")
    private String mark;

    /** 备注 */
    @Excel(name = "备注")
    private String backup;

    /** 用户id */
    private String userId;

    private String user_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setZixunId(Long zixunId)
    {
        this.zixunId = zixunId;
    }

    public Long getZixunId() 
    {
        return zixunId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setImg1(String img1) 
    {
        this.img1 = img1;
    }

    public String getImg1() 
    {
        return img1;
    }
    public void setImg2(String img2) 
    {
        this.img2 = img2;
    }

    public String getImg2() 
    {
        return img2;
    }
    public void setImg3(String img3) 
    {
        this.img3 = img3;
    }

    public String getImg3() 
    {
        return img3;
    }
    public void setMark(String mark) 
    {
        this.mark = mark;
    }

    public String getMark() 
    {
        return mark;
    }
    public void setBackup(String backup) 
    {
        this.backup = backup;
    }

    public String getBackup() 
    {
        return backup;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }

    public Long getZixun_id() {
        return zixun_id;
    }

    public void setZixun_id(Long zixun_id) {
        this.zixun_id = zixun_id;
    }

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_info() {
        return comment_info;
    }

    public void setComment_info(String comment_info) {
        this.comment_info = comment_info;
    }

    public String getCom_systime() {
        return com_systime;
    }

    public void setCom_systime(String com_systime) {
        this.com_systime = com_systime;
    }

    public String getDianzan() {
        return dianzan;
    }

    public void setDianzan(String dianzan) {
        this.dianzan = dianzan;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("zixunId", getZixunId())
            .append("title", getTitle())
            .append("img1", getImg1())
            .append("img2", getImg2())
            .append("img3", getImg3())
            .append("mark", getMark())
            .append("backup", getBackup())
            .append("userId", getUserId())
            .toString();
    }
}
