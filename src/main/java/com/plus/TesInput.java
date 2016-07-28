package com.plus;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/7/24 0024.
 */
//测试输入的合法性
public class TesInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            System.out.println(a + " " + b + " " + c +" " + d);
        }
    }
}
