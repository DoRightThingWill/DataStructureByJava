package com.data_structure_by_java.ThreadedBinaryTreeDemo;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {


        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();


        // test node5
        HeroNode node5Lfet = node5.getLeft();
        HeroNode node5Right = node5.getRight();
        System.out.println("10 node de left"+node5Lfet);
        System.out.println("10 node de right"+node5Right);


        System.out.println(" pre order threaded tree");
        threadedBinaryTree.threadedList();
    }
}

//

class ThreadedBinaryTree {
    private HeroNode root;

    // for threading process, define a pointeer
    // pre is always the previous node
    private HeroNode pre = null;

    public ThreadedBinaryTree() {

    }

    public void threadedNodes(){
        threadedNodes(root);
    }

    public void threadedList(){
        // define a mover
        HeroNode node = root;
        while(node !=null){
            // find the left type =1,
            // first threaded node
            while(node.getLeftType() ==0){
                node = node.getLeft();
            }
            System.out.println(node);

            while (node.getRightType()==1){
                // get the next node
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }

    // difine the inorder threaded tree
    public void threadedNodes (HeroNode node){
        // node is null
        if(node == null)
            return;
        //1, threaded left subtree
        threadedNodes(node.getLeft());
        //2, threaded current node;
        //
        //
        if(node.getLeft()==null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //
        if(pre!=null && pre.getRight()==null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre=node;

        //3, threaded right subtree
        threadedNodes(node.getRight());



    }




    public ThreadedBinaryTree(HeroNode root) {
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

    //notes:
    //1. if leftType =0, points to left child; if lefttype =1, points to prev;
    //2, if righttype =0, points to right child; if righttype=1, points to the next;
    private int leftType;
    private int rightType;

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

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
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