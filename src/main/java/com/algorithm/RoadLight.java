package com.algorithm;

/**
 * Created by Eric on 2016/7/29.
 */

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 一条长l的笔直的街道上有n个路灯，若这条街的起点为0，终点为l，第i个路灯坐标为ai，每盏灯可以覆盖到的最远距离为d，为了照明需求，
 所有灯的灯光必须覆盖整条街，但是为了省电，要是这个d最小，请找到这个最小的d。

 输入描述:
 每组数据第一行两个整数n和l（n大于0小于等于1000，l小于等于1000000000大于0）。第二行有n个整数(均大于等于0小于等于l)，为每盏灯的坐标，多个路灯可以在同一点。


 输出描述:
 输出答案，保留两位小数。

 输入例子:
 7 15
 15 5 3 7 9 14 0

 输出例子:
 2.5
 */
public class RoadLight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            double l = sc.nextDouble();
            double[] A = new double[n];
            for (int i = 0;i < n;i ++)
                A[i] = sc.nextDouble();
            System.out.println(new RoadLight().getD(A,l));
        }
    }
    public String getD(double[] A ,double L){
        double maxD = 0;
        DecimalFormat df = new DecimalFormat("0.00");
        Arrays.sort(A);
        if (L - A[A.length - 1] < A[0])
            maxD = 2 * A[0];
        else maxD = 2 * (L - A[A.length - 1]);
        for (int i = 0;i < A.length - 1;i ++ ) {
            double temp = A[i + 1] - A[i];
            if (maxD < temp)
                maxD = temp;
        }
        return df.format(maxD / 2);
    }
}
