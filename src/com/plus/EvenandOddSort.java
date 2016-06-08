package com.plus;

import java.util.Scanner;

/**
 * Created by Eric on 2016/3/18.
 */
public class EvenandOddSort {

    public static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args){

        int[] sum=new int[9];
        System.out.println("please enter nine numbers");
        for(int i=0;i<9;i++)
            sum[i]=scanner.nextInt();
        Desc_sort(sum);
        System.out.print("降序排列是:");
        for (int i=0;i<9;i++)
        System.out.print(sum[i]+" ");
        System.out.println();
        System.out.print("export odd:");
        for(int i=0;i<9;i++) {
            if (sum[i] % 2 == 1)
            System.out.print(sum[i]+" ");
        }
        System.out.println();
        System.out.print("export even:");
        for(int i=8;i>=0;i--) {
            if (sum[i] % 2 == 0)
                System.out.print(sum[i]+" ");
        }

    }

    //降序排列
    public  static void Desc_sort(int[] a){
        int temp;
        for(int i=0;i<a.length;i++)
            for(int j=0;j<a.length-i-1;j++)
                if(a[j]<a[j+1])
                {
                    temp=a[j+1];
                    a[j+1]=a[j];
                    a[j]=temp;
                }
            }
}
