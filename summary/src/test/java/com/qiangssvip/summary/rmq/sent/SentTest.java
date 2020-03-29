package com.qiangssvip.summary.rmq.sent;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SentTest {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    void sentOne() {
        amqpTemplate.convertAndSend("payNotify","今天天气不错");
    }


}
