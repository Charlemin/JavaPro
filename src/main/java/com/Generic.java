package com;

public class Generic<T> {
    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public Generic(T key) {
        this.key = key;
    }

    public <T> T showKey(Generic<T> container) {
        return container.getKey();
    }

    public static void main(String[] args) {
        Generic<Integer> keyA = new Generic<Integer>(12);
        Generic<String> keyB = new Generic<String>("generic");
        System.out.println(keyA.showKey(keyA));
        System.out.println(keyB.showKey(keyB));
    }
}
