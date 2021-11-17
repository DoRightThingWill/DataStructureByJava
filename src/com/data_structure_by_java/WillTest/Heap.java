package com.data_structure_by_java.WillTest;

import java.util.ArrayList;
import java.util.Random;

public class Heap {

    public static void main(String[] args) {

        ArrayList arr = new ArrayList();
        arr.add(3);
        arr.add(5);
        arr.add(9);
        arr.add(6);
        arr.add(4);
        arr.add(1);
        arr.add(8);

        Random random = new Random();

        for(int i=0; i<10; i++){
            arr.add(random.nextInt(100));
        }

//        heapify(arr);

        heapSort(arr);

        System.out.println(arr);


    }


    ArrayList<Integer> arr;

    public static void heapSort(ArrayList<Integer> arr){
        heapify(arr);
        for(int i = arr.size()-1; i>=0; i--){
            // swap value the first and the last element
            int temp = arr.get(0);
            arr.set(0,arr.get(i));
            arr.set(i,temp);

            // sift down the first element
            siftDown(0,i-1,arr);

        }
    }


    public static void heapify(ArrayList<Integer> arr){
        int lastIndex = arr.size() - 1;
        int parent = (lastIndex-1) / 2;

        for(int i = parent; i>=0; i--){
            siftDown(i, arr.size()-1,arr);
        }
    }

    private static void siftDown(int index, int lastIndex, ArrayList<Integer> arr){
        if(index > lastIndex)
            return;

        int left = 2 * index +1, right = 2 * index +2;

        int maxIndex = index;

        if(left<=lastIndex && arr.get(left)>arr.get(maxIndex))
            maxIndex = left;

        if(right<=lastIndex && arr.get(right)>arr.get(maxIndex))
            maxIndex = right;

        if(maxIndex != index){
            // switch the value
            int temp = arr.get(index);
            arr.set(index,arr.get(maxIndex));
            arr.set(maxIndex,temp);
            siftDown(maxIndex, lastIndex, arr);
        }
    }



}
