package com.plus;

import java.util.Scanner;

/**
 * Created by Eric on 2016/3/29.
 */
public class MaxGap {

    public static void main(String []args){

        int n,i;
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        int a[]=new int[n];
        for(i=0;i<n;i++)
            a[i]=scanner.nextInt();
        int maxFull=Integer.MIN_VALUE;
        int minMaxGap=Integer.MAX_VALUE;
        for (i = 1; i < n; i++) {
            maxFull = Math.max(maxFull, a[i]-a[i-1]);
        }
        for (i = 1; i < n-1; i++) {
            minMaxGap = Math.min(minMaxGap, Math.max(a[i+1]-a[i-1], maxFull));
        }
        System.out.println(minMaxGap);
        scanner.close();
    }
}
