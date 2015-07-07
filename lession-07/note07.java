package com.company;

/**
 * Created by i on 7/7/15.
 */
public class note07 {
    int aaa = 0;
    int sync07 = 2;
    public static void main(String[] args){

    }

    public static void test(){

    }

    public static void n01(){
        A07 a07 = new A07(){
             {
                a = 4;
            }
            @Override
            void b() {
                //do sth..
            }
            void c(){
                //do sth..
            }
        };

    }

    public static void n02(){
        I07 i07 = new I07() {

            @Override
            public void c07() {
                //do sth..
            }
        };
    }

    class ThisAnInnerClass{
        int aaa = 0;
        {
            aaa = 4;
            note07.this.aaa = 5;
        }
    }

    public static void n05(int data){
        class OnlyInN05{
            int aaa = 0;
            {
                aaa = data;
//                data ++ ;  //error..
            }
            void add(){
                aaa = data + 1;
            }
        }
    }

    public static void TestSync(){
       int  aaa = 0;
        //do sth..
    }

    synchronized  public void TestSync2(){
        int aaa = 0;
        synchronized(this){
            //do sth..
        }
    }



}

class A07 {
    public int a;
    void b(){}
}
interface I07{
    int b07 = 0;
    void c07();
}