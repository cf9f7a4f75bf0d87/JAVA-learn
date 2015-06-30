package com.company;

/**
 * Created by i on 6/30/15.
 */
public class note02 {
    public static void n07(){
        System.out.println(21/7);
        System.out.println(21/-7);
        System.out.println(-21/7);
        System.out.println(-21/-7);
        System.out.println('A'%3);
        System.out.println('A'/-3);
    }

    public static void n08(){
        tool.log(12>>2);
        tool.log(12>>34);
        tool.log(12>>>34);
    }

    public static void n09(){
        int x = 0, y=1;
        tool.log(x);
        if(x>y&x++>0){  // x 有变化
            //..
        }
        tool.log(x);
        if(x>y&&x++>0){  // x 被短路
            //..
        }
        tool.log(x);
    }

    public static void n10(){
        Boolean b = true, a = false;

        //只有这列的 boolean 是 true
        tool.log(String.valueOf(b));
        tool.log(Boolean.parseBoolean("true"));
        tool.log(Boolean.valueOf("true"));
        tool.log(new Boolean("true"));

        tool.log(String.valueOf(a));
        tool.log(Boolean.parseBoolean("false"));
        tool.log(Boolean.valueOf("false"));
        tool.log(new Boolean("false"));

        tool.log(String.valueOf(1));
        tool.log(Boolean.parseBoolean("1"));
        tool.log(Boolean.valueOf("1"));
        tool.log(new Boolean("1"));

        tool.log(String.valueOf(0));
        tool.log(Boolean.parseBoolean("0"));
        tool.log(Boolean.valueOf("0"));
        tool.log(new Boolean("0"));
    }

}
