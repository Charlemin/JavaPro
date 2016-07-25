package com.plus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Eric on 2016/7/25.
 */
public class Power {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str="";
        while(sc.hasNext()){
            str=sc.nextLine();
            System.out.println(getFoolNum(str));
        }
    }
    //求2的n次幂，以十六进制表示
    public static String getPower(int n){
        int i = 2<< n-1;
        String result = "0x"+Integer.toHexString(i);
        return result;
    }

    //tom的礼物
    public static int getFoolNum(String str){
        int length = str.length();
        int num = 0;
        for( int i = 0;i < length;i++){
            if(str.charAt(i) == 'A')
                break;
            else if(str.charAt(i) == '(')
                num ++;
            else num --;
        }
        return num;
    }
}
