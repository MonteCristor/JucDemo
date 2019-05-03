package com.demo.thirty.oom;

/**
 * @Author: sw
 * @sidereal_csday: 2019-05-03
 */
public class StackOverflowErrorDemo {

    public static void main(String[] args) {

        stackOverflowErrorDemo();

    }

    //默认栈空间512k-1024k windows视虚拟内存而定
    private static void stackOverflowErrorDemo() {
        //Exception in thread "main" java.lang.StackOverflowError
        stackOverflowErrorDemo();

    }
}
