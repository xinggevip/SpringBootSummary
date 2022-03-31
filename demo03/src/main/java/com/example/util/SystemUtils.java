package com.example.util;

import java.util.Map;

public class SystemUtils {
    void getSysInfo(){
        Map<String,String> map = System.getenv();
        System.out.println(map.get("USERNAME"));//获取用户名
        System.out.println(map.get("COMPUTERNAME"));//获取计算机名
        System.out.println(map.get("USERDOMAIN"));//获取计算机域名
    }

    public static void main(String[] args) {
        SystemUtils systemUtils = new SystemUtils();
        systemUtils.getSysInfo();
    }
}
