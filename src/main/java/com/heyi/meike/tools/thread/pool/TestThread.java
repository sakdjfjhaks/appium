package com.heyi.meike.tools.thread.pool;

public class TestThread extends Thread {
    private int num;
    public TestThread(int num){
        this.num = num;
    }
    @Override
    public void run(){
        try {
            Thread.sleep(10);
            System.out.println("第几个线程" + num);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
