package com.guangya.data_structure_by_java.ScapeGoatTreeDemo.V3ScapeGoatTree;

public class V3ScapegoatTreeNode<E> {
    // 以此节点为根的子树的总节点个数
    int size = 1;
    E value;
    V3ScapegoatTreeNode<E> leftChild;
    V3ScapegoatTreeNode<E> rightChild;
    V3ScapegoatTreeNode(E value) {
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

    public V3ScapegoatTreeNode<E> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(V3ScapegoatTreeNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    public V3ScapegoatTreeNode<E> getRightChild() {
        return rightChild;
    }

    public void setRightChild(V3ScapegoatTreeNode<E> rightChild) {
        this.rightChild = rightChild;
    }
}