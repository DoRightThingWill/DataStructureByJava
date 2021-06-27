package com.guangya.data_structure_by_java;

import com.guangya.data_structure_by_java.Array.IntArray;
import com.guangya.data_structure_by_java.Array.TypeArray;
import com.guangya.data_structure_by_java.Stack.ArrayStack;

public class Main {

    public static void main(String[] args) {
	// write your code hereR
//        runTypeArray();
        runArrayStack();
    }

    public static void runIntArray (){
        int capacity = 20;
        IntArray arr = new IntArray(capacity);
        for(int i=0; i<10; i++ )
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1,100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr.toString());

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);
    }

    public static void runTypeArray (){
//        int capacity = 10;
        TypeArray<Integer> arr = new TypeArray<>();
        for(int i=0; i<10; i++ )
            arr.addLast(i);
        System.out.println(arr);

        arr.addFirst(4);
        System.out.println(arr);

        arr.remove(1);
        arr.remove(1);
        arr.remove(1);
        System.out.println(arr);
    }

    public static void runArrayStack (){
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}

