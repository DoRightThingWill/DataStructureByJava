package com.data_structure_by_java.WillTest;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] arr= {3,4,5,5,6,5,7,8};

        selectionSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    public static void selectionSort (int[] arr){
//        int min = arr[0];
//        int minIndex = 0;


        for(int i=0; i<arr.length; i++){

            // selection sort
            // select the min and min index from the remaining un-sorted list
            // switch value the current value a[i]
            // i from 0 to length-1;
            // j from i+1 to length-1;
            int min = arr[i];
            int minIndex = i;

            for(int j=i+1; j<arr.length;j++){
                if(min>arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }

            arr[minIndex] = arr[i];
            arr[i] = min;
//            arr[minIndex] = arr[i];
        }
    }
}
