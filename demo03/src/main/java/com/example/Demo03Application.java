package com.example;

import com.example.service.FixedTimeDoService;
import com.example.util.FTPUtilTest;
import com.example.util.test02;
import jcifs.smb.SmbFile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Scanner;

@SpringBootApplication
@EnableScheduling
public class Demo03Application {

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================");
        System.out.println("       定时备份程序");
        System.out.println("    输入以下数字执行指令");
        System.out.println("1. 立即备份今日文件");
        System.out.println("=========================");

        int num = 0;
        try{
            num = scanner.nextInt();
        }catch (Exception e){
            System.out.println("无效的指令");
            Demo03Application.menu();
        }

        if (num == 1) {
            FixedTimeDoService.fixedTimeDo();
            Demo03Application.menu();
        } else {
            System.out.println("无效的指令");
            Demo03Application.menu();
        }
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Demo03Application.class, args);
        System.out.println("系统启动成功");
        FTPUtilTest ftpUtilTest = new FTPUtilTest();
        String hostname = ftpUtilTest.hostname;
        System.out.println("FTP host == " + hostname);


    }

}