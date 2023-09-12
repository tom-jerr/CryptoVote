

import com.ruoyi.algorithm.BloomFilterXor.BloomFilterXor;
import com.ruoyi.algorithm.Paillier;
import com.ruoyi.algorithm.SBTandSEP.SBT_receive;
import com.ruoyi.algorithm.SBTandSEP.SBT_send;
import com.ruoyi.algorithm.SBTandSEP.SEP_receive;
import com.ruoyi.algorithm.SBTandSEP.SEP_send;
import com.ruoyi.system.service.IAppRoomService;
import io.swagger.models.auth.In;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author lzy
 * @version 1.0.0
 * 2023/8/6 14:29
 */
public class EntireTest {
    @Test
    public void SingleVoteTest() throws Exception {
        Paillier p = new Paillier();
        int size = 10000, k = 3;
        BigInteger A = new BigInteger("10");
        BigInteger B = p.Encryption(new BigInteger("4"));

        String candidate[] = new String[]{"Tom", "Judy", "Jerry", "Sum", "Thompson"};
        System.out.print("候选者:\t");
        for(int i = 0; i < 5; ++i) {
            System.out.print(candidate[i] + "   ");
        }
        System.out.println("\n");

        BloomFilterXor[] filters = new BloomFilterXor[5];
        BigInteger[] ems = new BigInteger[5];

        for(int i = 0; i < 5; ++i) {
            filters[i] = new BloomFilterXor(size, k);
            ems[i] = p.Encryption(new BigInteger("1"));
        }

        String votepeople[] = new String[]{"Sum", "Tom", "Tom", "Tom", "Tom"};
        // 投票的结果
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("投票情况:");
        for(int i = 0; i < 5; ++i) {
            System.out.println(candidate[i] + " vote:\t" + votepeople[i]);
        }
        System.out.println("\n");
        filters[0].addElement(ems[0], "Sum");
        filters[1].addElement(ems[1], "Tom");
        filters[2].addElement(ems[2], "Tom");
        filters[3].addElement(ems[3], "Tom");
        filters[4].addElement(ems[4], "Tom");

        BigInteger[] retElements1 = new BigInteger[5];
        BigInteger[] retElements2 = new BigInteger[5];
//        System.out.println("elements:");
        for(int i = 0; i < 5; ++i) {
            filters[i].fillInAll();
        }
        for(int i = 0; i < 5; ++i) {
            retElements1[i] = filters[i].retElement("Tom");
            retElements2[i] = filters[i].retElement("Sum");
//            System.out.println(p.Decryption(retElements1[i]));
//            System.out.println(p.Decryption(retElements2[i]));
        }

        // SEP_send第一次发送
        SEP_send[] sends1 = new SEP_send[5];
        SEP_send[] sends2 = new SEP_send[5];
        for(int i = 0; i < 5; ++i) {
            sends1[i] = new SEP_send(A, ems[i], retElements1[i]);
            sends2[i] = new SEP_send(A, ems[i], retElements2[i]);
        }

        BigInteger[][] Integers1 = new BigInteger[5][];
        BigInteger[][] Integers2 = new BigInteger[5][];
        for(int i = 0; i < 5; ++i) {
            Integers1[i] = sends1[i].calculate_2xita();
            Integers2[i] = sends2[i].calculate_2xita();
        }

        SEP_receive[] receives1 = new SEP_receive[5];
        SEP_receive[] receives2 = new SEP_receive[5];
        for(int i = 0; i < 5; ++i) {
            receives1[i] = new SEP_receive(Integers1[i]);
            receives2[i] = new SEP_receive(Integers2[i]);
        }
        BigInteger[][] emius1 = new BigInteger[5][size];
        BigInteger[][] emius2 = new BigInteger[5][size];
        for(int i = 0; i < 5; ++i) {
            emius1[i] = receives1[i].calculate();
            emius2[i] = receives2[i].calculate();
        }

        BigInteger[] res1 = new BigInteger[5];
        BigInteger[] res2 = new BigInteger[5];
        for(int i = 0; i < 5; ++i) {
            res1[i] = sends1[i].calculate_result(emius1[i]);
            res2[i] = sends2[i].calculate_result(emius2[i]);
//            System.out.println(p.Decryption(res1[i]).toString());
//            System.out.println(p.Decryption(res2[i]).toString());
        }
//        System.out.println("SEP res:");

        BigInteger total1 = p.Encryption(BigInteger.ZERO);
        BigInteger total2 = p.Encryption(BigInteger.ZERO);
        for(int i = 0; i < 5; ++i) {
//            System.out.println(p.Decryption(res1[i]));
//            System.out.println(p.Decryption(res2[i]));
            total1 = p.cipher_add(total1, res1[i]);
            total2 = p.cipher_add(total2, res2[i]);
        }
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("获得总票数:");
        System.out.println("Tom\t" + p.Decryption(total1).divide((BigInteger.ONE.add(BigInteger.ONE))));
        System.out.println("Sum\t" + p.Decryption(total2).divide((BigInteger.ONE.add(BigInteger.ONE))));
        System.out.println("\n");
        String name[] = new String[]{"Tom", "Sum"};
        /**
         *  安全比较协议
         */
        SBT_send[] sbtSends = new SBT_send[2];
        BigInteger[] exitas = new BigInteger[2];
        SBT_receive[] sbtReceives = new SBT_receive[2];
        BigInteger[] emius = new BigInteger[2];

        sbtSends[0] = new SBT_send(A, B, total1);
        sbtSends[1] = new SBT_send(A, B, total2);

        TimeUnit.MILLISECONDS.sleep(1000);
        for(int i = 0; i < 2; ++i) {
            exitas[i] = sbtSends[i].calculate();
            sbtReceives[i] = new SBT_receive(exitas[i]);
            emius[i] = sbtReceives[i].calculate();
            System.out.println(name[i] +"是否超过半数票数:\t" +(sbtSends[i].calculate_result(emius[i]).toString().equals("1")));
        }
    }

