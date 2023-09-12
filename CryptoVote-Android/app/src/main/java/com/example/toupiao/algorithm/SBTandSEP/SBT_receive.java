package com.example.toupiao.algorithm.SBTandSEP;


import com.example.toupiao.algorithm.Paillier;

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
        System.out.println("xita: " + xita.toString(2));
        String s = xita.toString(2);

        //当其xita大于0时
        if (s.length() > 23) {
            this.emiu = BigInteger.ONE;
        }
        else {
            this.emiu = BigInteger.ZERO;
        }
        //生成返回值；可以返回明文
        System.out.println(emiu.toString());
        return emiu;
    }
}
