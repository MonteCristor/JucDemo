package com.demo.thirty.gc;



/**
 * @Author: sw
 * @sidereal_csday: 2019-05-02
 */
public class HelloGC {

    public static void testOverStack() {
        testOverStack();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("HelloGC");
//        byte[] byteArray = new byte[50 * 1024 * 1024];
        Thread.sleep(Integer.MAX_VALUE);

   /*     long totalMemory = Runtime.getRuntime().totalMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();

        System.out.println("TOTAL_MEMORY(-Xms) = " + totalMemory + " (字节) 、" + (totalMemory / (double) 1024 / 1024) + "MB");
        System.out.println("MAX_MEMORY(-Xmx) = " + maxMemory + " (字节) 、" + (maxMemory / (double) 1024 / 1024) + "MB");*/


    }
}
