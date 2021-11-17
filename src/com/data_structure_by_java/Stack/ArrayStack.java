package com.data_structure_by_java.Stack;

import com.data_structure_by_java.Array.TypeArray;

public class ArrayStack<T> implements Stack<T> {
    // instance variable, and also is the backing array
    private TypeArray arr;

    // build the constructor
    public ArrayStack(int capacity){
        this.arr = new TypeArray(capacity);
    }

    public ArrayStack(){
        arr = new TypeArray();
    }

    // implementation of interface methods
    @Override
    public int getSize(){
        return arr.getSize();
    }

    @Override
    public boolean isEmpty(){
        return arr.isEmpty();
    }

    @Override
    public void push (Object element){
        arr.addLast(element);
    }

    @Override
    public T pop(){
        return (T) arr.removeLast();
    }

    @Override
    public T peek(){
        return (T) arr.getLast();
    }

    public int getCapacity (){
        return arr.getCapacity();
    }

    @Override
    public String toString (){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Stack size : %d, capacity: %d \n",arr.getSize(),arr.getCapacity()));
        res.append("Stack :");
        res.append("[");
        for (int i = 0; i < arr.getSize(); i++) {
            res.append(arr.get(i));
            if(i!= arr.getSize()-1)
                res.append(",");
        }
        res.append("] top");
        return res.toString();
    }

}
