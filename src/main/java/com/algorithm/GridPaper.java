package com.algorithm;

/**
 * Created by Eric on 2016/7/28.
 */

import java.util.Scanner;

/**
 度度熊有一张网格纸，但是纸上有一些点过的点，每个点都在网格点上，若把网格看成一个坐标轴平行于网格线的坐标系的话，每个点可以用一对整数x，y来表示。
 度度熊必须沿着网格线画一个正方形，使所有点在正方形的内部或者边界。然后把这个正方形剪下来。问剪掉正方形的最小面积是多少。
 输入描述:
 第一行一个数n(2≤n≤1000)表示点数，接下来每行一对整数xi,yi(－1e9<=xi,yi<=1e9)表示网格上的点

 输出描述:
 一行输出最小面积

 输入例子:
 2
 0 0
 0 3

 输出例子:
 9
 */
public class GridPaper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            long maxAcreage_length = 0;
            int n = sc.nextInt();
            int[] X = new int[n];
            int[] Y = new int[n];
            for (int i = 0;i < n; i ++){
                X[i] = sc.nextInt();
                Y[i] = sc.nextInt();
            }
            for (int i = 0;i < n - 1; i ++){
                for (int j = i;j < n;j ++) {
                    long length = Math.max(Math.abs(X[j] - X[i]),Math.abs(Y[j] - Y[i]));
                    if ( length > maxAcreage_length)
                        maxAcreage_length = length;
                }
            }
            System.out.println(maxAcreage_length * maxAcreage_length);
        }
    }
}