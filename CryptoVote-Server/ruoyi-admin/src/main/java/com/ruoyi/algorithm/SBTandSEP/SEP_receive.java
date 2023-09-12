package com.ruoyi.algorithm.SBTandSEP;



import com.ruoyi.algorithm.Paillier;

import java.math.BigInteger;

public class SEP_receive {
    /**
     * 存放服务器私钥
     */
    public BigInteger pkey;

    /**
     * 输入的两个西塔值
     */
    public BigInteger exita1;
    public BigInteger exita2;


    /**
     * 输出的两个miu值
     */
    public BigInteger emiu1;
    public BigInteger emiu2;

    /**
     * 初始化数值（即两个exita值）
     * @param exitaarr
     */
    public SEP_receive(BigInteger[] exitaarr){
        this.exita1 = exitaarr[0];
        this.exita2 = exitaarr[1];
    }

//    public BigInteger decision(BigInteger xita1, BigInteger xita2){
//        Paillier paillier = new Paillier();
//        BigInteger u = null;
//
//        if(xita1.compareTo(xita2) == 1) {
//            u = new BigInteger("-1");
//        }
//        else{
//            u = new BigInteger("1");
//        }
//
//        BigInteger eu = paillier.Encryption(u);
//        return eu;
//    }

    /**
     * 直接判断某一西塔值和0的大小，再直接给出emiu的值
     * @param xita
     * @return
     */
    public BigInteger decision(BigInteger xita){
        Paillier paillier = new Paillier();
        BigInteger u = null;
//        String s = xita.toString(2);
//        System.out.println(s);
//        if(s.length() <= 23) {
//            u = new BigInteger("-1");
//        } else {
//            u = new BigInteger("1");
//        }
        BigInteger two = BigInteger.ONE.add(BigInteger.ONE);
        BigInteger N2 = paillier.n.divide(two);
        if(xita.max(N2).equals(xita) || xita.equals(N2)) {
            xita = xita.subtract((BigInteger.ONE).multiply(paillier.n));
        }
        if(xita.max(BigInteger.ZERO).equals(xita)) {
            u = new BigInteger("-1");
        } else {
            u = BigInteger.ONE;
        }
        BigInteger eu = paillier.Encryption(u);
        return eu;
    }

    /**
     * 即在判等协议的第二个大步骤
     * @return
     */
    public BigInteger[] calculate(){
        Paillier paillier= new Paillier();
        pkey = paillier.u;

        BigInteger xita1;
        BigInteger xita2;

        xita1 = paillier.Decryption(exita1);
        xita2 = paillier.Decryption(exita2);

        emiu1 = decision(xita1);
        emiu2 = decision(xita2);
        BigInteger[] emius = new BigInteger[2];
        emius[0] = emiu1; emius[1] = emiu2;
        return emius;
    }

}
