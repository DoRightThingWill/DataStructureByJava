package com.guangya.data_structure_by_java;

import java.util.ArrayList;

public class test {


    public static void main(String[] args) {


        int[] arr = {1,-2,-3,4,5,-6,7,-8,9};

        ArrayList<Integer> res = maxSubArr(arr);

        System.out.println(res);

    }

    public static ArrayList maxSubArr (int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int left = -1;
        int right = -1;

        for(int i = 0; i<arr.length; i++){
            sum =  arr[i];
            for (int j = i+1; j < arr.length; j++) {
                sum += arr[j];
                if(sum > maxSum){
                    maxSum = sum;
                    left = i;
                    right = j;
                }
            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        for( int m = left; m<=right; m++){
            temp.add(arr[m]);
        }
        return temp;
    }

}
