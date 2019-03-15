package com;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {

    ReentrantLock lock = new ReentrantLock(true);
    Condition condition = lock.newCondition();

    private int age;
    private String name;

    public ThreadTest(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ThreadTest{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest(28, "eric");
        System.out.println(threadTest);
    }
}
