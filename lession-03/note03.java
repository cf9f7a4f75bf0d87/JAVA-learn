package com.company;

/**
 * Created by i on 7/1/15.
 */
public class note03 {
    public static void n14(){
        new B(5);
        //输出为 p 0 s
    }
}

class A{
    public A(){
        System.out.println("p");
        this.init();
    }
    public void init(){
        System.out.println("q");
    }
}

class B extends A{
    int i = 4;
    B(int i){
        System.out.println("s");
        this.i = i;
    }
    public void init(){
        System.out.println(i);
    }
//    public static void main(String[] args){
//        new B(5);
//    }
}