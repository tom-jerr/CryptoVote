

import com.ruoyi.algorithm.Paillier;
import com.ruoyi.algorithm.SBTandSEP.SEP_receive;
import com.ruoyi.algorithm.SBTandSEP.SEP_send;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

/**
 * @author lzy
 * @version 1.0.0
 * 2023/5/24 19:50
 */
public class SEPTest {
    @Test
    public void SEPTestNotEqual() {
        BigInteger a=new BigInteger("10");
        BigInteger m1=new BigInteger("1");
        BigInteger m2=new BigInteger("3917772");

        Paillier paillier = new Paillier();
        BigInteger em1 = paillier.Encryption(m1);
        BigInteger em2 = paillier.Encryption(m2);
        System.out.println("secret:");
        System.out.println(em1 + "\t" + em2);
        SEP_send send = new SEP_send(a, em1, em2);
        BigInteger[] bigIntegers = send.calculate_2xita();


        SEP_receive receive = new SEP_receive(bigIntegers);
        BigInteger[] emius = receive.calculate();
        System.out.println("s:\t" + send.s1 + "\t" + send.s2);
        for (int i = 0; i < 2; i++) {
//            System.out.println(emius[i].toString());
            System.out.println(paillier.Decryption(emius[i]));
        }
        BigInteger res = send.calculate_result(emius);
        System.out.println("res:");
        System.out.println(paillier.Decryption(res).toString());
    }

    @Test
    public void SEPTestEqual() {
        BigInteger a=new BigInteger("10");
        BigInteger m1=new BigInteger("1");
        BigInteger m2=new BigInteger("1");

        Paillier paillier = new Paillier();
        BigInteger em1 = paillier.Encryption(m1);
        BigInteger em2 = paillier.Encryption(m2);
        SEP_send send = new SEP_send(a, em1, em2);
        BigInteger[] bigIntegers = send.calculate_2xita();


        SEP_receive receive = new SEP_receive(bigIntegers);
        BigInteger[] emius = receive.calculate();
        System.out.println("s:\t" + send.s1 + "\t" + send.s2);
        for (int i = 0; i < 2; i++) {
//            System.out.println(emius[i].toString());
            System.out.println(paillier.Decryption(emius[i]));
        }
        BigInteger res = send.calculate_result(emius);
        System.out.println(paillier.Decryption(res).toString());
    }

    @Test
    public void ReRand() throws InterruptedException {
        System.out.println();
        System.out.println("ReRand测试:\n");
        BigInteger two = BigInteger.ONE.add(BigInteger.ONE);

        int N = 10;
        Paillier paillier = new Paillier();
        BigInteger rerand2 = paillier.cipher_add(paillier.Encryption(two), paillier.Encryption(BigInteger.ZERO));
        BigInteger rerand3 = paillier.cipher_add(paillier.Encryption(BigInteger.ZERO), rerand2);
        BigInteger rerandn = paillier.Encryption(two);

        for(int i = 0; i < N; ++i) {
            rerandn = paillier.cipher_add(rerandn, paillier.Encryption(BigInteger.ZERO));
        }

        System.out.println("Enc(2):\t\t\t\t\t"+paillier.Encryption(two).toString());
        System.out.println("Decrypt:\t\t\t\t"+paillier.Decryption(paillier.Encryption(two)).toString());
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("Enc(2)+Enc(0):\t\t\t"+rerand2.toString());
        System.out.println("Decrypt:\t\t\t\t"+paillier.Decryption(rerand2).toString());
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("Enc(2)+Enc(0)+Enc(0):\t"+rerand3.toString());
        System.out.println("Decrypt:\t\t\t\t"+paillier.Decryption(rerand2).toString());
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("Enc(2)+...(10个)Enc(0):\t"+rerandn.toString());
        System.out.println("Decrypt:\t\t\t\t"+paillier.Decryption(rerandn).toString());

    }
}
