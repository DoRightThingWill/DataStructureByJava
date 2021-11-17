package com.data_structure_by_java.WoodyPractiseComp272A2;

import java.util.Random;

public class Q2Test<E extends Comparable<E>> {

    public static void main(String[] args) {

        // initialize the tree printer
        V4BTPrinter v4BTPrinter = new V4BTPrinter();
        // initialize the tree checker
        IsBSearchTree isBSearchTree = new IsBSearchTree();


        // folloiwng is the test for a binary search tree
        // folloiwng is the test for a binary search tree
        // folloiwng is the test for a binary search tree
        // folloiwng is the test for a binary search tree
        System.out.println();
        System.out.println("===========is binary search tree===============");
        System.out.println("===========is binary search tree===============");

        BST bstEmpty = new BST();
        BST bstOnlyOneElement = new BST();
        BST bstMoreThanOneElement = new BST();

        // add one element to the tree that has only one element
        bstOnlyOneElement.add(1);

        // randomly add elements to the tree that has more than one elements
        Random random = new Random();
        for(int i=0; i<10;i++){
            bstMoreThanOneElement.add(random.nextInt(100));
        }

        // print and check the tree that is empty
        System.out.println("**********print out tree that is empty ");
        v4BTPrinter.printNode(bstEmpty.getRoot());
        try{
            if(isBSearchTree.check(bstEmpty.getRoot())){
                System.out.println("The tree is binary search tree");
            } else {
                System.out.println("The tree is NOT binary search tree");
            }
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        // print and check the tree that hase only one element
        System.out.println("**********print out tree with only one element ");
        v4BTPrinter.printNode(bstOnlyOneElement.getRoot());
        try{
            if(isBSearchTree.check(bstOnlyOneElement.getRoot())){
                System.out.println("The tree is binary search tree");
            } else {
                System.out.println("The tree is NOT binary search tree");
            }
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


        // print and check the tree that hase more than one elements
        System.out.println("**********print out tree with more than one elements ");
        v4BTPrinter.printNode(bstMoreThanOneElement.getRoot());
        try{
            if(isBSearchTree.check(bstMoreThanOneElement.getRoot())){
                System.out.println("The tree is binary search tree");
            } else {
                System.out.println("The tree is NOT binary search tree");
            }
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        // following is test for non search tree
        // following is test for non search tree
        // following is test for non search tree
        // following is test for non search tree

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("===========non binary search tree==================");
        System.out.println("===========non binary search tree==================");
//      Integer[] arr ={1,2,3,4,5,6,7,8,9,10,11,12};
        Integer[] arr ={};

        BT nonSearchTreeEmpty = new BT();
        BT nonSearchTreeOneElement = new BT();
        BT nonSearchTreeMoreThanOneElement = new BT();

        // add one element to the tree with only one element
        nonSearchTreeOneElement.addByLevel(1);

        // randomly elelments to the tree with more than one elements
        for(int i=0; i< 10; i++){
            nonSearchTreeMoreThanOneElement.addByLevel(random.nextInt(100));
        }

        // print and check the tree that is empty
        System.out.println("**********print out tree that is empty ");
        v4BTPrinter.printNode(nonSearchTreeEmpty.getRoot());
        try{
            if(isBSearchTree.check(nonSearchTreeEmpty.getRoot()))
                System.out.println("The tree is binary search tree");
            else {
                System.out.println("The tree is NOT binary search tree");
            }
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        // print and check the tree with only one element
        System.out.println("**********print out tree with only more element ");
        v4BTPrinter.printNode(nonSearchTreeOneElement.getRoot());
        try{
            if(isBSearchTree.check(nonSearchTreeOneElement.getRoot()))
                System.out.println("The tree is binary search tree");
            else {
                System.out.println("The tree is NOT binary search tree");
            }
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        // print and check the tree with more than one elements
        System.out.println("**********print out tree with more than one elements ");
        v4BTPrinter.printNode(nonSearchTreeMoreThanOneElement.getRoot());
        try{
            if(isBSearchTree.check(nonSearchTreeMoreThanOneElement.getRoot()))
                System.out.println("The tree is binary search tree");
            else {
                System.out.println("The tree is NOT binary search tree");
            }
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }



    }





}
