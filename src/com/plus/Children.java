package com.plus;

/**
 * Created by Administrator on 2016/5/24.
 */
class Father {

    public int i=0;
    private int j=0;

    public void public_print(){

        System.out.println("this is a public test");
    }

    private void private_print(){

        System.out.println("this is a private test");
    }
}

//子类不能访问父类的私有成员变量和成员方法
public class Children extends Father{


    public static void main(String[] args) {

        new Children().public_print();
    }
}