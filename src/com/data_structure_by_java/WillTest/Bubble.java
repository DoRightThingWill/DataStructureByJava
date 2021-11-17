package com.data_structure_by_java.WillTest;

import java.util.ArrayList;
import java.util.Random;

public class Bubble {

    public static void main(String[] args) {

        Random random = new Random();

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<10; i++)
            arr.add(random.nextInt(100));

        System.out.println(arr);

        bubbleSort(arr);
        System.out.println(arr);

        ArrayList arr2 = new ArrayList();
        for (int i = 0; i < 15; i++) {
            arr2.add(i);
        }

        System.out.println(arr2);

    }

    public static void bubbleSort(ArrayList<Integer> arr){
        for(int i=arr.size()-1; i>=0; i--){
            for(int j=0; j<i; j++){
                if(arr.get(j) > arr.get(j+1)) {
                    int temp = arr.get(j);
                    arr.set(j,arr.get(j+1));
                    arr.set(j+1,temp);
                }
            }
        }
    }
}
