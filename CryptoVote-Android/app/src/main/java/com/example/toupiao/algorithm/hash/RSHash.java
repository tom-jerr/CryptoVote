package com.example.toupiao.algorithm.hash;

import java.io.Serializable;

/**
 * @author lzy
 * @version 1.0.0
 * 2023/8/6 23:01
 */
public class RSHash implements HashFunc, Serializable {
    private String className;

    public RSHash() {
        this.className = this.getClass().getSimpleName();
    }
    @Override
    public long hash(String str) {
        long hash = 0;
        long magic = 63689;
        for(char c:str.toCharArray()) {
            hash = hash*magic + c;
            magic *= 378551;
        }
        return hash;
    }
}
