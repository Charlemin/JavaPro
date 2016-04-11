package com.plus;
import java.util.Scanner;
public class CalMoneyNum{

    public static void main(String[] args){

        Scanner scn=new Scanner(System.in);
        int T=scn.nextInt();
        for(int i=0;i<T;i++){
            int n=scn.nextInt();
            int a[]=new int[n];
            for(int j=0;j<n;j++)
                a[j]=scn.nextInt();
            getnum(a);
        }
    }


    static void getnum(int[] a){

        int sum=0;
        for(int i=0;i<a.length;i++)
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[i])
                    sum++;
                System.out.println(sum);
            }

    }

static void compute(int[] a, int d){
    int min = 0, len;
    for(int i=1;i<a.length;i++)
        if(a[i]<a[min])
            min=i;
    len = d/a[min];
    if(len<1)
        System.out.println(-1);
    int[] ans = new int[len];
    for(int j=0;j<len;j++)
        for(int num=9;num>min;num--)
            if((d-a[num-1]) >= (len-j-1)*a[min]) {
                ans[j] = num;
                d -= a[num - 1];
                break;
            }
    for(int j=0;j<len;j++)
        System.out.print(ans[j]);
    }
}