package com.demo.thirty.threadpool;

import java.util.concurrent.*;

/**
 * @Author: sw
 * @sidereal_csday: 2019-05-02
 * 第四种获得/使用java多线程的方式, 线程池
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {

        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        //模拟10个用户办理业务, 每个用户就是一个来自外部的请求线程
        try {
            for (int i = 1; i <= 10; i++) {

                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
                //暂停一会儿线程
//               try{ TimeUnit.MICROSECONDS.sleep(200);} catch (InterruptedException e) { e.printStackTrace();}
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }


    }

    public static void threadPoolInit() {
        //        System.out.println(Runtime.getRuntime().availableProcessors());

        //辅助工具类
        //Array Arrays
        //Collection Collections
        //Executor Executors

        //一池5个处理线程
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        //一池1个处理线程
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        //一池n个处理线程
//        ExecutorService threadPool = Executors.newCachedThreadPool();


        //模拟10个用户办理业务, 每个用户就是一个来自外部的请求线程
        try {
            for (int i = 1; i <= 10; i++) {

                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
               //暂停一会儿线程
//               try{ TimeUnit.MICROSECONDS.sleep(200);} catch (InterruptedException e) { e.printStackTrace();}
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
