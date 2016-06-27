package com.plus;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/4/23.
 */
public class Steps {


    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(n+"层台阶共有"+getSteps(n)+"种走法");
    }


    public static int getSteps(int n){

            if(n==1)
                return 1;
            else if(n==2)
                return 2;
            else return getSteps(n-1)+getSteps(n-2);
    }
}
