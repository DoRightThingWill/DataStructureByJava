package com.guangya.data_structure_by_java.WoodyPractiseComp272A2;

import java.util.Random;

public class Q1Q5Test {
    public static void main(String[] args) {

        Random random = new Random();

        Integer[] arr ={1,2,3,4,5,6,7,8,9,10,11,12};

        BT btree = new BT();
        for(int i=0; i< arr.length; i++){
            btree.addByLevel(arr[i]);
        }

        // print out the binary tree
        System.out.println("=============the binary tree looks like=============");
        System.out.println("=============the binary tree looks like=============");
        V4BTPrinter v4BTPrinter = new V4BTPrinter();
        v4BTPrinter.printNode(btree.getRoot());
        System.out.println();

        // print out the next element by pre oder traversal
        System.out.println("=============pre order next element=============");
        System.out.println("=============pre order next element=============");

        for (int i =0; i< arr.length; i++){
            try {
                System.out.println(arr[i]+"-> preOrderNext -> "+btree.preOrderNext(arr[i]).getValue());
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        // print out the next element by in order traversal
        System.out.println();
        System.out.println("=============in order next element=============");
        System.out.println("=============in order next element=============");
        for (int i =0; i< arr.length; i++){
            try {
                System.out.println(arr[i]+"-> inOrderNext -> "+btree.inOrderNext(arr[i]).getValue());
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        // print out the next element by post order traversal
        System.out.println();
        System.out.println("=============post order next element=============");
        System.out.println("=============post order next element=============");
        for (int i =0; i< arr.length; i++){
            try {
                System.out.println(arr[i]+"-> postOrderNext -> "+btree.postOrderNext(arr[i]).getValue());
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        // assign and list out the pre-order-number of each element
        System.out.println();
        System.out.println("==========assign pre order number=============");
        System.out.println("==========assign pre order number=============");
        btree.preOrderNumber();

        // assign and list out the in-order-number of each element
        System.out.println();
        System.out.println("==========assign in order number=============");
        System.out.println("==========assign in order number=============");
        btree.inOrderNumber();

        // assign and list out the post-order-number of each element
        System.out.println();
        System.out.println("==========assign post order number=============");
        System.out.println("==========assign post order number=============");
        btree.postOrderNumber();

    }
}
