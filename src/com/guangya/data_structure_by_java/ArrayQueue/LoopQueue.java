package com.guangya.data_structure_by_java.ArrayQueue;

import com.guangya.data_structure_by_java.Array.TypeArray;

public class LoopQueue<T> implements Queue<T>{
    // we are not going to use the dynamic array we defined last time
    // instead, we are going to implement from scratch (static array)
    private T[] data;
    private int front, tail; //front points to the first element  in the queue; and tail -1 points to the last element
    private int size;
    // define the constructor, if user know what capacity the queue needs to have
    public LoopQueue(int capacity){
        // since, tail points to the position next to thte last element, there will be an extra space needed compared with user designed capacity.
        data =(T[])new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }
    // define the default constructor, if the user do not pass a capacity parameter. we will provide a default capacity of 10
    public LoopQueue(){
        this(10);
    }
    public int getCapacity(){
        return data.length -1;
    }
    @Override
    public boolean isEmpty(){
//        return size==0;
        return front == tail;
    }
    @Override
    public int getSize(){
        return size;
    }
    @Override
    public void enqueue(T e){
        if ((tail+1)% data.length == front) // check if the queue is full
            resize(2*data.length);
        data[tail] = e;
        tail = (tail+1)%data.length;
        size++;
    }
    @Override
    public T dequeue(){
        if(tail==front)
            throw new IllegalArgumentException("Queue if empty");
        T tem = data[front];
        data[front] = null; // empty this position
        front = (front+1)% data.length;
        size--;
        if(size<= getCapacity()/4 && getCapacity()!=0)
            resize(getCapacity()/2);
        return tem;
    }
    @Override
    public T getFront(){
        if(tail==front)// the queue is empty
            throw new IllegalArgumentException("Queue if empty");
        return data[front];
    }
    private void resize (int capacity){
        T[] tem = (T[]) new Object[capacity+1]; // define a temporary array to store values
        for (int i = 0; i < size; i++) {
            tem[i] = data[(i+front)%data.length]; // in the tem array, elements starts from 0, in the current array, element start from front
        }
        data = tem;
        front = 0;
        tail = size;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue : size %d, capacity %d\n",size,getCapacity()));
        res.append("front [");
        // the resize for loop, from i = 0, to i=size, could be used here as well.
        for (int i = front; i !=tail ; i=(i+1)%data.length) {
            res.append(data[i]);
            if((i+1)%data.length != tail)
                res.append(",");
        }
        res.append("] tail");
        return res.toString();
    }
}
