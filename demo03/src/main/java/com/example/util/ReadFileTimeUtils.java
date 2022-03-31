package com.example.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class ReadFileTimeUtils {

    public static String file = "E:/02-BackUp/251/AIS20200724161308_backup_2020_12_05_000019_1088765.bak";

    public static void main(String[] args) throws IOException {

        File f = new File(file);
        System.out.println(getCreationTime(f));
//        Path file =  f.toPath();
//        BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
//        System.out.println("creationTime: " + attr.creationTime());
//        System.out.println("lastAccessTime: " + attr.lastAccessTime());
//        System.out.println("lastModifiedTime: " + attr.lastModifiedTime());
    }


    public static String getCreationTime(File file) {
        if (file == null) {
            return null;
        }

        BasicFileAttributes attr = null;
        try {
            Path path =  file.toPath();
            attr = Files.readAttributes(path, BasicFileAttributes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 创建时间
        Instant instant = attr.creationTime().toInstant();
        // 更新时间
//        Instant instant = attr.lastModifiedTime().toInstant();
        // 上次访问时间
//        Instant instant = attr.lastAccessTime().toInstant();
        String format = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.systemDefault()).format(instant);
        return format;
    }
}