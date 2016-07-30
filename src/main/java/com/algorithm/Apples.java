package com.algorithm;

/**
 * Created by Eric on 2016/7/28.
 */

/**
 果园里有一堆苹果，一共n头(n大于1小于9)熊来分，第一头为小东，它把苹果均分n份后，多出了一个，它扔掉了这一个，拿走了自己的一份苹果，接着第二头熊重复这一过程，
 即先均分n份，扔掉一个然后拿走一份，以此类推直到最后一头熊都是这样(最后一头熊扔掉后可以拿走0个，也算是n份均分)。问最初这堆苹果最少有多少个。
 给定一个整数n,表示熊的个数，返回最初的苹果数。保证有解。
 测试样例：
 2
 返回：3
 */
public class Apples {
    public static void main(String[] args) {
        System.out.println(getInitial(2));
    }

    public static int getInitial(int n) {
        int temp1=1;
        int temp2=1;
        int result=0;
        for(int i=0;i<n;i++){
            temp1=temp1*n;
        }
        for(int i=0;i<(n-1);i++){
            temp2=temp2*(n-1);
        }
        for(int x=0;;x++){
            result=(x+1)*temp1/temp2+1-n;
            int temp=result;
            int bear=n;
            while(bear>0) {
                if(temp%n==1){
                    temp=temp-temp/n-1;
                    bear--;
                }else {
                    break;
                }
            }
            if(bear==0) {
                return result;
            }
        }
    }
}
