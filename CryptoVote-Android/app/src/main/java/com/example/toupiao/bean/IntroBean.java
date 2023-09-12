package com.example.toupiao.bean;

import com.google.gson.Gson;

import java.util.List;

public class IntroBean {
    private String msg;
    private int code;
    /**
     * head_url : sdf
     * toupiaotime : 2023-05-13 22:48:19
     * nickname : 24
     * tp_user_id : 2
     */

    private List<IntroBean.ContentBean> content;

    public static IntroBean objectFromData(String str) {

        return new Gson().fromJson(str, IntroBean.class);
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

    public List<IntroBean.ContentBean> getContent() {
        return content;
    }

    public void setContent(List<IntroBean.ContentBean> content) {
        this.content = content;
    }

    public static class ContentBean {
        private String hx_url;
        private String toupiaotime;
        private String hx_name;
        private String hx_intro;

        public String getHx_intro() {
            return hx_intro;
        }

        public void setHx_intro(String hx_intro) {
            this.hx_intro = hx_intro;
        }

        private String id;

        public static TouPiaoListBean.ContentBean objectFromData(String str) {

            return new Gson().fromJson(str, TouPiaoListBean.ContentBean.class);
        }

        public String getHx_url() {
            return hx_url;
        }

        public void setHx_url(String hx_url) {
            this.hx_url = hx_url;
        }

        public String getToupiaotime() {
            return toupiaotime;
        }

        public void setToupiaotime(String toupiaotime) {
            this.toupiaotime = toupiaotime;
        }

        public String getHx_name() {
            return hx_name;
        }

        public void setHx_name(String hx_name) {
            this.hx_name = hx_name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
