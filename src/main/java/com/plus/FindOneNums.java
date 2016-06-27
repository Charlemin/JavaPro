package com.plus;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/5/11.
 */
public class FindOneNums {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        System.out.println("数字"+num+"对应的二进制表示中1的个数是"+count(num));
        System.out.println("数字"+num+"对应的二进制表示中1的个数是"+count2(num));
    }

    public static int count(int num){

        int count=0;
        while (num!=0)
        {

            if((num&1)==1)
                count++;
            num>>=1;
        }
        return count;
    }

    public static int count2(int num){

        int count=0;
        while (num!=0)
        {

            if((num%2)==1)
                count++;
            num/=2;
        }
        return count;
    }
}
