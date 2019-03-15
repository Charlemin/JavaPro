package com.test;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Test {
    public static void main(String[] args) {
        System.out.println(getUserFromPlatform("org-devtest!@@!_admin"));
    }

    public static String getUserFromPlatform(String user){
        if (user.contains("!@@!")) {
            String md5String = DigestUtils.md5Hex(user);
            return "eco" + md5String.substring(0, 9);
        }
        return user;
    }
}
