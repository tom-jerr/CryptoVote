package com.example.toupiao.bean;

import com.google.gson.Gson;

import java.util.List;


public class ZiXunBean {

    /**
     * msg : 操作成功！
     * code : 200
     * content : [{"img3":"3213","backup":"123","user_id":"1","title":"12","img2":"1231","mark":"1231231","zixun_id":1,"img1":"http://xychead.xueyiche.vip/pic_1681351141083.jpg,http://xychead.xueyiche.vip/pic_1681351141083.jpg,http://xychead.xueyiche.vip/pic_1681351141083.jpg"},{"img3":"123","backup":"123","user_id":"12","title":"123","img2":"123","mark":"123","zixun_id":2,"img1":"http://xychead.xueyiche.vip/pic_1681351141083.jpg,http://xychead.xueyiche.vip/pic_1681351141083.jpg"},{"backup":"备注","user_id":"12","title":"咨询标题","mark":"标签征兵","zixun_id":3,"img1":"123123,123123,12314213"},{"backup":"备注","user_id":"12","title":"咨询标题","mark":"标签征兵","zixun_id":4,"img1":"123123,123123,12314213"},{"backup":"备注","user_id":"12","title":"咨询标题","mark":"标签征兵","zixun_id":6,"img1":"123123,123123,12314213"},{"backup":"备注","user_id":"12","title":"咨询标题","mark":"标签征兵","zixun_id":7,"img1":"123123,123123,12314213"},{"backup":"匿名信","user_id":"6","title":"噢噢噢哦哦","mark":"匿名信","zixun_id":8,"img1":"http://xychead.xueyiche.vip/pic_1681396651756.jpg,http://xychead.xueyiche.vip/pic_1681396651772.jpg,http://xychead.xueyiche.vip/pic_1681396651774.jpg,http://xychead.xueyiche.vip/pic_1681396651775.jpg,http://xychead.xueyiche.vip/pic_1681396651777.jpg"},{"backup":"匿名信","user_id":"6","title":"噢噢噢哦哦","mark":"匿名信","zixun_id":9,"img1":"http://xychead.xueyiche.vip/pic_1681396651756.jpg,http://xychead.xueyiche.vip/pic_1681396651772.jpg,http://xychead.xueyiche.vip/pic_1681396651774.jpg,http://xychead.xueyiche.vip/pic_1681396651775.jpg,http://xychead.xueyiche.vip/pic_1681396657801.jpg"},{"backup":"匿名信","user_id":"6","title":"噢噢噢哦哦","mark":"匿名信","zixun_id":10,"img1":"http://xychead.xueyiche.vip/pic_1681396657781.jpg,http://xychead.xueyiche.vip/pic_1681396651772.jpg,http://xychead.xueyiche.vip/pic_1681396651774.jpg,http://xychead.xueyiche.vip/pic_1681396657799.jpg,http://xychead.xueyiche.vip/pic_1681396657801.jpg"},{"backup":"匿名信","user_id":"6","title":"噢噢噢哦哦","mark":"匿名信","zixun_id":11,"img1":"http://xychead.xueyiche.vip/pic_1681396657781.jpg,http://xychead.xueyiche.vip/pic_1681396651772.jpg,http://xychead.xueyiche.vip/pic_1681396657798.jpg,http://xychead.xueyiche.vip/pic_1681396657799.jpg,http://xychead.xueyiche.vip/pic_1681396657801.jpg"},{"backup":"匿名信","user_id":"6","title":"噢噢噢哦哦","mark":"匿名信","zixun_id":12,"img1":"http://xychead.xueyiche.vip/pic_1681396657781.jpg,http://xychead.xueyiche.vip/pic_1681396657796.jpg,http://xychead.xueyiche.vip/pic_1681396657798.jpg,http://xychead.xueyiche.vip/pic_1681396657799.jpg,http://xychead.xueyiche.vip/pic_1681396657801.jpg"},{"backup":"匿名信","user_id":"6","title":"噢噢噢哦哦","mark":"匿名信","zixun_id":13,"img1":"http://xychead.xueyiche.vip/pic_1681396651756.jpg,http://xychead.xueyiche.vip/pic_1681396651772.jpg,http://xychead.xueyiche.vip/pic_1681396651774.jpg,http://xychead.xueyiche.vip/pic_1681396657799.jpg,http://xychead.xueyiche.vip/pic_1681396657801.jpg"}]
     */

    private String msg;
    private int code;
    /**
     * img3 : 3213
     * backup : 123
     * user_id : 1
     * title : 12
     * img2 : 1231
     * mark : 1231231
     * zixun_id : 1
     * img1 : http://xychead.xueyiche.vip/pic_1681351141083.jpg,http://xychead.xueyiche.vip/pic_1681351141083.jpg,http://xychead.xueyiche.vip/pic_1681351141083.jpg
     */

    private List<ContentBean> content;

    public static ZiXunBean objectFromData(String str) {

        return new Gson().fromJson(str, ZiXunBean.class);
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
        private String img3;
        private String backup;
        private String user_id;
        private String title;
        private String img2;
        private String mark;
        private int zixun_id;
        private String img1;
        private String zx_systime;

        public String getZx_systime() {
            return zx_systime;
        }

        public void setZx_systime(String zx_systime) {
            this.zx_systime = zx_systime;
        }

        public static ContentBean objectFromData(String str) {

            return new Gson().fromJson(str, ContentBean.class);
        }

        public String getImg3() {
            return img3;
        }

        public void setImg3(String img3) {
            this.img3 = img3;
        }

        public String getBackup() {
            return backup;
        }

        public void setBackup(String backup) {
            this.backup = backup;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImg2() {
            return img2;
        }

        public void setImg2(String img2) {
            this.img2 = img2;
        }

        public String getMark() {
            return mark;
        }

        public void setMark(String mark) {
            this.mark = mark;
        }

        public int getZixun_id() {
            return zixun_id;
        }

        public void setZixun_id(int zixun_id) {
            this.zixun_id = zixun_id;
        }

        public String getImg1() {
            return img1;
        }

        public void setImg1(String img1) {
            this.img1 = img1;
        }
    }
}
