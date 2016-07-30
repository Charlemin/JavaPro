package com.algorithm;

/**
 * Created by Eric on 2016/7/28.
 */

import java.util.Scanner;

/**
 C市现在要转移一批罪犯到D市，C市有n名罪犯，按照入狱时间有顺序，另外每个罪犯有一个罪行值，值越大罪越重。现在为了方便管理，
 市长决定转移入狱时间连续的c名犯人，同时要求转移犯人的罪行值之和不超过t，问有多少种选择的方式？

 输入描述:
 第一行数据三个整数:n，t，c(1≤n≤2e5,0≤t≤1e9,1≤c≤n)，第二行按入狱时间给出每个犯人的罪行值ai(0≤ai≤1e9)

 输出描述:
 一行输出答案。

 输入例子:
 3 100 2
 1 2 3

 输出例子:
 2
 */
public class TransferCriminal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int t = sc.nextInt();
            int c = sc.nextInt();
            int[] A = new int[n];
            for (int i = 0;i < n;i ++)
                A[i] = sc.nextInt();
            System.out.println(getChoices(A,t,c));
        }
    }

    public static int getChoices(int[] A,int t,int c){
        int length = A.length;
        int count = 0;
        int sum = 0;
        for(int i = 0;i<c;i++){
            sum += A[i];
        }
        if(sum <= t)
            count++;
        //这里很关键，用了复用的思想，后边加上一个，前边减去一个，中间的都被复用了
        for(int i = c;i< length;i++){
            sum  = sum + A[i] - A[i-c];
            if(sum <= t)
                count++;
        }
        return count;
    }
}
