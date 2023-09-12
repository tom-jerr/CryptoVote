package com.ruoyi.algorithm.hash;

import java.io.Serializable;

/**
 * @author lzy
 * @version 1.0.0
 * 2023/8/6 23:05
 */
public class DEKHash implements HashFunc, Serializable {
    @Override
    public long hash(String str) {
        if(str.isEmpty()) {
            return 0;
        }
        long hash = 1215423911;
        for(char c:str.toCharArray()) {
            hash = ((hash << 5)^ (hash >> 27)) ^ c;
        }
        return hash;
    }
}
