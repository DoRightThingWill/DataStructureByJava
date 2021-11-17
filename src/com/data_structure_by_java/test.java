package com.data_structure_by_java;

import com.data_structure_by_java.LinkedList.DoublyLinkedListThree;

import java.util.ArrayList;

public class test {


    public static void main(String[] args) {

//
//        int[] arr = {1,-2,-3,4,5,-6,7,-8,9};
//
//        QuickSort222 quickSort222 = new QuickSort222();
//
//        quickSort222.sort(arr);
//
//        System.out.println(Arrays.toString(arr));



        DoublyLinkedListThree node1 = new DoublyLinkedListThree(1);
        DoublyLinkedListThree node2 = new DoublyLinkedListThree(2);
        DoublyLinkedListThree node3 = new DoublyLinkedListThree(3);

        node1.next = node2;

        node2.prev = node1;
        node2.next = node3;

        node3.prev = node2;


        DoublyLinkedListThree mover2 = node1;
        while (mover2 != null){
            System.out.println(mover2.value);
            mover2 = mover2.next;
        }
        System.out.println("*********************");

        DoublyLinkedListThree curNode =   node1.reverseDoublyList();

        DoublyLinkedListThree mover = curNode;
        while (mover != null){
            System.out.println(mover.value);
            mover = mover.next;
        }

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
