package com.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by xingchenzm on 17-7-27.
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args) throws Exception{
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(2);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);
        new Thread(producer).start();
        new Thread(consumer).start();
        Thread.sleep(4000);
    }
}

class Producer implements Runnable{
    protected BlockingQueue queue = null;
    public Producer(BlockingQueue queue){
        this.queue = queue;
    }
    public void run() {
        try {
            queue.put("1");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("3");
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{

    protected BlockingQueue queue = null;

    public Consumer(BlockingQueue queue){
        this.queue = queue;
    }

    public void run() {
       try {
           System.out.println(queue.take());
           System.out.println(queue.take());
           System.out.println(queue.take());
       }
       catch (InterruptedException e){
           e.printStackTrace();
       }
    }
}