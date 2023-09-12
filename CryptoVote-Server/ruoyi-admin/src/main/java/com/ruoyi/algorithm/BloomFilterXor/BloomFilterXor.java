package com.ruoyi.algorithm.BloomFilterXor;



import com.ruoyi.algorithm.hash.HashFunc;
import com.ruoyi.algorithm.hash.*;
import io.swagger.models.auth.In;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;

/**
 * @author lzy
 * @version 1.0.0
 * 2023/5/4 12:39
 */

/**
 * 基于异或Shamir的混淆布隆过滤器
 */

// TODO 选择偶数个hash函数解决冲突问题
public class BloomFilterXor implements Serializable {
    /**
     * 秘密共享方案
     */
    private ShamirSecret share;
    /**
     * 秘密分发后的share[i]
     */
    private SecretShare2[] filter;
    /**
     * 布隆过滤器的大小
     */
    private int size;
    /**
     * Hash函数的个数
     */
    private int k;
    /**
     * 存放不同的Hash函数
     */
    private List<HashFunc> hashFunctions;

    /**
     * 存放可能hash冲突的元素个数（key：明文（用于计算插入GBF的位置），value：冲突元素的个数）
     */
    private Map<String, Integer> hashConfict;
    /**
     * 存放GBF插入的字符串数量
     */
    private int globalCnt;
    /**
     * 存放每一次插入新元素的随机数的异或和（key：明文（用于计算插入GBF的位置），value：随机数的异或和）
     */
    private Map<String, BigInteger> rkList;

    public List<HashFunc> getHashFunctions() {
        return hashFunctions;
    }

    public void setHashFunctions(List<HashFunc> hashFunctions) {
        this.hashFunctions = hashFunctions;
    }

    /**
     * 构造函数，初始化布隆过滤器
     * @param size 布隆过滤器的大小
     * @param k 布隆过滤器使用的哈希函数数量
     */
    public BloomFilterXor(int size, int k) {
        BigInteger prime = new BigInteger("4001");
        // 初始化Shamir
        ShamirSecret shamir = new ShamirSecret(k, prime);
        this.share = shamir;
        this.filter = new SecretShare2[size];
        this.size = size;
        this.k = k;
        // 初始化hash函数列表，将hash函数装入
        List<HashFunc> hashList = new ArrayList<>();
//        hashList.add(new newhash());
        hashList.add(new RSHash(RSHash.class.getSimpleName()));
        hashList.add(new BKDRHash(BKDRHash.class.getSimpleName()));
        hashList.add(new SDBMHash(SDBMHash.class.getSimpleName()));
//        hashList.add(new DJBHash());

        this.hashFunctions = hashList;
        // 初始化没有冲突
        this.hashConfict = new HashMap<String, Integer>();
        // 初始化时没有元素
        this.globalCnt = 0;
        this.rkList = new HashMap<String, BigInteger>();
    }

    public void addElement(BigInteger secret, String pos) {

//        // 将String转为BigInteger，秘密共享element
//        byte[] inputStringBytes = element.getBytes();
//        BigInteger secret = new BigInteger(inputStringBytes);
//        System.out.println("encrypt: " + element);
//        System.out.println(secret.toString());

        // 存放可能的hash位置:
        // 插入a[1],hash_pos: [hash1[pos], hash2[pos], hash3[pos]];
        int[] hash_pos = new int[k];
        int confilct = 0;

        // 依据不同的Hash函数计算出明文的位置
        // 将分解后的element插入刚才计算出的位置
        for (int i = 0 ; i < k; i++) {
            long hash = (hashFunctions.get(i).hash(pos)) % size;
            int val = (int)(hash + size) % size;
            hash_pos[i] = val;


            /*
                插入a[1],hash_pos: [hash1[pos], hash2[pos], hash3[pos]];
                插入a[2],hash_pos: [hash1[pos2], hash2[pos2], hash3[pos2]];
                如果hash1[pos] = hash2[pos2]；a[1] = a[1] xor filter[hash1[pos]]
                将新的a[1]进行秘密共享插入到其他不冲突的位置
                更新hash冲突的值
            */

            if (filter[val] != null) {
                secret = secret.xor(filter[val].share);
                confilct += 1;
                hash_pos[i] = 0;
            }
        }
        hashConfict.put(pos, confilct);

        /*
            新的秘密共享shareSecert的数组下标
         */
        int newIndex = 0;
        /*
            如果全部产生冲突，不会进行新的秘密共享
         */
        if (k == hashConfict.get(pos)) {
            return;
        }
//        System.out.println(k - hashConfict[globalCnt]);
        SecretShare2[] newShamir = share.share_by_K(secret, k - hashConfict.get(pos));

        /*
            在不hash冲突的位置将得到的新的shamir插入到GBF中
         */
        for (int i = 0; i < k; i++) {
            if (hash_pos[i] != 0) {
                filter[hash_pos[i]] = newShamir[newIndex];
                newIndex += 1;
            }
        }

        // 更新插入元素随机数的异或和
        rkList.put(pos, newShamir[0].getRn());
        globalCnt += 1;

    }

