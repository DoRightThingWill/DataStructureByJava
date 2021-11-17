package com.data_structure_by_java.Set;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left, right;

        public Node(E e){
            this.e = e;
            left=null;
            right=null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        this.size = 0;
    }

    public int size (){
        return size;
    }

    public boolean isEmpty (){
        return size==0;
    }

    // add new elelment to bst
    public void add (E e){
        root = add(root,e);
    }


    // this is very important
    // add an element e to the tree rooted as e
    // recurse to the subtrees with new node
    // the rooted node change accordingly
    // return the new root node of the new tree after insertion
    private Node add (Node node, E e){
        if(node==null){
            size++;
            return new Node(e);
        }

        if(e.compareTo(node.e)<0){
            node.left = add(node.left,e);
        } else {
            node.right=add(node.right,e);
        }
        return node;
    }

    // check if the bst contains an element
    public boolean contains (E e){
        return contains(root, e);
    }

    // check if the node-rooted bst contains an elelment
    private boolean contains(Node node, E e){
        if(root==null)
            return false;
        if(e.compareTo(node.e)==0)
            return true;
        else if (e.compareTo(node.e)<0){
            return contains(node.left,e);
        } else { // e.compareTo(node.e)>0
            return contains(node.right,e);
        }
    }

    // preorder traverse by user
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderNR (){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if(cur.right!=null)
                stack.push(cur.right);
            if(cur.left!=null)
                stack.push(cur.left);
        }
    }

    public void inOrder (){
        inOrder(root);
    }

    private void inOrder(Node node) {
        if(node==null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }


    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node) {
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void levelOrder(){
        Queue<Node> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);

            if(cur.left!=null)
                q.add(cur.left);
            if(cur.right!=null)
                q.add(cur.right);
        }
    }

    public E minimum(){
        if(size==0)
            throw new IllegalArgumentException("BST is empty");
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if(node.left==null)
            return node;
        return minimum(node.left);
    }

    public E maximum(){
        if(size==0)
            throw new IllegalArgumentException("BST is emtpy");
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if(node.right == null)
            return node;
        return maximum(node.right);
    }

    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);

        return ret;
    }

    private Node removeMin(Node node) {
        if(node.left==null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left= removeMin(node.left);

        return node;
    }

    public E removeMax (){
        E ret = maximum();
        root= removeMax(root);

        return ret;
    }

    private Node removeMax(Node node) {
        if(node.right==null){
            Node leftNode = node.left;
            node.left=null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    // delete the element of e from the bst
    public void remove (E e){
        root= remove(root, e);
    }

    // delemet element e from the tree rooted as node.
    // return the new root of the new tree after element deletion
    public Node remove(Node node,E e){
        if(node == null)
            return null;

        if(e.compareTo(node.e)<0){
            node.left = remove(node.left,e);
            return node;
        } else if(e.compareTo(node.e)>0){
            node.right= remove(node.right,e);
            return node;
        } else {// e == node.e
            // left child is null
            if(node.left==null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            // right child is null
            if(node.right==null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // both children are not null
            // find the mim of the right subtree
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }


    @Override
    public String toString (){
        StringBuilder res = new StringBuilder();
        genereateBSTString(root, 0, res);
        return res.toString();
    }

    private void genereateBSTString(Node node, int depth, StringBuilder res) {
        if(node==null) {
            res.append(genereateDepthString(depth) + "null\n");
            return;
        }

        res.append(genereateDepthString(depth)+node.e+"\n");
        genereateBSTString(node.left,depth+1,res);
        genereateBSTString(node.right,depth+1,res);
    }

    private String genereateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i=0; i<depth; i++){
            res.append("--");
        }
        return res.toString();
    }


}
