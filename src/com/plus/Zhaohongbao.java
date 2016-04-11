package com.plus;

import java.util.Scanner;

/**
 * Created by Eric on 2016/4/11.
 */
public class Zhaohongbao {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int n=Integer.parseInt(str.substring(str.length() - 1));
        String numstr=str.substring(1, str.length() - 3);
        int nums[]=new int[n];
        for(int i=0;i<n;i++)
            nums[i]=Integer.parseInt(numstr.split(",")[i]);
        System.out.println(getNum(nums,n));
    }

    static int getNum(int[] nums,int n){

        int gift=0,count=0;
        boolean flag=false;
        for(int i=0;i<n;i++)
            for(int j=0;j<i;j++) {
                flag = false;//说明前面已经出现过该字符。
                if(nums[j]==nums[i]) {
                    flag = true;
                    break;
                }
                if(flag==true)
                    continue;
                for(int k=i;k<n;k++)
                    count++;
                if(count>n/2)
                    gift=nums[i];
            }
                 return gift;
    }
}
