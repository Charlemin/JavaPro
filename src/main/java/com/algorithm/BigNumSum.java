package com.algorithm;

/**
 * Created by Eric on 2016/8/9.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 大数相加
 给定两个非常大的正整数A和B，位数在50至100之间。求C＝A+B；

 题目类别: 字符串
 难度: 中级
 分数:
 运行时间限制: 10 Sec
 内存限制: 128 MByte
 阶段: 招聘管理
 输入:
 因为A和B很大，从高位到低位，以字符串的形式输入两行数字A和B。A和B的位数在50至100之间。

 输出:
 以字符串形式，输出一行，表示A和B的和。

 样例输入: 11111111111111111111111111111111111111111111111111
 22222222222222222222222222222222222222222222222222

 样例输出: 33333333333333333333333333333333333333333333333333

 */
public class BigNumSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String a = sc.nextLine();
            String b = sc.nextLine();

            List<Integer> sum = new ArrayList<Integer>();
            if (a.length() > b.length()){
                int carry = 0;
                for (int i = b.length() - 1,j = a.length() - 1;i >= 0;i --,j --)
                {
                    int m = Integer.parseInt(String.valueOf(a.charAt(j)));
                    int n = Integer.parseInt(String.valueOf(b.charAt(i)));
                    sum.add((m + n + carry) % 10);
                    if (m + n +carry >= 10)
                        carry = 1;
                    else carry = 0;

                }
                for (int i = a.length() - b.length() - 1;i >= 0;i --){
                    int m = Integer.parseInt(String.valueOf(a.charAt(i)));
                    sum.add((m + carry) % 10);
                    if (m + carry >= 10)
                        carry = 1;
                    else carry = 0;
                }
                if (carry == 1)
                    sum.add(1);
            }
            else if (b.length() > a.length()){
                int carry = 0;
                for (int i = a.length() - 1,j = b.length() - 1;i >= 0 ;i --,j --)
                {
                    int m = Integer.parseInt(String.valueOf(b.charAt(j)));
                    int n = Integer.parseInt(String.valueOf(a.charAt(i)));
                    sum.add((m + n + carry) % 10);
                    if (m + n +carry >= 10)
                        carry = 1;
                    else carry = 0;

                }
                for (int i = b.length() - a.length() - 1;i >= 0;i --){
                    int m = Integer.parseInt(String.valueOf(b.charAt(i)));
                    sum.add((m + carry) % 10);
                    if (m + carry >= 10)
                        carry = 1;
                    else carry = 0;
                }
                if (carry == 1)
                    sum.add(1);
            }
            else {
                int carry = 0;
                for (int i = a.length() - 1;i >= 0;i --)
                {
                    int m = Integer.parseInt(String.valueOf(b.charAt(i)));
                    int n = Integer.parseInt(String.valueOf(a.charAt(i)));
                    sum.add((m + n + carry) % 10);
                    if (m + n + carry >= 10)
                        carry = 1;
                    else carry = 0;
                }
                if (carry == 1)
                    sum.add(1);
            }
            Iterator<Integer> iterator = sum.iterator();
            String output = "";
            while (iterator.hasNext()) {
                int k = iterator.next();
                output += k;
            }
            for (int i = output.length() - 1;i >= 0; i --)
            System.out.print(output.charAt(i));
        }
    }
}
