package com.heyi.meike.tools.thread.pool;

import java.util.concurrent.ThreadFactory;

public class TestThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {

        return new Thread(r);
    }

}
