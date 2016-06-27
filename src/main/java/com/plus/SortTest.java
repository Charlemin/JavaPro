package com.plus;

import java.util.Scanner;

/**
 * Created by Eric on 2016/3/21.
 */
//输入一串整数，再输入一个整数，取前一串整数和后一个整数的绝对差，按绝对差从小到大输出这一个串整数。
public class SortTest {

    public static void main(String[] args){
        int n;
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        String[] strings=str.split(" ");
        int a[]=new int[strings.length];
        int b[]=new int[strings.length];
        for(int i=0;i<strings.length;i++)
          a[i]=Integer.parseInt(strings[i]);
        n=scanner.nextInt();
        for(int i=0;i<a.length;i++)
            b[i]=Math.abs(a[i]-n);//取绝对值
        for(int i=0;i<a.length;i++)
            for(int j=0;j<a.length-1-i;j++)
                if(b[j]>b[j+1]){
                    int tmp=b[j];
                    b[j]=b[j+1];
                    b[j+1]=tmp;
                    int tmp2=a[j];
                    a[j]=a[j+1];
                    a[j+1]=tmp2;
                }
        for(int j=0;j<a.length;j++)
            System.out.print(a[j] + " ");

        }
}
