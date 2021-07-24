package com.guangya.data_structure_by_java.WoodyA3;

import java.util.ArrayList;

public class AVLTree<E extends Comparable<E>> {

    private int size;
    private BinaryTNode<E> root;

    // define the constructor
    public AVLTree(){
        this.size=0;
    }

    public AVLTree (BinaryTNode root){
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

    //get the balance factor of this node
    private int getBalanceFactor(BinaryTNode node){
        if(node == null)
            return 0;
        return getHeight(node.leftChild) - getHeight(node.rightChild);
    }

    // rightChild rotate node y, and return the new root node
    //                y                                      x
    //               / \                                   /   \
    //              x   t4   rightChild rotate                 z     y
    //             / \       ------------------>         / \   / \
    //            z   t3                                 t1 t2 t3 t4
    //           / \
    //          t1  t2
    //
    private BinaryTNode rightRotate(BinaryTNode y){
        BinaryTNode x = y.leftChild;
        BinaryTNode t3 = x.rightChild;

        // rightChild rotate
        x.rightChild = y;
        y.leftChild = t3;

        // update the height
        y.height = Math.max(getHeight(y.leftChild),getHeight(y.rightChild))+1;
        x.height = Math.max(getHeight(x.leftChild),getHeight(x.rightChild))+1;

        return x;
    }

    // left rotate node y, and return the new root node
    //        y                                      x
    //       / \                                   /   \
    //      t1  x           left rotate           y     z
    //          / \    ------------------>       / \   / \
    //         t2  z                            t1 t2 t3 t4
    //             / \
    //            t3   t4
    //
    private BinaryTNode leftRotate(BinaryTNode y){
        BinaryTNode x = y.rightChild;
        BinaryTNode t2 = x.leftChild;

        // left rotate
        x.leftChild = y;
        y.rightChild = t2;

        // update the node height
        y.height = Math.max(getHeight(y.leftChild),getHeight(y.rightChild))+1;
        x.height = Math.max(getHeight(x.leftChild),getHeight(x.rightChild))+1;

        return x;
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

        //update height of this node
        node.height = 1+ Math.max(getHeight(node.leftChild), getHeight(node.rightChild));

        return reBalance(node);
    }

    public E remove(E element){
        BinaryTNode<E> node = getNode(root, element);
        if(node!=null){
            root = remove(root,element);
            return node.value;
        }
        return null;
    }

    // delemet element e from the tree rooted as node.
    // return the new root of the new tree after element deletion
    public BinaryTNode<E> remove(BinaryTNode<E> node, E element){
        if(node == null)
            return null;

        BinaryTNode retNode;
        if(element.compareTo(node.value)<0){
            node.leftChild = remove(node.leftChild,element);
            retNode = node;
        } else if(element.compareTo(node.value)>0){
            node.rightChild= remove(node.rightChild,element);
            retNode = node;
        } else {// e == node.e
            // left child is null
            if(node.leftChild==null) {
                BinaryTNode rightNode = node.rightChild;
                node.rightChild = null;
                size--;
                retNode = rightNode;
            }
            // rightChild child is null
            else if(node.rightChild==null){
                BinaryTNode leftNode = node.leftChild;
                node.leftChild = null;
                size--;
                retNode = leftNode;
            } else {// both children are not null
                // find the mim of the rightChild subtree
                BinaryTNode<E> successor = minimum(node.rightChild);
//            successor.rightChild = removeMin(node.rightChild);
                successor.rightChild = remove(node.rightChild, successor.value);
                successor.leftChild = node.leftChild;
                node.leftChild = node.rightChild = null;
                retNode = successor;
            }
        }

        if(retNode == null)
            return null;

        //update height of this node
        retNode.height = 1+ Math.max(getHeight(retNode.leftChild), getHeight(retNode.rightChild));

        return reBalance(retNode);
    }

    private BinaryTNode reBalance(BinaryTNode node){
        // check the balance factor
        int balanceFactor = getBalanceFactor(node);
//        if(Math.abs(balanceFactor)>1)
//            System.out.println("Unbalanced : "+balanceFactor);

        // re-balance
        // LL
        if(balanceFactor>1 && getBalanceFactor(node.leftChild)>=0){
//            node = rightRotate(node);
            return rightRotate(node);
        }

        // RR
        if(balanceFactor<-1 && getBalanceFactor(node.rightChild)<=0)
            return leftRotate(node);

        // LR
        if(balanceFactor>1 && getBalanceFactor(node.leftChild)<0 ){
            node.leftChild = leftRotate(node.leftChild);
            return rightRotate(node);
        }

        // RL
        if(balanceFactor <-1 && getBalanceFactor(node.rightChild)>0){
            node.rightChild = rightRotate(node.rightChild);
            return leftRotate(node);
        }

        return node;
    }

    public E minimum(){
        if(size==0)
            throw new IllegalArgumentException("BST is empty");
        return minimum(root).value;
    }

    private BinaryTNode<E> minimum(BinaryTNode<E> node) {
        if(node.leftChild==null)
            return node;
        return minimum(node.leftChild);
    }

    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);

        return ret;
    }

    private BinaryTNode removeMin(BinaryTNode node) {
        if(node.leftChild==null){
            BinaryTNode rightNode = node.rightChild;
            node.rightChild = null;
            size--;
            return rightNode;
        }
        node.leftChild= removeMin(node.leftChild);

        return node;
    }

    private BinaryTNode<E> getNode(BinaryTNode<E> node, E element) {
        if(node == null)
            return null;
        if(node.value == element)
            return node;
        BinaryTNode leftRes = getNode(node.leftChild,element);
        if(leftRes !=null)
            return leftRes;
        return  getNode(node.rightChild,element);
    }


    // check if the tree is still a bst
    public boolean isBST(){
        ArrayList<E> elements = new ArrayList<>();
        inOrder(root, elements);
        for(int i=1; i< elements.size(); i++)
            if (elements.get(i-1).compareTo(elements.get(i))>0)
                return false;
        return true;
    }

    private void inOrder(BinaryTNode<E> node, ArrayList<E> list){
        if(node == null)
            return;
        inOrder(node.leftChild, list);
        list.add(node.value);
        inOrder(node.rightChild,list);
    }
    private int getHeight(BinaryTNode node){
        if(node==null)
            return 0;
        return node.height;
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(BinaryTNode<E> node) {
        if(node == null)
            return true;
        int balanceFactor = getBalanceFactor(node);
        if(Math.abs(balanceFactor)>1)
            return false;
        return isBalanced(node.leftChild) && isBalanced(node.rightChild);
    }

    // transform this tree by rotation
    public void transform(){
        this.root = transform1(root);

    }
    private BinaryTNode transform1(BinaryTNode node){

        if(node == null)
            return null;
        if(node.leftChild!=null && node.rightChild!=null){
            node = leftRotate(node);
            node=reBalance(node);
        }
        node.leftChild = transform1(node.leftChild);

        node.rightChild = transform1(node.rightChild);

        return node;
    }


}
