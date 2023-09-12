package com.example.toupiao.algorithm.BloomFilterXor;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author lzy
 * @version 1.0.0
 * 2023/5/7 18:31
 */
public class SecretShare2 implements Serializable {
    /**
     * 生成的随机函数ri
     */
    private BigInteger ri ;
    /**
     * 当前n个随机数的异或和
     */
    private BigInteger rn ;
    /**
     * 秘密共享得到的secret xor rn
     */
    public BigInteger share;
    public SecretShare2(final BigInteger share) {
        this.ri = BigInteger.ONE;
        this.rn = BigInteger.ONE;
        this.share = share;
    }
    public SecretShare2(final BigInteger num, final BigInteger rn, final BigInteger share) {
        this.ri = num;
        this.rn = rn;
        this.share = share;
    }

    public BigInteger getRi() {
        return ri;
    }

    public BigInteger getShare() {
        return share;
    }

    public void setShare(BigInteger share) {
        this.share = share;
    }

    public void setNum(BigInteger num) {
        this.ri = num;
    }

    public void setRi(BigInteger ri) {
        this.ri = ri;
    }

    public BigInteger getRn() {
        return rn;
    }

    public void setRn(BigInteger rn) {
        this.rn = rn;
    }

    @Override
    public String toString() {
        return rn.toString() + ri.toString() + share.toString();
    }
    public SecretShare2 toShare(String ri, String rn, String share) {
        SecretShare2 share2 = new SecretShare2(new BigInteger(ri), new BigInteger(rn), new BigInteger(share));
        return share2;
    }
}

