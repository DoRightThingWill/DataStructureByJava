package com.data_structure_by_java.WoodyA3;

public class BinaryTNode<E extends Comparable<E>> {
    // number of direct descendant rooted at this node
    int size = 0;
    E value;
    BinaryTNode<E> leftChild;
    BinaryTNode<E> rightChild;
    BinaryTNode<E> parent;
    int height;
    int preOrderNumber;
    int inOrderNunmber;
    int postOrderNumber;
    BinaryTNode(E value) {
        this.value = value;
        this.height = 1 ;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public BinaryTNode<E> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTNode<E> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTNode<E> rightChild) {
        this.rightChild = rightChild;
    }
}