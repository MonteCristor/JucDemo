package com.demo.thirty;

/**
 * @Author: sw
 * @sidereal_day: 2019-04-30 22:44
 * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行。
 * 但是
 * 如果有一个线程想去写共享资源， 就不应该再有其他线程可以对该资源进行读或写
 * 小总结：
 *              读-读能共存
 *              读-写不能共存
 *              写-写不能共存
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {




    }
}



