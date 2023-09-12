package com.ruoyi.algorithm.SBTandSEP;

import com.ruoyi.algorithm.Paillier;

import java.math.BigInteger;

import static java.lang.Math.pow;
import static java.lang.Math.random;

public class SBT_send {
    /**
     * 输入哈希函数的个数,比对密文1和比对密文2
     */
    public BigInteger k;
    public BigInteger em1;
    public BigInteger em2;

    /**
     *  选取其抛出硬币的值
     */
    public int[] s_list={-1, 1};
    public int s_temp = s_list[(int)(random()+0.5)];//输出0.5-1.5（由int 会下取整所以各一半概率取0,1）
    public String s = String.valueOf(s_temp);

    /**
     * 得到r1，r2两个比特串(字符串)，其中r1要大于r2
     * @return
     */
    public String[] getr(){
        String r1;  //可能为字符串“53”
        String r2;  //可能为字符串“20”

        //做出r1大于r2的于明确值域内的十进制值,结果为字符串
        r1 = getRandom(0,(int)pow(2,k.intValue())-1);
        r2 = getRandom(0,(int)pow(2,k.intValue())-1);
        if (Integer.parseInt(r1) < Integer.parseInt(r2)) {
            String tmp = r1;
            r1 = r2;
            r2 = tmp;
        }
        r1 = "2";
        r2 = "1";

        String[] result = {r1,r2};
        return result;
    }

    /**
     * 初始化需要输入的数据
     * @param k_numberofhash
     * @param em1
     * @param em2
     */
    public SBT_send(BigInteger k_numberofhash, BigInteger em1, BigInteger em2){
        this.k = k_numberofhash;
        this.em1 = em1;
        this.em2 = em2;
    }

    /**
     * 于min到max的确定范围内随机抽取一个值
     * @param min
     * @param max
     * @return
     */
    public String getRandom(int min, int max){
        int num = (int) (Math.random() * (max - min + 1) + min);
        return String.valueOf(num);
    }

    /**
     * 计算出其中的xita加密值
     * @return
     */
    public BigInteger calculate(){
        String[] r = getr();

        Paillier paillier = new Paillier();
        BigInteger er2 = paillier.Encryption(new BigInteger(r[1]));
        BigInteger nsquare = paillier.nsquare;
//        if (s.equals("-1")) {
//            s = "1";
//        }
        BigInteger exita1= (em1.multiply(em2.modInverse(nsquare))).modPow(new BigInteger(r[0]),nsquare)
                .multiply((er2.modInverse(nsquare)));
        BigInteger exita = exita1.modPow(new BigInteger(s),nsquare);

        return exita;
    }

    public BigInteger calculate_result(BigInteger emiu){
        Paillier paillier = new Paillier();
        BigInteger edelta = null;

        if(this.s.equals("1")){
            edelta = emiu;
        }
        else if(this.s.equals("-1")){
            edelta = BigInteger.ONE.subtract(emiu);
            // edelta = paillier.Encryption(BigInteger.ONE).multiply(paillier.Encryption(emiu.modInverse(paillier.nsquare))).mod(paillier.nsquare);
        }

        return edelta;
    }

}
