package com.plus;

import java.util.Scanner;

/**
 * Created by Eric on 2016/3/18.
 */
public class Findgroup {

   public static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args ){

        int money;
        int[] sum;
        System.out.println("please enter a number:");
        money=scanner.nextInt();
        sum=return_sum(money);
        for(int i=0;i<sum.length;i++)
            System.out.println(sum[i]);
    }

    //给定一组数，输出组合成某个数的所用数字最少的方式；
    static int[] return_sum(int money){

        int[] sum={0,0,0,0,0};
        sum[0]=money/100;
        money%=100;
        sum[1]=money/50;
        money%=50;
        sum[2]=money/10;
        money%=10;
        sum[3]=money/5;
        money%=5;
        sum[4]=money;
        return sum;
    }
}
