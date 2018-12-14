package com.algorithm;

import java.util.concurrent.atomic.AtomicInteger;

public class Atmoic {

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(1);
        System.out.println(count.decrementAndGet());
        System.out.println(count.getAndIncrement());
        System.out.println(count.compareAndSet(1,2));
        System.out.println(count.get());


    }
}
