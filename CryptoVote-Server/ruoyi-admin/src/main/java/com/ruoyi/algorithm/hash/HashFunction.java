package com.ruoyi.algorithm.hash;

public class HashFunction {
    public long SDBMhash(String str) {
        char[] s = str.toCharArray();
        long value = 0;
        for (int i = 0; i < str.length(); i++) {
            value = value*65539 + s[i];
        }
        return value;
    }

    public long BKDRhash(String str) {
        char[] s = str.toCharArray();
        long value = 0;
        for (int i = 0; i < str.length(); i++) {
            value = value*131 + s[i];
        }
        return value;
    }

    public long RShash(String str) {
        long hash = 0;
        long magic = 63689;
        for(char c:str.toCharArray()) {
            hash = hash*magic + c;
            magic *= 378551;
        }
        return hash;
    }

    public long DJBhash(String str) {
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
