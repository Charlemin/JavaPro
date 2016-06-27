package com.plus;

/**
 * Created by Eric on 2016/4/22.
 */
public class StringArray {


    public static void main(String[] args) {

        int count=0;
        for(int i=1;i<=1000;i++)
        {
            if(i%2==0)
            if(isCoprimeNumber(i))
                count++;
        }
        System.out.println("互质数的个数是:"+count);
    }

    public static void getStringArrangement(String str){

        int num=str.length();

    }

    public static Boolean isCoprimeNumber(int n){

          int m=105;
          int i=getCommonDivisor(n,m);
          if(i==1)
            return true;
          else
            return false;

    }
    //求最大公约数
    public static int getCommonDivisor(int n,int m){

            int temp=n%m;
            while (temp!=0)
            {
                n=m;
                m=temp;
                temp=n%m;
            }

        return m;
    }
}
