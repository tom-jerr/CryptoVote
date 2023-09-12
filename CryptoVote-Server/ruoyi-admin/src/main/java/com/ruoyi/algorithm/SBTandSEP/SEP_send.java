package com.ruoyi.algorithm.SBTandSEP;



import com.ruoyi.algorithm.Paillier;

import java.math.BigInteger;

public class SEP_send {
    /**
     * 哈希函数个数
     */
    public BigInteger k;

    /**
     * 比较相等的密文,且在第一步中取得的两个s
     */
    public String s1;
    public String s2;
    public BigInteger em1;
    public BigInteger em2;

    /**
     * 两次比较的结果,即第一大步骤的结果
     */
    public BigInteger exita1;
    public BigInteger exita2;

    /**
     * 第三大步骤的输出结果，即两个edelta
     */
    public BigInteger edelta1;
    public BigInteger edelta2;

    /**
     * 整个安全判等协议的最终结果，即a
     */
    public BigInteger a;

    /**
     * 初始化需要的数据（即哈希函数个数和两个密文）
     * @param k_numberofhash
     * @param em1
     * @param em2
     */
    public SEP_send(BigInteger k_numberofhash,BigInteger em1,BigInteger em2){
        this.k=k_numberofhash;
        this.em1=em1;
        this.em2=em2;
    }

    /**
     * 即在安全判等协议的第一步
     * @return
     */
    public BigInteger[] calculate_2xita(){
        //初始化em1比较em2和em2比较em1
        SBT_send sbt_send1 = new SBT_send(k,em1,em2);
        SBT_send sbt_send2 = new SBT_send(k,em2,em1);

        //得到两个s值
        this.s1 = sbt_send1.s;
        this.s2 = sbt_send2.s;
//        this.s1 = "1";
//        this.s2 = "1";
        //直接利用SBT计算两个exita结果值
        this.exita1 = sbt_send1.calculate();
        this.exita2 = sbt_send2.calculate();

        BigInteger[] bigIntegers = new BigInteger[2];
        bigIntegers[0] = exita1; bigIntegers[1] = exita2;
        return bigIntegers;
   }

    /**
     * 在安全判等协议的第三大步骤中，小判断每个s
     * @param s
     * @param emiu
     * @return
     */
    public BigInteger decision(String s,BigInteger emiu){
        Paillier paillier = new Paillier();
        BigInteger edelta_temp = null;

        if(s.equals("1")){
            edelta_temp = emiu;
        }
        else if (s.equals("-1")){
            edelta_temp = emiu.modInverse(paillier.nsquare);
        }
        return edelta_temp;
    }

    /**
     * 在安全判等协议的第三大步骤
     * @param emius
     * @return
     */
    public BigInteger calculate_result(BigInteger[] emius){
        Paillier paillier=new Paillier();

        //计算两个edelta结果值
        BigInteger edl1 = decision(s1,emius[0]);
        BigInteger edl2 = decision(s2,emius[1]);
        this.a = edl1.multiply(edl2);
        return a;
    }

}
