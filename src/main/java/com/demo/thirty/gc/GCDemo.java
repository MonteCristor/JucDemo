package com.demo.thirty.gc;

import java.util.Random;

/**
 * @Author: sw
 * @sidereal_csday: 2019-05-03
 *
 * 1
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC      (DefNew+Tenured)
 *
 * 2
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC      (ParNew+Tenured)
 *
 *      备注情况:
 *      Java HotSpot(TM) 64-Bit Server VM warning: Using the ParNew young collector with the Serial old collector
 *      is deprecated and will likely be removed in a future release
 *
 * 3
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC      (PSYoungGen+ParOldGen)
 *
 * 4
 * 4.1
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelOldGC      (PSYoungGen+ParOldGen)
 * 4.2 不加就是默认UseParallelGC
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags                            (PSYoungGen+ParOldGen)
 *
 * 5
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC   (par new generation+concurrent mark-sweep)
 *
 * 6
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseG1GC
 *
 * 7(理论指导即可, 实际中java8已经被优化掉了, 没有了。)
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialOldGC
 *
 * for study 一般生产不这么配  和单独配效果一致
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC -XX:+UseParallelOldGC      (PSYoungGen+ParOldGen)
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC -XX:+UseConcMarkSweepGC      (par new generation+concurrent mark-sweep)
 *
 */
public class GCDemo {

    public static void main(String[] args) {

        //        byte[] bytes = new byte[80 * 1024 * 1024];

        String str = "lalala";

       try {

        while(true) {
            str += str + new Random().nextInt(1111111111) + new Random().nextInt(22222222);
            str.intern();
        }
       } catch (Throwable e) {
           e.printStackTrace();
       }
    }
}
