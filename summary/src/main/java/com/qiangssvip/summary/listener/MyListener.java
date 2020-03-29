package com.qiangssvip.summary.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RabbitListener(queues = "payNotify")
public class MyListener {

    @RabbitHandler
    public void process(String msg) {
        log.info("msg = {}", msg);
    }

}
