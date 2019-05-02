package com.demo.thirty.ref;

/**
 * @Author: sw
 * @sidereal_csday: 2019-05-02
 */
public class StrongReferenceDemo {

    public static void main(String[] args) {
        Object obj1 = new Object();//这样定义的默认就是强引用
        Object obj2 = obj1; //obj2引用赋值
        obj1 = null;
        System.gc();
        System.out.println(obj2);

    }
}
