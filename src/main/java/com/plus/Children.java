package com.plus;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2016/5/24.
 */
class Father {

    public int i=0;
    private int j=0;

    public Father(int i){
        this.i = i;
    }
}

//子类不能访问父类的私有成员变量和成员方法
public class Children extends Father{
    int i = 0;
    public Children(int i){
        super(i);
        this.i = i;
    }
    public static void main(String[] args) {
        Children children = new Children(8);
        System.out.println(children.i);
    }
}