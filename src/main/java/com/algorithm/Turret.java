package com.algorithm;

import java.util.Scanner;

/**
 * Created by Eric on 2016/7/25.
 */

/**
 * 兰博教训提莫之后,然后和提莫讨论起约德尔人,谈起约德尔人,自然少不了一个人,那就是黑默丁格---
 * ---约德尔人历史上最伟大的科学家. 提莫说,黑默丁格最近在思考一个问题:黑默丁格有三个炮台,炮台能攻击到距离它R的敌人
 * (两点之间的距离为两点连续的距离,例如(3,0),(0,4)之间的距离是5),如果一个炮台能攻击 到敌人,那么就会对敌人造成1×的伤害.
 * 黑默丁格将三个炮台放在N*M方格中的点上,并且给出敌人 的坐标. 问:那么敌人受到伤害会是多大?
 */
public class Turret {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int R = sc.nextInt();
            int[] X = new int[4];
            int[] Y = new int[4];
            int n = 0;
            String threat = "x";
            for(int i = 0;i < 4;i ++)
            {
                X[i] = sc.nextInt();
                Y[i] = sc.nextInt();
            }
            for(int i = 0;i < 3;i ++)
                if(Math.pow((double) (X[i] - X[3]),2) + Math.pow((double) (Y[i] - Y[3]),2)  <= Math.pow((double) R,2))
                    n ++;
            System.out.println(n + threat);
        }
    }
}
