import com.ruoyi.algorithm.Paillier;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

/**
 * @author lzy
 * @version 1.0.0
 * 2023/5/24 18:24
 */
public class PaillierTest {
    @Test
    public void PaillierTest_ENC() {
        Paillier paillier = new Paillier();
        /* instantiating two plaintext msgs 即明文*/
        BigInteger m1 = new BigInteger("-1");
        BigInteger em1 = paillier.Encryption(m1);
        System.out.println("decrypted text:" + "\t" + paillier.Decryption(em1).toString());
    }
    @Test
    public void PaillierTest_CipherAdd() {
        /* instantiating an object of Paillier cryptosystem */
        Paillier paillier = new Paillier();
        /* instantiating two plaintext msgs 即明文*/
        BigInteger m1 = new BigInteger("20");
        BigInteger m2 = new BigInteger("60");
        System.out.print("message:\t" + m1 + "\t" + m2 + "\n");
        /* encryption 加密形成密文*/
        BigInteger em1 = paillier.Encryption(m1);
        BigInteger em2 = paillier.Encryption(m2);
        /* printout encrypted text 输出密文*/
        System.out.print("cipher:" + "\t" +  em1 + "\t" + em2 + "\n");
        /* printout decrypted text 输出明文 */
        System.out.println("decrypted text:" + "\t" + paillier.Decryption(em1).toString() + "\t"
                            + paillier.Decryption(em2).toString());
    }

    @Test
    public void PaillierAddTest() {
        //sum test
        Paillier p = new Paillier();
        BigInteger t1 = new BigInteger("21");
        BigInteger t2 = new BigInteger("50");
        BigInteger t3 = new BigInteger("50");
        System.out.println("original sum: " + (t1.add(t2.add(t3))));
        BigInteger et1 = p.Encryption(t1);
        BigInteger et2 = p.Encryption(t2);
        BigInteger et3 = p.Encryption(t3);
        BigInteger sum = new BigInteger("1");
        sum = p.cipher_add(sum, et1);
        sum = p.cipher_add(sum, et2);
        sum = p.cipher_add(sum, et3);
        System.out.println("sum: "+sum.toString());
        System.out.println("decrypted sum: "+p.Decryption(sum).intValue());

        BigInteger new1 = new BigInteger("1");
        BigInteger new2 = new BigInteger("2");
        BigInteger addl = new1.subtract(new2);
        System.out.println("new1 + new2:\t" + addl.toString());

        Paillier paillier = new Paillier();
        BigInteger cipher = paillier.Encryption(new1).multiply(paillier.Encryption(new2).modInverse(paillier.nsquare));
        BigInteger msg = paillier.Decryption(cipher);
        System.out.println("msg:\t" + msg.toString());
    }

    @Test
    public void PaillierBigIntegerTest2() {
        BigInteger a = new BigInteger("5");
        // 门限的阈值
        BigInteger m1 = new BigInteger("20");
        // 候选人票数
        BigInteger m2 = new BigInteger("80");

        String s = "1";
        String r1 = "2", r2 = "1";
        Paillier paillier = new Paillier();
        BigInteger em1 = paillier.Encryption(m1);
        BigInteger em2= paillier.Encryption(m2);

        BigInteger er2 = paillier.Encryption(new BigInteger(r2));
        BigInteger nsquare = paillier.nsquare;

        BigInteger exita = (em1.multiply(em2.modInverse(nsquare))).modPow(new BigInteger(r1),nsquare)
                .multiply((er2.modInverse(nsquare)).modPow(new BigInteger(s),nsquare)).mod(nsquare);
        System.out.println("cipher:\t" + exita);

        System.out.println("msg:\t" + paillier.Decryption(exita).toString());
        System.out.println(paillier.Decryption(exita).compareTo(BigInteger.ZERO));
    }

