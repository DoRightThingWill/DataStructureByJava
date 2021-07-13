package com.guangya.data_structure_by_java.WoodyPractiseComp272A2;

public class Q4Test {

    public static void main(String[] args) {
        LinearHashTable linearHashTable = new LinearHashTable();

        int[] arr = {1, 5, 21, 26, 39, 14, 15, 16, 17, 18, 19, 20, 111, 145, 146};


        for(int i=0; i< arr.length; i++){
//            System.out.println(i);
            linearHashTable.add(arr[i]);
        }

        System.out.println(linearHashTable);
        System.out.println("===================================================");
        System.out.println("===================================================");
        System.out.println("===================================================");
        for(int i=0;i<arr.length; i++){
            linearHashTable.remove(arr[i]);
            System.out.println(linearHashTable);
        }
    }
}
