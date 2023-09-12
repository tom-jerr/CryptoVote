

import com.ruoyi.algorithm.Paillier;
import com.ruoyi.algorithm.SBTandSEP.SBT_receive;
import com.ruoyi.algorithm.SBTandSEP.SBT_send;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

/**
 * @author lzy
 * @version 1.0.0
 * 2023/5/24 19:26
 */
public class SBTTest {
    @Test
    public void SBTOneLargerTwoTest() {
        BigInteger a = new BigInteger("10");
        // 门限的阈值
        BigInteger m1 = new BigInteger("11111");
        // 候选人票数
        BigInteger m2 = new BigInteger("11");

        Paillier paillier = new Paillier();
        BigInteger em1 = paillier.Encryption(m1);
        BigInteger em2= paillier.Encryption(m2);

        SBT_send send = new SBT_send(a, em1, em2);
        BigInteger exita = send.calculate();

        SBT_receive receive = new SBT_receive(exita);
        BigInteger emiu = receive.calculate();

        // m2 >= m1, 输出1; 否则输出0
        System.out.println("emiu: " + emiu.toString());
        System.out.println("s: " + send.s);
        BigInteger res = send.calculate_result(emiu);
        System.out.println("decryption emiu: " + res.toString());
    }

    @Test
    public void SBTTwoLargerOneTest() {
        BigInteger a = new BigInteger("10");
        // 门限的阈值
        BigInteger m1 = new BigInteger("11");
        // 候选人票数
        BigInteger m2 = new BigInteger("1111");

        Paillier paillier = new Paillier();
        BigInteger em1 = paillier.Encryption(m1);
        BigInteger em2= paillier.Encryption(m2);

        SBT_send send = new SBT_send(a, em1, em2);
        BigInteger exita = send.calculate();

        SBT_receive receive = new SBT_receive(exita);
        BigInteger emiu = receive.calculate();

        // m2 >= m1, 输出1; 否则输出0
        System.out.println("emiu: " + emiu.toString());
        System.out.println("s: " + send.s);
        BigInteger res = send.calculate_result(emiu);
        System.out.println("decryption emiu: " + res.toString());
    }


    @Test
    public void SBTtest2() {
        BigInteger a = new BigInteger("10");
        // 门限的阈值
        BigInteger m1 = new BigInteger("11");
        // 候选人票数
        BigInteger m2 = new BigInteger("11111");

        Paillier paillier = new Paillier();
        BigInteger em1 = paillier.Encryption(m1);
        BigInteger em2= paillier.Encryption(m2);

        SBT_send send = new SBT_send(a, em1, em2);
        BigInteger[] exitas = new BigInteger[21];
        for(int i = 0; i < 21; ++i) {
            BigInteger exita = send.calculate();
            exitas[i] = exita;
        }

        Integer posCount = 0;
        Integer negCount = 0;
        BigInteger emiu;
        for (int i = 0; i < 15; ++i) {
            SBT_receive receive = new SBT_receive(exitas[i]);
            emiu = receive.calculate();
            if(emiu == BigInteger.ONE) {
                negCount++;
            }
            else {
                posCount++;
            }
        }
        if(negCount > posCount) {
            emiu = BigInteger.ONE;
        }
        else {
            emiu = BigInteger.ZERO;
        }

        System.out.println("emiu: " + emiu.toString());
        System.out.println("s: " + send.s);
        BigInteger res = send.calculate_result(emiu);
        System.out.println("decryption emiu: " + res.toString());
    }

}
