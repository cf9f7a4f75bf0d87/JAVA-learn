package com.company;

/**
 * Created by i on 6/30/15.
 */
public class tool {
    public static void log(Object o){
        System.out.println(o);
    }
    public static void logb(Object o){
        byte[] b = (byte[])o;
        int i = 0;
        while(i<b.length){
            System.out.println(b[i]);
            i++;
        }
    }
}
