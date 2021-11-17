package com.data_structure_by_java.WoodyTest;

import java.util.Arrays;

public class QuickSort2 {

    public static void main(String[] args) {

        int[] arr = {12,34,12,11,78,53,42,56,78,65,11,23,21};

        quickSort2(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort2(int[] arr, int low, int high) {
        // check empty or null
        if (arr == null || arr.length == 0)
            return;

        // check low>high
        if (low > high)
            return;

        // nlogn
        // pivot choice
        // worst case
        // o n2
        int pivot = arr[(low + high) / 2];
        int i = low, j=high;
        int temp = 0;

        while (i < j) {
            // check value arr[i] < pivot
            while (arr[i] < pivot)
                i++;

            // check value arr[j] > pivot
            while (arr[j] > pivot)
                j--;

            // switch value
            if (i <= j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        }

        if (i < high) {
            quickSort2(arr, i, high);
        }

        if (low < j) {
            quickSort2(arr, low, j);
        }

    }
}