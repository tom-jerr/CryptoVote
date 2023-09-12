package com.example.toupiao.algorithm.hash;

/**
 * @author lzy
 * @version 1.0.0
 * 2023/5/9 23:19
 */

import java.io.Serializable;

/**
 * 测试冲突的hash函数
 */
public class PinHash implements HashFunc, Serializable {
    @Override
    public long hash(String str) {
        return 1;
    }

    public static void main(String[] args) {
        PinHash PinHash = new PinHash();
        PinHash.hash("abc");
        System.out.println(PinHash.hash("abc"));
    }
}
