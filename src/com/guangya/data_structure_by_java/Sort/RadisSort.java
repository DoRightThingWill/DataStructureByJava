package com.guangya.data_structure_by_java.Sort;

import java.util.Arrays;

public class RadisSort {

    public static void main(String[] args) {

        int[] arr = {53,3,542,748,14,214};

        radixSort(arr);
    }

    public static void radixSort(int[] arr){


        // to avoid memory leak, set the capacity of array = arr.length
        int[][] bucket = new int[10][arr.length];

        // to record the qty of numbers stored in each bucket
        int[] bucketElementCounts = new int[10];

        int max = arr[0]; // assume the first element is max;
        for (int i =1; i<arr.length; i++){
            if(arr[i]>max)
                max=arr[i];
        }

        // to get the max digit of the max number
        int maxLength = (max + "").length();

        for(int i =0, n=1; i<maxLength; i++, n*= 10){
            // for the corresponding digit of each element
            for(int j=0; j< arr.length; j++){
                int digitOfElement = arr[j] /n %10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            int index = 0;

            for (int k =0; k< bucketElementCounts.length; k++){
                if(bucketElementCounts[k]!=0){
                    for(int l =0; l<bucketElementCounts[k]; l++){
                        arr[index++] = bucket[k][l];
                    }
                }
                // every round is done, reset the bucket element to 0
                bucketElementCounts[k] = 0;
            }

            System.out.printf(" radix sort # %d round -->arry %s \n",i, Arrays.toString(arr));
        }
    }
}