    @Test
    public void EncTest() {
        BigInteger a = new BigInteger("100001");
        // 门限的阈值
        BigInteger m1 = new BigInteger("20");
        // 候选人票数
        BigInteger m2 = new BigInteger("80");

        String s = "1";
        String r1 = "2", r2 = "1";
        Paillier paillier = new Paillier();
        BigInteger em1 = paillier.Encryption(m1);
        BigInteger em2= paillier.Encryption(m2);

        BigInteger er2 = paillier.Encryption(new BigInteger(r2));
        BigInteger nsquare = paillier.nsquare;

        BigInteger exita1= (em1.multiply(em2.modInverse(nsquare))).modPow(new BigInteger(r1),nsquare)
                .multiply((er2.modInverse(nsquare)));
        BigInteger exita = exita1.modPow(new BigInteger(s),nsquare);
        BigInteger tmp1 = new BigInteger(r1).multiply(m1.subtract(m2));
        BigInteger msg = new BigInteger(s).multiply(tmp1.subtract(new BigInteger(r2)));
        BigInteger cipher = paillier.Encryption(msg);
        BigInteger decryption = paillier.Decryption(exita);
        System.out.println(cipher);
        System.out.println(paillier.Encryption(new BigInteger("15959868")).toString());
        System.out.println(exita);
        System.out.println(msg);
        System.out.println(paillier.Decryption(cipher).toString());
        System.out.println(decryption);
        System.out.println(decryption.toString(2));
    }

    @Test
    public void SingleEncTest() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(5000);
        System.out.println("单元素加解密测试");
        Paillier p = new Paillier();
        Integer hash = 31;
        BigInteger[] single = new BigInteger[10000];
        for(int i = 0; i < 100; ++i) {
            hash = (31*hash + i*31);
            if(hash < 0) {
                hash = 0 - hash;
            }
            String val = hash.toString();
            System.out.print("明文:\t" + hash +"\t\t");
//            System.out.print(hash +"\t\t\t");
            if(i < 3) {
                if(i == 0) System.out.print("\t");
                System.out.print("\t");
            }
            single[i] = new BigInteger(val);
            BigInteger encryption = p.Encryption(single[i]);
            System.out.print("密文:\t" + encryption+"\t\t");
//            System.out.print(encryption+"\t\t\t");
            BigInteger decryption = p.Decryption(encryption);
            System.out.print("解密结果:\t" + decryption+"\t\t");
            if(i < 3) {
                if(i == 0) System.out.print("\t");
                System.out.print("\t");
            }
//            System.out.print(decryption+"\t\t\t");
            System.out.println("正确性:\t" + single[i].equals(decryption));
            TimeUnit.MILLISECONDS.sleep(500);
        }
    }

    @Test
    public void MultiEncTest() throws InterruptedException {
        System.out.println("两元素相加");
        Paillier p = new Paillier();
        Integer hash = 31;
        BigInteger[] single1 = new BigInteger[10000];
        BigInteger[] single2 = new BigInteger[10000];
        for(int i = 4; i < 100; ++i) {
            hash = (31*hash + i*31);
            if(hash < 0) {
                hash = 0 - hash;
            }
            Integer hash2 = hash/12;
            String val1 = hash.toString();
            String val2 = hash2.toString();
            System.out.print("明文1:\t" + hash +"\t\t");
            if(i < 7) {
                System.out.print("\t");
            }
            System.out.print("明文2:\t" + hash2 +"\t\t");
//            System.out.print(hash +"\t\t\t");
            if(i <= 7) {
                if(i == 4) System.out.print("\t");
                System.out.print("\t");
            }
            // 明文和
            single1[i] = new BigInteger(val1);
            single2[i] = new BigInteger(val2);
            BigInteger singlesum = single1[i].add(single2[i]);
            System.out.print("明文和:\t" + singlesum + "\t\t");
            if(i < 7) {
                System.out.print("\t");
            }
            // 密文和
            BigInteger encryption1 = p.Encryption(single1[i]);
            BigInteger encryption2 = p.Encryption(single2[i]);
            BigInteger encsum = p.cipher_add(encryption1, encryption2);
            System.out.print("密文和:\t" + encsum+"\t\t");

//            System.out.print(encryption+"\t\t\t");
            BigInteger decryption = p.Decryption(encsum);
            System.out.print("解密结果:\t" + decryption+"\t\t");
            if(i < 7) {
                System.out.print("\t");
            }
//            System.out.print(decryption+"\t\t\t");
            System.out.println("正确性:\t" + singlesum.equals(decryption));
            TimeUnit.MILLISECONDS.sleep(500);
        }
    }
}
