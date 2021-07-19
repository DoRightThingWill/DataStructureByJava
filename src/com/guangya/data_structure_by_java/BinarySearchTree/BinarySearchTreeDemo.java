package com.guangya.data_structure_by_java.BinarySearchTree;

public class BinarySearchTreeDemo {
    public static void main(String[] args) {

        int[] arr = {7,3,10,12,5,1,9,2};
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for(int i=0;i<arr.length;i++){
            binarySearchTree.add(new Node(arr[i]));
        }

        binarySearchTree.inOrder();

        //delete leaf
        System.out.println("before all delete");
        binarySearchTree.delNode(2);
        binarySearchTree.delNode(5);
        binarySearchTree.delNode(9);
        binarySearchTree.delNode(12);
        binarySearchTree.delNode(7);
        binarySearchTree.delNode(3);
        binarySearchTree.delNode(10);
        binarySearchTree.delNode(1);

        System.out.println("all delete");
        binarySearchTree.inOrder();


    }
}

class BinarySearchTree<E extends Comparable<E>> {
    private Node root;

    // add node
    public void add(Node newNode){
        if(root==null)
            root=newNode;
        else {
            root.add(newNode);
        }
    }

    public void inOrder(){
        if(root!=null)
            root.inOrder();
        else {
            System.out.println("the bst is empty");
        }
    }

    public Node search (int value){
        if(root==null)
            return null;
        return root.search(value);
    }

    public Node searchParent (int value){
        if(root==null)
            return null;
        return root.searchParent(value);
    }

    /**
     *
     * @param node
     * @return
     */
    public int delRightTreeMin(Node node){
        Node temp = node;
        //
        while (temp.left!=null){
            temp = temp.left;
        }
        delNode(temp.getValue());
        return temp.getValue();
    }

    public void delNode (int value){
        if(root==null)
            return;
        Node targetNode = search(value);
        if(targetNode==null)
            return;
        //if the parent node of target node does not exist
        if(root.left==null && root.right==null) {
            root = null;
            return;
        }
        // find the parenet node of the target node
        Node parent = searchParent(value);
        if(targetNode.left==null && targetNode.right==null) {
            if (parent.left != null && parent.left.getValue() == value) {
                parent.left = null;
                return;
            } else if (parent.right != null && parent.right.getValue() == value) {
                parent.right = null;
                return;
            }
        } else if (targetNode.left!=null && targetNode.right!=null){
            int minValue = delRightTreeMin(targetNode.right);
            targetNode.setValue(minValue);
        } else {
             if(targetNode.left!=null){
                 if(parent==null)
                     root=targetNode.left;
                 else {
                     if (parent.left != null && parent.left.getValue() == value) {
                         parent.left = targetNode.left;
                     } else {
                         parent.right = targetNode.right;
                     }
                 }
             } else {
                 if(parent.right==null)
                     root=targetNode.right;
                 else {
                     if (parent.left != null && parent.left.getValue() == value) {
                         parent.left = targetNode.right;
                     } else {
                         parent.right = targetNode.right;
                     }
                 }
             }
        }
    }
}


class Node{
    private int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    // add a node
    // recurse to add, for BST
    public void add(Node newNode){
        if(newNode==null)
            return;

        if(newNode.value <this.value){
            if(this.left==null)
                this.left = newNode;
            else {
                this.left.add(newNode);
            }
        } else {// if value of the new node larger than value of the node
            if(this.right == null)
                this.right=newNode;
            else {
                this.right.add(newNode);
            }
        }
    }

    //
    public void inOrder(){
        if(this.left!=null)
            this.left.inOrder();
        System.out.println(this);
        if(this.right !=null)
            this.right.inOrder();
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public Node search(int value){
        if(this.value == value)
            return this;
        if(this.value >value){
            if(this.left==null)
                return null;
            return this.left.search(value);
        } else {
            if(this.right==null)
                return null;
            return this.right.search(value);
        }
    }

    /**
     * @param value value of the target node
     * @return parent node of the target node
     */
    public Node searchParent(int value){
         if((this.left!=null && this.left.value==value) ||
                 (this.right!=null && this.right.value==value)
         ) {
             return this;
         } else {
             if(value<this.value && this.left!=null){
                return this.left.searchParent(value);
             } else if(value >=this.value && this.right!=null){
                return this.right.searchParent(value);
             } else {
                 return null;
             }
         }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
