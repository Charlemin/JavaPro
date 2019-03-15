package com;

import java.util.concurrent.CountDownLatch;

public class DeathLock {
    private static final Object object1 = new Object();
    private static final Object object2 = new Object();
    private static final CountDownLatch latch1 = new CountDownLatch(1);
    private static final CountDownLatch latch2 = new CountDownLatch(1);

    static class ThreadLock implements Runnable {
        private boolean flag;
        ThreadLock(boolean flag) {
            this.flag = flag;
        }
        @Override
        public void run() {
            if (flag) {
                synchronized (object1) {
                    System.out.println("enter object1");

                    try {
                        latch2.await();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    latch1.countDown();
                    synchronized (object2) {
                        System.out.println("enter object2");
                    }
                }
            } else {
                synchronized (object2) {
                    System.out.println("enter object2");
                    try {
                        latch1.await();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    latch2.countDown();
                    synchronized (object1) {
                        System.out.println("enter object1");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread lock1 = new Thread(new ThreadLock(true));
        Thread lock2 = new Thread(new ThreadLock(false));
        lock1.start();
        lock2.start();

    }
}
