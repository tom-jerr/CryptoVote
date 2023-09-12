package com.ruoyi.algorithm.BloomFilterXor;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.SecureRandom;
/**
 * @author lzy
 * @version 1.0.0
 * 2023/5/7 20:53
 */

 /**
  *
    基于异或的Shamir
    s 分成 3 份
    生成随机数 r1, r2, r3
    rk = r1 xor r2 xor r3

    分配的秘密份额：[s xor rk xor r1, s xor rk xor r2, s xor rk xor r3]
    将其全部异或可以得到秘密
 */
public class ShamirSecret implements Serializable {
     /**
      * n是秘密分享的份数
      */
    public final int n;
     /**
      * 秘密的位数
      */
    public int lambda;
     /**
      * prime是mod的质数
      */
    private final BigInteger prime;
     /**
      * 生成n个随机数的异或和
      * rk 是出现冲突时生成n个随机数的异或和
      */
     private BigInteger rn;
     private BigInteger rk;
     /**
      * 生成的n个随机数
      */
     private BigInteger[] randomlist ;

     /**
      * 初始化密钥共享方案
       * @param n   秘密分享的份数
      * @param prime    mod的质数
      */
    public ShamirSecret(int n, BigInteger prime) {
        this.n = n;
        this.prime = prime;
        this.randomlist = new BigInteger[n];
        SecureRandom random = new SecureRandom();
        BigInteger tmp = BigInteger.ONE;
        for (int i = 0; i < n; i++) {
            randomlist[i] = new BigInteger(prime.bitLength(), random).mod(prime);
            tmp = tmp.xor(randomlist[i]);
        }
        this.rn = tmp.xor(BigInteger.ONE);
        this.rk = BigInteger.ZERO;
    }

//    /**
//     * 秘密共享分配
//     * 如果有n个人分配，n为奇数，所有人分配secret xor rn和对应的ri
//     * n为偶数，最后一个人分配secret xor secret xor rn
//     * @param secret    需要共享的秘密
//     * @return
//     */
//    public SecretShare2[] share(BigInteger secret) {
//        SecretShare2[] share = new SecretShare2[n];
//        for (int i = 0; i < n; i++) {
//            share[i] = new SecretShare2(randomlist[i],rn,secret.xor(rn).xor(randomlist[i]));
//        }
//        if (n % 2 == 0) {
//            share[0] = new SecretShare2(randomlist[n - 1],rn,secret.xor(rn).xor(randomlist[n - 1]));
//        }
//        return share;
//    }

    /**
     * 秘密共享恢复
     * n为奇数，将所有的shares[i]异或后再异或rn
     * n为偶数，将所有的shares[i]异或即可
     * @param shares    密钥分配后生成的BigInteger
     * @return
     */
    public BigInteger recover(SecretShare2[] shares) {
        BigInteger result = BigInteger.ONE;

        for(SecretShare2 s : shares) {
            if(s != null){
                result = result.xor(s.share);
            }
        }

//        for (int i = 0; i < n; i++) {
//            result = result.xor(shares[i].share);
//        }
        if (n > 0 && n % 2 == 0) {
            result = result.xor(shares[0].getRn());
        }
        result = result.xor(BigInteger.ONE);
        return result;
    }

     /**
      * 出现冲突后，按照new_n分配秘密
      * @param secret   需要分配的秘密
      * @param new_n    分配的份数
      * @return 装有秘密的类对象数组
      *
      * SecretShare2：存放当前生成随机数的异或和（每插入一个字符串，就重新生成随机数）、分配到的秘密份额
      */
     public SecretShare2[] share_by_K(BigInteger secret, int new_n) {
         SecretShare2[] share = new SecretShare2[new_n];
         BigInteger[] new_random = new BigInteger[new_n];

         /*
            生成new_n个随机数，计算它们的异或和
          */
         rk = BigInteger.ONE;
         SecureRandom random2 = new SecureRandom();
//         for (int i = 0; i < new_n; i++) {
//             new_random[i] = new BigInteger(prime.bitLength(), random2).mod(prime);
//             rk = rk.xor(new_random[i]);
//         }
         for (int i = 0; i < new_n; i++) {
             new_random[i] = randomlist[i];
             rk = rk.xor(new_random[i]);
         }

         rk = rk.xor(BigInteger.ONE);

         /*
            如果出现偶数个份数
            rk = r1 xor r2
            secret插入GBF中的元素:    [s xor rk xor r1, s xor s xor rk xor r2]
            最后一个元素必须异或上一个 s，保证异或和可以得到秘密
          */
         int num = new_n;
         if (new_n > 0 && new_n % 2 == 0)
         {
             num = new_n - 1;
             // share[i]中包括ri和secret xor rn
             share[new_n - 1] = new SecretShare2(new_random[new_n - 1], rk, secret.xor(rk).xor(secret).xor(new_random[new_n - 1]));
         }

         for (int i = 0; i < num; i++) {
             share[i] = new SecretShare2(new_random[i], rk, secret.xor(rk).xor(new_random[i]));
         }
         this.lambda = share[0].share.bitLength();
         return share;
     }

//     public BigInteger recover_by_K(SecretShare2[] shares, int new_n) {
//         BigInteger result = BigInteger.ONE;
//
//         for (int i = 0; i < new_n; i++) {
//             result = result.xor(shares[i].share);
//
//         }
//         if (new_n % 2 == 0) {
//             result = result.xor(shares[n - 1].getRn());
//         }
//         result = result.xor(BigInteger.ONE);
//         return result;
//     }

    public static void main(String[] args) {
        // 构造素数
        BigInteger prime = new BigInteger("91");
        BigInteger prime2 = new BigInteger("131");

        // n为奇数和偶数时，密钥分配

        ShamirSecret shamireven = new ShamirSecret(5, prime2);


        // 字符串转为BigInteger
        byte[] inputStringBytes = "Judy".getBytes();
        BigInteger secret = new BigInteger(inputStringBytes);

        // 测试share_by_k
        System.out.println("Secret: "+secret);
        SecretShare2[] Integers_K = shamireven.share_by_K(secret, 5);
        BigInteger res_K = shamireven.recover(Integers_K);
        System.out.println("recover:" + res_K);
        if (res_K.equals(secret)) {
            System.out.println("True!");
        }
    }
}
