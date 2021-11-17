package com.data_structure_by_java.ArrayQueue;

public interface Queue<T> {

    int getSize ();
    boolean isEmpty();
    void enqueue(T e);
    T dequeue();
    T getFront();

}
