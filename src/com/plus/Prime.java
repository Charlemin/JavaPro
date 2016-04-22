package com.plus;

import java.util.Scanner;

/**
 * Created by Eric on 2016/4/22.
 */
public class Prime {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int i=sc.nextInt();
        getPrime(i);
    }

    //求小于n的所有质数
    public static void getPrime(int n){

        for(int i=2;i<n;i++){
            Boolean flag=true;
            for(int j=2;j<i;j++){
                if(i%j==0)
                {
                    flag=false;
                    break;
                }
            }
            if(flag==true)
                System.out.println("质数为:" + i);
        }
    }
}
