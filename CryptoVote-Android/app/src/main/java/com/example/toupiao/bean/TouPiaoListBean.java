package com.example.toupiao.bean;

import com.google.gson.Gson;

import java.util.List;

public class TouPiaoListBean {

    /**
     * msg : 操作成功！
     * code : 200
     * content : [{"head_url":"sdf","toupiaotime":"2023-05-13 22:48:19","nickname":"24","tp_user_id":"2"},{"head_url":"http://xychead.xueyiche.vip/pic_1681351141083.jpg","toupiaotime":"2023-05-14 22:04:01","nickname":"路飞7","tp_user_id":"6"},{"head_url":"http://xychead.xueyiche.vip/pic_1681437348894.jpg","toupiaotime":"2023-05-14 22:30:36","nickname":"蜡笔小新","tp_user_id":"7"}]
     */

    private String msg;
    private int code;
    /**
     * head_url : sdf
     * toupiaotime : 2023-05-13 22:48:19
     * nickname : 24
     * tp_user_id : 2
     */

    private List<ContentBean> content;

    public static TouPiaoListBean objectFromData(String str) {

        return new Gson().fromJson(str, TouPiaoListBean.class);
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
        private String head_url;
        private String toupiaotime;
        private String nickname;
        private String tp_user_id;

        public static ContentBean objectFromData(String str) {

            return new Gson().fromJson(str, ContentBean.class);
        }

        public String getHead_url() {
            return head_url;
        }

        public void setHead_url(String head_url) {
            this.head_url = head_url;
        }

        public String getToupiaotime() {
            return toupiaotime;
        }

        public void setToupiaotime(String toupiaotime) {
            this.toupiaotime = toupiaotime;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getTp_user_id() {
            return tp_user_id;
        }

        public void setTp_user_id(String tp_user_id) {
            this.tp_user_id = tp_user_id;
        }
    }
}
