package com.example.toupiao.bean;

import com.google.gson.Gson;

import java.io.Serializable;

public class AddRoomBean implements Serializable {

    /**
     * msg : 操作成功！
     * code : 200
     * content : {"room_id":3,"close_ticket":"1","roomtime":"2023-05-11 22:40:27","user_id":"9","room_pass":"6677","room_url":"http://xychead.xueyiche.vip/pic_1683816017432.jpg","one_all":"1","room_title":"呢呢呢"}
     */

    private String msg;
    private int code;
    /**
     * room_id : 3
     * close_ticket : 1
     * roomtime : 2023-05-11 22:40:27
     * user_id : 9
     * room_pass : 6677
     * room_url : http://xychead.xueyiche.vip/pic_1683816017432.jpg
     * one_all : 1
     * room_title : 呢呢呢
     */

    private ContentBean content;

    public static AddRoomBean objectFromData(String str) {

        return new Gson().fromJson(str, AddRoomBean.class);
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

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public static class ContentBean implements Serializable {
        private int room_id;
        private String close_ticket;
        private String roomtime;
        private String user_id;
        private String room_pass;
        private String room_url;
        private String one_all;
        private String room_title;

        public static ContentBean objectFromData(String str) {

            return new Gson().fromJson(str, ContentBean.class);
        }

        public int getRoom_id() {
            return room_id;
        }

        public void setRoom_id(int room_id) {
            this.room_id = room_id;
        }

        public String getClose_ticket() {
            return close_ticket;
        }

        public void setClose_ticket(String close_ticket) {
            this.close_ticket = close_ticket;
        }

        public String getRoomtime() {
            return roomtime;
        }

        public void setRoomtime(String roomtime) {
            this.roomtime = roomtime;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getRoom_pass() {
            return room_pass;
        }

        public void setRoom_pass(String room_pass) {
            this.room_pass = room_pass;
        }

        public String getRoom_url() {
            return room_url;
        }

        public void setRoom_url(String room_url) {
            this.room_url = room_url;
        }

        public String getOne_all() {
            return one_all;
        }

        public void setOne_all(String one_all) {
            this.one_all = one_all;
        }

        public String getRoom_title() {
            return room_title;
        }

        public void setRoom_title(String room_title) {
            this.room_title = room_title;
        }
    }
}
