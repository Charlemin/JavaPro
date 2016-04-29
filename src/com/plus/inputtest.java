package com.plus;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/3/31.
 */
public class inputtest {

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int a[]=new int[2];
        int b[]=new int[2];
        for(int i=0;i<2;i++)
            a[i]=scanner.nextInt();
        for(int i=0;i<2;i++)
            b[i]=scanner.nextInt();
        for(int i=0;i<2;i++)
            System.out.println(a[i]+" "+b[i]);
    }
}
