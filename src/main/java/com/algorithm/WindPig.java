package com.algorithm;

/**
 * Created by Administrator on 2016/8/2 0002.
 */

/**
 题目描述
 风口之下，猪都能飞。当今中国股市牛市，真可谓“错过等七年”。 给你一个回顾历史的机会，已知一支股票连续n天的价格走势，
 以长度为n的整数数组表示，数组中第i个元素（prices[i]）代表该股票第i天的股价。假设你一开始没有股票，
 但有至多两次买入1股而后卖出1股的机会，并且买入前一定要先保证手上没有股票。若两次交易机会都放弃，收益为0。
 设计算法，计算你能获得的最大收益。 输入数值范围：2<=n<=100,0<=prices[i]<=100
 输入例子:
 3,8,5,1,7,8

 输出例子:
 12
 */
public class WindPig {
    public static void main(String[] args) {
        int[] prices = {3,8,5,1,7,8};
        System.out.println(calculateMax(prices));
    }

    public static int calculateMax(int[] prices) {
        int max_1 = 0;
        int max_2 = 0;
        int length = prices.length;
        int min_1 = prices[0];
        int min_2 = 101;
        int k1 = 0;
        int k2 = 0;
        for (int i = 1;i < length;i ++){
            if (min_1 > prices[i]) {
                min_1 = prices[i];
                k1 = i;
            }
        }
        for (int i = 0;i < length;i ++){
            if (min_2 > prices[i] && prices[i] != min_1) {
                min_2 = prices[i];
                k2 = i;
            }
        }
        System.out.println(k1 + " " + k2);
        if (k1 == length -2 && k2 == length - 1){
            max_1 = 0;
            max_2 = prices[k2] - prices[k1];
        }
       else if (k2 - k1 > 1){
            for (int i = k1 + 1;i < k2; i ++)
                if (prices[i] - min_1 > max_1)
                    max_1 = prices[i] - min_1;
            for (int i = k2 + 1;i < length;i ++)
                if (prices[i] - min_2 > max_2)
                    max_2 = prices[i] - min_2;
        }else if (k1 - k2 > 1){
            for (int i = k2 + 1;i < k1; i ++)
                if (prices[i] - min_2 > max_2)
                    max_2 = prices[i] - min_2;
            for (int i = k1 + 1;i < length;i ++)
                if (prices[i] - min_1 > max_1)
                    max_1 = prices[i] - min_1;
        }
        return max_1 + max_2;
    }
}
