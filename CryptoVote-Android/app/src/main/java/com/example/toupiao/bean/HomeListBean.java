package com.example.toupiao.bean;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.List;


public class HomeListBean implements Serializable {

    /**
     * msg : 操作成功！
     * code : 200
     * content : [{"picurl":"http://xychead.xueyiche.vip/pic_1681351141083.jpg","news_title":"23","type":"1","news_id":1,"content":"234523452345"},{"picurl":"http://xychead.xueyiche.vip/pic_1681351141083.jpg","news_title":"423","type":"1","news_id":2,"content":"2342"},{"picurl":"http://xychead.xueyiche.vip/pic_1681351141083.jpg","news_title":"2","type":"1","news_id":3,"content":"33"},{"picurl":"http://xychead.xueyiche.vip/pic_1681351141083.jpg","news_title":"3","type":"0","news_id":4,"content":"4"},{"picurl":"http://xychead.xueyiche.vip/pic_1681351141083.jpg","news_title":"3","type":"0","news_id":5,"content":"434"},{"picurl":"http://xychead.xueyiche.vip/pic_1681351141083.jpg","news_title":"4","type":"0","news_id":6,"content":"242"}]
     */

    private String msg;
    private int code;
    /**
     * picurl : http://xychead.xueyiche.vip/pic_1681351141083.jpg
     * news_title : 23
     * type : 1
     * news_id : 1
     * content : 234523452345
     */

    private List<ContentBean> content;

    public static HomeListBean objectFromData(String str) {

        return new Gson().fromJson(str, HomeListBean.class);
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
        private String picurl;
        private String news_title;
        private String type;
        private String sys_time;
        private int news_id;
        private String content;

        public String getSys_time() {
            return sys_time;
        }

        public void setSys_time(String sys_time) {
            this.sys_time = sys_time;
        }

        public static ContentBean objectFromData(String str) {

            return new Gson().fromJson(str, ContentBean.class);
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

        public String getNews_title() {
            return news_title;
        }

        public void setNews_title(String news_title) {
            this.news_title = news_title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getNews_id() {
            return news_id;
        }

        public void setNews_id(int news_id) {
            this.news_id = news_id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
