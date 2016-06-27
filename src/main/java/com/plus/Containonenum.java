package com.plus;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/5/2.
 */
public class Containonenum {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        while (true) {
            int n=scanner.nextInt();
            int num=0;
            for (int i = 1; i <= n; i++)
                num += getones(i);
            System.out.println("含有1的个数为：" + num);
            if(n==7)
                break;//遇到7，则终止循环
        }

    }
    //求1到n的之间出现“1”的个数；
    public static int getones(int n){

        int num=0;
        while (n!=0)
        {
            num+=(n%10==1)?1:0;
            n/=10;
        }
        return num;
    }
}
