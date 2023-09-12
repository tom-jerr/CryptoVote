package com.ruoyi.algorithm.hash;



/**
 * @author lzy
 * @version 1.0.0
 * 2023/5/7 11:28
 */
public interface HashFunc {
    /**
     * 接口：生成的hash函数
     * @param str
     * @return
     */
    public long hash(String str);
}
