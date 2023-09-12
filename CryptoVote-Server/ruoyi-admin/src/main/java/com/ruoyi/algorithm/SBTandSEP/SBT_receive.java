package com.ruoyi.algorithm.SBTandSEP;


import com.ruoyi.algorithm.Paillier;

import java.math.BigInteger;

public class SBT_receive {

    private BigInteger pkey;
    private Integer PosCount;
    private Integer NegCount;

    public BigInteger k;
    public BigInteger exita;

    //输出的返回值
    public BigInteger emiu;

    //用于对接收的exita的处理操作选择
    public BigInteger u;


    //初始化时输入其中的接受值
    public SBT_receive(BigInteger exita){
        this.exita = exita;
    }

    public BigInteger calculate(){
        Paillier paillier = new Paillier();
        this.pkey = paillier.u;

        //调用paillier解密函数解密exita
        BigInteger xita = paillier.Decryption(exita);
        BigInteger two = BigInteger.ONE.add(BigInteger.ONE);

        BigInteger N2 = paillier.n.divide(two);
        if(xita.max(N2).equals(xita) || xita.equals(N2)) {
            xita = xita.subtract((BigInteger.ONE).multiply(paillier.n));
        }
        if(xita.max(BigInteger.ZERO).equals(xita)) {
            this.emiu = BigInteger.ZERO;
        } else {
            this.emiu = BigInteger.ONE;
        }
//        String s = xita.toString(2);
//        if(s.length() <= 23) {
//            this.emiu = BigInteger.ZERO;
//        } else {
//            this.emiu = BigInteger.ONE;
//        }
        //生成返回值；可以返回明文
//        System.out.println(emiu.toString());
        return emiu;
    }
}
