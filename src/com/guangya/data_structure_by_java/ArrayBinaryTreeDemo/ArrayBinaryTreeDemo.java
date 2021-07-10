package com.guangya.data_structure_by_java.ArrayBinaryTreeDemo;

public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.preOrder();
    }

}


// left child of nth node is (2n+1) th
// right child of nth node is (2n+2) th

class ArrayBinaryTree {
    private int[] arr; // to store value

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    // overloading the preorder method
    public void preOrder(){
        preOrder(0);
    }

    // define a method to store the arr values in the tree
    /**
     *
     * @param index, index of array
     */
    public void preOrder (int index){
        // if array is empty, or arr.length ==0
        if(arr == null || arr.length ==0) {
            System.out.println("Array is empty.");
            return;
        }
        // print out the current element in the array
        System.out.println(arr[index]);
        // recurse to the left
        if((index*2+1)<arr.length){
            preOrder(index*2+1);
        }
        // recurse to the right
        if ((index*2+2)<arr.length)
            preOrder(index*2+2);
    }
}



