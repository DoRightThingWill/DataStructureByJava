package com.data_structure_by_java.LinkedList;

public class DoublyLinkedListThree {

    public DoublyLinkedListThree next;
    public int value;



    public DoublyLinkedListThree prev;

    public DoublyLinkedListThree(int value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    public DoublyLinkedListThree reverseDoublyList (){
        DoublyLinkedListThree prev = null;
         DoublyLinkedListThree next = null;
         DoublyLinkedListThree curr = this;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
