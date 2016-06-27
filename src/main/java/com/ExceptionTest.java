package com;

/**
 * Created by Eric on 2016/6/21.
 */
public class ExceptionTest {

    public static void main(String[] args) {
        System.out.println(test());
    }

    public  static int test(){
        try {
            int i=5/3;
            return 0;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }
}
