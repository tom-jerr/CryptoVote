package com.ruoyi.algorithm.hash;

/**
 * @author lzy
 * @version 1.0.0
 * 2023/5/10 22:54
 */

import java.io.Serializable;

/**
 * 测试冲突的hash函数
 */
public class newHash3 implements HashFunc, Serializable {
    @Override
    public long hash(String str) {
        return 100;
    }
}
