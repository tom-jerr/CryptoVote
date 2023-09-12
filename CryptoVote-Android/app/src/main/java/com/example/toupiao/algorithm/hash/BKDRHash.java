package com.example.toupiao.algorithm.hash;

/**
 * @author lzy
 * @version 1.0.0
 * 2023/5/7 11:25
 */

import java.io.Serializable;

/**
 * BKDR hash函数
 */
public class BKDRHash implements HashFunc, Serializable {
    private String className;
    public BKDRHash() {
        this.className = this.getClass().getSimpleName();
    }
    @Override
    public long hash(String str) {
        char[] s = str.toCharArray();
        long value = 0;
        for (int i = 0; i < str.length(); i++) {
           value = value*131 + s[i];
        }
        return value;
    }

    public static void main(String[] args) {
        String str1 = "Tom";
        String str2 = "Sam";

        BKDRHash bkdrHash = new BKDRHash();
        long v1 = bkdrHash.hash(str1);
        long v2 = bkdrHash.hash(str2);

        int v3 = (int)v1;
        int v4 = (int)v2;
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
    }
}
