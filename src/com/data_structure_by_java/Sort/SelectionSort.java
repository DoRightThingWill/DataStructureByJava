package com.data_structure_by_java.Sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {101,34,119,1,-1,90,123};

        selectionSort(arr);

    }

    public static void selectionSort (int[] arr){

        for(int i =0; i< arr.length-1;i++){
            // start from the first element to the last element of the array
            int minIndex = i; // record the current index
            int min = arr[i]; // get the value of the current element
            for (int j=i+1; j<arr.length; j++){
                 // the key point is here
                // compare a[i], with the next element a[i+1];
                // switch the value;
                // illustration:
                // [3,5,8,2,1]
                // [1,3,5,8,2]
                // [1,2,3,5,8]
                // select the min or max from the remaining unsorted list
                // by comparison a[i] and a[j], j>=i;
                // no switching value during this operation, but assign the min value to a pointer which is min
                // check this from j=i+1 to the last element of the array
                // thus, confirm this min is the min value of the remaining unsorted list
                if(min>arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            // switch the value, a[i] and a[minIndex]
            // in-place switch
            if(minIndex !=i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

            System.out.printf(" #%d round selection sort --",i);
            System.out.println(Arrays.toString(arr));
        }
    }
}
