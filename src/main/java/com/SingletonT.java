package com;

public class SingletonT {

    private static SingletonT instance;

    public static SingletonT getInstance() {
        if (instance == null) {
            synchronized (SingletonT.class) {
                if (instance == null)
                    instance = new SingletonT();
                return instance;
            }
        }
        return instance;
    }
}
