package com.algorithm;

/**
 * Created by Eric on 2016/8/4.
 */

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 ss请cc来家里钓鱼，鱼塘可划分为n＊m的格子，每个格子每分钟有不同的概率钓上鱼，cc一直在坐标(x,y)的格子钓鱼，而ss每分钟随机钓一个格子。
 问t分钟后他们谁至少钓到一条鱼的概率大？为多少？

 输入描述:
 第一行五个整数n,m,x,y,t(1≤n,m,t≤1000,1≤x≤n,1≤y≤m);
 接下来为一个n＊m的矩阵，每行m个一位小数，共n行，第i行第j个数代表坐标为(i,j)的格子钓到鱼的概率为p(0≤p≤1)

 输出描述:
 输出两行。第一行为概率大的人的名字(cc/ss/equal),第二行为这个概率(保留2位小数)

 输入例子:
 2 2 1 1 1
 0.2 0.1
 0.1 0.4

 输出例子:
 equal
 0.20
 */
public class Fishing {
    public static void main(String[] args) {
        DecimalFormat df   = new DecimalFormat("0.00");//保留两位小数
        Scanner sc = new Scanner(System.in);
        System.out.println(df.format(564.256));
        while (sc.hasNext()){
            String[] s1 = sc.nextLine().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            int x = Integer.parseInt(s1[2]) - 1;
            int y = Integer.parseInt(s1[3]) - 1;
            int t = Integer.parseInt(s1[4]);
            double p_ss = 0;
            double p_cc = 0;
            for (int i = 0;i < n;i ++) {
                String[] pString = sc.nextLine().split(" ");
                for (int j = 0; j < m; j++) {
                    double p = Double.parseDouble(pString[j]);
                    if (i == x && j == y)
                        p_cc = p;
                    p_ss += p;
                }
            }
                p_ss /= n * m;
                double pp_cc = 1 - Math.pow(1 - p_cc, t);
                double pp_ss = 1 - Math.pow(1 - p_ss, t);
                if (pp_cc == pp_ss) {
                    System.out.println("equal");
                    System.out.println(df.format(pp_cc));
                } else if (pp_cc > pp_ss) {
                    System.out.println("cc");
                    System.out.println(df.format(pp_cc));
                } else {
                    System.out.println("ss");
                    System.out.println(df.format(pp_ss));
                }
            System.out.println(df.format(564.256));
        }
    }
}
