package com.plus;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/3/28.
 */
public class Testpro {

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n,b;
        while (scanner.hasNext()) {
            n=scanner.nextInt();
            b=scanner.nextInt();

            System.out.println(get_num(n,b));
        }

    }

   static int get_num(int n ,int b){
       int a=1;
       if(n-b==1||n==b)
           a=b;
       else{
           while (a<b)
           a++;
           a++;
       }
       return a;
   }
}
