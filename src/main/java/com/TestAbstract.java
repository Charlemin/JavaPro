package com;

public abstract class TestAbstract {

    public abstract void test(int d, int i);

    public TestAbstract() {
    }

    public static void test2(int d, String j) {
        System.out.println("cdwc");
    }

    public static void test2(String j, String d) {
        System.out.println("cdwc");
    }

    public static void test2(String j, int d) {
        System.out.println("cdwc");
    }
}
