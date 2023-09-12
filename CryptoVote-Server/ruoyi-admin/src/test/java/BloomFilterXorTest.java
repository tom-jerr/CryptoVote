import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ruoyi.algorithm.BloomFilterXor.BloomFilterXor;
import com.ruoyi.algorithm.HashFuncDeserializer;
import com.ruoyi.algorithm.Paillier;
import com.ruoyi.algorithm.SerializeUtil;
import com.ruoyi.algorithm.hash.BKDRHash;
import com.ruoyi.algorithm.hash.HashFunc;
import com.ruoyi.algorithm.hash.RSHash;
import com.ruoyi.algorithm.hash.SDBMHash;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author lzy
 * @version 1.0.0
 * 2023/8/8 0:57
 */

public class BloomFilterXorTest {
    @Test
    public void InsertTest() throws Exception {
        int size = 10000;
        int k = 3;

        BloomFilterXor filter = new BloomFilterXor(size, k);
        Paillier p = new Paillier();
        BigInteger em1 = p.Encryption(BigInteger.ONE);

        String candidate[] = new String[]{"Tom", "Judy", "Jerry", "Sun", "Thompson"};
        System.out.print("候选者:\t");
        for(int i = 0; i < 5; ++i) {
            System.out.print(candidate[i] + "   ");
        }
        System.out.println();

        System.out.print("选择的候选者:\t");
        System.out.print(candidate[1] + "   ");
        System.out.println(candidate[2]);

        System.out.println("插入的元素:\t" + em1.toString() + "    " + em1.toString());
        System.out.println("\n");
        TimeUnit.MILLISECONDS.sleep(2000);
        // 填充布隆过滤器
        filter.addElement(em1.toString(), candidate[1]);
        filter.addElement(em1.toString(), candidate[2]);
        filter.fillInAll();

        // 判断是否在布隆过滤器中
        for(int i = 0; i < 5; ++i) {
            BigInteger res = filter.retElement(candidate[i]);
            byte[] bytes = res.toByteArray();
            System.out.println("候选人"+(i+1));
            System.out.println("获得的元素:\t" + new String(bytes));
            System.out.println("是否在过滤器:\t" + filter.checkElement(em1.toString(), candidate[i]));
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(500);
        }
        System.out.print("算法获取的候选人:\t");
        for(int i = 0; i < 5; ++i) {
            if(filter.checkElement(em1.toString(), candidate[i])) {
                System.out.print(candidate[i] + "   ");
            }
        }
        System.out.println();
    }

    @Test
    public void SerializeTest() throws Exception {
        int size = 10000;
        int k = 3;
        BloomFilterXor filter = new BloomFilterXor(size, k);

        filter.addElement("1", "Tom");
        filter.addElement("2", "Judy");
        filter.addElement("3", "Jerry");
        filter.addElement("4", "Sun");
        filter.addElement("5", "Thompson");
        filter.fillInAll();

        String objstring = SerializeUtil.serialize(filter);
//        System.out.println(objstring);
        BloomFilterXor newfilter = SerializeUtil.deserialize(objstring);

        System.out.println(newfilter.checkElement("1","Tom"));
        System.out.println(newfilter.checkElement("2","Tom"));
    }

    @Test
    public void GSONTest() throws Exception {
        int size = 10000;
        int k = 3;
        BloomFilterXor filter = new BloomFilterXor(size, k);

        filter.addElement("1", "Tom");
        filter.addElement("2", "Judy");
        filter.addElement("3", "Jerry");
        filter.addElement("4", "Sun");
        filter.addElement("5", "Thompson");
        filter.fillInAll();
        Gson gson = new Gson();
        String objstring = gson.toJson(filter);
//        System.out.println(objstring);
        Gson gson2 = new GsonBuilder()
                .serializeNulls()
                .registerTypeAdapter(HashFunc.class, new HashFuncDeserializer())
                .create();
        BloomFilterXor newfilter = gson2.fromJson(objstring, BloomFilterXor.class);
        List<HashFunc> hashList = new LinkedList<>();
//        hashList.add(new newhash());
        hashList.add(new RSHash());
        hashList.add(new BKDRHash());
        hashList.add(new SDBMHash());
        newfilter.setHashFunctions(hashList);
        System.out.println(newfilter.checkElement("1","Tom"));
        System.out.println(newfilter.checkElement("2","Tom"));
    }
}
