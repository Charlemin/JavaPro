package com.plus;

/**
 * Created by Administrator on 2016/5/7.
 */
public class StringTest {

    public static void main(String[] args) {

//        String a=new String("12345");
//        String b="12345";
//        System.out.println(a==b);
//        System.out.println(a.equals(b));

        System.out.println(getFibonacciNum(10));
    }

    //斐波那契数列的非递归实现
    public static long getFibonacciNum(int n){

        long result=1,prev_result=1,next_result;

        while (n>2){
            n--;
            next_result = prev_result;
            prev_result = result;

            result = prev_result + next_result;

        }
        return result;
    }
}
