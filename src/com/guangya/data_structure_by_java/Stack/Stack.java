package com.guangya.data_structure_by_java.Stack;

public interface Stack<T> {

    int getSize();
    boolean isEmpty();
    void push(T e);
    T pop();
    T peek();
}
