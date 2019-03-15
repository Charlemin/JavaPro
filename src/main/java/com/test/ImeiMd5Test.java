package com.test;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.regex.Pattern;

public class ImeiMd5Test {
    public static void main(String[] args){
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        Pattern pattern = Pattern.compile("[0-9]*");
        try {
            fw = new FileWriter("/home/workspace/JavaPro/src/main/resources/imeimd5.txt");
            bw = new BufferedWriter(fw);
            br = new BufferedReader(new InputStreamReader(new FileInputStream("/home/workspace/JavaPro/src/main/resources/imei.txt")));
            String imei;
            while ((imei = br.readLine()) != null) {
                if (StringUtils.isNotBlank(imei) && pattern.matcher(imei).matches()) {
                    //System.out.println(imei);
                    String imeiMd5 = DigestUtils.md5Hex(imei);
                    System.out.println(imeiMd5);
                    bw.write(imeiMd5 + '\n');
                }
            }
        } catch (IOException e) {
            System.out.println(" reading error happened : " + e.getMessage());
        } finally {
            try {
                br.close();
                bw.close();
                fw.close();
            } catch (IOException e) {
                System.out.println("closing error happened : " + e.getMessage());
            }
        }
    }
}
