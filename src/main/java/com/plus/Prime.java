package com.plus;

import java.util.Scanner;

/**
 * Created by Eric on 2016/4/22.
 */
public class Prime {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(getPrime(a,b));
        }
    }

    //求a和b之间的所有素数个数
    public static int getPrime(int a,int b){

        int num = 0;
        for(int i = a + 1;i < b;i ++){
            Boolean flag = true;
            for(int j = 2;j < i;j ++){
                if(i % j==0)
                {
                    flag = false;
                    break;
                }
            }
            if(i != 1 && flag == true)
               num++;
        }
        return num;
    }
}