    /**
     * 添加元素到布隆过滤器
     * @param element   要添加的元素
     * @param pos       根据Pos计算可能的hash值
     */
    public void addElement(String element, String pos) {

        // 将String转为BigInteger，秘密共享element
        byte[] inputStringBytes = element.getBytes();
        BigInteger secret = new BigInteger(inputStringBytes);
        System.out.println("encrypt: " + element);
        System.out.println(secret.toString());

        // 存放可能的hash位置:
        // 插入a[1],hash_pos: [hash1[pos], hash2[pos], hash3[pos]];
        int[] hash_pos = new int[k];
        int confilct = 0;

        // 依据不同的Hash函数计算出明文的位置
        // 将分解后的element插入刚才计算出的位置
        for (int i = 0 ; i < k; i++) {
            long hash = (hashFunctions.get(i).hash(pos)) % size;
            int val = (int)(hash + size) % size;
            hash_pos[i] = val;


            /*
                插入a[1],hash_pos: [hash1[pos], hash2[pos], hash3[pos]];
                插入a[2],hash_pos: [hash1[pos2], hash2[pos2], hash3[pos2]];
                如果hash1[pos] = hash2[pos2]；a[1] = a[1] xor filter[hash1[pos]]
                将新的a[1]进行秘密共享插入到其他不冲突的位置
                更新hash冲突的值
            */

            if (filter[val] != null) {
                secret = secret.xor(filter[val].share);
                confilct += 1;
                hash_pos[i] = 0;
            }
        }
        hashConfict.put(pos, confilct);
        
        /*
            新的秘密共享shareSecert的数组下标
         */
        int newIndex = 0;
        /*
            如果全部产生冲突，不会进行新的秘密共享
         */
        if (k == hashConfict.get(pos)) {
            return;
        }
//        System.out.println(k - hashConfict[globalCnt]);
        SecretShare2[] newShamir = share.share_by_K(secret, k - hashConfict.get(pos));
        
        /*
            在不hash冲突的位置将得到的新的shamir插入到GBF中
         */
        for (int i = 0; i < k; i++) {
            if (hash_pos[i] != 0) {
                filter[hash_pos[i]] = newShamir[newIndex];
                newIndex += 1;
            }
        }
        
        // 更新插入元素随机数的异或和
        rkList.put(pos, newShamir[0].getRn());
        globalCnt += 1;

    }

    /**
     * 检查给定的元素element，在插入序号为seq，用hash计算pos的位置
     * 从而判断元素是否在GBF中
     * @param element   需要查询的元素
     * @param pos   需要hash的字符串，计算位置
     * @return  是否存在
     * @throws Exception
     */
    public boolean checkElement(String element, String pos) throws Exception {

        System.out.println("decrypt: " + element);
        boolean flag = false;
        /*
            如果需要查询的序号已经超过插入GBF的字符串的数量，直接返回错误
         */
        for (String npos : hashConfict.keySet()) {
            if (npos.equals(pos)) {
                flag = true;
                break;
            }
        }
        if (flag == false) {
            System.out.println("GBF内不含有该元素");
            return false;
        }
        byte[] inputStringBytes = element.getBytes();
        BigInteger msg = new BigInteger(inputStringBytes);
//        System.out.println(msg);
        SecretShare2[] shamir = new SecretShare2[k];

        // 将通过pos计算出的位置的字符串取出
        for (int i = 0 ; i < k; i++) {
            long hash = (hashFunctions.get(i).hash(pos)) % size;
            int val = (int)(hash + size) % size;
            shamir[i] = filter[val];
        }


        // 进行秘密恢复，观察是否是GBF内的元素
        // 实际上执行的xor操作
        BigInteger result = share.recover(shamir);
        // 如果分成的份数 - 冲突的份数是偶数，
        // 为了平衡插入的随机数，需要异或该序号对应的 rk (随机数的异或和)
        /*
            r1, r2, r3为随机数
            rk = r2 xor r3
            此时存在冲突，s' = s xor rn xor r1
            secret插入GBF中的元素:    [s xor rn xor r1, s' xor rk xor r2, s' xor s' xor rk xor r3]
            而后三项的异或和:   s' xor rk
            所有必须异或上一个 rk
         */
        if (hashConfict.get(pos) > 0 && (k - hashConfict.get(pos)) > 0 && (k - hashConfict.get(pos)) % 2 == 0) {
            result = result.xor(rkList.get(pos));
        }

        return result.equals(msg);
    }

