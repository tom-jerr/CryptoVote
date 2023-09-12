package com.example.toupiao.bean;

import com.google.gson.Gson;


public class InfoBean {

    /**
     * msg : 操作成功！
     * code : 200
     * content : {"password":"1234","user_id":1,"userphone":"1234","introduce":"简介","sex":"boy","nickname":"aaa4","remark":"备注","age":"14"}
     */

    private String msg;
    private int code;
    /**
     * password : 1234
     * user_id : 1
     * userphone : 1234
     * introduce : 简介
     * sex : boy
     * nickname : aaa4
     * remark : 备注
     * age : 14
     */

    private ContentBean content;

    public static InfoBean objectFromData(String str) {

        return new Gson().fromJson(str, InfoBean.class);
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
        private String password;
        private int user_id;
        private String userphone;
        private String introduce;
        private String sex;
        private String nickname;
        private String remark;
        private String age;
        private String head_url;
        private String back_url;

        public String getHead_url() {
            return head_url;
        }

        public void setHead_url(String head_url) {
            this.head_url = head_url;
        }

        public String getBack_url() {
            return back_url;
        }

        public void setBack_url(String back_url) {
            this.back_url = back_url;
        }

        public static ContentBean objectFromData(String str) {

            return new Gson().fromJson(str, ContentBean.class);
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getUserphone() {
            return userphone;
        }

        public void setUserphone(String userphone) {
            this.userphone = userphone;
        }

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}
