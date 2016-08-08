package com.algorithm;

/**
 * Created by Eric on 2016/8/8.
 */

import java.util.Scanner;

/**
 题目描述

 狐进行了一次黑客马拉松大赛，全公司一共分为了N个组，每组一个房间排成一排开始比赛，比赛结束后没有公布成绩，但是每个组能够看到自己相邻的两个组里比自己成绩低的组的成绩，
 比赛结束之后要发奖金，以1w为单位，每个组都至少会发1w的奖金，另外，如果一个组发现自己的奖金没有高于比自己成绩低的组发的奖金，就会不满意，
 作为比赛的组织方，根据成绩计算出至少需要发多少奖金才能让所有的组满意。

 输入描述:
 每组数据先输入N，然后N行输入N个正整数，每个数表示每个组的比赛成绩。

 输出描述:
 输出至少需要多少w的奖金

 输入例子:
 10
 20
 32
 12
 32
 45
 11
 21
 31
 41
 33

 输出例子:
 20
 */
public class Bonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0;i < n;i ++)
                array[i] = sc.nextInt();
            int[] bonus = new int[n];
            for (int i = 0;i < n;i ++){
                int bonus_1 = 1;
                for (int j = i - 1;j >= 0;j --)
                    if (array[j + 1] > array[j])
                        bonus_1 ++;
                else break;
                int bonus_2 = 1;
                for (int j = i + 1;j < n;j ++)
                    if (array[j - 1] > array[j])
                        bonus_2 ++;
                else break;
                bonus[i] = Math.max(bonus_1,bonus_2);
            }
            int sum = 0;
            for (int i = 0;i < n;i ++)
                sum +=bonus[i];
            System.out.println(sum);
        }
    }
}
