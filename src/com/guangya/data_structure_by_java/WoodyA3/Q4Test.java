package com.guangya.data_structure_by_java.WoodyA3;

import java.util.Arrays;

public class Q4Test {


    public static void main(String[] args) {
        int [] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
//
        int recursionCount = 0;

        quickSort(arr,0, arr.length-1,recursionCount);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right, int count){
        count++;
        int l = left; // index of left as the mover;
        int r = right; // index of right end as the mover
        // select the middle element as the pivot value
        // random selection of pivot gives the best chance to achieve O(NlogN) runing time
        // worst case, could make the running time at n^2
        int pivot = arr[(left+right)/2];
        System.out.println("*****************************I am dooing #"+count+" recursion");
        System.out.println("Current : "+printArray(arr,0, arr.length-1));
        System.out.printf("Sub array : "+printArray(arr,left,right)+" with left: %d, pivot: %d, right: %d \n",left,pivot,right);
        int temp = 0; // temporary value for exchange
        // while loop to place number less than pivot in the left side, and those larger than pivot in the right side
        int loopCounter = 1;
        while(l<r){
//            System.out.println(" while loop for switching values No. ->"+loopCounter+", l: "+l+", r: "+r);

            // first, l moves from left to right, until find an element not less than pivot
            while(arr[l]<pivot)
                // if l element is less pivot, l continues moving right, l++
                l +=1;
            // then, r moves from right to left, until find an element not larger than pivot
            while(arr[r]>pivot)
                // if r element is larger than pivot, r continues moving left, r--
                r -=1;
            if(l>=r){// when l>=r, this round partition done
                break;
            }

            // l stops at the element which is larger or equal to pivot
            // r stops at the element which is less or equal to pivot
            // then switch these two values
            System.out.println("switched arr[l]->"+arr[l] + " and arr[r]->"+ arr[r]);
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // once exchagne done, check if arr[l] == pivot
            if(arr[l]==pivot)
                r-=1;
            // if arr[r] == pivot
            if(arr[r]==pivot)
                l+=1;
            loopCounter++;

        }

        // if l = r, l++, r--, move one next
        if(l==r){
            l++;
            r--;
        }

        // if left <r, means
        // recurse to left
        if(left<r){
//            System.out.println("recusre in the left side");
//            printArray(arr,left,r);
            quickSort(arr,left,r,count);
        }

        // recurse to right
        if(right >l){
//            System.out.println("recurse in the right side");
//            printArray(arr,l,right);
            quickSort(arr,l,right,count);
        }
    }

    public static String printArray(int[] arr, int start, int end){
        if(start>end)
            throw new IllegalArgumentException("Start can not be larger than End");
        StringBuilder res = new StringBuilder();
        res.append("Array->[");
        for(int i=start; i<= end; i++){
            res.append(arr[i]);
            if(i!=end)
                res.append(",");
        }
        res.append("]");
//        System.out.println(res.toString());
        return res.toString();
    }
}
