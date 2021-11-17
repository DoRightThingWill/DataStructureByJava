package com.data_structure_by_java.ScapeGoatTreeDemo;

public class ScapeNode {
    int value;
    ScapeNode left;
    ScapeNode right;

    public ScapeNode(Integer value) {
        this.value = value;
    }

    // add a node
    // recurse to add, for BST
    public void add(ScapeNode newNode){
        if(newNode==null)
            return;

        if(newNode.value<this.value){
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

    public ScapeNode search(Integer value){
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
    public ScapeNode searchParent(Integer value){
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

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}