package com.example.toupiao.bean;

import com.google.gson.Gson;

public class ShenHeBean {

    /**
     * msg : 操作成功！
     * code : 200
     * content : 待审核
     */

    private String msg;
    private int code;
    private String content;

    public static ShenHeBean objectFromData(String str) {

        return new Gson().fromJson(str, ShenHeBean.class);
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
