package com.example.util;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import jcifs.smb.SmbFileOutputStream;

/**
 * java访问共享目录
 *
 * @author 林计钦
 * @version 1.0 2013-7-16 上午09:18:38
 */
public class test02 {

    public static void main(String[] args) throws Exception {
        //smb://xxx:xxx@192.168.2.188/testIndex/
        //xxx:xxx是共享机器的用户名密码
//        String url="smb://C1307890:Ivo123@10.20.2.33/CIMPublic/";
//        String url="smb://RY-CW-05/Users/Public/";
        String url="smb://10.50.0.131/backup/";
        SmbFile file = new SmbFile(url);
        if(file.exists()){
            SmbFile[] files = file.listFiles();
            for(SmbFile f : files){
                System.out.println(f.getName());
            }
        }

//        smbGet("smb://C1307890:Ivo123@10.20.2.33/CIMPublic/02 MES/SPC/Spc_Check_IVO_V1_00.ppt", "D:/ap_log");
//        smbPut("smb://C1307890:Ivo123@10.20.2.33/CIMPublic/", "D:/qra/fileUpload/SQL_JOIN.pptx");


//        smbPut(url, "D:/2、如何追加销售单.docx");
        smbPut(url, "D:/config.properties");

    }

//    从共享目录下载文件
    @SuppressWarnings("unused")
    public static void smbGet(String remoteUrl,String localDir) {
       InputStream in = null;
       OutputStream out = null;
       try {
           SmbFile remoteFile = new SmbFile(remoteUrl);
           if(remoteFile==null){
              System.out.println("共享文件不存在");
              return;
           }
           String fileName = remoteFile.getName();
           File localFile = new File(localDir+File.separator+fileName);
           in = new BufferedInputStream(new SmbFileInputStream(remoteFile));
           out = new BufferedOutputStream(new FileOutputStream(localFile));
           byte[] buffer = new byte[1024];
           while(in.read(buffer)!=-1){
              out.write(buffer);
              buffer = new byte[1024];
           }
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           try {
              out.close();
              in.close();
           } catch (IOException e) {
              e.printStackTrace();
           }
       }
    }

   //向共享目录上传文件
    public static void smbPut(String remoteUrl,String localFilePath) {
       InputStream in = null;
       OutputStream out = null;
       try {
           File localFile = new File(localFilePath);

           String fileName = localFile.getName();
           SmbFile remoteFile = new SmbFile(remoteUrl+"/"+fileName);
           in = new BufferedInputStream(new FileInputStream(localFile));
           out = new BufferedOutputStream(new SmbFileOutputStream(remoteFile));
           byte[] buffer = new byte[1024];
           while(in.read(buffer)!=-1){
              out.write(buffer);
              buffer = new byte[1024];
           }
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           try {
              out.close();
              in.close();
               System.out.println("上传完成");
           } catch (IOException e) {
              e.printStackTrace();
           }
       }
    }

}