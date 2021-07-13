package com.guangya.data_structure_by_java.WoodyPractiseComp272A2;

import java.util.Random;

public class Q3Test {
    public static void main(String[] args) {
        ScapeGoatTree scapeGoatTree = new ScapeGoatTree();

        Random random = new Random();

        int[] arr = {1,5,2,4,3};

        for(int i =0; i< 20; i++){
            scapeGoatTree.add(i);
        }


        V4BTPrinter v4BTPrinter = new V4BTPrinter();
        v4BTPrinter.printNode(scapeGoatTree.getRoot());
//        System.out.println("test good");
//
//        testRecurse(0,10);

    }


    public static void testRecurse ( int start, int end){

        if(start>end)
            return;

        int m = (int)Math.ceil((start + end)/2.0);

        System.out.printf("test (%d, %d)---> m: %d \n", start,end, m);

        testRecurse(start,m-1);
        testRecurse(m+1,end);

    }

}
