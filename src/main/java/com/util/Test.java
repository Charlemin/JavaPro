package com.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
        System.out.println(mySign());
    }

    private static final String privateSecret = "DFGSGFGdQIBADEFTRSHFDGWKUAVGDFT";

    public static String mySign(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        String date =  sdf.format(new Date());
        String mySecret = DigestUtils.md5Hex(String.format("%s%s",date,privateSecret));
        return mySecret;
    }
}
