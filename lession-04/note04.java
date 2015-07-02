package com.company;

/**
 * Created by i on 7/2/15.
 */
public class note04 {
    public static void main(String[] args){
        String a = new String("a");
        String b = new String("a");
       tool.log(a.equals(b));
    }
    public static void n7(){
        A4 b = new B4();
        b.b();
    }

    public static void n12(){
        A4 a = null;
        C4 b = null;
        tool.log(a instanceof A4);
        //    tool.log(a instanceof C4);
        a = new B4();
        b = new C4();
        tool.log(a instanceof A4);
        //    tool.log(a instanceof C4);
    }
}

interface i {
    int n1 = 3;
    public final static int n2 = 4;
    void a();
    void b();
}

interface ii{
    int a();
    int b();
}


////////////////////////////////////////////////
/**
 * A4 不完全实现接口 有main
 * B4 实现接口
 */
abstract class A4 implements i{
    static {
        tool.log("hello static a1");
    }
    public static void main(String[] args){
        tool.log("hello a1");

    }
    public void a(){tool.log("hello a1.a");}
}

class B4 extends A4{
    static {
        tool.log("hello static b1");
    }
    public void b(){super.a();}
    public static void main(String[] args){
        tool.log("hello b1");
    }


}


//////////////////////////////////////////////////
/**
 * 多重继承接口出错。。
 */
//    public void i.b(){
//
//    }
//
//    public void i.a(){
//
//    }
//
//    public void ii.a(){
//        return 1;
//    }
//    public void ii.b(){
//        return 1;
//    }
//
//
//}


/////////////////////////////
class C4{
    int i = 0 ;
}