package com.example.toupiao.bean;

import com.google.gson.Gson;

import java.util.List;

public class RemarkListBean {

    /**
     * msg : 操作成功！
     * code : 200
     * content : [{"com_systime":"2023-04-13 23:28:01","head_url":"http://xychead.xueyiche.vip/pic_1681351141083.jpg","dianzan":"1","user_id":"6","comment_info":"评论内容","comment_id":3,"zixun_id":"14"},{"com_systime":"2023-04-13 23:40:08","head_url":"http://xychead.xueyiche.vip/pic_1681351141083.jpg","dianzan":"0","user_id":"6","comment_info":"么么","comment_id":4,"zixun_id":"14"},{"com_systime":"2023-04-13 23:40:45","head_url":"http://xychead.xueyiche.vip/pic_1681351141083.jpg","dianzan":"0","user_id":"6","comment_info":"么么","comment_id":5,"zixun_id":"14"}]
     */

    private String msg;
    private int code;
    /**
     * com_systime : 2023-04-13 23:28:01
     * head_url : http://xychead.xueyiche.vip/pic_1681351141083.jpg
     * dianzan : 1
     * user_id : 6
     * comment_info : 评论内容
     * comment_id : 3
     * zixun_id : 14
     */

    private List<ContentBean> content;

    public static RemarkListBean objectFromData(String str) {

        return new Gson().fromJson(str, RemarkListBean.class);
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
        private String com_systime;
        private String head_url;
        private String dianzan;
        private String user_id;
        private String comment_info;
        private int comment_id;
        private String zixun_id;

        public static ContentBean objectFromData(String str) {

            return new Gson().fromJson(str, ContentBean.class);
        }

        public String getCom_systime() {
            return com_systime;
        }

        public void setCom_systime(String com_systime) {
            this.com_systime = com_systime;
        }

        public String getHead_url() {
            return head_url;
        }

        public void setHead_url(String head_url) {
            this.head_url = head_url;
        }

        public String getDianzan() {
            return dianzan;
        }

        public void setDianzan(String dianzan) {
            this.dianzan = dianzan;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getComment_info() {
            return comment_info;
        }

        public void setComment_info(String comment_info) {
            this.comment_info = comment_info;
        }

        public int getComment_id() {
            return comment_id;
        }

        public void setComment_id(int comment_id) {
            this.comment_id = comment_id;
        }

        public String getZixun_id() {
            return zixun_id;
        }

        public void setZixun_id(String zixun_id) {
            this.zixun_id = zixun_id;
        }
    }
}
