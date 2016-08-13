package com.exception;

/**
 * Created by Eric on 2016/8/10.
 */
public class TestException {
    public static void main(String[] args) {
        int a = 6;
        int b = 0;
        try { // try监控区域

            if (b == 0) throw new ArithmeticException(); // 通过throw语句抛出异常
            System.out.println("a/b的值是：" + a / b);
        }
        catch (ArithmeticException e) { // catch捕捉异常
            System.out.println("程序出现异常，变量b不能为0。");
        }
        System.out.println("程序正常结束。");
    }
}