    /**
     * 返回由序号seq和计算pos的hash位置确定的元素
     * @param pos   需要返回元素计算hash位置的字符串
     * @return  返回该位置上计算的元素
     * @throws Exception
     */
    public BigInteger retElement(String pos) throws Exception {
        /*
            标记该pos是否在GBF中出现
         */
        boolean flag = false;
        /*
            如果要根据明文计算hash
         */
        for (String npos : hashConfict.keySet()) {
            if (npos.equals(pos)) {
                flag = true;
                break;
            }
        }

        SecretShare2[] shamir = new SecretShare2[k];

        // 将通过pos计算出的位置的字符串取出
        for (int i = 0 ; i < k; i++) {
            long hash = (hashFunctions.get(i).hash(pos)) % size;
            int val = (int)(hash + size) % size;
            shamir[i] = filter[val];
        }


        // 进行秘密恢复，观察是否是GBF内的元素
        // 实际上执行的xor操作
        BigInteger result = share.recover(shamir);
        // 如果分成的份数 - 冲突的份数是偶数，
        // 为了平衡插入的随机数，需要异或该序号对应的 rk (随机数的异或和)
        /*
            r1, r2, r3为随机数
            rk = r2 xor r3
            此时存在冲突，s' = s xor rn xor r1
            secret插入GBF中的元素:    [s xor rn xor r1, s' xor rk xor r2, s' xor s' xor rk xor r3]
            而后三项的异或和:   s' xor rk
            所有必须异或上一个 rk
         */
        if (flag && hashConfict.get(pos) > 0 && (k - hashConfict.get(pos)) > 0 && (k - hashConfict.get(pos)) % 2 == 0) {
            result = result.xor(rkList.get(pos));
        }
        return result;
    }

    public String getRandom(int length) {
        String s = "1";
        for(int i = 0; i < length; ++i) {
            s += "1";
        }
        return s;
    }
    public void fillInAll() {
        for(int i = 0; i < size; ++i) {
            if(filter[i] == null) {
                filter[i] = new SecretShare2(new BigInteger(getRandom(share.lambda)));
            }
        }
    }

    public void setShare(ShamirSecret share) {
        this.share = share;
    }

    public void setFilter(SecretShare2[] filter) {
        this.filter = filter;
    }

    public SecretShare2[] getFilter() {
        return filter;
    }

    /**
     * 测试布隆过滤器
     * @param args 命令行参数
     */
    public static void main(String[] args) throws Exception {
        int size = 10000;
        int k = 3;

        BloomFilterXor filter = new BloomFilterXor(size, k);

        filter.addElement("1", "Tom");
        filter.addElement("2", "Judy");
        filter.addElement("3", "Jerry");
        filter.addElement("4", "Sun");
        filter.addElement("5", "Thompson");
        filter.fillInAll();
        // 检查一些随机字符串是否在布隆过滤器中
        System.out.println(filter.checkElement("1", "Tom"));
        System.out.println(filter.checkElement("abc", "Tom"));
        System.out.println(filter.checkElement("2", "Judy"));
        System.out.println(filter.checkElement("Sam", "Thompson"));
        System.out.println(filter.checkElement("5", "Jerry"));

        // 返回对应明文位置上的字符串
        BigInteger res = filter.retElement("Tom");
        BigInteger res2 = filter.retElement("Judy");
        BigInteger res3 = filter.retElement("To");

        byte[] byte1 = res.toByteArray();
        byte[] byte2 = res2.toByteArray();

        System.out.println("\nRes1: " + new String(byte1));
        System.out.println("\nRes2: " + new String(byte2));
        System.out.println("\nRes3: " + res3);
    }
}


