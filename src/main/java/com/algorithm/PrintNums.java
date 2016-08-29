package com.algorithm;

/**
 * Created by Administrator on 2016/8/29 0029.
 */

import java.util.Scanner;

/**
 输入一个整数n，打印n行
 输入3，打印
 1
 3*2
 4*5*6
 输入4，打印
 1
 3*2
 4*5*6
 10*9*8*7
 */
public class PrintNums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            print(n);
        }
    }

    public static void print(int n){
        for (int i = 1;i <= n;i ++){
            int nums = ((1 + i) * i) / 2;
            if (i % 2 == 0)
                for (int j = 0;j < i;j ++)
                    if (j == i - 1)
                        System.out.println((nums - j));
                    else System.out.print((nums - j) + "*");
            else {
                for (int j = i - 1;j >= 0;j --)
                    if (j == 0)
                        System.out.println((nums - j));
                    else System.out.print((nums - j) + "*");
            }
        }
    }
}
