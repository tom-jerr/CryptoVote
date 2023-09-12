package com.example.toupiao.algorithm;

import java.math.BigInteger;
import java.util.Random;

//生成p，q，r
public class Paillier {

    /**
     * p and q are two large primes.
     * lambda = lcm(p-1, q-1) = (p-1)*(q-1)/gcd(p-1, q-1).
     */
    private BigInteger p, q, lambda;
    /**
     * 计算其中的私钥
     */
    public BigInteger u;
    /**
     * n = p*q.
     */
    public BigInteger n;
    /**
     * nsquare = n*n
     */
    public BigInteger nsquare;
    /**
     * a random integer r in Z*_{n^2} where gcd (L(g^lambda mod n^2), n) = 1.( 其中=前者mod后者有逆元同个道理)
     */
    private BigInteger g;
    /**
     * number of bits of modulus
     */
    private int bitLength;

    public Paillier(int bitLengthVal, int certainty) {
        KeyGeneration(bitLengthVal, certainty);
    }

    /**
     * Constructs an instance of the Paillier cryptosystem with 512 bits of
     * modulus and at least 1-2^(-64) certainty of primes generation.
     */
    public Paillier() {
        KeyGeneration(512, 64);
    }

    //用于初始化值
    public void KeyGeneration(int bitLengthVal, int certainty) {
        //bitLengthVal是位数值，certainty是准确度值（用于确定多少概率生成一个素数）
        bitLength = bitLengthVal;
        /*
         * Constructs two randomly generated positive BigIntegers that are
         * probably prime, with the specified bitLength and certainty.
         */
        //随机生成（但此处确定了种子值所以应该是定值）两个大素数
//        p = new BigInteger(bitLength / 2, certainty, new Random(1));
//        q = new BigInteger(bitLength / 2, certainty, new Random(1));

        p = new BigInteger("3989");
        q = new BigInteger("4001");

        n = p.multiply(q);
        nsquare = n.multiply(n);
        //将字符串变为biginteger表达形式(此处将2改为了N+1)
        g = n.add(BigInteger.ONE);

        //相当于p-1乘以q-1，后再除以了（p-1和q-1的最大公因数）
        lambda = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE))
                .divide(p.subtract(BigInteger.ONE).gcd(q.subtract(BigInteger.ONE)));
        /* check whether g is good. */

        //a.modpow（b,c）是用于将a的b次方模c
        //即检测该生成元是否符合使得求逆元成立
        if (g.modPow(lambda, nsquare).subtract(BigInteger.ONE).divide(n).gcd(n).intValue() != 1) {
            System.out.println("g is not good. Choose g again.");
            System.exit(1);
        }

        //私钥计算方法
        u = g.modPow(lambda, nsquare).subtract(BigInteger.ONE).divide(n).modInverse(n);
    }

    //输入m和r输出密文
    public BigInteger Encryption(BigInteger m, BigInteger r) {
        BigInteger ret = g.modPow(m, nsquare).multiply(r.modPow(n, nsquare)).mod(nsquare);
        return ret;
    }

    //输入明文，其中的r是随机选定的，输出密文
    public BigInteger Encryption(BigInteger m) {
//        if (m.intValue() < 0 || m.intValue() > n.intValue()) {
//            System.out.println("明文消息不符合");
//            System.exit(1);
//        }
//        BigInteger r = new BigInteger(bitLength, new Random());
        BigInteger r = new BigInteger(bitLength, new Random(1)).mod(nsquare);
        BigInteger result = g.modPow(m, nsquare).multiply(r.modPow(n, nsquare)).mod(nsquare);

        return result;
    }

    //输入密文，输出其解得的明文
    public BigInteger Decryption(BigInteger c) {
        //a.modInverse（b）是用于求a关于模b的逆元
        //其中u为解密的私钥
        BigInteger ret = c.modPow(lambda, nsquare).subtract(BigInteger.ONE).divide(n).multiply(u).mod(n);
        return ret;
    }

    //其目标是实现明文的相加，但在实现上需要进行密文的相乘并且模n方
    public BigInteger cipher_add(BigInteger em1, BigInteger em2) {
        BigInteger ret = em1.multiply(em2).mod(nsquare);
        return ret;
    }

}