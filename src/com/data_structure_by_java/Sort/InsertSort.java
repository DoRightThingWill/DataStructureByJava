package com.data_structure_by_java.Sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {101,34,119,1,23,58,69,78};

        insertSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void insertSort (int[] arr){

        // define the number to be inserted

        for (int i =1; i<arr.length; i++){
            // define the pointer
            // to current value
            // to the index pre to the current value;
            int insertVal = arr[i];
            int insertIndex = i-1;

            // there two keypoint
            // move backward
            // i start from 1;
            // insert to the proper spot

            while(insertIndex>=0 && insertVal < arr[insertIndex]){
                // two termination condition
                // index =0;
                // arr[insertIndex] > arr[i]--->means, move the value next by one,
                // be careful, this is not a switch
                // move the value to the next slot
                // move the pointer pre by one
                arr[insertIndex +1] = arr[insertIndex];
                insertIndex--;
            }
            // this is where the insert happen
            arr[insertIndex + 1] = insertVal;
        }

    }
}
