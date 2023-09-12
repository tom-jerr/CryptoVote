import com.ruoyi.RuoYiApplication;
import com.ruoyi.algorithm.Paillier;
import com.ruoyi.system.service.IAppRoomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RuoYiApplication.class)
public class SpringTest {
    @Autowired
    private IAppRoomService appRoomService;

    @Test
    public void getHxName() {
        List<String> hxNamelist = appRoomService.hxpeoplename("12");
        for (String people : hxNamelist) {
            System.out.println(people);
        }
    }
    @Test
    public void TotalTest() {
        Paillier p = new Paillier();
        int size = 10000, k = 3;
//        int TotalTickets = appRoomService.ticketscount("9");
//        System.out.println(TotalTickets);
//        // 考虑用户来传或者新建一个投票者数据
//        List<Map<String, String>> hxNamelist = appRoomService.hxpeoplename("9");
//        // 该房间候选者名单
//        List<String> hxpeople = new ArrayList<>();
//        for (Map<String, String> people : hxNamelist) {
//           hxpeople.add(String.valueOf(people.values()));
//        }
    }

}
