package com.algorithm;

/**
 * Created by Eric on 2016/7/26.
 */

import java.util.Scanner;

/**
 * 输入包括多组测试数据。
 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
 学生ID编号从1编到N。
 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
 */
public class HighestGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] Ni = new int[N];
            for (int i = 0;i < N;i++)
                Ni[i] = sc.nextInt();
            char[] C = new char[M];
            int[] A = new int[M];
            int[] B = new int[M];
            for (int i = 0;i < M;i++){
                C[i] = sc.next().charAt(0);
                A[i] = sc.nextInt();
                B[i] = sc.nextInt();
            }
            for(int i =0;i < M;i++){
                if (C[i] == 'Q')
                    System.out.println(getHighGrade(Ni,A[i],B[i]));
                else
                    updateGrade(Ni,A[i],B[i]);
            }

        }
    }

    public static int getHighGrade(int[] Ni,int A,int B){
        if ( A > B){
            int temp = A;
            A = B;
            B= temp;
        }
        int high_grade = Ni[A - 1];
        for (int i = A -1;i < B;i++)
            if (high_grade < Ni[i])
                high_grade = Ni[i];
        return high_grade;
    }

    public static void updateGrade(int[] Ni,int A,int B){
        Ni[A - 1] = B;
    }

}
