package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by i on 7/8/15.
 * 问题：
 ×      只是一个对象池，没做多线程
 ×      wait 阻塞到死
 */
public class lession08 {
    public static void main(String[] args){
        test();
    }

    public static void test(){
        Pool<String> p = new Pool<String>(String.class,2);
        String s1 = p.get("String 01");
        String s2 = p.get("String 02");
            tool.log(s1); tool.log(s2);

        p.release(s1);

        String s3 = p.get("String 03");

        p.release(s3);
        p.release(s2);
        String ss = "";
        tool.log(ss.getClass() == String.class);

        tool.log("能运行到这里吗?");
    }
}

class Pool<T>{
    private ArrayList<T> li = new ArrayList<T>();
    private int size = 0;
    private int pos = 0;
    private int available = 0;
    private boolean[] valid = null;
    Pool(Class<T> c, int size){
        this.size = this.available = size;
        valid = new boolean[size];
        for(int i = 0;i < size; i++){
            try {
                li.add(c.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            valid[i] = true;
        }
    }

    synchronized public T get(T t){
        while(available<=0){
            try {
                wait();
                tool.log("i m waiting..");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i = 0;i < size; i++){
            if(valid[i]){
                available -- ;
                valid[i] = false;
                li.set(i,t);
                return li.get(i);
            }
        }
        return null;
    }


    synchronized public boolean release(T t){
        tool.log("start release..");
        if(available>=size){
            return false;
        }
        for(int i = 0;i < size; i++){
            if(li.get(i) == t&&!valid[i]){
                tool.log("release one..");
                available ++;
                valid[i] = true;
                notify();
                return true;
            }
        }
        return false;
    }

}

