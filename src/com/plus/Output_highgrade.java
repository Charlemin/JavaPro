package com.plus;

import java.util.Scanner;

/**
 * Created by Eric on 2016/3/16.
 */
public class Output_highgrade {

    static  Scanner scanner=new Scanner(System.in);
    static  float high_grade;
    float[] grade={};
    public static void main(String[] args){

        int n=scanner.nextInt();
        int m=scanner.nextInt();


    }

    float search(float[] grade,int A,int B){

        float highgrade=grade[A];
        for(int i=A+1;i<=B;i++)
            if(grade[i]>highgrade)
                highgrade=grade[i];
        return highgrade;

    }
   void updata_grade(int n,int new_grade){

       grade[n]=new_grade;

    }
}
