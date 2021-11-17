package com.data_structure_by_java.Sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {

        int[] arr = {8,9,1,7,2,3,5,4,6,0};

        shellSort(arr);

    }


    // shellSort is an improved version of insert sort
    public static void shellSort (int[] arr){

        int temp = 0;
        int count = 0;
        for (int gap = arr.length/2; gap>0; gap /= 2){
            for(int i = gap; i<arr.length; i++){
                // traverse all elements ( total gap groups, length/gap elements per group
                for(int j = i-gap; j>=0; j-= gap){
                    if(arr[j]>arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
            count++;
            System.out.printf("shell sort # %d round, array->%s \n",count, Arrays.toString(arr));
        }
    }
}
