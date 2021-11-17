package com.data_structure_by_java.WillTest;

public class FindMax {

    public static void main(String[] args) {
        int[] arr ={14,67,76,32,34,21,1};
        System.out.println(findMax(arr));
    }

    public static int findMax (int[] arr){
        int max = arr[0];

        for(int i=1; i< arr.length; i++){

            if(arr[i]>max)
                max=arr[i];
        }

        return max;


    }
}
