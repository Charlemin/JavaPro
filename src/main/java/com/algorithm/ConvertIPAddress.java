package com.algorithm;

import java.util.Scanner;

/**
 * Created by Eric on 2016/7/27.
 */
public class ConvertIPAddress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            int input = sc.nextInt();
            //String convertedString = Integer.toHexString(input);
            String convertedString = "C0A80101";
            int[] ipAddress = new int[4];
            for (int i = 0;i < 4;i ++){
                char m = convertedString.charAt(2 * i);
                char n = convertedString.charAt(2 * i + 1);
                int convert_m = 0;
                int convert_n = 0;
                if ( 'A'<= m && m <= 'F')
                   convert_m = m - 55;
                else convert_m = m - '0';
                if ( 'A'<= n && n <= 'F')
                    convert_n = n - 55;
                else convert_n = n - '0';
                ipAddress[i] = convert_m * 16 + convert_n;
            }
            System.out.println(ipAddress[0] + "." + ipAddress[1]+ "." + ipAddress[2] + "." + ipAddress[3]);
        }
    //}
}
