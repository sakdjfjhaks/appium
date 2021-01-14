package com.heyi.meike.tools.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PoolsTest {
    public static void main(String[] args) {
        ExecutorService executorService =  new ThreadPoolExecutor(3,220,10000L, TimeUnit.SECONDS, new ArrayBlockingQueue(100));

        for(int i=0;i<100;i++){
            executorService.execute(new TestThread(i));
            if(i==50){
                executorService.shutdown();
            }
            if(i==70){
                executorService.shutdownNow();
            }
        }
    }
}
