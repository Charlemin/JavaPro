package com.test;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ImeiMd5Test2 {
    private static final String key = "MIICdQIBADANB";
    public static void main(String[] args){

        System.out.println(mySecret());
//        File f;
//        String fileName = String.format("%s%s%s","god_upload/","pn","_d");
//        //先将文件上传到本地
//        f = new File(fileName + "2542356587326");
//        if (!f.exists()) {
//            f.mkdirs();
//        }
//        System.out.println(f.getAbsolutePath());
    }


    /**
     * 该函数用于生成加密数据
     */
    public static String mySecret() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        String date =  sdf.format(new Date());
        System.out.println(date);
        String mySecret = DigestUtils.md5Hex(String.format("%s%s",date,key));
        return mySecret;
    }
}
