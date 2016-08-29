package com.algorithm;

import java.util.Scanner;

/**
 * Created by Eric on 2016/7/27.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] xi = new int[n];
            int[] yi = new int[n];
            int[] xj = new int[n];
            int[] yj = new int[n];
            for (int i = 0;i < n;i ++){
                xi[i] = sc.nextInt();
                yi[i] = sc.nextInt();
                xj[i] = sc.nextInt();
                yj[i] = sc.nextInt();
            }
            int length[] = new int[n];
            for (int i = 0;i < n;i ++)
                length[i] = (xj[i] - xi[i]) *(xj[i] - xi[i]) + (yi[i] - yj[i])* (yi[i] - yj[i]);

        }
    }
}
