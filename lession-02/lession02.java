package com.company;

/**
 * Created by i on 6/30/15.
 */
public class lession02 {
    public static int[] subArray(int[] data, int beginIndex, int endIndex) {
        //包括beginIndex位置的数据，不包括endIndex的数据
        //返回data数组中从beginIndex开始到endIndex的子数组
        if(beginIndex<0||endIndex>data.length||endIndex<=beginIndex){
            return null;
        }
        int [] res = new int[endIndex-beginIndex];
        for(int i=beginIndex,j=0;i<endIndex;i++,j++){
            res[j] = data[i];
        }
        return res;
    }

    public static int[] concat(int[] data1, int[] data2) {
        //返回合并两个数组的新数组，data1数组数据在前，data2数组数据在后
        int length = data1.length + data2.length;
        int[] res = new int[length];
        int i = 0;
        for(int j=0;j<data1.length;j++,i++){
            res[i] = data1[j];
        }
        for(int j=0;j<data2.length;j++,i++){
            res[i] = data2[j];
        }
        return res;

    }

    public static int[] merge(int[] data1, int[] data2) {
        //合并两个数组，但是去掉重复数据，合并后的新数组中没有重复数据
        int length = data1.length + data2.length;
        int [] res = new int[length];
        int i = 0;
        for(int j=0;j<data1.length;j++,i++){
            res[i] = data1[j];
        }
        for(int j=0;j<data2.length;j++){
            if(lession02.indexOf(data1, data2[j])==-1){
                res[i] = data2[j];
                i++;
            }else{
                length--;
            }
        }
        System.out.println(res);
        return lession02.subArray(res,0,length);

    }

    public static int indexOf(int[] data, int d) {
        //返回数据d在data数组中的位置，如果有重复，返回第一个出现的位置，如果不存在，则返回-1
        for(int i=0;i<data.length;i++){
            if(data[i]==d){
                return i;
            }
        }
        return -1;
    }

    public static int[] sort(int[] data) {
        //排序数组，结果存在新的数组中，原数组中的数据不变
        int[] res = new int[data.length];
        int min = 0;
        for(int i=0;i<data.length;i++){
            min = i;
            for(int j=i+1;j<data.length;j++){
                if(data[min]>data[j]){
                    min = j;
                }
            }
            if(min!=i){
                int temp = data[min];
                data[min] = data[i];
                data[i] = temp;
            }
        }
        return res;
    }

    public static void sort2(int[] data) {
        //排序数组， 对data数组中的数据排序，排序后的数据依然在data中
        data = lession02.sort(data);
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 9, 8, 1, -2, 6, 8 };
        int[] b = subArray(a, 1, 3);
        int[] c = subArray(a, 3, 5);
        int[] d = subArray(a, 4, 9);
        int[] e = concat(c, d);
        int[] f = merge(c, d);
        int[] g = sort(f);
        sort2(f);
        System.out.println(indexOf(a, 8));

    }

}
