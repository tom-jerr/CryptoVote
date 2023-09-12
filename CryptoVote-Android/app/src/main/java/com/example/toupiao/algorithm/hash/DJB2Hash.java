package com.example.toupiao.algorithm.hash;

import java.io.Serializable;

/**
 * @author lzy
 * @version 1.0.0
 * 2023/8/6 23:09
 */
public class DJB2Hash implements HashFunc, Serializable {
    @Override
    public long hash(String str) {
        if(str.isEmpty()) {
            return 0;
        }
        long hash = 5381;
        for(char c:str.toCharArray()) {
            hash = hash * 33 ^ c;
        }
        return hash;
    }
}
