package cn.edu.mju.configserver;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigServerApplicationTests {

    @Test
    public void contextLoads() {

        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        String encrypt = standardPBEStringEncryptor.encrypt("xzc19970716");
        System.out.println(encrypt);

    }

}
