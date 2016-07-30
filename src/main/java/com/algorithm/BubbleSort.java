package com.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Eric on 2016/3/17.
 */
public class BubbleSort {

    public static void main(String[] args){

        int a[]={2,3,4,11,6,9,8};
        int n=a.length;
        Desc_sort(a);
        System.out.print("使用冒泡排序，降序序列为:");
        for(int i=0;i<n;i++)
            System.out.print(a[i]+" " );
        System.out.println();
        Asc_Sort(a);
        System.out.print("使用冒泡排序，升序序列为:");
        for(int i=0;i<n;i++)
            System.out.print(a[i]+" " );
        }

    //降序
  public  static void Desc_sort(int[] a){

        int high;
        for(int i=0;i<a.length;i++)
           for(int j=0;j<a.length-1-i;j++){
               if(a[j]<a[j+1])
               {
                   high=a[j+1];
                   a[j+1]=a[j];
                   a[j]=high;
               }
           }
    }


    //升序
   public static  void Asc_Sort(int[] num) {

       int i, j;
        int n=num.length;
        for(i = 0; i < n; i++)
            for(j = 0; i + j < n - 1; j++)
                if(num[j] > num[j + 1])
                {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }

  }
