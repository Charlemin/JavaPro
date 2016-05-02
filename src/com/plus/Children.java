package com.plus;

/**
 * Created by Administrator on 2016/4/24.
 */

class father{

    public void getClassName(){

        System.out.println(this.getClass().toString());
    }
}
public class Children extends father {

    public static void main(String[] args) {

        father father=new Children();
        father.getClassName();
    }

    public void getClassName(){

        System.out.println(this.getClass().toString());
    }

}
