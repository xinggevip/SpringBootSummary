package com.qiangssvip.summary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.qiangssvip.summary.dao")
public class SummaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SummaryApplication.class, args);
    }

}
