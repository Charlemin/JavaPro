package com.algorithm;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/4.
 */
public class SumOfN {
    public static void main(String[] args) {
//        DecimalFormat df = new DecimalFormat("0.00");
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            double n = sc.nextInt();
//            int m = sc.nextInt();
//            double sum = n;
//            for (int i = 0;i < m - 1;i ++)
//            {
//                n = Math.sqrt(n);
//                sum += n;
//            }
//            System.out.println(df.format(sum));
//            System.out.println("");
//        }
//        List<String> ayy = new ArrayList<String>();

         JobStatus jobStatus = JobStatus.FAILED;
        System.out.println(jobStatus);
    }

   public static void getName(){
       System.out.println("name");
   }
   public void getSex(){
       System.out.println("sex");
   }

}

enum JobStatus {
    SUCCEED, FAILED, WAITING
}