package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 报名审核对象 app_shenhe
 * 
 * @author chris
 * @date 2023-04-13
 */
public class AppShenhe extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private String userId;

    /** 报名图片 */
    @Excel(name = "报名图片")
    private String pic;

    /** 民族 */
    @Excel(name = "民族")
    private String minzu;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 年龄 */
    @Excel(name = "年龄")
    private String age;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private String zzmm;

    /** 籍贯 */
    @Excel(name = "籍贯")
    private String jiguan;

    /** 婚姻状况 */
    @Excel(name = "婚姻状况")
    private String hyzk;

    /** 学历信息 */
    @Excel(name = "学历信息")
    private String xlxx;

    /** 从业类别 */
    @Excel(name = "从业类别")
    private String cylb;

    /** 独生子女 */
    @Excel(name = "独生子女")
    private String dszv;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 身份证 */
    @Excel(name = "身份证")
    private String sfzid;

    /** 家庭住址 */
    @Excel(name = "家庭住址")
    private String address;

    /** 0:未审核 1:审核通过 */
    @Excel(name = "0:未审核 1:审核通过")
    private String type;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setPic(String pic) 
    {
        this.pic = pic;
    }

    public String getPic() 
    {
        return pic;
    }
    public void setMinzu(String minzu) 
    {
        this.minzu = minzu;
    }

    public String getMinzu() 
    {
        return minzu;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setAge(String age) 
    {
        this.age = age;
    }

    public String getAge() 
    {
        return age;
    }
    public void setZzmm(String zzmm) 
    {
        this.zzmm = zzmm;
    }

    public String getZzmm() 
    {
        return zzmm;
    }
    public void setJiguan(String jiguan) 
    {
        this.jiguan = jiguan;
    }

    public String getJiguan() 
    {
        return jiguan;
    }
    public void setHyzk(String hyzk) 
    {
        this.hyzk = hyzk;
    }

    public String getHyzk() 
    {
        return hyzk;
    }
    public void setXlxx(String xlxx) 
    {
        this.xlxx = xlxx;
    }

    public String getXlxx() 
    {
        return xlxx;
    }
    public void setCylb(String cylb) 
    {
        this.cylb = cylb;
    }

    public String getCylb() 
    {
        return cylb;
    }
    public void setDszv(String dszv) 
    {
        this.dszv = dszv;
    }

    public String getDszv() 
    {
        return dszv;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setSfzid(String sfzid) 
    {
        this.sfzid = sfzid;
    }

    public String getSfzid() 
    {
        return sfzid;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
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
            .append("id", getId())
            .append("userId", getUserId())
            .append("pic", getPic())
            .append("minzu", getMinzu())
            .append("sex", getSex())
            .append("age", getAge())
            .append("zzmm", getZzmm())
            .append("jiguan", getJiguan())
            .append("hyzk", getHyzk())
            .append("xlxx", getXlxx())
            .append("cylb", getCylb())
            .append("dszv", getDszv())
            .append("name", getName())
            .append("phone", getPhone())
            .append("sfzid", getSfzid())
            .append("address", getAddress())
            .append("type", getType())
            .toString();
    }
}
