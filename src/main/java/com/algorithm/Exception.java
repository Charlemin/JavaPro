package com.algorithm;

public class Exception {
    public static void main(String[] args) {
        try {
            test(3,0);
        } catch (ArithmeticException e) {
            System.out.println("done,done,done");
            //return;
        }

        System.out.println("go,go,go");
    }

    public static int test(int a,int b) throws ArithmeticException{
        return a/b;
    }
}
