package com.ruoyi.algorithm.hash;

import java.io.Serializable;

/**
 * @author lzy
 * @version 1.0.0
 * 2023/8/6 23:08
 */
public class DJBHash implements HashFunc, Serializable {
    private String className;

    public DJBHash() {
        this.className = this.getClass().getSimpleName();
    }

    @Override
    public long hash(String str) {
        if(str.isEmpty()) {
            return 0;
        }
        long hash = 5381;
        for(char c:str.toCharArray()) {
            hash += (hash << 5) + c;
        }
        return hash;
    }
}
