package com.company;

import java.io.*;

/**
 * Created by i on 7/6/15.
 */
public class lession07 {
    public static void main(String[] args){
        test();
    }

    public static void test(){
           // convertGBK2UTF();
        addLineNumbers();
    }

    private static void convertGBK2UTF() {
        BufferedReader bf= null;
        PrintWriter pw = null;
        try {
            bf = new BufferedReader(new InputStreamReader(new FileInputStream("a.txt"),"GBK"));
            pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("b.txt"),"UTF-8"));
            String s =null;
            while((s=bf.readLine())!=null){
                pw.write(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bf!=null) try {
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(pw!=null)pw.close();
        }

    }

    private static void addLineNumbers(){
        BufferedReader bf= null;
        PrintWriter pw = null;
        try {
            bf = new BufferedReader(new InputStreamReader(new FileInputStream("c.txt"),"UTF-8"));
            pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("d.txt"),"UTF-8"));
            String s = null;
            int i = 1;
            String num = "";
            while((s=bf.readLine())!=null){
                if(i<10){
                    num = "0" + i;
                }else{
                    num = "" + i;
                }
                s =  num + "\t" + s;
                pw.println(s);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bf!=null) try {
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(pw!=null)pw.close();
        }

    }
}
