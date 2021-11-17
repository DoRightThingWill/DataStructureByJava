package com.data_structure_by_java.BinaryTreeDemo;

public class BinaryTreeDemo {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "jiang song");
        HeroNode node2 = new HeroNode(2, "wu yong");
        HeroNode node3 = new HeroNode(3, "lu jun yi");
        HeroNode node4 = new HeroNode(4, "chong lin");
        HeroNode node5 = new HeroNode(5, "sheng guan");

        binaryTree.setRoot(root);

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

//        // test
//        System.out.println("Pre order search");
//        binaryTree.preOrder();
//        System.out.println("In order search");
//        binaryTree.inOrder();
//        System.out.println("Post order search");
//        binaryTree.postOrder();


        // search
//        // figure out how many times for searching
//        System.out.println("pre order search");
//        HeroNode resNode = binaryTree.preOrderSearch(5);
//        if(resNode!=null)
//            System.out.printf("Found, no=%d name=%s",resNode.getNo(),resNode.getName());
//        else
//            System.out.println("No"+5+" node was not found in the tree");

//
//        // figure out how many times for searching
//        System.out.println("pre order search");
//        HeroNode resNode = binaryTree.inOrderSearch(5);
//        if(resNode!=null)
//            System.out.printf("Found, no=%d name=%s",resNode.getNo(),resNode.getName());
//        else
//            System.out.println("No"+5+" node was not found in the tree");

//
//        // figure out how many times for searching
//        System.out.println("pre order search");
//        HeroNode resNode = binaryTree.postOrderSearch(5);
//        if(resNode!=null)
//            System.out.printf("Found, no=%d name=%s",resNode.getNo(),resNode.getName());
//        else
//            System.out.println("No"+5+" node was not found in the tree");


        System.out.println("before delete, pre order search");
        binaryTree.preOrder();
        System.out.println("after delete, pre order search");
        binaryTree.deleteNode(3);
        binaryTree.preOrder();



    }
}

// define a binary tree
class BinaryTree {
    private HeroNode root;

    public BinaryTree() {
    }

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    public void preOrder(){
        if(root !=null)
            root.preOrder();
        else {
            System.out.println(" BT is empty. No preOrder search available");
        }
    }

    public void inOrder(){
        if(root !=null)
            root.inOrder();
        else {
            System.out.println(" BT is empty. No inOrder search available");
        }
    }

    public void postOrder(){
        if(root !=null)
            root.postOrder();
        else {
            System.out.println(" BT is empty. No postOrder search available");
        }
    }

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public HeroNode preOrderSearch (int no){
        if(root!=null)
            return  root.preOrderSearch(no);
        else
            return null;
    }

    public HeroNode inOrderSearch (int no){
        if(root!=null)
            return  root.inOrderSearch(no);
        else
            return null;
    }

    public HeroNode postOrderSearch (int no){
        if(root!=null)
            return  root.postOrderSearch(no);
        else
            return null;
    }

    public void deleteNode (int no){
        if(root!=null) {
            if (root.getNo() == no)
                root = null;
            else {
                root.deleteNode(no);
            }
        } else{
            System.out.println("Tree is empty, can not delete");
        }

    }

}


// create hero node
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    // define the constructor
    // left and right node are null by default in initiation
    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    // pre-order traverse
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null)
            this.left.preOrder();
        if(this.right!=null)
            this.right.preOrder();
    }

    // in-order traverse
    public void inOrder(){
        if(this.left!=null)
            this.left.inOrder();
        System.out.println(this);
        if(this.right!=null)
            this.right.inOrder();
    }

    // post-order traverse
    public void postOrder(){
        if(this.left!=null)
            this.left.postOrder();
        if(this.right!=null)
            this.right.postOrder();
        System.out.println(this);
    }

    // pre-order search
    /**
     * @param no hero number
     * @return if yes and found, return node; if not found, return null
     */

    public HeroNode preOrderSearch(int no){
        System.out.println("preOrderSearch run");
        // check the current node,
        if(this.no==no)
            return this;
        // check if the left child is null; if not, recurse pre-order search
        // if the left recurse found the node, return the node
        HeroNode resNode = null;
        if(this.left!=null)
            resNode = this.left.preOrderSearch(no);
        if(resNode !=null)
            return resNode;
        if(this.right!=null)
            resNode = this.right.preOrderSearch(no);
        return resNode;
    }

    public HeroNode inOrderSearch(int no){
        // check the current node
        HeroNode resNode = null;
        if(this.left!=null)
            resNode = this.left.inOrderSearch(no);
        if(resNode !=null)
            return resNode;
        System.out.println("In order search run");
        if(this.no==no)
            return this;
        if(this.right!=null)
            resNode = this.right.inOrderSearch(no);
        return resNode;
    }

    public HeroNode postOrderSearch(int no){
        // check the current node
        HeroNode resNode = null;
        if(this.left!=null)
            resNode = this.left.postOrderSearch(no);
        if(resNode !=null)
            return resNode;
        if(this.right!=null)
            resNode = this.right.postOrderSearch(no);
        if(resNode !=null)
            return resNode;
        System.out.println("Post order search run");
        if(this.no==no)
            return this;
        return resNode;
    }

    public void deleteNode(int no){
        if(this.left!=null && this.left.getNo()==no) {
            this.left = null;
            return;
        }

        if(this.right!=null && this.right.getNo()==no) {
            this.right = null;
            return;
        }

        if(this.left!=null)
            this.left.deleteNode(no);

        if(this.right!=null)
            this.right.deleteNode(no);
    }


}