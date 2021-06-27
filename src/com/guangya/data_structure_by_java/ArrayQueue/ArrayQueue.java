package com.guangya.data_structure_by_java.ArrayQueue;

import com.guangya.data_structure_by_java.Array.TypeArray;

public class ArrayQueue<T> implements Queue<T>{
    // instance variable
    private TypeArray<T> arr;
    //constructor with parameters
    public ArrayQueue(int capacity){
        arr = new TypeArray<>(capacity);
    }
    // constructor without parameter, wiht default capacity of 10, defined with typearray
    public ArrayQueue(){
        arr = new TypeArray<>();
    }

    @Override
    public int getSize(){
        return arr.getSize();
    }
    @Override
    public boolean isEmpty(){
        return arr.isEmpty();
    }
    public int getCapacity(){
        return arr.getCapacity();
    }
    @Override
    public void enqueue(T e){
        arr.addLast(e);
    }
    @Override
    public T dequeue(){
        return arr.removeFirst();
    }
    @Override
    public T getFront(){
        return arr.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n",arr.getSize(),arr.getCapacity()));
        res.append('[');
        for (int i=0; i<arr.getSize(); i++) {
            res.append(arr.get(i));// sine arr is class, rather than a generic java array
            if(i != arr.getSize()-1)
                res.append(',');
        }
        res.append(']');
        return res.toString();
    }

}
