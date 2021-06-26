package com.guangya.data_structure_by_java;

import com.guangya.data_structure_by_java.Array.Array;

public class Main {

    public static void main(String[] args) {
	// write your code hereR
        int capacity = 20;
        Array arr = new Array(capacity);
        for(int i=0; i<10; i++ )
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1,100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

    }
}

