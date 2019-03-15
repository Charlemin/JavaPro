package com;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        System.out.println("Current Time = "+new Date());
//        for(int i=0; i<10; i++){
//            Thread.sleep(1000);
            WorkerThread worker = new WorkerThread("do heavy processing");
           //scheduledThreadPool.schedule(worker, 3, TimeUnit.SECONDS);
            scheduledThreadPool.scheduleAtFixedRate(worker, 5, 3, TimeUnit.SECONDS);
           scheduledThreadPool.scheduleWithFixedDelay(worker, 5, 3, TimeUnit.SECONDS);
//        }
//        Thread.sleep(300000);

//        scheduledThreadPool.shutdown();
//        while(!scheduledThreadPool.isTerminated()){
//        }
//        System.out.println("Finished all threads");
    }

}