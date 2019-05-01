package com.demo.thirty;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author: sw
 * @sidereal_csday: 2019-05-01 15:34
 */
public class SemaphoreDemo {

    public static void main(String[] args) {

        //模拟三个车位
        Semaphore semaphore = new Semaphore(3);

        //模拟6部车
        for (int i = 1; i <= 6; i++) {

            new Thread(() -> {
                try {

                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t 抢到车位");
                    //暂停一会儿线程
                    try{TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) { e.printStackTrace();}
                    System.out.println(Thread.currentThread().getName()+ "\t 停车3秒后离开车位");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();

        }


    }
}
