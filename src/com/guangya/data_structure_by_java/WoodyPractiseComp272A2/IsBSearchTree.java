package com.guangya.data_structure_by_java.WoodyPractiseComp272A2;

public class IsBSearchTree<E extends Comparable<E>> {
    // define two variables to record:
    // 1. a counter, how many times the recursion method, check, has been called
    // 2. a trigger, that changes from true to false once the tree is found a non-search tree; by default it is true;
    int recursionNumber = 0;
    boolean isSearchTree = true;

    /**
     *
     * @param root, user only needs to input the root of a binary tree that is to be checked
     * @return, true, if the tree is a search tree; false, if the tree is not a search tree
     */
    public boolean check (BinaryTNode root){
        check(root,root);
        return isSearchTree;
    }

    /**
     * define a private, overloading method of check, for in-class recursion call only. not accessible to user outside the class
     * @param node, the current node, to checked if or not, meet the property of a search tree. This node change accordingly during recursion
     * @param rootNode, the root node of the tree to be checked. root node does not change during recursion
     */
    private void check(BinaryTNode<E> node, BinaryTNode rootNode){
        // if the current node being checked is root node of the tree
        // it means, we are checking a new tree.
        // every time to check a NEW tree, reset :
        // 1, trigger, isSearchTree, to defaul value, true;
        // 2, recursionNumber, to default value, 0.
        isSearchTree = (node==rootNode) ? true : isSearchTree;
        recursionNumber = (node == rootNode) ? 0 : recursionNumber;

        // every time, the private method, check, is called, increment the recursionNumber
        recursionNumber++;

        // define the recursion termination condition
        if(node== null)
            return;

        // check all of the nodes, via a pre-order-traversal
        // visit and check the current node
        // if the recursionNumber is 1, it means root node is being checked.
        // check if the tree is empty
        // if empty, throw an exception
        if(recursionNumber==1 && node==null)
            throw new IllegalArgumentException("The tree is empty");
        // when the root node is being checked, and also find both its left and right child are null
        // means the tree has only one node
        // if only one element in the tree, three an exception
        if(recursionNumber==1 && node.leftChild==null && node.rightChild==null)
            throw new IllegalArgumentException("The tree has only one element");

        // here, the tree has more than one elements
        // check if the current node match the search tree property
        // if yes, go for the next node
        // if not, set the trigger to false, stop the recursion and return .
        if((node.leftChild!=null && node.leftChild.getValue().compareTo(node.getValue())>0)
                ||
                (node.rightChild!=null && node.rightChild.getValue().compareTo(node.getValue())<0)
        ){
            isSearchTree=false;
            return;
        }
        check(node.leftChild,rootNode);
        check(node.rightChild,rootNode);
    }
}