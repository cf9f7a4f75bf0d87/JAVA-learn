package com.company;

import java.io.*;

/**
 * Created by i on 7/3/15.
 */
public class lession06 {
    public static void main(String[] args){
        test();
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void test(){
        File f06 = new File("./data");
        try {
            if(!f06.exists()){
                f06.createNewFile();
            }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            FileOutputStream fou = new FileOutputStream(f06);
            BufferedOutputStream fbos = new BufferedOutputStream(fou);
            DataOutputStream fdos = new DataOutputStream(fbos);
            for(int i=0;i<10;i++){
                fdos.writeInt(i);
            }
            for( int i=0;i<10;i++){
                fdos.writeDouble(i*1.1);
            }

            fdos.close();fbos.close();fou.close();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            FileInputStream fin = new FileInputStream(f06);
            BufferedInputStream fbis = new BufferedInputStream(fin);
            DataInputStream fdis = new DataInputStream(fbis);

            for(int i=0;i<10;i++){
                tool.log(fdis.readInt());
            }
            for(int i=0;i<10;i++){
                tool.log(fdis.readDouble());
            }
            fdis.close();fbis.close();fin.close();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            RandomAccessFile raf = new RandomAccessFile(f06,"rw");
            Student s1,s2,s3,st1,st2,st3;
            s1 = new Student("n1",11,001);
            s2 = new Student("n2",22);
            s3 = new Student("n3");
            long end = raf.length();
            raf.seek(end);
            writeStudent(raf,s1);
            writeStudent(raf,s2);
            writeStudent(raf,s3);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            raf.seek(end);
            st1 = readStudent(raf);
            st2 = readStudent(raf);
            st3 = readStudent(raf);
            st1.show();st2.show();st3.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void writeStudent(RandomAccessFile raf,Student source) throws IOException {
        int len = source.name_len;
            raf.writeInt(source.id);
            raf.writeInt(source.age);
            raf.writeInt(len);
            for(int i=0;i<len;i++){
                raf.writeChar(source.name[i]);
            }
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static Student readStudent(RandomAccessFile raf) throws IOException {
        Student temp = new Student();
        temp.id = raf.readInt();
        temp.age = raf.readInt();
        int len = temp.name_len = raf.readInt();
        temp.name = new char[len];
        for(int i=0;i<len;i++){
            temp.name[i]= raf.readChar();
        }
        return temp;
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Student{
    int age,id,name_len;
    char[] name ;
    public Student(String name ,int id ,int age ){
        this.name = name.toCharArray();this.age = age; this.id = id;this.name_len = this.name.length;
    }
    public Student(String name ,int id){this(name,id,18);}
    public Student(String name){this(name, 0);}
    public Student(){this("");}
    public void show(){
        tool.log("name\t"+ new String(name) + ", id\t"+id+", age\t"+age);
    }
}