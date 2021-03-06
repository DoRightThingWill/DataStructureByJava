package com.data_structure_by_java.LinkedList;

public class LinkedList<T> {

    private class Node{
        public T e;
        public Node next;

        // constructor
        public Node (T e, Node next){
            this.e = e;
            this.next = next;
        }
        public Node (T e){
            this(e, null);
        }
        public Node (){
            this(null,null);
        }
        @Override
        public String toString(){
            return e.toString();
        }

    }
}
