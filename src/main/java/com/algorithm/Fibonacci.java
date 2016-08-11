package com.algorithm;

/**
 * Created by Eric on 2016/8/10.
 */

import java.util.Scanner;

/**
 Fibonacci数列是这样定义的：
 F[0] = 0
 F[1] = 1
 for each i ≥ 2: F[i] = F[i-1] + F[i-2]
 因此，Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13, ...，在Fibonacci数列中的数我们称为Fibonacci数。给你一个N，
 你想让其变为一个Fibonacci数，每一步你可以把当前数字X变为X-1或者X+1，现在给你一个数N求最少需要多少步可以变为Fibonacci数。
 输入描述:
 输入为一个正整数N(1 ≤ N ≤ 1,000,000)

 输出描述:
 输出一个最小的步数变为Fibonacci数"

 输入例子:
 15

 输出例子:
 2
 */
public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int i = sc.nextInt();
            int temp_1 = 0;
            int temp_2 = 1;
            int temp = 0;
            while (temp <= i) {
                temp = temp_1 + temp_2;
                temp_1 = temp_2;
                temp_2 = temp;
                }
                int length = Math.min(i - temp_1, temp_2 - i);
                System.out.println(length);
            }
         }
    }
