package com;

import java.util.ArrayList;
import java.util.List;

public class ValidIP {

    public static void main(String[] args) {
        String str = "25525511135";

        System.out.println(findValidIp(str));
    }

    private static List<String> findValidIp(String str) {
        List<String> ips = new ArrayList<>();
        if (null == str || str.length() < 4)
            return ips;
        String[] segment = new String[4];
        int length = str.length();
        for(int i = 1; i < 4 && i < length - 2;i++){
            for(int j = i + 1;j < i + 4 && j < length - 1; j++){
                for(int k = j + 1; k < j + 4 && k < length; k++) {
                    segment[0] = str.substring(0, i);
                    System.out.println(segment[0]);
                    if (segment[0].charAt(0) == '0' || Integer.valueOf(segment[0]) > 255)
                        break;
                    segment[1] = str.substring(i, j);
                    System.out.println(segment[1]);
                    if (Integer.valueOf(segment[1]) > 255 || (segment[1].charAt(0) == '0' && segment[1].length() > 1))
                        break;
//
                    segment[2] = str.substring(j, k);
                    System.out.println(segment[2]);
                    if (Integer.valueOf(segment[2]) > 255 || (segment[2].charAt(0) == '0' && segment[2].length() > 1))
                        break;
                    segment[3] = str.substring(k);
                    System.out.println(segment[3]);
                    if (Integer.valueOf(segment[3]) > 255 || segment[3].length() > 3 || (segment[3].charAt(0) == '0' && segment[3].length() > 1))
                        break;

                    String ip = segment[0] + '.' + segment[1] + '.' + segment[2] + '.' + segment[3];
                    ips.add(ip);

                }
            }
        }
        return ips;
    }
}
