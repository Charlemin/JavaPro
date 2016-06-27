package com.plus;

/**
 * Created by Eric on 2016/4/8.
 */
public class Callength {


    public static void main(String[] args){
        float[] a={100,90,80,70};

        float sum=0;
        for(int i=0;i<4;i++)
            sum+=getlength(a[i]);

        System.out.println((int)sum);
    }

    public static float getlength(float heigth){
         float sum1=0,sum2=0;
        while (heigth!=Float.MIN_VALUE) {
            sum1 += heigth;
            heigth /=2;
            sum2+=heigth;
        }
          return sum1+sum2;
    }
}
