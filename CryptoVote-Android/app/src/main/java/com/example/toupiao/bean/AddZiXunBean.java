package com.example.toupiao.bean;

import com.google.gson.Gson;

import java.util.List;


public class AddZiXunBean {

    /**
     * msg : 操作成功！
     * code : 200
     * content : [{"backup":"匿名信","user_id":"6","title":"噢噢噢哦哦","mark":"匿名信","zixun_id":12,"img1":"http://xychead.xueyiche.vip/pic_1681396657781.jpg,http://xychead.xueyiche.vip/pic_1681396657796.jpg,http://xychead.xueyiche.vip/pic_1681396657798.jpg,http://xychead.xueyiche.vip/pic_1681396657799.jpg,http://xychead.xueyiche.vip/pic_1681396657801.jpg"}]
     */

    private String msg;
    private int code;
    /**
     * backup : 匿名信
     * user_id : 6
     * title : 噢噢噢哦哦
     * mark : 匿名信
     * zixun_id : 12
     * img1 : http://xychead.xueyiche.vip/pic_1681396657781.jpg,http://xychead.xueyiche.vip/pic_1681396657796.jpg,http://xychead.xueyiche.vip/pic_1681396657798.jpg,http://xychead.xueyiche.vip/pic_1681396657799.jpg,http://xychead.xueyiche.vip/pic_1681396657801.jpg
     */

    private List<ContentBean> content;

    public static AddZiXunBean objectFromData(String str) {

        return new Gson().fromJson(str, AddZiXunBean.class);
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
        private String backup;
        private String user_id;
        private String title;
        private String mark;
        private int zixun_id;
        private String img1;

        public static ContentBean objectFromData(String str) {

            return new Gson().fromJson(str, ContentBean.class);
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
