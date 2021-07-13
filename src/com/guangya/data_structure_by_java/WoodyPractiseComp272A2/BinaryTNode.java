package com.guangya.data_structure_by_java.WoodyPractiseComp272A2;

public class BinaryTNode<E extends Comparable<E>> {
    // 以此节点为根的子树的总节点个数
    int size = 0;
    E value;
    BinaryTNode<E> leftChild;
    BinaryTNode<E> rightChild;
    BinaryTNode<E> parent;
    int preOrderNumber;
    int inOrderNunmber;
    int postOrderNumber;
    BinaryTNode(E value) {
        this.value = value;
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