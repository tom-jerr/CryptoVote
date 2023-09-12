import com.ruoyi.algorithm.BloomFilterXor.SecretShare2;
import com.ruoyi.algorithm.BloomFilterXor.ShamirSecret;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

/**
 * @author lzy
 * @version 1.0.0
 * 2023/5/30 22:18
 */
public class ShamirTest {
    @Test
    public void ShamirTestK3() {
        ShamirSecret Shamirsecret = new ShamirSecret(3, new BigInteger("4001"));
        // 字符串转为BigInteger
        String[] str = new String[5];
        str[0] = "Tom"; str[1] = "Judy"; str[2] = "Jerry"; str[3] = "Sun"; str[4] = "Thompson";
        for (int i = 0; i < 5; i++) {
            byte[] inputStringBytes = str[i].getBytes();
            BigInteger secret = new BigInteger(inputStringBytes);
            System.out.println("secret:\t" + str[i]);
            SecretShare2[] Integers_K = Shamirsecret.share_by_K(secret,3);
            for (int j = 0; j < 3; j++) {
                System.out.print(Integers_K[j].getShare() + ", ");
            }
            System.out.println();
            BigInteger recover = Shamirsecret.recover(Integers_K);
            String s = new String(recover.toByteArray());
            System.out.println("recovered msg:\t" + s);
        }

    }
    @Test
    public void ShamirTestK7() {
        ShamirSecret Shamirsecret = new ShamirSecret(7, new BigInteger("131"));
        // 字符串转为BigInteger
        String[] str = new String[5];
        str[0] = "Tom"; str[1] = "Judy"; str[2] = "Jerry"; str[3] = "Sun"; str[4] = "Thompson";
        for (int i = 0; i < 5; i++) {
            byte[] inputStringBytes = str[i].getBytes();
            BigInteger secret = new BigInteger(inputStringBytes);
            System.out.println("secret:\t" + str[i]);
            SecretShare2[] Integers_K = Shamirsecret.share_by_K(secret,7);
            for (int j = 0; j < 7; j++) {
                System.out.print(Integers_K[j].getShare() + ", ");
            }
            System.out.println();
            BigInteger recover = Shamirsecret.recover(Integers_K);
            String s = new String(recover.toByteArray());
            System.out.println("recovered msg:\t" + s);
        }

    }
    @Test
    public void ShamirTestK5() {
        ShamirSecret Shamirsecret = new ShamirSecret(7, new BigInteger("1000000007"));
        ShamirSecret shamirsecret2 = new ShamirSecret(7,new BigInteger("100003"));
        // 字符串转为BigInteger
        String[] str = new String[5];
        str[0] = "Tom"; str[1] = "Judy"; str[2] = "Jerry"; str[3] = "Sun"; str[4] = "Thompson";
        for (int i = 0; i < 5; i++) {
            byte[] inputStringBytes = str[i].getBytes();
            BigInteger secret = new BigInteger(inputStringBytes);
            System.out.println("secret:\t" + str[i]);
            SecretShare2[] Integers_K = Shamirsecret.share_by_K(secret,7);
            SecretShare2[] secretShare2s = shamirsecret2.share_by_K(secret, 7);;
            for (int j = 0; j < 7; j++) {
                System.out.print(Integers_K[j].getShare() + ", ");
            }
            System.out.println();
            System.out.println("100003:");
            for (int j = 0; j < 7; j++) {
                System.out.print(secretShare2s[j].getShare() + ", ");
            }
            BigInteger recover = Shamirsecret.recover(Integers_K);
            String s = new String(recover.toByteArray());
            System.out.println("recovered msg:\t" + s);
        }

    }
}
