package com.example;

import com.example.util.SystemHardwareInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo02ApplicationTests {

    @Test
    void contextLoads() {
        SystemHardwareInfo systemHardwareInfo = new SystemHardwareInfo();
        System.out.println(systemHardwareInfo.getCpu().getSys());
//        System.out.println(systemHardwareInfo);
    }

}
