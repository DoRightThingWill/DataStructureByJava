package com.data_structure_by_java.ScapeGoatTreeDemo.V3ScapeGoatTree;

import java.util.Arrays;

public class V3BTreePrinterTestTwo {

    private static V3ScapegoatTreeNode<Integer> test1() {
        V3ScapegoatTreeNode<Integer> root = new V3ScapegoatTreeNode<Integer>(2);
        V3ScapegoatTreeNode<Integer> n11 = new V3ScapegoatTreeNode<Integer>(7);
        V3ScapegoatTreeNode<Integer> n12 = new V3ScapegoatTreeNode<Integer>(5);
        V3ScapegoatTreeNode<Integer> n21 = new V3ScapegoatTreeNode<Integer>(2);
        V3ScapegoatTreeNode<Integer> n22 = new V3ScapegoatTreeNode<Integer>(6);
        V3ScapegoatTreeNode<Integer> n23 = new V3ScapegoatTreeNode<Integer>(3);
        V3ScapegoatTreeNode<Integer> n24 = new V3ScapegoatTreeNode<Integer>(6);
        V3ScapegoatTreeNode<Integer> n31 = new V3ScapegoatTreeNode<Integer>(5);
        V3ScapegoatTreeNode<Integer> n32 = new V3ScapegoatTreeNode<Integer>(8);
        V3ScapegoatTreeNode<Integer> n33 = new V3ScapegoatTreeNode<Integer>(4);
        V3ScapegoatTreeNode<Integer> n34 = new V3ScapegoatTreeNode<Integer>(5);
        V3ScapegoatTreeNode<Integer> n35 = new V3ScapegoatTreeNode<Integer>(8);
        V3ScapegoatTreeNode<Integer> n36 = new V3ScapegoatTreeNode<Integer>(4);
        V3ScapegoatTreeNode<Integer> n37 = new V3ScapegoatTreeNode<Integer>(5);
        V3ScapegoatTreeNode<Integer> n38 = new V3ScapegoatTreeNode<Integer>(8);

        root.leftChild = n11;
        root.rightChild = n12;

        n11.leftChild = n21;
        n11.rightChild = n22;
        n12.leftChild = n23;
        n12.rightChild = n24;

        n21.leftChild = n31;
        n21.rightChild = n32;
        n22.leftChild = n33;
        n22.rightChild = n34;
        n23.leftChild = n35;
        n23.rightChild = n36;
        n24.leftChild = n37;
        n24.rightChild = n38;

        return root;
    }

    private static V3ScapegoatTreeNode<Integer> test2() {
        V3ScapegoatTreeNode<Integer> root = new V3ScapegoatTreeNode<Integer>(2);
        V3ScapegoatTreeNode<Integer> n11 = new V3ScapegoatTreeNode<Integer>(7);
        V3ScapegoatTreeNode<Integer> n12 = new V3ScapegoatTreeNode<Integer>(5);
        V3ScapegoatTreeNode<Integer> n21 = new V3ScapegoatTreeNode<Integer>(2);
        V3ScapegoatTreeNode<Integer> n22 = new V3ScapegoatTreeNode<Integer>(6);
        V3ScapegoatTreeNode<Integer> n23 = new V3ScapegoatTreeNode<Integer>(9);
        V3ScapegoatTreeNode<Integer> n31 = new V3ScapegoatTreeNode<Integer>(5);
        V3ScapegoatTreeNode<Integer> n32 = new V3ScapegoatTreeNode<Integer>(8);
        V3ScapegoatTreeNode<Integer> n33 = new V3ScapegoatTreeNode<Integer>(4);

        root.leftChild = n11;
        root.rightChild = n12;

        n11.leftChild = n21;
        n11.rightChild = n22;

        n12.rightChild = n23;
        n22.leftChild = n31;
        n22.rightChild = n32;

        n23.leftChild = n33;

        return root;
    }

//    private static V3ScapegoatTreeNode<Integer> test3() {
//
//
//        V3NewScapeGoatTree v3NewScapeGoatTree = new V3NewScapeGoatTree();
////        Integer[] arr = {7,3,10,12,5,1,9,2};
//        Integer[] arr = {1,5,2,4,3};
//        for(Integer i=0;i<arr.length;i++){
//            v3NewScapeGoatTree.insert(arr[i]);
//        }
//
//
//        return v3NewScapeGoatTree.root;
//    }

    public static void main(String[] args) {

//        BTreePrinter.printNode(test1());
//        BTreePrinter.printNode(test2());
//        BTreePrinter.printNode(test3());


        V3NewScapeGoatTree v3NewScapeGoatTree = new V3NewScapeGoatTree();
//        Integer[] arr = {7,3,10,12,5,1,9,2};
//        Integer[] arr = {1,5,2,4,3,8,6,9,10,11,12,13};
//        Integer[] arr = {1,5,2,4,3};

//        for(Integer i=0;i<arr.length;i++){
//            v3NewScapeGoatTree.insert(arr[i]);
//        }
//
//        BTreePrinter.printNode(v3NewScapeGoatTree.root);
//
////        V3NewScapeGoatTree v3NewScapeGoatTree = new V3NewScapeGoatTree(test3());
//        System.out.println("credit given out is: ");
//        System.out.println(v3NewScapeGoatTree.creditGivenOut);
//        System.out.println("credit for normall insert is: ");
//        System.out.println(v3NewScapeGoatTree.creditForNormalAdd);
//        System.out.println("credit for rebuild is: ");
//        System.out.println(v3NewScapeGoatTree.creditForRebuid);
//        System.out.println("m*log(m) running credit is");
//        System.out.println(arr.length*Math.log(arr.length));


        Integer[] arr = {0,1,2,3};
        V3ScapegoatTreeNode newRoot = v3NewScapeGoatTree.reBuildCore(Arrays.asList(arr),0,3);
        BTreePrinter.printNode(newRoot);
                System.out.println("credit for rebuild is: ");
        System.out.println(v3NewScapeGoatTree.creditForRebuid);
        System.out.println("m*log(m) running credit is");
        System.out.println(arr.length*Math.log(arr.length));

    }
}

//class V3ScapegoatTreeNode<E extends Comparable<?>> {
//    V3ScapegoatTreeNode<E> leftChild, rightChild;
//    E value;
//
//    public V3ScapegoatTreeNode(E data) {
//        this.value = data;
//    }
//}

