package com.data_structure_by_java.WillTest;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {


        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i <10; i++) {
            arr[i] = random.nextInt(100);
        }

        mergeSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length-1);
    }
    public static void mergeSort( int[] arr, int low, int high){
        if(low>=high)
            return;

        int mid = (low + high) / 2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    };

    public static void merge(int[] arr, int low, int mid, int high){

        // find the size of teh sub array to be merged
        int n1 = mid - low +1;
        int n2 = high - mid;

        // create temp array
        int[] L = new int[n1];
        int[] R = new int[n2];

        // copy data to temp arrays
        for(int i=0; i<n1; i++){
            L[i] = arr[low+i];
        }

        for (int i = 0; i < n2; i++) {
            R[i] = arr[mid+1+i];
        }

        // merge teh temp array
        // initial index of the merged subarray
        int i =0, j=0;

        int k=low;

        while(i<n1 && j<n2){
            if(L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        // copy remaing elements of L[] if any
        while(i<n1){
            arr[k++] = L[i++];
        }

        while(j<n2){
            arr[k++] = R[j++];
        }
    }

}
