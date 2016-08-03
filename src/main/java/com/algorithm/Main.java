package com.algorithm;

import java.util.Scanner;

/**
 * Created by Eric on 2016/7/27.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String N = sc.nextLine();
            int[] nums = new int[4];
            for (int i = 0;i < 4;i ++){
                nums[i] = Integer.parseInt(String.valueOf(N.charAt(i)));
            }
            if (nums[0] == nums[1] && nums[0] == nums[2] &&nums[0] == nums[3])
                System.out.println();
            int[] nums_asc = Asc_Sort(nums);
            int[] nums_deac = Desc_sort(nums);
            int A = 1000 * nums_deac[0] + 100 * nums_deac[1] + 10 * nums_deac[2] + nums_deac[3];
            int B = 1000 * nums_asc[0] + 100 * nums_asc[1] + 10 * nums_asc[2] + nums_asc[3];
            int minus = A - B;
            while (minus != 6174){
                System.out.println(A + "-" + B + "=" + minus);


            }

        }

    }

    public  static int[] Desc_sort(int[] a){

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
            return a;
    }


    //升序
    public static  int[] Asc_Sort(int[] num) {

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
                return num;
    }
}
