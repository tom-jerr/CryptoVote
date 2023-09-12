import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ruoyi.algorithm.BloomFilterXor.BloomFilterXor;
import com.ruoyi.algorithm.HashFuncDeserializer;
import com.ruoyi.algorithm.JsonCompression;
import com.ruoyi.algorithm.hash.BKDRHash;
import com.ruoyi.algorithm.hash.HashFunc;
import com.ruoyi.algorithm.hash.RSHash;
import com.ruoyi.algorithm.hash.SDBMHash;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PostTest {
    @Test
    public void FilterPostTest() throws Exception {
        int size = 50;
        int k = 3;
        BloomFilterXor filter = new BloomFilterXor(size, k);

        filter.addElement("1", "Tom");
        filter.addElement("2", "Judy");
        filter.fillInAll();
        Gson gson = new Gson();
        String str = gson.toJson(filter);
        System.out.println(str);

        Gson gson2 = new GsonBuilder()
                .serializeNulls()
                .registerTypeAdapter(HashFunc.class, new HashFuncDeserializer())
                .create();
        BloomFilterXor newfilter = gson2.fromJson(str, BloomFilterXor.class);
//        List<HashFunc> hashList = new ArrayList<>();
//
//        hashList.add(new RSHash());
//        hashList.add(new BKDRHash());
//        hashList.add(new SDBMHash());
//        newfilter.setHashFunctions(hashList);
        System.out.println(newfilter.checkElement("1","Tom"));
        System.out.println(newfilter.checkElement("2","Tom"));

    }

    @Test
    public void transferTest() throws Exception {

        String compress = "H4sIAAAAAAAAAMVRPQ+CMBD9Lzd3kDSkkRGIMfFjADfCUBClsbSmxUXCf/daNJrowGaXtu/ee3d5N8BJyL4xEBUDGAFRQMAof9mWmwZfzzOSmQTGnozwgxLOltPgS07pbPVfCSWBs9QVl4nqPaHltk20Ooka/wMcdAfRYpzw1U3VvdDK+uhrya3d8w7tIMvXWAfX7xOON2n2s5Cn8W4q4AAXjAsHvGyFffd08b+mHUDyrjpyXBQB5dlXI5xR4KPn6qg76dXFkhLEGCud47SSaTXOTtydZjE+AMs3E7lDAgAA";
        // 只插入（1, "TOM"）
        String compress2 = "H4sIAAAAAAAAAI1Ptw7CMBT8lzd7wAlFZEwihEQZgA1lcBqx4oLssBDl33GhSTDEi+135d31UFPWVQqicw+KQoQRKOEu3RBVmZc/AxqJPwnB8s0Il2PF4Y92uhgyBBcmc8IS0TltQ3STSFHTwvx7OEkO0WTw89VNFB2VQrtCBSNa7wk3RnA4rg0OdtX3ON6kh7/AMY13HjABWp+t3VL92RmYXq+cPTDC85JANEcgHPuqqDXCoW1NRCk5c+pzgFGIMM6soS/rS1s3ejeS2fAA8rfU5pcBAAA=";



        String decompress = JsonCompression.decompress(compress2);
        System.out.println(decompress);
        Gson gson2 = new GsonBuilder()
                .serializeNulls()
                .registerTypeAdapter(HashFunc.class, new HashFuncDeserializer())
                .create();
        BloomFilterXor newfilter = gson2.fromJson(decompress, BloomFilterXor.class);

        System.out.println(newfilter.checkElement("1","Tom"));
        System.out.println(newfilter.checkElement("2","Tom"));

    }
    @Test
    public void HashFuncSerializeTest() {
        List<HashFunc> list = new ArrayList<>();
        list.add(new SDBMHash());
        list.add(new RSHash());

        String str = new Gson().toJson(list);
        Gson gson2 = new GsonBuilder()
        .serializeNulls()
        .registerTypeAdapter(HashFunc.class, new HashFuncDeserializer())
        .create();

        List<HashFunc> list2 = gson2.fromJson(str, List.class);
        for(HashFunc hash:list) {
            System.out.println(hash.getClass().getSimpleName());
        }
    }
}
