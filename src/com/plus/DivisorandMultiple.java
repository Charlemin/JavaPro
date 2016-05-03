package com.plus;

/**
 * Created by Administrator on 2016/5/3.
 */
public class DivisorandMultiple {

    public static void main(String[] args) {

        System.out.println("最大公约数是："+getMaximumDivisor(6, 12));
        System.out.println("最小公倍数是："+getMinimumMultiple(2,3));

    }

    //最大公约数
    public static int getMaximumDivisor(int a,int b){

        int temp=a%b;
        while (temp!=0)
        {
            a=b;
            b=temp;
            temp=a%b;
        }
        return b;
    }

    //最小公倍数
    public static int getMinimumMultiple(int a,int b){

        int temp;
        if(a<b)
            temp=b;
        else temp=a;
        for(int i=1;;i++)
            if((i*temp)%a==0&&(i*temp)%b==0) {
                temp *= i;
                break;
            }
        return temp;
    }
}
