package com.demo.thirty.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: sw
 * @sidereal_csday: 2019-05-01 15:47
 * ArrayBlockingQueue: 是一个基于数组结构的有界阻塞队列， 此队列按FIFO(先进先出)原则对元素进行排序
 * LinkedBlockingQueue: 一个基于链表结构的阻塞队列，此队列按FIFO(先进先出)排序元素，吞吐量通常要高于ArrayBlockingQueue
 * SynchronousQueue:一个不存储元素的阻塞队列，每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高
 *
 * 1、队列
 *
 * 2、阻塞队列
 *  2.1阻塞队列有没有好的一面
 *
 *  2.2不得不阻塞，你如何管理
 *
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        //第四组， 超时组
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(3);

        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));


    }

    private static void powerfulBlockingGroup() throws InterruptedException {
        //第三组，阻塞组，慎用，威力强大
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(3);

        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        System.out.println("====================================================");
        blockingQueue.put("x");

//        blockingQueue.take();
//        blockingQueue.take();
//        blockingQueue.take();
//        blockingQueue.take();
    }

    private static void returnBooleanGroup() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("X"));

        //探测器，探测队顶元素
        System.out.println(blockingQueue.peek());

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
    }

    private static void throwExceptionGroup() {
        //List list = new ArrayList();
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        System.out.println(blockingQueue.element());

        //检查是否为空，检查队首元素
//        System.out.println(blockingQueue.add("x"));

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

//        System.out.println(blockingQueue.remove());
    }


}
