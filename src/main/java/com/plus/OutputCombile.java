package com.plus;

/**
 * Created by Administrator on 2016/3/22.
 */
public class OutputCombile {

    public  static void main(String[] args){

       System.out.println(getcombile(5,5));

    }

    public static int getcombile(int a,int b){

        int sum1=1,sum2=1,sum3=6*a-b+a-1,sum4=6*a-b-6+a-1,sum5=1,sum6=1;
        for(int i=1;i<=6*a-b;i++)
            sum1*=i;
        for(int i=1;i<=6*a-b-6;i++)
            sum2*=i;
        for(int i=1;i<=6*a-b;i++)
            sum5*=sum3;
            sum3--;
        for(int i=1;i<=6*a-b-6;i++)
            sum6*=sum4;
            sum4--;
       if(sum4>0&&sum3>0)
        return sum5/sum1-a*(sum6/sum2);
        else return sum5/sum1;


    }
}
