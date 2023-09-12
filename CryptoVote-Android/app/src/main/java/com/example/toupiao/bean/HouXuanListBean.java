package com.example.toupiao.bean;

import com.google.gson.Gson;

import java.util.List;

public class HouXuanListBean {

    /**
     * msg : 操作成功！
     * code : 200
     * content : [{"hx_name":"2","backup":"2","id":1,"hx_num_piao":"2","hx_url":"2"},{"hx_name":"2","backup":"","id":3,"hx_num_piao":"0","hx_url":"2"}]
     */

    private String msg;
    private int code;
    /**
     * hx_name : 2
     * backup : 2
     * id : 1
     * hx_num_piao : 2
     * hx_url : 2
     */

    private List<ContentBean> content;

    public static HouXuanListBean objectFromData(String str) {

        return new Gson().fromJson(str, HouXuanListBean.class);
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

    public static class ContentBean {
        private String hx_name;
        private String backup;
        private int id;
        private String hx_num_piao;
        private String hx_url;

        public static ContentBean objectFromData(String str) {

            return new Gson().fromJson(str, ContentBean.class);
        }

        public String getHx_name() {
            return hx_name;
        }

        public void setHx_name(String hx_name) {
            this.hx_name = hx_name;
        }

        public String getBackup() {
            return backup;
        }

        public void setBackup(String backup) {
            this.backup = backup;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getHx_num_piao() {
            return hx_num_piao;
        }

        public void setHx_num_piao(String hx_num_piao) {
            this.hx_num_piao = hx_num_piao;
        }

        public String getHx_url() {
            return hx_url;
        }

        public void setHx_url(String hx_url) {
            this.hx_url = hx_url;
        }
    }
}
