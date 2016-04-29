package com.plus;

/**
 * Created by Administrator on 2016/4/8.
 */
public class father extends oppa {
    public father(String str) {

        System.out.println(str);
    }

    public void print(){

        System.out.println("father");
    }
    public static void main(String[] args) {

        new father("hello").print();
    }
}
    class oppa{

        public void print(){

            System.out.println("oppa");
        }
    }

