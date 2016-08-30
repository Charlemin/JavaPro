package com.algorithm;

/**
 * Created by Eric on 2016/8/30.
 */

import java.util.Scanner;

/**
 有一楼梯共m级，刚开始时你在第一级，若每次只能跨上一级或者二级，要走上m级，共有多少走法？注：规定从一级到一级有0种走法。
 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100。为了防止溢出，请返回结果Mod 1000000007的值。
 测试样例：
 3
 返回：2
 */
public class GoUpstairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(new GoUpstairs().countWays(n));
        }
    }
    public int countWays(int n) {
        int steps = 1;
        if (n == 1)
            return 0;
        else if (n == 2)
            return 1;
        int k = 3;
        int steps_before = 1;
        int steps_after = 1;
        if (n >= 3) {
            while (k <= n){
                steps_before = steps_after % 1000000007;
                steps_after = steps % 1000000007;
                steps = (steps_after + steps_before) % 1000000007;
                k ++;
            }
        }
        return steps;
    }
}
