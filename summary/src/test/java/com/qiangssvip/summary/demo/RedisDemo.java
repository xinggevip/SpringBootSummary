package com.qiangssvip.summary.demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qiangssvip.summary.pojo.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
@Slf4j
public class RedisDemo {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * 存字符串
     */
    // TODO 现在暂且先集成用原生写，日后学深了再用工具类
    @Test
    void stringTest() {
        stringRedisTemplate.boundValueOps("name").set("张三");
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setUsername("李四");
        employee.setPassword("123456");
        stringRedisTemplate.boundValueOps("lisi").set(gson.toJson(employee));
        String name = stringRedisTemplate.boundValueOps("name").get();
        log.info("name = {}",name);
        String lisi = stringRedisTemplate.opsForValue().get("lisi");
        Employee fromJson = gson.fromJson(lisi, Employee.class);
        log.info("fromJson = {}",fromJson);
    }





}
