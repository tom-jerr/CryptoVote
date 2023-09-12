package com.ruoyi.system.domain;

/**
 * @author gaike
 * @date 2023/5/15 10:28 下午
 * @description Ztest
 */
public class Ztest {
    public static void main(String[] args) {
        String hxid= "1,3";
        String s[] = hxid.split(",");
        System.out.println(s.length);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }

    }
}
