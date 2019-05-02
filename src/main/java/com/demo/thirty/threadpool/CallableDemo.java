package com.demo.thirty.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Runnable{

    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {

        System.out.println(Thread.currentThread().getName()+"************ come in Callable");

        try{java.util.concurrent.TimeUnit.SECONDS.sleep(3);} catch (java.lang.InterruptedException e) { e.printStackTrace();}
        return 1024;
    }
}

/**
 * @Author: sw
 * @sidereal_csday: 2019-05-02
 *
 java多线程中,第3种获得多线程的方式
    并发+异步导致的Callable的诞生

 Runnable和Callable区别
 1 Runnable没有返回值，Callable有返回值
 2 Run不会抛异常，     Call会抛异常
 3 un实现run方法R     Call实现call方法
 *
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //多个线程启动一个FutureTask只启动一次
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());
        FutureTask<Integer> futureTask2 = new FutureTask<>(new MyThread2());
        new Thread(futureTask, "AA").start();
        new Thread(futureTask2, "BB").start();
//        int result02 = futureTask.get();

        System.out.println(Thread.currentThread().getName()+ "******************");
        int result01 = 100;

//        while (!futureTask.isDone()) {
//
//        }

        //建议放在最后 要求获得Callable线程的计算结果，如果没有计算完成就要去强求，就会导致堵塞，值得计算完成
        int result02 = futureTask.get();

        System.out.println("******reuslt:" + (result01 + result02));

    }
}
