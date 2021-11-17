package com.data_structure_by_java.WoodyTest;

import java.util.Stack;

public class SLinkedList {
    public static void main(String[] args) {

        SLinkedList sLinkedList = new SLinkedList();

        for (int i = 0; i < 10; i++) {
            sLinkedList.add(i);
        }

        System.out.println(sLinkedList);

//        sLinkedList.reverse();
//        sLinkedList.reserve4();
//        sLinkedList.reverse2();

        sLinkedList.reserve3();

        System.out.println(sLinkedList);

    }


    SLNode head;
    int size;


    //define constructor
    public SLinkedList(){
        this.head = null;
        this.size = 0;
    }



    public void reserve3 (){

        // use a stack to reverse print
        // running time is O(2n)
        Stack<SLNode> stack = new Stack<>();
        SLNode temp = this.head;
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        this.head = stack.pop();
        temp = this.head;
        while(!stack.isEmpty()){
            temp.next = stack.pop();
            temp = temp.next;
        }
    }

    public void reverse2 (){

        SLNode cur = head.next, next;
        head.next = null;
        while( cur != null){
            next = cur.next;
            cur.next = head;
            head = cur;
            cur = next;
        }
    }

    public void reverse (){
        SLNode cur = this.head;
        SLNode prev = null, next;
        while (cur != null){ // to the very end, over the tail node
            next = cur.next;  // store the next node, temporary storage for step 4 usage
            cur.next = prev;  // switch the pointer
            prev = cur;      //  pre move forward
            cur = next;      // cur move forward, take the node from step 1
        }
        this.head = prev;
    }


    public void add( int e){
        if(size == 0) {
            this.head = new SLNode(e);
            size++;
            return;
        }
        SLNode temp = head;
        while(true){

            if(temp.next == null) {
                temp.next = new SLNode(e);
                break;
            }
            temp = temp.next;
        }
        size++;
    }




    private class SLNode {
        int data;
        SLNode next;

        public SLNode(int e){
            this.data = e;
            this.next = null;
        }

    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("linkedin list-->{");
        SLNode temp = head;
        for (int i = 0; i < size; i++) {
            res.append(temp.data);
            if(i != size-1)
                res.append(",");
            temp = temp.next;
        }

        res.append("}");
        return res.toString();
    }
}
