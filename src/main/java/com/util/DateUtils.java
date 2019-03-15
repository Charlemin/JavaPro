package com.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static void main(String[] args) throws IOException{
        SimpleDateFormat myFmt2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(System.currentTimeMillis());

        String str = "rypZH3SPOuWb\u200BIMTYc6oC5XEU2gJiYtmGFS+3XXKA6V0=";

        String str2 = "rypZH3SPOuWbIMTYc6oC5XEU2gJiYtmGFS+3XXKA6V0=";
        System.out.println(str.equals(str2));
        System.out.println(new String(str.getBytes("gbk"),"utf-8"));


    }
}
