package com.example;

import com.example.util.FTPUtilTest;
import com.example.util.ReadFileTimeUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class Demo03ApplicationTests {

    // 测试上传到FTP
    @Test
    void contextLoads() {
        FTPUtilTest ftp = new FTPUtilTest();
        // 文件路径写为用户建立时 指定的目录
        ftp.uploadFile("/OA", "DMS.xlsx", "E:/DMS.xlsx");
        // ftp.downloadFile("/home/ftpFile", "123.png", "E://");
        //ftp.deleteFile("/home/ftpFile", "123.png");
        System.out.println("ok");
    }

    // 读取外部配置文件
    @Test
    void readConfig() {
        try {
            String filePath = "D:/test.properties";
            InputStream inStream = new FileInputStream(new File(filePath));
            Properties prop = new Properties();
            prop.load(inStream);
            String key = prop.getProperty("upLoadPath");
            System.out.println(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 读取文件列表 筛选出今天的文件
    @Test
    void readFileList() {
        String basePath="E:/02-BackUp/";
        // 获取文件名和文件夹列表
        String[] list=new File(basePath).list();
        // 所有的文件名列表
        ArrayList<String> fileNameList = new ArrayList<>();
        // 完整路径的文件名列表
        ArrayList<String> fullFileNameList = new ArrayList<>();
        // 今天的完整路径的文件名列表
        ArrayList<String> todayFullFileNameList = new ArrayList<>();
        // 今天的文件名列表
        ArrayList<String> todayFileNameList = new ArrayList<>();

        for (String s : list) {

            int i = s.indexOf(".");

            if (i != -1) {
                fileNameList.add(s);
                String fullPath = basePath + s;
                fullFileNameList.add(fullPath);
            }
        }

        for (String s : fileNameList) {
            System.out.println(s);
        }

        for (String fullFileName : fullFileNameList) {

            File file = new File(fullFileName);
            long lastModified = file.lastModified();
            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
            String fileDateStr = dateFormat.format(lastModified);


            Date nowDate = new Date();
            String todayStr = dateFormat.format(nowDate);
//            System.out.println("今天的日期===" + todayStr);

            if (fileDateStr.equals(todayStr)) {
//                System.out.println(fullFileName + "    " + fileDateStr + "    此文件为今天产生的文件");
                todayFullFileNameList.add(fullFileName);
            }

        }

        System.out.println("-----------------------------");

        for (String todayFullFileName : todayFullFileNameList) {
            System.out.println(todayFullFileName);

            String regEx = ".+/(.+)$";

            // 创建 Pattern 对象
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(todayFullFileName);
            if (!m.find()) {
                System.out.println("文件路径格式错误!");
                return;
            }
            String todayFileName = m.group(1);
            todayFileNameList.add(todayFileName);
        }

        for (String todayFileName : todayFileNameList) {
            System.out.println(todayFileName);
        }



    }


    @Test
    void aaa() {
        System.out.println("处理定时任务...");
        // 1. 读取配置文件取备份文件夹路径、FTP信息
        String configFilePath = "D:/config.properties";
        // 备份文件夹的路径
        String backupPath = "";
        // 上传的路径
        String uploadPath = "";
        try {
            InputStream inStream = new FileInputStream(new File(configFilePath));
            Properties prop = new Properties();
//            prop.load(inStream);
            prop.load(new InputStreamReader(inStream, "utf-8"));
            backupPath = prop.getProperty("backupPath");
            uploadPath = prop.getProperty("uploadPath");
            System.out.println(backupPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2.获取备份文件夹的路径

        // 获取文件名和文件夹列表
        String[] list=new File(backupPath).list();
        // 所有的文件名列表
        ArrayList<String> fileNameList = new ArrayList<>();
        // 完整路径的文件名列表
        ArrayList<String> fullFileNameList = new ArrayList<>();
        // 今天的完整路径的文件名列表
        ArrayList<String> todayFullFileNameList = new ArrayList<>();
        // 今天的文件名列表
        ArrayList<String> todayFileNameList = new ArrayList<>();

        for (String s : list) {

            int i = s.indexOf(".");

            if (i != -1) {
                fileNameList.add(s);
                String fullPath = backupPath + s;
                fullFileNameList.add(fullPath);
            }
        }

        for (String s : fileNameList) {
            System.out.println(s);
        }


        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");



        Date nowDate = new Date();
        String todayStr = dateFormat.format(nowDate);

        for (String fullFileName : fullFileNameList) {

            File file = new File(fullFileName);
//            long lastModified = file.lastModified();
//            String fileDateStr = dateFormat.format(lastModified);
            String fileDateStr = ReadFileTimeUtils.getCreationTime(file);
//            System.out.println("今天的日期===" + todayStr);
            System.out.println(fullFileName + "文件创建日期===" + fileDateStr);

            if (fileDateStr.equals(todayStr)) {
                System.out.println(fullFileName + "    " + fileDateStr);
                todayFullFileNameList.add(fullFileName);
            }

        }

        if (todayFullFileNameList.size() == 0) {
            System.out.println(todayStr + "--今天未产生任何新文件--");
            return;
        }
        System.out.println("-----------开始上传--------------");

        FTPUtilTest ftp = new FTPUtilTest();



        for (String todayFullFileName : todayFullFileNameList) {
//            System.out.println(todayFullFileName + "=======");
            String regEx = ".+/(.+)$";

            // 创建 Pattern 对象
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(todayFullFileName);
            if (!m.find()) {
                System.out.println("文件路径格式错误!");
                return;
            }
            String todayFileName = m.group(1);
            ftp.uploadFile(uploadPath, todayFileName, todayFullFileName);
            System.out.println(todayFullFileName + "上传完成");
        }
    }

}



