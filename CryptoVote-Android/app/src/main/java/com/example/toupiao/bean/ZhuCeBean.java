package com.example.toupiao.bean;

import com.google.gson.Gson;

public class ZhuCeBean {

    /**
     * msg : 操作成功！
     * code : 200
     * content : {"user_id":5}
     */

    private String msg;
    private int code;
    /**
     * user_id : 5
     */

    private ContentBean content;

    public static ZhuCeBean objectFromData(String str) {

        return new Gson().fromJson(str, ZhuCeBean.class);
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

    public static class ContentBean {
        private int user_id;

        public static ContentBean objectFromData(String str) {

            return new Gson().fromJson(str, ContentBean.class);
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }
    }
}
