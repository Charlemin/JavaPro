package com.algorithm;

/**
 * Created by Eric on 2016/8/1.
 */

import java.util.Scanner;

/**
 题目描述

 现在有一张半径为r的圆桌，其中心位于(x,y)，现在他想把圆桌的中心移到(x1,y1)。每次移动一步，都必须在圆桌边缘固定一个点然后将圆桌绕这个点旋转。
 问最少需要移动几步。

 输入描述:
 一行五个整数r,x,y,x1,y1(1≤r≤100000,-100000≤x,y,x1,y1≤100000)


 输出描述:
 输出一个整数，表示答案

 输入例子:
 2 0 0 0 4

 输出例子:
 1
 */
public class RoundTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int r = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            double length = Math.sqrt(Math.pow(Math.abs(x1 - x),2) + Math.pow(Math.abs(y1 - y),2));
            int i = (int)(length - 1) / (r * 2) + 1;
            System.out.println(i);
            }
    }
}
