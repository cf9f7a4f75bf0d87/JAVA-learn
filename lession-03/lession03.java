package com.company;


import java.util.List;

/**
 * Created by i on 6/30/15.
 * base64 加密 解密
 * export :   lession03.encode(String);
 * export :   lession03.decode(String);
 */
public class lession03 {
    static char[] base64_table = new char[64];
    static char special_char = '=';
    public static void init(){
        int i = 0;
        for(i=0;i<26;i++)
            base64_table[i]= (char) ('A' + i);
        for(int j=0;j<26;j++,i++)
            base64_table[i] = (char) ('a' + j);
        for( int j=0;j<10;j++,i++)
            base64_table[i] = (char) ('0' + j);

        base64_table[i]='+';i++;base64_table[i]='/';
    }
    public static String encode(String source){
        String temp = "";
        List<byte[]> b = null;
        int i=0;

        int length = source.length();
        for( i=0;length-i>2;i+=3){
            temp += lession03.bytes2base(lession03.strs2bytes(source.charAt(i), source.charAt(i + 1), source.charAt(i + 2)));
        }
        switch(length-i){
            case 2:
                byte[] bs = lession03.strs2bytes(source.charAt(i),source.charAt(i+1),(char)0x00);
                temp = temp + lession03.base64_table[bs[0]] + lession03.base64_table[bs[1]] + lession03.base64_table[bs[2]] + lession03.special_char;
                break;
            case 1:
                byte[] bo = lession03.strs2bytes(source.charAt(i),(char)0x00,(char)0x00);
                temp = temp + lession03.base64_table[bo[0]] + lession03.base64_table[bo[1]] + lession03.special_char + lession03.special_char;
                break;
        }
        return temp;
    }

    public static String decode(String source){
        String temp = "";
        source = source.replaceAll("={1,2}$","");
        tool.log(source);
        int length = source.length();
        int i=0;
        for(i=0;length-i>3;i+=4){
            temp += lession03.bytes2strs(lession03.base2bytes(source.charAt(i),source.charAt(i+1),source.charAt(i+2),source.charAt(i+3)));
        }
        if(length-i==3){
            temp += lession03.bytes2strs(lession03.base2bytes(source.charAt(i),source.charAt(i+1),source.charAt(i+2),(char)0x41)).substring(0,2);
        }
        if(length-i==2){
            temp += lession03.bytes2strs(lession03.base2bytes(source.charAt(i),source.charAt(i+1),(char)0x41,(char)0x41)).substring(0,1);
        }
        return temp;

    }

    public static byte[] strs2bytes(char s1, char s2, char s3){
        byte[] b = new byte[4];
        byte c1 = (byte)s1;
        byte c2 = (byte)s2;
        byte c3 = (byte)s3;
        b[0] = (byte) (( c1 >> 2) & 0x3f);
        b[1] = (byte) (((c1 << 4) & 0x30) | (( c2 >> 4 ) & 0xf ));
        b[2] = (byte) (((c2 << 2) & 0x3c) | (( c3 >> 6 ) & 0x3 ));
        b[3] = (byte) (( c3 >> 0) & 0x3f);
        return b;
    }
    public static String bytes2base(byte[] b){
        return  "" + lession03.base64_table[b[0]] + lession03.base64_table[b[1]] + lession03.base64_table[b[2]] + lession03.base64_table[b[3]];
    }
    public static String bytes2strs(byte[] b){
        char c1,c2,c3;
        c1 = (char) (((b[0]<<2)&0xfc) | ((b[1]>>4)&0x03));
        c2 = (char) (((b[1]<<4)&0xf0) | ((b[2]>>2)&0x0f));
        c3 = (char) (((b[2]<<6)&0xc0) | ((b[3]))&0x3f);
        return ""+c1+c2+c3;
    }
    public static byte[] base2bytes(char b1, char b2, char b3, char b4){
        byte[] b = new byte[4];
        b[0] = (byte)lession03.base2byte(b1);
        b[1] = (byte)lession03.base2byte(b2);
        b[2] = (byte)lession03.base2byte(b3);
        b[3] = (byte)lession03.base2byte(b4);
        return b;
    }
    public static int base2byte(char b){
        if(b=='/'){
            return 63;
        }else if(b=='+'){
            return 62;
        }else if(b>='A'&&b<='Z'){
            return b-'A'+ 0;
        }else if(b>='a'&&b<='z'){
            return b-'a'+ 26;
        }else if(b>='0'&&b<='9'){
            return b-'0'+ 52;
        }
        tool.log("error..........."+b);
        return 0;
    }

}
