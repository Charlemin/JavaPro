package com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singleton {


    ExecutorService service = Executors.newCachedThreadPool();
    private Singleton() {}

    public static Singleton getInstance() {
        return SingletonInstance.instance;
    }

    private static class SingletonInstance{
        private static final Singleton instance = new Singleton();
    }

    private static final Singleton singleton = new Singleton();
    public static Singleton getSingletonInstance() {
        return singleton;
    }

}
