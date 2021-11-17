package com.data_structure_by_java.WillA3.Q3;

import java.util.Arrays;

public class Q3Test {

    public static void main(String[] args) {
        // create five data sets of comparable elements
        // to be simple, we are going to using integers.

        int[] arr1 = {10,20,45,0,83,-15,260,999,10,20,2,43,66};
        // data set arr1 and arr2 are identical
        int[] arr2 = {10,20,45,0,83,-15,260,999,10,20,2,43,66};
        // data set arr3 has idential elements with arr1 but stored in different order
        int[] arr3  = {20,10,45,0,83,-15,260,999,10,20,2,66,43};
        // data set arr4 has same quantity of elements with arr1, but different values
        int[] arr4 = {10,2,4,0,3,-15,260,999,10,21,2,42,6};

        // data set arr5, has less elements than arr1
        int[] arr5 = {10,20,45,0,83,-15,260,999,10,20};

        // initiate a new class of SmaeSet
        SameSet sameSet = new SameSet();

        // check the sorting method works for all data sets;
        System.out.println("arr1-->"+Arrays.toString(arr1)+" after sorting : -->");
        System.out.println(Arrays.toString(sameSet.selectionSort(arr1)));

        System.out.println("arr2-->"+Arrays.toString(arr2)+" after sorting : -->");
        System.out.println(Arrays.toString(sameSet.selectionSort(arr2)));

        System.out.println("arr3-->"+Arrays.toString(arr3)+" after sorting : -->");
        System.out.println(Arrays.toString(sameSet.selectionSort(arr3)));

        System.out.println("arr4-->"+Arrays.toString(arr4)+" after sorting : -->");
        System.out.println(Arrays.toString(sameSet.selectionSort(arr4)));

        System.out.println("arr5-->"+Arrays.toString(arr5)+" after sorting : -->");
        System.out.println(Arrays.toString(sameSet.selectionSort(arr5)));

        // test case one:---> two data-set are identical
        System.out.println("***************two data-set are identical********************");
//        System.out.println("Input data set one "+ Arrays.toString(arr1));
//        System.out.println("Input data set two "+ Arrays.toString(arr2));
        System.out.println("arr1 v.s. arr2 test result: --->>");
        try{sameSet.check(arr1,arr2);} catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        };

        // test case two:---> same elments but stored in different order
        System.out.println("***************same elments but stored in different order********************");
//        System.out.println("Input data set one "+ Arrays.toString(arr1));
//        System.out.println("Input data set three "+ Arrays.toString(arr3));
        System.out.println("arr1 v.s. arr3 test result: --->>");
        try{sameSet.check(arr1,arr3);} catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        };

        // test case three:---> same qty, but different values
        System.out.println("***************same qty, but different values********************");
//        System.out.println("Input data set one "+ Arrays.toString(arr1));
//        System.out.println("Input data set four "+ Arrays.toString(arr4));
        System.out.println("arr1 v.s. arr4 test result: --->>");
        try{sameSet.check(arr1,arr4);} catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        };

        // test case four:---> data-sets with different sizes
        System.out.println("***************data-sets with different sizes ********************");
//        System.out.println("Input data set one "+ Arrays.toString(arr1));
//        System.out.println("Input data set five "+ Arrays.toString(arr5));
        System.out.println("arr1 v.s. arr5 test result: --->>");
        try{sameSet.check(arr1,arr5);} catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        };

    }
}
