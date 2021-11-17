package com.data_structure_by_java.WoodyTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class QuickSort {
    public static void main(String[] args) {
        ArrayList test = new ArrayList();

        Random random = new Random();
        for(int i=0; i<10; i++){
            test.add(random.nextInt(100));
        }

//        Arrays.sort(new ArrayList[]{test});
        Collections.sort(test);
        System.out.println(test);

//        Object[] arr = test.toArray();

        int[] arr = {23,34,56,7,6,54,34,1,2,3};

        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int low, int high){
        // check for empty or null array
        if(arr== null || arr.length==0){
            return;
        }

        if(low>=high){
            return;
        }

        // get the pivot element from the middle fo the list
        int middle = (low+high)/2;

        int pivot = arr[middle];

        int i = low;
        int j = high;

        int temp = 0;

        while(i<=j){
            // check until all values on left side array are lower than pivot
            while(arr[i]<pivot)
                i++;

            // check until all values on right side are greater than pivot
            while(arr[j]>pivot)
                j--;

            // now compare values from both side of lists if they need swapping
            // after swapping, move the iterator on both sides
            if(i<=j){
//                swap(arr,i,j);
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        }

        // recursively to sort sub list
        if(low<j){
            quickSort(arr,low,j);
        }

        if(high>i){
            quickSort(arr,i,high);
        }
    }



}
