package com.company;

import jdk.nashorn.internal.runtime.regexp.RegExp;

/**
 * Created by i on 7/2/15.
 * 检查邮箱名是否合法
 * export check_mail_format
 */
public class lession04 {
    public static void main(String[] args){
       tool.log(check_mail_format("ss16@3.com"));
    }

    public static boolean check_mail_format(String source){
        return source.matches("\\w{1,}@(?:(\\w{2,}).){1,}com");
    }
}
