package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 房间大厅对象 app_room
 * 
 * @author ChrisGai
 * @date 2023-05-11
 */
@Data
public class AppRoom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id")
    private Long roomId;

    /** 用户id */
    @Excel(name = "用户id")
    private String userId;
    private String user_id;

    /** 房间密码 */
    @Excel(name = "房间密码")
    private String roomPass;

    /** 房间标题 */
    @Excel(name = "房间标题")
    private String roomTitle;

    /** 房间图片 */
    @Excel(name = "房间图片")
    private String roomUrl;

    private String one_all;
    private String close_ticket;
    private String is_del;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date roomtime;

    public void setRoomId(Long roomId) 
    {
        this.roomId = roomId;
    }

    public Long getRoomId() 
    {
        return roomId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setRoomPass(String roomPass) 
    {
        this.roomPass = roomPass;
    }

    public String getRoomPass() 
    {
        return roomPass;
    }
    public void setRoomTitle(String roomTitle) 
    {
        this.roomTitle = roomTitle;
    }

    public String getRoomTitle() 
    {
        return roomTitle;
    }
    public void setRoomUrl(String roomUrl) 
    {
        this.roomUrl = roomUrl;
    }

    public String getRoomUrl() 
    {
        return roomUrl;
    }
    public void setRoomtime(Date roomtime) 
    {
        this.roomtime = roomtime;
    }

    public Date getRoomtime() 
    {
        return roomtime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("roomId", getRoomId())
            .append("userId", getUserId())
            .append("roomPass", getRoomPass())
            .append("roomTitle", getRoomTitle())
            .append("roomUrl", getRoomUrl())
            .append("roomtime", getRoomtime())
            .toString();
    }
}
