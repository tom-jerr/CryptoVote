package com.example.toupiao.bean;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.List;

public class RoomListBean implements Serializable{


    /**
     * msg : 操作成功！
     * code : 200
     * content : [{"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"roomId":1,"userId":"9","roomPass":"111","roomTitle":"111","roomUrl":"111","roomtime":"2023-05-11"},{"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"roomId":2,"userId":"2","roomPass":"2","roomTitle":"2","roomUrl":"2323","roomtime":"2023-05-11"},{"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"roomId":3,"userId":"9","roomPass":"6677","roomTitle":"呢呢呢","roomUrl":"http://xychead.xueyiche.vip/pic_1683816017432.jpg","roomtime":"2023-05-11"}]
     */

    private String msg;
    private int code;
    /**
     * createBy : null
     * createTime : null
     * updateBy : null
     * updateTime : null
     * remark : null
     * roomId : 1
     * userId : 9
     * roomPass : 111
     * roomTitle : 111
     * roomUrl : 111
     * roomtime : 2023-05-11
     */

    private List<ContentBean> content;

    public static RoomListBean objectFromData(String str) {

        return new Gson().fromJson(str, RoomListBean.class);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public static class ContentBean implements Serializable{
        private Object createBy;
        private Object createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private int roomId;
        private String userId;
        private String roomPass;
        private String roomTitle;
        private String one_all;
        private String close_ticket;

        private String roomUrl;
        private String roomtime;

        public String getOne_all() {
            return one_all;
        }

        public void setOne_all(String one_all) {
            this.one_all = one_all;
        }

        public String getClose_ticket() {
            return close_ticket;
        }

        public void setClose_ticket(String close_ticket) {
            this.close_ticket = close_ticket;
        }

        public static ContentBean objectFromData(String str) {

            return new Gson().fromJson(str, ContentBean.class);
        }

        public Object getCreateBy() {
            return createBy;
        }

        public void setCreateBy(Object createBy) {
            this.createBy = createBy;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
            this.updateBy = updateBy;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public int getRoomId() {
            return roomId;
        }

        public void setRoomId(int roomId) {
            this.roomId = roomId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getRoomPass() {
            return roomPass;
        }

        public void setRoomPass(String roomPass) {
            this.roomPass = roomPass;
        }

        public String getRoomTitle() {
            return roomTitle;
        }

        public void setRoomTitle(String roomTitle) {
            this.roomTitle = roomTitle;
        }

        public String getRoomUrl() {
            return roomUrl;
        }

        public void setRoomUrl(String roomUrl) {
            this.roomUrl = roomUrl;
        }

        public String getRoomtime() {
            return roomtime;
        }

        public void setRoomtime(String roomtime) {
            this.roomtime = roomtime;
        }
    }
}
