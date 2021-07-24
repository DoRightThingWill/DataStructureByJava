package com.guangya.data_structure_by_java.Sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length]; // a temporary storage array

        mergeSort(arr,0, arr.length-1,temp);

        System.out.println(" after merge sort : " + Arrays.toString(arr));

    }


    // merge + sort method
    public static void mergeSort (int[] arr, int left, int right, int[] temp){
        if(left<right){
            int mid = (left+right)/2; // the index of the middle element

            // recurse left
            mergeSort(arr, left, mid, temp);

            // recurse right
            mergeSort(arr, mid+1, right, temp);

            // merge
            merge(arr,left,mid,right,temp);
        }
    }

    /**
     *
     * @param arr
     * @param left, the index of the most left element
     * @param mid, the index of the middle element
     * @param right, the index of the right element
     * @param temp, temporary array for storage
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp){
        System.out.println("this is merging mergig merging merging merging");
        int i = left; // initiate the i, starting index of the left side of the array
        int j = mid + 1; // initiate the j, starting index of the right side of the array
        int t = 0; // point to the current index of temp array

        // step one:
        // copy the sorted elements from the array to the temp array
        // until one side is empty
        while (i<=mid && j<=right){// move on
            // if the current element of left array, is less than, current element of right array
            // put the left current element to tem array
            // then t++, i++;
            if(arr[i]<=arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            } else {// otherwise, copy the right current element to the temp array
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        // step two:
        // copy all of the remaining element of the other side into the temp array
        while(i<=mid){
            temp[t] = arr[i];
            t++;
            i++;
        }

        while (j<=right){
            temp[t] = arr[j];
            t++;
            j++;
        }

        // step three:
        // copy temp array elements to arr
        // attention: not every time, copying all elements
        t=0;
        int tempLeft = left;
        System.out.println("tempLeft = "+tempLeft+", right = "+right);
        while(tempLeft <= right){
            // first time: tempLeft = 0, right = 1;
            // second time: tempLeft = 2, right = 3;
            // third time: tempLeft = 0, right = 3;
            // ...
            // last time: tempLeft = 0, right = 7;
            arr[tempLeft] = temp[t];
            t++;
            tempLeft ++;
        }
    }
}
