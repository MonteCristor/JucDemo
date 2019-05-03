package com.demo.thirty.gc;

import java.util.Random;

/**
 * @Author: sw
 * @sidereal_csday: 2019-05-03
 *  -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+UseG1GC
 */
public class G1Demo {

    public static void main(String[] args) {

        String str = "lalala";
        while (true) {
            str += str + new Random().nextInt(777777777) + new Random().nextInt(888888888);
            str.intern();
        }

    }
}
