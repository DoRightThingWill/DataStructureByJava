package com.data_structure_by_java.WillA3.Q3;

public class SameSet {

    public void check (int[] arr1, int[] arr2){
        // simply, first check the length of the input set
        // if their sizes differ, for sure they are different set
        // throw an error, no further action needed
        if(arr1.length != arr2.length)
            throw new IllegalArgumentException(" Data sets have different amount of elements.");

        // if their sizes are the same, move on for elements check
        // to facilitate elements check, first sort the elements
        // using a radix sorting method
        int[] arrNew1 = selectionSort(arr1);
        int[] arrNew2 = selectionSort(arr2);

        for(int i =0 ; i<arrNew1.length; i++){
            if(arrNew1[i]!=arrNew2[i]) {
                System.out.println("They are different. ");
                return;
            }
        }

        // by default, the two sets are same
        // if program running to here, no different elements were found
        // that means, the two sets are identical
        System.out.println("The two data-sets are identical");;
    }


    public int[] selectionSort(int[] arr){
        for(int i =0; i< arr.length-1;i++){
            int minIndex = i;
            int min = arr[i];
            for (int j=i+1; j<arr.length; j++){
                if(min>arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            if(minIndex !=i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }

        return arr;
    }
}
