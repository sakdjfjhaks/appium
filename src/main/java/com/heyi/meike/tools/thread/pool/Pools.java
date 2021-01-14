package com.heyi.meike.tools.thread.pool;

import java.util.concurrent.*;

public class Pools {
    public static void pool(){
        new ThreadPoolExecutor(10,220,100000L, TimeUnit.SECONDS, new SynchronousQueue());//不能插入线程
        new ThreadPoolExecutor(10,220,100000L, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
        new ThreadPoolExecutor(10,220,100000L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        new ThreadPoolExecutor(10,220,100000L, TimeUnit.SECONDS, new LinkedBlockingDeque());
        new ThreadPoolExecutor(10,220,100000L, TimeUnit.SECONDS, new PriorityBlockingQueue());
        new ThreadPoolExecutor(10,220,100000L, TimeUnit.SECONDS, new LinkedTransferQueue());

        new ThreadPoolExecutor(10,220,100000L, TimeUnit.SECONDS, new ArrayBlockingQueue(100),new ThreadPoolExecutor.CallerRunsPolicy());
        new ThreadPoolExecutor(10,220,100000L, TimeUnit.SECONDS, new ArrayBlockingQueue(100),new ThreadPoolExecutor.AbortPolicy());
        new ThreadPoolExecutor(10,220,100000L, TimeUnit.SECONDS, new ArrayBlockingQueue(100),new ThreadPoolExecutor.DiscardPolicy());
        new ThreadPoolExecutor(10,220,100000L, TimeUnit.SECONDS, new ArrayBlockingQueue(100),new ThreadPoolExecutor.DiscardOldestPolicy());

    }
}
