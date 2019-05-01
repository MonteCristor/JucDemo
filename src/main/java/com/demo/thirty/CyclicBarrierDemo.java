package com.demo.thirty;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: sw
 * @sidereal_csday: 2019-05-01 15:13
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {

        //CylicBarrier(int parties, Runnable BarrierAction)

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() -> {
            System.out.println("*********召唤神龙");
        });

        for (int i = 1; i <= 7; i++) {

            final int tempInt = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 收集到第" + tempInt +"\t 颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();

        }







    }



}
