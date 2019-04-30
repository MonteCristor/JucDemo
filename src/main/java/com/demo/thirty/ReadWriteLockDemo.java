package com.demo.thirty;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//资源类
class MyCache {
    private volatile Map<String, Object> map = new HashMap<String, Object>();
    private Lock lock = new ReentrantLock();

    public void put (String key, Object value) {
        System.out.println(Thread.currentThread().getName() + "\t 正在写入：" + key);
        //暂停一会儿线程
        try{TimeUnit.MICROSECONDS.sleep(300);} catch (java.lang.InterruptedException e) { e.printStackTrace();}
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "\t 写入完成：");
    }
    public void get (String key) {
        System.out.println(Thread.currentThread().getName() + "\t 正在读取：" + key);
        //暂停一会儿线程
        try{TimeUnit.MICROSECONDS.sleep(300);} catch (java.lang.InterruptedException e) { e.printStackTrace();}
        Object result = map.get(key);
        System.out.println(Thread.currentThread().getName() + "\t 读取完成：");
    }
}

/**
 * @Author: sw
 * @sidereal_csday: 2019-04-30 22:44
 * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行。
 * 但是
 * 如果有一个线程想去写共享资源， 就不应该再有其他线程可以对该资源进行读或写
 * 小总结：
 *              读-读能共存
 *              读-写不能共存
 *              写-写不能共存
 *
 *              写操作： 原子+独占,整个过程必须是一个完整的统一体，中间不许被分割，被打断
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {

        final MyCache myCache = new MyCache();

        for (int i = 0; i <= 5; i++) {
            final int tempInt = i ;
            new Thread(() -> {
                myCache.put(tempInt+"",tempInt+"");
            }, String.valueOf(i)).start();

        }
        for (int i = 0; i <= 5; i++) {
            final int tempInt = i ;
            new Thread(() -> {
                myCache.get(tempInt+"");
            }, String.valueOf(i)).start();

        }


    }
}



