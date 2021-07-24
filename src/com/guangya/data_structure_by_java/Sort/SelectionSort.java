package com.guangya.data_structure_by_java.Sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {101,34,119,1,-1,90,123};

        selectionSort(arr);

    }

    public static void selectionSort (int[] arr){
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

            System.out.printf(" #%d round selection sort --",i);
            System.out.println(Arrays.toString(arr));
        }
    }
}
