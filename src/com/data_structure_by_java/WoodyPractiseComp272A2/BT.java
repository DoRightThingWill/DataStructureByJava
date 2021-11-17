package com.data_structure_by_java.WoodyPractiseComp272A2;

import java.util.LinkedList;
import java.util.Queue;

public class BT<E extends Comparable<E>> {

    private BinaryTNode root;
    private int size;
    private int currentPreOrderNumber =1;
    private int currentInOrderNumber =1;
    private int currentPostOrderNumber =1;

    public BinaryTNode getRoot() {
        return root;
    }

    // return the node visted after node x in the pre-oder traversal of bt

    // add element to the binary tree via a breadth first traversal
    public void addByLevel (E data){
        BinaryTNode newNode = new BinaryTNode<E>(data);
        if(root==null) {
            root = newNode;
            return;
        }
        Queue<BinaryTNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            BinaryTNode cur = q.remove();
            if(cur.leftChild==null) {
                cur.leftChild = newNode;
                newNode.parent=cur;
                return;
            }
            else {
                q.add(cur.leftChild);
            }
            if(cur.rightChild==null) {
                cur.rightChild = newNode;
                newNode.parent=cur;
                return;
            }
            else {
                q.add(cur.rightChild);
            }
        }
    }

    // print out all elements via pre order traveral by user
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(BinaryTNode node) {
        if(node==null)
            return;
        System.out.println(node.getValue());
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }

    // each node has fields to store pre order number, in order number, and post order number
    // assign these numbers properly
    public void preOrderNumber(){
        preOrderNumber(root);
    }

    private void preOrderNumber(BinaryTNode node) {
        if(node==null)
            return ;
        // visit the current node
        node.preOrderNumber = currentPreOrderNumber;
        System.out.println(node.getValue()+"-> preOrderNumber ->"+ currentPreOrderNumber);
        currentPreOrderNumber++;
        preOrderNumber(node.leftChild);
        preOrderNumber(node.rightChild);
    }

    public void inOrderNumber(){
        inOrderNumber(root);
    }

    private void inOrderNumber(BinaryTNode node ) {
        // recursion terminates condition
        if(node ==null)
            return;

        // recurse to the left subtree
        inOrderNumber(node.leftChild);
        // vist current node
        node.inOrderNunmber = currentInOrderNumber;
        System.out.println(node.getValue()+"-> inOrderNumber ->"+currentInOrderNumber);
        currentInOrderNumber++;
        // recurse to the right subtree
        inOrderNumber(node.rightChild);
    }

    public void postOrderNumber(){
        postOrderNumber(root);
    }

    private void postOrderNumber(BinaryTNode node) {
        if(node == null)
            return;

        // recurse to left sub tree
        postOrderNumber(node.leftChild);
        // recurse to right sub tree
        postOrderNumber(node.rightChild);
        // visit the current node
        node.postOrderNumber = currentPostOrderNumber;
        System.out.println(node.getValue()+"-> postOrderNumber ->"+currentPostOrderNumber);
        currentPostOrderNumber++;
    }

    //return the node visited after node x in a pre-order traversal of BT.
    public BinaryTNode preOrderNext(E target){

        if (preOrderNext(root,target)!=null){
            return preOrderNext(root,target);
        } else {
            throw new IllegalArgumentException(target+" is the last element in the tree. No next available");
        }
    }

    private boolean found = false;

    private BinaryTNode preOrderNext(BinaryTNode node, E target){
        found =(node ==root) ? false : found;

        if(node==null)
            return null;
        if(found==true)
            return node;
        if(node.getValue() ==target)
            found=true;
        BinaryTNode temp1 = preOrderNext(node.leftChild, target);
        if(temp1!=null)
            return temp1;
        BinaryTNode temp2 = preOrderNext(node.rightChild, target);
        if(temp2!=null)
            return temp2;
        return null;
    }

    public BinaryTNode inOrderNext(E target){
        if(inOrderNext(root, target)!=null){
            return inOrderNext(root, target);
        } else {
            throw new IllegalArgumentException(target+" is the last element. No in order next exist");
        }
    }

    private BinaryTNode inOrderNext(BinaryTNode node, E target) {
        found =(node ==root) ? false : found;

        // recursion termination condition
        if(node==null)
            return null;

        // search in the left sub-tree
        BinaryTNode leftRes = inOrderNext(node.leftChild,target);
        if(leftRes!=null)
            return leftRes;
        // visit the current node
        if(found==true)
            return node;
        if(target.equals(node.getValue()))
            found =true;
        // search in the right sub tree
        BinaryTNode rightRes = inOrderNext(node.rightChild, target);
        if(rightRes!=null)
            return rightRes;
        return null;
    }

    public BinaryTNode postOrderNext(E target){
        if(postOrderNext(root, target)!=null)
            return postOrderNext(root,target);
        else {
            throw new IllegalArgumentException(target+" is the last element. No post order next exist.");
        }
    }

    private BinaryTNode postOrderNext(BinaryTNode node, E target) {
        found =(node ==root) ? false : found;
        // recursion terminates condition
        if(node == null)
            return null;

        BinaryTNode leftRes = postOrderNext(node.leftChild,target);
        if(leftRes!=null)
            return leftRes;
        BinaryTNode rightRes = postOrderNext(node.rightChild,target);
        if(rightRes!=null)
            return rightRes;
        // visit the current node
        if(found == true)
            return node;
        if (target.equals(node.getValue()))
            found=true;

        return null;
    }

    public BinaryTNode findByPreOrderNumber(int preOrderNumber){
        preOrderNumber();
        return      findByPreOrderNumber(root,preOrderNumber);
    }

    private BinaryTNode findByPreOrderNumber(BinaryTNode node, int preOrderNumber) {
        if(node==null)
            return null;
        // visit node
        if(node.preOrderNumber==preOrderNumber)
            return node;
        BinaryTNode leftRes = findByPreOrderNumber(node.leftChild,preOrderNumber);
        if(leftRes!=null)
            return leftRes;
        BinaryTNode rightRes = findByPreOrderNumber(node.rightChild,preOrderNumber);
        if(rightRes!=null)
            return rightRes;
        return null;
    }

}
