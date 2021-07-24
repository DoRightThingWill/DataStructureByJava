package com.guangya.data_structure_by_java;

import java.util.Arrays;
import java.util.TreeSet;

public class test {

    public static void main(String[] args) {
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};

        Solution solution = new Solution();
        int[][] intersection = solution.intervalIntersection(firstList,secondList);
        System.out.println(Arrays.toString(intersection));

    }
}


class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {


        // sub-method one:
        // check if two interval has intersection (empty or not)



        // sub-method two:
        // fst[0] intersect snd[0]
        // no intersection
        //      type 1:
        //      type 2:
        // have intersection

        int[][] retArr = new int[firstList.length + secondList.length][2];
        int index = 0;

        for (int i=0; i<firstList.length; i++){
            for(int j=0; i<secondList.length; j++){
                if(isIntersect(firstList[i],secondList[j])){
                    retArr[index] = getIntersect(firstList[i],secondList[j]);
                    index++;
                }
            }
        }

        return retArr;

    }


    private int[] getIntersect (int[] a, int[] b){
        int startA = a[0];
        int endA = a[1];

        int startB = b[0];
        int endB = b[1];

        int newStart = ((startA-startB)>=0) ? startA : startB ;
        int newEnd = ((endA-endB)<=0) ? endA : endB ;

        int[] intersection = {newStart, newEnd};

        return intersection;
    }

    private boolean isIntersect (int[] a, int[] b){
        int startA = a[0];
        int endA = a[1];

        int startB = b[0];
        int endB = b[1];


        if(endB<startA || startB>endA){
            return false;
        } else {
            return true;
        }
    }
}