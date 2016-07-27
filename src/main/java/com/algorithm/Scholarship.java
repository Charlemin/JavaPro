package com.algorithm;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/7/24 0024.
 */

/**
 * 小v今年有n门课，每门都有考试，为了拿到奖学金，小v必须让自己的平均成绩至少为avg。每门课由平时成绩和考试成绩组成，
 * 满分为r。现在他知道每门课的平时成绩为ai ,若想让这门课的考试成绩多拿一分的话，小v要花bi 的时间复习，不复习的话当然就是0分。
 * 同时我们显然可以发现复习得再多也不会拿到超过满分的分数。为了拿到奖学金，小v至少要花多少时间复习。
 */
public class Scholarship {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            long r = sc.nextLong();
            long arv = sc.nextLong();
            long total = n * arv;
            long pin_sum = 0;
            long[] A = new long[n];
            long[] B = new long[n];
            for (int i = 0; i < n; i ++) {
                A[i] = sc.nextLong();
                pin_sum += A[i];
                B[i] = sc.nextLong();
            }
            long sum = total - pin_sum;
            long time_sum = 0;
            sort(A, B);
            for (int i = 0; i < n; i ++) {
                if (A[i] < r && sum > 0) {
                    if (sum > r - A[i]) {
                        time_sum += ((r - A[i]) * B[i]);
                        sum -= (r - A[i]);

                    } else {
                        time_sum += (sum * B[i]);
                        sum = 0;
                    }

                }
                if (sum <= 0)
                    break;
            }
            System.out.println(time_sum);
        }
    }

    public static void sort(long[] A,long[] B){
        int length = A.length;
        for(int i = 0;i < length;i++)
            for(int j = 0;j < length - i -1;j++)
                if(B[j] > B[j + 1]){
                    long temp_B = B[j];
                    B[j] = B[j + 1];
                    B[j + 1] = temp_B;
                    long temp_A = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp_A;
                }
    }

}
