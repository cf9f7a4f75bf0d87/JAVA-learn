package com.company;

import java.util.*;

/**
 * Created by i on 7/2/15.
 */
public class lession05 {
    public static void main(String[] args){
        test();
    }

    public static void test(){
        SingleLinkedList sll = new SingleLinkedList();
        sll.add(5);
        sll.add(9);
        sll.add(3);

        SingleLinkedList s2 = new SingleLinkedList();
        s2.add(9);
        s2.add(38);
        s2.add(65);
        s2.add(97);
        s2.add(76);
        s2.add(3);
        s2.add(27);
        s2.add(49);

    //    SingleLinkedList mer = merge(sll,s2);       //手写
    //    mer.printAll();
        SingleLinkedList mer2 = merge2(sll,s2);   //HashSet
        mer2.printAll();


    }

    public static SingleLinkedList merge(SingleLinkedList s1, SingleLinkedList s2){
        SingleLinkedList temp = new SingleLinkedList();
        int size = s1.size;
        while(size>0){
            temp.add(s1.head.data);
            s1.remove(0);
            size--;
        }
        size = s2.size;
        while(size>0){
            if(temp.indexOf(s2.head.data)==-1){
                temp.add(s2.head.data);
            }
            s2.remove(0);
            size--;
        }

        return temp;
    }

    public static SingleLinkedList merge2(SingleLinkedList s1, SingleLinkedList s2){
        SingleLinkedList temp = new SingleLinkedList();
        int size = s1.size;
        Set set = new HashSet() ;
        while(size>0){
            set.add(s1.head.data);
            s1.remove(0);
            size--;
        }
        size = s2.size;
        while(size>0){
            set.add(s2.head.data);
            s2.remove(0);
            size--;
        }
        Iterator itr = set.iterator();
        while(itr.hasNext()){
            temp.add((int) itr.next());
        }
        return temp;
    }

}

//以下不是自己写的哈。。

class Node { 
    public int data;
    public Node next;
}

class SingleLinkedList {
    public Node head, tail; 
    public int size = 0; 

    
    public int getSize() { 
        return size; 
    }

    public void clear() { 
        head = tail = null;
        size = 0;
    }

    public void add(int data) { 
        Node n = new Node();
        int i  = 5;
        n.data = data;
        if (size == 0) { 
            head = n; 
            tail = n;
        } else { 
			/*
			 * n.next = head; head = n; 
			 */
            tail.next = n; 
            tail = n;
        }
        size++; 
    }

    public void add(int index, int data) { 

        if (index > size || index < 0) {
            return;
        }
        Node n1 = new Node();
        n1.data = data;
        if (size == 0) { 
            head = n1;
            tail = n1;
        } else { 
            Node n = head; 
            Node p = head; 
            for (int i = 0; i < index; i++) { 
                p = n;
                n = n.next;
            }
            if (n == p) { 
                n1.next = head;
                head = n1;
            } else if (n == null) { 
                tail.next = n1;
                tail = n1;
            } else { 
                p.next = n1;
                n1.next = n;
            }
        }
        size++; 
    }

    public void remove(int index) { 
        
        if (index >= size || index < 0) {
            return; 
        }
        if (size == 1) { 
            head = tail = null;
        } else if (index == 0) { 
            head = head.next; 
        } else {
            Node n = head; 
            Node p = head; 
            for (int i = 0; i < index; i++) {
                p = n;
                n = n.next;
            }
            p.next = n.next; 
            if (p.next == null) { 
                tail = p; 
            }
        }
        size--; 
    }

    public void printElements() { 
        if (size == 0) {
            System.out.println("empty single linkedlist!");
        } else {
            Node n = head;
            System.out.print("elements: ");
            while (n != null) { 
                if (n == tail) { 
                    System.out.println(n.data); 
                } else { 
                    System.out.print(n.data + ", ");
                }
                n = n.next; 
            }
        }
    }

    public void printFirst() { 
        if (head != null) {
            System.out.println("first = " + head.data);
        } else {
            System.out.println("no first element.");
        }
    }

    public void printLast() { 
        if (tail != null) {
            System.out.println("last = " + tail.data);
        } else {
            System.out.println("no last element.");
        }
    }

    public void printSize() { 
        System.out.println("size = " + size);
    }

    public void printAll() { 
        System.out.println("-----------------------------------------------------------");
        printFirst();
        printLast();
        printSize();
        printElements();
    }

    public void bubbleSort() { 
        if (size < 2) {
            return;
        }
        Node tail2 = tail; 
        while (tail2 != head) { 
            Node t1 = head; 
            Node t2 = t1.next; 
            Node p1 = null;
            while (t1 != tail2) { 
                if (t1.data > t2.data) { 
                    swapData(t1, t2); 
                }
                p1 = t1; 
                t1 = t2; 
                t2 = t2.next;
            }
            tail2 = p1; 
        }
    }

    public void swapData(Node t1, Node t2) { 
        if (t1 == null || t2 == null) { 
            return;
        }
        int temp = t1.data;
        t1.data = t2.data;
        t2.data = temp;
    }

    public void insertionSort() {
        
        if (size < 2) {
            return;
        }
        Node p1 = head.next; 
        while (p1 != null) { 
            
            Node p2 = head; 
            while (p1 != p2) { 
                if (p1.data < p2.data) {
                    int i1 = p1.data;
                    while (p2 != p1.next) { 
                        int i2 = p2.data; 
                        p2.data = i1;
                        i1 = i2;
                        p2 = p2.next;
                    }
                    break;
                } else {
                    p2 = p2.next; 
                    
                }
            }
            p1 = p1.next;
        }
    }

    public int indexOf(int data) { 
        int index = -1; 
        if (size == 0) {
            return index;
        }
        Node n = head;
        index = 0;
        while (n != null) {
            if (n.data == data) {
                return index;
            } else {
                index++;
            }
            n = n.next;
        }
        return -1;
    }

//    public static void main(String[] args) {
//        SingleLinkedList sll = new SingleLinkedList();
//        sll.add(5);
//        sll.add(9);
//        sll.add(3);
//        sll.printAll();
//        sll.remove(0);
//        sll.printAll();
//
//
//        SingleLinkedList s2 = new SingleLinkedList();
//        s2.add(49);
//        s2.add(38);
//        s2.add(65);
//        s2.add(97);
//        s2.add(76);
//        s2.add(13);
//        s2.add(27);
//        s2.add(49);
//        s2.insertionSort();
//        s2.printAll();
//
//        s2.clear();
//        s2.add(49);
//        s2.add(38);
//        s2.add(65);
//        s2.add(97);
//        s2.add(76);
//        s2.add(13);
//        s2.add(27);
//        s2.add(49);
//        s2.bubbleSort();
//        s2.printAll();
//
//        System.out.println(s2.indexOf(5));
//    }
}