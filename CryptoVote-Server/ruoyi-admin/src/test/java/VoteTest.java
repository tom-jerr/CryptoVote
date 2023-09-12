import com.ruoyi.algorithm.BloomFilterXor.BloomFilterXor;
import com.ruoyi.algorithm.Paillier;
import com.ruoyi.algorithm.SBTandSEP.SBT_receive;
import com.ruoyi.algorithm.SBTandSEP.SBT_send;
import com.ruoyi.algorithm.SBTandSEP.SEP_receive;
import com.ruoyi.algorithm.SBTandSEP.SEP_send;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class VoteTest {
    @Test
    public void VoteTest() throws Exception {
        Paillier p = new Paillier();
        int size = 100, k = 3;
        BigInteger A = new BigInteger("5");
        BigInteger B = p.Encryption(new BigInteger("2"));

        BloomFilterXor[] filters = new BloomFilterXor[2];
        BigInteger ems = p.Encryption(new BigInteger("1"));
        for(int i = 0; i < 2; ++i) {
            filters[i] = new BloomFilterXor(size, k);
        }


        filters[0].addElement(ems, "啦啦啦");
        filters[1].addElement(ems, "白色");


        BigInteger[] retElements1 = new BigInteger[5];
        BigInteger[] retElements2 = new BigInteger[5];
//        System.out.println("elements:");
        for(int i = 0; i < 2; ++i) {
            filters[i].fillInAll();
        }
        for(int i = 0; i < 2; ++i) {
            retElements1[i] = filters[i].retElement("啦啦啦");
            retElements2[i] = filters[i].retElement("白色");
            System.out.println(p.Decryption(retElements1[i]));
            System.out.println(p.Decryption(retElements2[i]));
        }
        System.out.println("\n");
        // SEP_send第一次发送
        SEP_send[] sends1 = new SEP_send[5];
        SEP_send[] sends2 = new SEP_send[5];
        for(int i = 0; i < 2; ++i) {
            sends1[i] = new SEP_send(A, ems, retElements1[i]);
            sends2[i] = new SEP_send(A, ems, retElements2[i]);
        }

        BigInteger[][] Integers1 = new BigInteger[5][];
        BigInteger[][] Integers2 = new BigInteger[5][];
        for(int i = 0; i < 2; ++i) {
            Integers1[i] = sends1[i].calculate_2xita();
            Integers2[i] = sends2[i].calculate_2xita();
        }

        SEP_receive[] receives1 = new SEP_receive[5];
        SEP_receive[] receives2 = new SEP_receive[5];
        for(int i = 0; i < 2; ++i) {
            receives1[i] = new SEP_receive(Integers1[i]);
            receives2[i] = new SEP_receive(Integers2[i]);
        }
        BigInteger[][] emius1 = new BigInteger[5][size];
        BigInteger[][] emius2 = new BigInteger[5][size];
        for(int i = 0; i < 2; ++i) {
            emius1[i] = receives1[i].calculate();
            emius2[i] = receives2[i].calculate();
            System.out.println("emius1:");
            for(BigInteger b:emius1[i]) {
                System.out.println(p.Decryption(b).toString());
            }
//            System.out.println("emius2:");
//            for(BigInteger b:emius1[i]) {
//                System.out.println(p.Decryption(b).toString());
//            }
        }
        System.out.println("\n");
        BigInteger[] res1 = new BigInteger[5];
        BigInteger[] res2 = new BigInteger[5];
        for(int i = 0; i < 2; ++i) {
            res1[i] = sends1[i].calculate_result(emius1[i]);
            res2[i] = sends2[i].calculate_result(emius2[i]);
            System.out.println(p.Decryption(res1[i]).toString());
            System.out.println(p.Decryption(res2[i]).toString());
        }
//        System.out.println("SEP res:");

        BigInteger total1 = BigInteger.ONE;
        BigInteger total2 = BigInteger.ONE;
        for(int i = 0; i < 2; ++i) {
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
        String name[] = new String[]{"Sum", "Tom"};
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
    public void Test() throws Exception {
        List<BloomFilterXor> filters = new ArrayList<>();
        Paillier p = new Paillier();
        BloomFilterXor newfilter = new BloomFilterXor(100,3);
        newfilter.addElement(p.Encryption(BigInteger.ONE), "tom");
        newfilter.fillInAll();
        filters.add(newfilter);
        List<String> namelist = new ArrayList<>();
        namelist.add("tom");
        namelist.add("judy");
        int n = filters.size();            // 投票人人数
        int m = namelist.size();           // 候选人人数
        int SIZE = 100;                    // 布隆过滤器的装载大小

        BigInteger[][] retelement = new BigInteger[m][n];       // 根据候选人字符串hash去得到加密后的结果
        int i1 = 0, j1 = 0;
        for(String name:namelist) {
            for(BloomFilterXor filter:filters) {
                retelement[i1][j1] = filter.retElement(name);
                j1 += 1;
            }
            i1 += 1;
            j1 = 0;
        }

        // SEP使用的值
        BigInteger A = new BigInteger("3");
        SEP_send[][] sends = new SEP_send[m][n];

        for(int i = 0; i < m;++i) {
            for(int j = 0; j < n; ++j) {
                sends[i][j] = new SEP_send(A,p.Encryption(BigInteger.ONE),retelement[i][j]);
            }
        }

        BigInteger[][][] integers = new BigInteger[m][n][];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                integers[i][j] = sends[i][j].calculate_2xita();
            }
        }

        // SEP接收端
        SEP_receive[][] receives = new SEP_receive[m][n];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n;++j) {
                receives[i][j] = new SEP_receive(integers[i][j]);
            }
        }
        BigInteger[][][] emius = new BigInteger[m][n][SIZE];
        for(int i = 0; i < m;++i) {
            for(int j = 0; j < n;++j) {
                emius[i][j] = receives[i][j].calculate();
                for(BigInteger b:emius[i][j]) {
                    System.out.println(p.Decryption(b).toString());
                }
            }
        }
        System.out.println("\n");

        BigInteger[][] results = new BigInteger[m][n];
        for(int i = 0; i <m;++i) {
            for(int j = 0; j <n;++j) {
                results[i][j] = sends[i][j].calculate_result(emius[i][j]);
                System.out.println(p.Decryption(results[i][j]).toString());
            }
        }

        // 每个候选人的票数(m个候选者)
        BigInteger[] totals = new BigInteger[m];
        for(int i =0; i < m;++i) {
            totals[i] = p.Encryption(BigInteger.ZERO);
        }
        for(int i =0; i < m;++i) {
            for(int j =0 ; j < n;++j) {
                totals[i] = p.cipher_add(totals[i], results[i][j]);
            }
        }
        System.out.println("\n");
        // DEBUG
        for(BigInteger total:totals) {
            System.out.println(p.Decryption(total).toString());
        }

        /*
         *  安全比较协议
         */
        SBT_send[] sbtSends = new SBT_send[m];
        BigInteger[] exitas = new BigInteger[m];
        SBT_receive[] sbtReceives = new SBT_receive[m];
        BigInteger[] sep_emius = new BigInteger[m];
        // 半数票数
        BigInteger flag = p.Encryption(new BigInteger(String.valueOf((n+1)/2)));

        for(int i = 0; i < m; ++i) {
            sbtSends[i] = new SBT_send(A,flag, totals[i]);
        }
        BigInteger[] finalres = new BigInteger[m];
        List<Integer> deletename = new ArrayList<>();
        for(int i = 0; i < m; ++i) {
            exitas[i] = sbtSends[i].calculate();
            sbtReceives[i] = new SBT_receive(exitas[i]);
            sep_emius[i] = sbtReceives[i].calculate();
            finalres[i] = sbtSends[i].calculate_result(sep_emius[i]);
            System.out.println("是否超过半数票数:\t" +(finalres[i].toString().equals("1")));
            if(!finalres[i].toString().equals("1")) {
                deletename.add(i);
            }
        }
    }
}
