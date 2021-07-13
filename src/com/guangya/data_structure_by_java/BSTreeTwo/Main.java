package com.guangya.data_structure_by_java.BSTreeTwo;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        BST<Integer> bst2 = new BST<>();

        Random random = new Random();
        int n =1000;
        for(int i=0;i<n;i++){
            bst.add(random.nextInt(10000));
            bst2.add(random.nextInt(10000));
        }

        ArrayList<Integer> nums = new ArrayList<>();
        while(!bst.isEmpty())
            nums.add(bst.removeMin());
        System.out.println(nums);


        ArrayList<Integer> nums2 = new ArrayList<>();
        while(!bst2.isEmpty()){
            nums2.add(bst2.removeMax());
        }
        System.out.println(nums2);


    }
}




