package com.example.toupiao.algorithm.hash;

/**
 * @author lzy
 * @version 1.0.0
 * 2023/5/10 9:41
 */

import java.io.Serializable;

/**
 * 测试冲突的hash函数
 */
public class newHash2 implements HashFunc, Serializable {
    @Override
    public long hash(String str) {
        return 10;
    }
}
