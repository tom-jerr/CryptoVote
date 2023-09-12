package com.example.toupiao.algorithm.SBTandSEP;



import com.example.toupiao.algorithm.Paillier;

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

    /**
     * 直接判断某一西塔值和0的大小，再直接给出emiu的值
     * @param xita1
     * @param xita2
     * @return
     */
    public BigInteger decision(BigInteger xita1, BigInteger xita2){
        Paillier paillier = new Paillier();
        BigInteger u = null;

        if(xita1.compareTo(xita2) == 1) {
            u = new BigInteger("-1");
        }
        else{
            u = new BigInteger("1");
        }

        BigInteger eu = paillier.Encryption(u);
        return eu;
    }

    public BigInteger decision(BigInteger xita){
        Paillier paillier = new Paillier();
        BigInteger u = null;
        String s = xita.toString(2);
        if(s.length() <= 23) {
            u = new BigInteger("-1");
        }
        else{
            u = new BigInteger("1");
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
