package com.data_structure_by_java.LinkedList;

import java.lang.reflect.Array;

public class SkiplistSSet {

    public static void main(String[] args) {

    }
}


class Node<T> {
    T x;
    Node<T>[] next;
    Node(T ix, int h){
        x = ix;
        next = (Node<T>[]) Array.newInstance(Node.class, h+1);
    }

    int height(){
        return next.length -1;
    }
}


