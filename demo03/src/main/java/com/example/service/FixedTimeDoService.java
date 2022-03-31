package com.example.service;

import com.example.Demo03Application;
import com.example.util.FTPUtilTest;
import com.example.util.ReadFileTimeUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class FixedTimeDoService {

    @Scheduled(cron = "0 15 3 * * ?")
    public static void fixedTimeDo() {
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
        String[] list = new File(backupPath).list();
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


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date nowDate = new Date();
        String todayStr = dateFormat.format(nowDate);
        System.out.println("今天的日期===" + todayStr);

        for (String fullFileName : fullFileNameList) {

            File file = new File(fullFileName);
//            long lastModified = file.lastModified();
//            String fileDateStr = dateFormat.format(lastModified);
            String fileDateStr = ReadFileTimeUtils.getCreationTime(file);


            if (fileDateStr.equals(todayStr)) {
//                System.out.println(fullFileName + "    " + fileDateStr);
                todayFullFileNameList.add(fullFileName);
                System.out.println(fullFileName + "文件创建日期===" + fileDateStr);
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