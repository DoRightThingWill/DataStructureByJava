package com.guangya.data_structure_by_java.WoodyA3;

import java.util.Random;

public class Q2Test {

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        V4BTPrinter v4BTPrinter = new V4BTPrinter();

        for(int i =0; i<10; i++){
            avlTree.add(i);
            v4BTPrinter.printNode(avlTree.getRoot());
            System.out.println("is bst : "+avlTree.isBST());
            System.out.println("is balanced : " +avlTree.isBalanced());
        }


        System.out.println("is bst : "+avlTree.isBST());
        System.out.println("is balanced : " +avlTree.isBalanced());

        System.out.println("***********************************************************");
        System.out.println("***********************************************************");
        for(int i=0; i<10; i++){
            avlTree.remove(i);
            v4BTPrinter.printNode(avlTree.getRoot());
            System.out.println("is bst : "+avlTree.isBST());
            System.out.println("is balanced : " +avlTree.isBalanced());
        }


        AVLTree avlTree2 = new AVLTree();
        Random random = new Random();
        for(int i =0; i<11; i++){
            avlTree2.add(i);
//            avlTree2.add(random.nextInt(100));
            v4BTPrinter.printNode(avlTree2.getRoot());
            System.out.println("is bst : "+avlTree2.isBST());
            System.out.println("is balanced : " +avlTree2.isBalanced());
        }

        System.out.println("************* After Transformation ******************");
        avlTree2.transform();
        v4BTPrinter.printNode(avlTree2.getRoot());
        System.out.println("is bst : "+avlTree2.isBST());
        System.out.println("is balanced : " +avlTree2.isBalanced());

    }
}