    @Test
    public void MutiVoteTest() {

    }

    @Test
    public void ReRandVoteTest() throws Exception {
        System.out.println("ReRand在投票中的应用:");
        Paillier p = new Paillier();
        int size = 100, k = 3;
        BigInteger A = new BigInteger("10");
        BigInteger B = p.Encryption(new BigInteger("3"));

        String candidate[] = new String[]{"Tom", "Judy"};
        String people[] = new String[]{"Jerry", "Sum", "Thompson"};
        System.out.print("候选者:\t");
        for(int i = 0; i < 2; ++i) {
            System.out.print(candidate[i] + "   ");
        }
        System.out.println("\n");

        BloomFilterXor[] filters = new BloomFilterXor[5];
        BigInteger[] ems = new BigInteger[5];

        for(int i = 0; i < 3; ++i) {
            filters[i] = new BloomFilterXor(size, k);
            ems[i] = p.Encryption(new BigInteger("1"));
        }

        String votepeople[] = new String[]{"Judy", "Tom", "Judy"};
        // 投票的结果
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("投票情况:");
        for(int i = 0; i < 3; ++i) {

            if(i==0) {
                System.out.println(people[i] + " vote:\t\t" + votepeople[i]);
            } else if (i == 1) {
                System.out.println(people[i] + " vote:\t\t" + votepeople[i]);
            } else {
                System.out.println(people[i] + " vote:\t" + votepeople[i]);
            }
        }
        System.out.println("");
        TimeUnit.MILLISECONDS.sleep(1000);
        filters[0].addElement(ems[0], "Judy");
        filters[1].addElement(ems[1], "Tom");
        filters[2].addElement(ems[2], "Judy");

        BigInteger[] retElements1 = new BigInteger[5];
        BigInteger[] retElements2 = new BigInteger[5];
//        System.out.println("elements:");
        for(int i = 0; i < 3; ++i) {
            filters[i].fillInAll();
        }
        for(int i = 0; i < 3; ++i) {
            retElements1[i] = filters[i].retElement("Judy");
            retElements2[i] = filters[i].retElement("Tom");
//            System.out.println(p.Decryption(retElements1[i]));
//            System.out.println(p.Decryption(retElements2[i]));
        }

        // SEP_send第一次发送
        SEP_send[] sends1 = new SEP_send[5];
        SEP_send[] sends2 = new SEP_send[5];
        for(int i = 0; i < 3; ++i) {
            sends1[i] = new SEP_send(A, ems[i], retElements1[i]);
            sends2[i] = new SEP_send(A, ems[i], retElements2[i]);
        }

        BigInteger[][] Integers1 = new BigInteger[5][];
        BigInteger[][] Integers2 = new BigInteger[5][];
        for(int i = 0; i < 3; ++i) {
            Integers1[i] = sends1[i].calculate_2xita();
            Integers2[i] = sends2[i].calculate_2xita();
        }

        SEP_receive[] receives1 = new SEP_receive[5];
        SEP_receive[] receives2 = new SEP_receive[5];
        for(int i = 0; i < 3; ++i) {
            receives1[i] = new SEP_receive(Integers1[i]);
            receives2[i] = new SEP_receive(Integers2[i]);
        }
        BigInteger[][] emius1 = new BigInteger[5][size];
        BigInteger[][] emius2 = new BigInteger[5][size];
        for(int i = 0; i < 3; ++i) {
            emius1[i] = receives1[i].calculate();
            emius2[i] = receives2[i].calculate();
        }

        BigInteger[] res1 = new BigInteger[5];
        BigInteger[] res2 = new BigInteger[5];
        for(int i = 0; i < 3; ++i) {
            res1[i] = sends1[i].calculate_result(emius1[i]);
            res2[i] = sends2[i].calculate_result(emius2[i]);
//            System.out.println(p.Decryption(res1[i]).toString());
//            System.out.println(p.Decryption(res2[i]).toString());
        }
//        System.out.println("SEP res:");

        BigInteger total1 = p.Encryption(BigInteger.ZERO);
        BigInteger total2 = p.Encryption(BigInteger.ZERO);

        for(int i = 0; i < 3; ++i) {
//            System.out.println(res1[i]);
//            System.out.println(res2[i]);
            total1 = p.cipher_add(total1, res1[i]);
            total2 = p.cipher_add(total2, res2[i]);
            System.out.println("第"+(i+1)+"次Enc(res1[i])相加:\t" + total1.toString());
            System.out.println("Decrypt total1:\t" + p.Decryption(total1).toString());
            System.out.println("第"+(i+1)+"次Enc(res2[i])相加:\t" + total2.toString());
            System.out.println("Decrypt total2:\t" + p.Decryption(total2).toString());
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(1000);
        }
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("Double tickets of Judy Decrypt:\t"+p.Decryption(total1).toString());
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("Double tickets of Tom  Decrypt:\t"+p.Decryption(total2).toString());
    }
}
