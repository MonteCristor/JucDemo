package com.demo.thirty.oom;

import java.util.Random;

/**
 * @Author: sw
 * @sidereal_csday: 2019-05-03
 */
public class JavaHeapSpaceDemo {

    public static void main(String[] args) {

//        byte[] bytes = new byte[80 * 1024 * 1024];

        String str = "lalala";

        //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        while(true) {
            str += str + new Random().nextInt(1111111111) + new Random().nextInt(22222222);
            str.intern();
        }

    }
}
