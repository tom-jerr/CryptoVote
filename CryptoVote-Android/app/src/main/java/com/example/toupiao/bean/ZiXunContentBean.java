package com.example.toupiao.bean;

import com.google.gson.Gson;

public class ZiXunContentBean {

    /**
     * msg : 操作成功！
     * code : 200
     * content : {"backup":"我们一起征兵了","user_id":"6","title":"征兵了","zx_systime":"2023-04-13 22:56:47","mark":"我们一起征兵了","zixun_id":14,"img1":"http://xychead.xueyiche.vip/pic_1681397811343.jpg,http://xychead.xueyiche.vip/pic_1681397811358.jpg,http://xychead.xueyiche.vip/pic_1681397811360.jpg,http://xychead.xueyiche.vip/pic_1681397811361.jpg"}
     */

    private String msg;
    private int code;
    /**
     * backup : 我们一起征兵了
     * user_id : 6
     * title : 征兵了
     * zx_systime : 2023-04-13 22:56:47
     * mark : 我们一起征兵了
     * zixun_id : 14
     * img1 : http://xychead.xueyiche.vip/pic_1681397811343.jpg,http://xychead.xueyiche.vip/pic_1681397811358.jpg,http://xychead.xueyiche.vip/pic_1681397811360.jpg,http://xychead.xueyiche.vip/pic_1681397811361.jpg
     */

    private ContentBean content;

    public static ZiXunContentBean objectFromData(String str) {

        return new Gson().fromJson(str, ZiXunContentBean.class);
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
        private String backup;
        private String user_id;
        private String title;
        private String zx_systime;
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

        public String getZx_systime() {
            return zx_systime;
        }

        public void setZx_systime(String zx_systime) {
            this.zx_systime = zx_systime;
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
