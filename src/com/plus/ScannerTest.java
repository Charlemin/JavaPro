package com.plus;

import java.util.Scanner;

/**
 * Created by Eric on 2016/3/17.
 */
public class ScannerTest {

    public static void main(String[] args){

        Scanner scanner;
        char[] chars=new char[5];
        for(int i=0;i<5;i++){

            scanner=new Scanner(System.in);
            String str=scanner.next();
            chars[i]=str.charAt(0);
        }
        for(int j=0;j<5;j++)

        System.out.println(chars[j]);
    }
}
