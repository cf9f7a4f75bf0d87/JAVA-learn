package com.company;

/**
 * Created by i on 6/30/15.
 */
public class tool {
    public static void log(Object o){
        if(o instanceof byte[]){
            byte[] b = (byte[])o;
            int i = 0;
            while(i<b.length){
                System.out.println(b[i]);
                i++;
            }
            return;
        }
        if( o instanceof int[]){
            int[] b = (int[])o;
            int i = 0;
            while(i<b.length){
                System.out.println(b[i]);
                i++;
            }
            return;
        }
        if( o instanceof char[]){
            char[] b = (char[])o;
            int i = 0;
            while(i<b.length){
                System.out.println(b[i]);
                i++;
            }
            return;
        }
        if( o instanceof String[]){
            String[] b = (String[])o;
            int i = 0;
            while(i<b.length){
                System.out.println(b[i]);
                i++;
            }
            return;
        }

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
