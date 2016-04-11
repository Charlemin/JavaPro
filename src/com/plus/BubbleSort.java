package com.plus;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Eric on 2016/3/17.
 */
public class BubbleSort {

    public static void main(String[] args){

        //BufferedReader bf;
        int a[]={2,3,4,11,6,9,8};
        //bf=new BufferedReader(new InputStreamReader(System.in));
//        for(int i=0;i<7;i++){
//            try {
//                a[i]=Integer.parseInt(bf.readLine());
//            }
//           catch (IOException e){
//               e.printStackTrace();
//           }
//        }
//        System.out.println("ASC sorting");
//        Asc_Sort(a);
//        for(int i=0;i<7;i++){
//            System.out.println(a[i]);
//        }
//        System.out.println("DESC sorting");
        //Desc_sort2(a);
        delsort(a);
        for(int i=0;i<7;i++)
            System.out.print(a[i]+" " );
        }

    //Ωµ–Ú≈≈¡–
    static void Desc_sort(int[] a){

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

    //Ωµ–Ú≈≈¡–
    static int[] Desc_sort2(int[] a){
        int high;
        for(int i=0;i<a.length;i++)
            for(int j=a.length-1;j>i;j--){
                if(a[j]>a[j-1])
                {
                    high=a[j-1];
                    a[j-1]=a[j];
                    a[j]=high;
                }
            }
        return a;
    }

    //…˝–Ú≈≈¡–
    static  void Asc_Sort(int[] num)
    {
        int i, j;
        int n=num.length;
        for(i = 0; i < n; i++)
        {
            for(j = 0; i + j < n - 1; j++)
            {
                if(num[j] > num[j + 1])
                {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
        }
    }
    static void delsort(int[] a){
        for(int i=1;i<a.length-1;i++)
        {
            if(a[i]-a[i-1]==1&&a[i+1]-a[i]==1)
                for(int j=i+1;j<a.length;j++)
                    a[j-1]=a[j];
        }
    }
}
