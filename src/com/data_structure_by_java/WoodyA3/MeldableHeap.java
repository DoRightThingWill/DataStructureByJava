package com.data_structure_by_java.WoodyA3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class MeldableHeap<E extends Comparable<E>> {

    private BinaryTNode<E> root;
    private int size;

    public MeldableHeap(){
        size =0;
    }

    public MeldableHeap(BinaryTNode root){
        this.root = root;
        size =1;
    }

    public BinaryTNode<E> getRoot() {
        return root;
    }

    private BinaryTNode<E> merge(BinaryTNode<E> h1, BinaryTNode<E> h2){
        if(h1== null) return h2;
        if(h2== null) return h1;
        if(h2.value.compareTo(h1.value)<0) return merge(h2,h1);
        // now we always have h1.x < h2.x
        Random random = new Random();
        if(random.nextBoolean()){
            h1.leftChild = merge(h1.leftChild, h2);
            h1.leftChild.parent = h1;
        } else {
            h1.rightChild = merge(h1.rightChild,h2);
            h1.rightChild.parent = h1;
        }

        return h1;
    }

    public void add(E x){
        BinaryTNode<E> newNode = new BinaryTNode<>(x);
        root = merge(root,newNode);
        root.parent = null;
        size++;
    }

    public E remove(){
        E ret = root.value;
        root = merge(root.leftChild, root.rightChild);
        if(root!=null) root.parent = null;
        size--;
        return ret;
    }

    public E remove (E e){
        BinaryTNode<E> node = findNodeByElement(e);

        return remove(node);
    }

    public E remove ( BinaryTNode<E> u){
        if(u==null)
            throw new IllegalArgumentException("Can not find element");

        if(u == root)
            remove();

        else {
            if(u == u.parent.leftChild)
                u.parent.leftChild = null;
            else u.parent.rightChild=null;
        }

        u.parent = null;
        root = merge(root, u.leftChild);
        root = merge(root, u.rightChild);
        root.parent = null;
        size --;

        return u.value;
    }


    private BinaryTNode<E> findNodeByElement (E e){
        BinaryTNode<E> newNode = new BinaryTNode<E>(e);
        if(root==null) {
            throw new IllegalArgumentException("Heap is empty");
        }
        Queue<BinaryTNode<E>> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            BinaryTNode<E> cur = q.remove();
            if(cur.value == e) {
                return cur;
            }
            if(cur.leftChild!=null) q.add(cur.leftChild);
            if(cur.rightChild!=null) q.add(cur.rightChild);
        }

        return null;
    }

}
