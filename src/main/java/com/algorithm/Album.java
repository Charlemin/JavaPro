package com.algorithm;

/**
 * Created by Administrator on 2016/7/31 0031.
 */

import java.util.Scanner;

/**

 */
public class Album {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int s = sc.nextInt();
            int l = sc.nextInt();
            int count = 0;
            int k = l/ (s + 1);
            int left = l - k * s;
            if (left >= s)
                k ++;
            if (k % 13 != 0){
                if (n % k == 0)
                    count = n / k;
                else count = n / k +1;
            }
            else {
                if (n % (k - 1) == 0)
                    count = n / (k - 1);
                else count = n / (k - 1);
            }
            System.out.println(count);
        }
    }
}
