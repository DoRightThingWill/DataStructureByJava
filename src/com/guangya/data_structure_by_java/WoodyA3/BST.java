package com.guangya.data_structure_by_java.WoodyA3;

public class BST<E extends Comparable<E>> {

    private int size;
    private BinaryTNode root;

    // define the constructor
    public BST(){
        this.size=0;
    }

    public BST (BinaryTNode root){
        this.size=0;
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public BinaryTNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTNode root) {
        this.root = root;
    }

    public void add (E value){
        root = add(root, value);
    }


    private BinaryTNode add(BinaryTNode<E> node, E value) {
        BinaryTNode newNode = new BinaryTNode(value);
        if(node==null) {
            size++;
            return newNode;
        }
        if(value.compareTo(node.getValue())<0){
            node.leftChild = add(node.leftChild,value);
        } else {
            node.rightChild = add(node.rightChild,value);
        }
        return node;
    }

}
