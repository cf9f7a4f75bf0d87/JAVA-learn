package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.DoubleSummaryStatistics;

/**
 * Created by i on 7/3/15.
 */
public class note05 {
    public static void main(String[] args){
        test();
    }
    public static void test(){
       // n01();
//        n03();
//        n04();
//        get_path();
        n07();
    }

    public static void n01(){
        File f01 = new File("H"+File.separator+"not_exist.txt");
    }

    public static void n03(){
        File f03 = new File("./hello.txt");
        try {
            f03.createNewFile();
            tool.log(f03.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        tool.log(System.getProperty("user.dir"));

    }

    public static void n04(){
        File f04 = new File("./hello1.txt");
        try {
            tool.log(f04.getPath());
            tool.log(f04.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void n07(){
        try {
            RandomAccessFile f07 = new RandomAccessFile("./a.txt","rw");
            for( int i=0;i<10;i++){
                f07.writeDouble(i*1.44);
            }

            f07.close();
            f07 = new RandomAccessFile("a.txt","rw");
            f07.seek(5*(Double.SIZE/Byte.SIZE));  // skip 5 item and write
            tool.log(Double.SIZE);
            f07.writeDouble(22.2222);
            f07.seek(0);
            for(int i=0;i<10;i++){
                tool.log(f07.readDouble());
            }
            f07.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void get_path(){
        tool.log(note05.class.getResource(""));
        tool.log(note05.class.getResource("/"));
        tool.log(Thread.currentThread().getContextClassLoader().getResource(""));
        tool.log(note05.class.getClassLoader().getResource(""));
        tool.log(ClassLoader.getSystemResource(""));
    }


}
