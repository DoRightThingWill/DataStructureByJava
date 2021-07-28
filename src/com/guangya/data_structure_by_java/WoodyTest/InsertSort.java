package com.guangya.data_structure_by_java.WoodyTest;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {

        int[] arr= {3,4,5,5,6,5,7,8};

        insertSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    public static void insertSort(int[] arr){

        for(int i=1; i<arr.length; i++){

            // since the arr[i] will be replaced by pre values
            // we need to store its value here, i think it is a betetr way
            int insertVal = arr[i];
            int insertIndex = i-1;

//            for(int j=insertIndex; j>=0; )
            // we are not going to use for,
            // since we do not need to necessarily go through all elements
            // we just need to stop where is proper

            while(insertIndex>=0 && arr[insertIndex]>=insertVal){
                // move the insertIndex value to the next slot
                // so, the next slot will be changed
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }

            // insert the a[i] here.
            arr[insertIndex+1] = insertVal;

        }

    }
}
