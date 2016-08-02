package com.algorithm;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/7/30 0030.
 */

/**
 世界上有10种人，一种懂二进制，一种不懂。那么你知道两个int32整数m和n的二进制表达，有多少个位(bit)不同么？

 输入例子:
 1999 2299

 输出例子:
 7
 */
public class UnderstandBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int i = new UnderstandBinary().countOnes(m ^ n);//异或
            System.out.println(Integer.toBinaryString(m));//整数转二进制
            System.out.println(i);
        }
    }

    public int  countOnes(int n){
        int count = 0;
        while (n != 0)
        {
            n &= n -1;
            count ++;
        }
        return count;
    }
}
