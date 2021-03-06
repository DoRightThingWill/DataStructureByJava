package com.data_structure_by_java.BSTreeThree;

import java.util.Comparator;

public class BinarySearchTree<E> {



    private int size;
    private Node<E> root;
    private Comparator<E> comparator;

    public BinarySearchTree(){
        this(null);
    }

    public BinarySearchTree(Comparator comparator){
        this.comparator = comparator;
    }


    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return false;
    }

    public void clear(){

    }

    public void add(E element){
        elementNotNullCheck(element);

        // add the first element to the tree
        if(root ==null){
            root = new Node(element,null);
            size++;
            return;
        }

        // the element is not the first one into the tree
        Node<E> parent = root;
        Node<E> node = root;
        int cmp = 0;

        while(node!=null){
            cmp = compare(element,node.element);
            parent = node;
            if(cmp>0){
                node = node.right;
            } else if (cmp<0){
                node = node.left;
            } else {
                return;
            }
        }

        Node<E> newNode = new Node(element,parent);
        if(cmp>0)
            parent.right = newNode;
        else
            parent.left = newNode;

        size++;
    }

   public void remove(E element){


    }

    public boolean contains(E element){
        return false;
    }

    /**
     *
     * @param e1
     * @param e2
     * @return 0 if e1==e2; >0 if e1>e2; <0 if e1<e2
     */
    private int compare(E e1, E e2){
        if(comparator!=null){
            return this.comparator.compare(e1,e2);
        }

        return ((Comparable<E>)e1).compareTo(e2);
    }

    private void elementNotNullCheck(E element){
        if(element==null){
            throw new IllegalArgumentException("Element can not be null");
        }
    }

    private static class Node<E>{
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node (E element, Node<E> parent){
            this.element = element;
            this.parent = parent;
        }
    }

}


