package com.demo.thirty;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: sw
 * @sidereal_csday: 2019-05-01 11:48
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {

            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+ "\t 国，被灭");
                countDownLatch.countDown();
            }, CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t *****************秦，一统天下");

    }

    private static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {

            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+ "\t 上完自习，离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t *****************班长最后关门走人");
    }
}
