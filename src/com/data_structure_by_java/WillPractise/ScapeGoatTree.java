package com.data_structure_by_java.WillPractise;

import java.util.ArrayList;

public class ScapeGoatTree<E extends Comparable<E>> {

    private BinaryTNode root;
    private final double rebuildFactor = 0.67;

    private ArrayList<BinaryTNode<E>> insertPath = new ArrayList<>();

    // define the constructor
    public ScapeGoatTree (BinaryTNode root){
        this.root = root;
    }

    public ScapeGoatTree(){}

    public BinaryTNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTNode root) {
        this.root = root;
    }

    // add element
    public void add (E elment){
        if(insertGood(root, elment)){
            // if the element insertion successdes
            // print out this msg
            System.out.println(" insert "+elment+" is done");
            // the size of each node in the inserting path increment by one
            insertPath.forEach(node->node.size++);
            int scapeGoatindex = scapeGoatIndexSearch(elment);
            if(scapeGoatindex !=-1){ // scape goat node exists
                BinaryTNode scapeGoat = insertPath.get(scapeGoatindex);
                System.out.println("need to rebuild, scapeNode is--->"+scapeGoat.getValue());
                BinaryTNode newRoot  = rebuid(scapeGoat);
                if(scapeGoatindex ==0){
                    this.root =  newRoot;
                } else {
                    BinaryTNode parentScapeGoat = insertPath.get(scapeGoatindex-1);
                    if(parentScapeGoat.leftChild == scapeGoat )
                        parentScapeGoat.leftChild = newRoot;
                    else {
                        parentScapeGoat.rightChild = newRoot;
                    }
                }
            }

            // clear the insert path list for adding next element
            insertPath.clear();
        } else {
            System.out.println(" Failed. Insert "+elment);
        }
    }

    private int scapeGoatIndexSearch(E elment) {
        int scapeGoatIndex = -1;
        for (int i=0; i<insertPath.size();i++){
            BinaryTNode cur =  insertPath.get(i);
            int leftChildSize = (cur.leftChild!=null) ? cur.leftChild.size : 0;
            int rightChildSize = (cur.rightChild!=null) ? cur.rightChild.size : 0;
            if(leftChildSize>rebuildFactor* cur.size || rightChildSize>rebuildFactor* cur.size) {
                scapeGoatIndex = i;
                break;
            }
        }
        return scapeGoatIndex;
    }

    private boolean insertGood(BinaryTNode<E> node, E element){
        BinaryTNode<E> newNode = new BinaryTNode(element);
        root = insertGood(root,newNode);
        return true;
    }


    private BinaryTNode<E> insertGood( BinaryTNode<E> cur, BinaryTNode<E> newNode){
        // store the parent node in the insert path
        if(cur !=null)
            insertPath.add(cur);

        // recursion termination: node is null
        // replace the null node with the new node, and terminate the recursion
        if(cur == null) {
            return newNode;
        }

        // if not, compare with current node
        // if less than the current, recursively insert to the left sub tree
        // otherwise, to the right sub tree
        if(newNode.getValue().compareTo(cur.getValue())<0){
            cur.leftChild = insertGood(cur.leftChild,newNode);
        } else {
            cur.rightChild = insertGood(cur.rightChild,newNode);
        }

        return cur;
    }


    public BinaryTNode<E> rebuid(BinaryTNode scapeGoat){
        ArrayList<BinaryTNode<E>> childNodes = new ArrayList();
        // pack all child nodes to array list via in order traversal
        inOrderTraversal(scapeGoat,childNodes);

        return buildCore(childNodes,0, childNodes.size()-1);
    }

    private BinaryTNode<E> buildCore(ArrayList<BinaryTNode<E>> nodeArr, int start, int end) {
        if(start>end)
            return null;

        int middle = (int)Math.ceil((start+end)/2.0);
        BinaryTNode<E> newRoot = nodeArr.get(middle);

        newRoot.size = end - start;

        newRoot.leftChild = buildCore(nodeArr, start,middle-1);
        newRoot.rightChild = buildCore(nodeArr, middle+1,end);

        return newRoot;
    }


    private void inOrderTraversal (BinaryTNode<E> node, ArrayList<BinaryTNode<E>> arr){
        if(node == null)
            return;
        inOrderTraversal(node.leftChild, arr);
        arr.add(node);
        inOrderTraversal(node.rightChild,arr);
    }
}
