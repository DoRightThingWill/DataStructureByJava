package com.guangya.data_structure_by_java;

import com.guangya.data_structure_by_java.Array.IntArray;
import com.guangya.data_structure_by_java.Array.TypeArray;
import com.guangya.data_structure_by_java.ArrayQueue.ArrayQueue;
import com.guangya.data_structure_by_java.ArrayQueue.LoopQueue;
import com.guangya.data_structure_by_java.Stack.ArrayStack;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code hereR
//        runTypeArray();
//        runArrayStack();
//        System.out.println(bracketMatch("([{}])"));
//        System.out.println(bracketMatch("([{)])"));
//        runArrayQueue();
        runLoopQueue();
    }

    public static void runIntArray (){
        int capacity = 20;
        IntArray arr = new IntArray(capacity);
        for(int i=0; i<10; i++ )
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1,100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr.toString());

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);
    }

    public static void runTypeArray (){
//        int capacity = 10;
        TypeArray<Integer> arr = new TypeArray<>();
        for(int i=0; i<10; i++ )
            arr.addLast(i);
        System.out.println(arr);

        arr.addFirst(4);
        System.out.println(arr);

        arr.remove(1);
        arr.remove(1);
        arr.remove(1);
        System.out.println(arr);
    }

    public static void runArrayStack (){
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }

    public static boolean bracketMatch (String s){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c=='[' || c=='{')
                stack.push(c);
            else {
                if(stack.isEmpty())
                    return false;
                char topChar = stack.pop();
                if(topChar=='(' && c != ')')
                    return false;
                if(topChar =='[' && c != ']')
                    return false;
                if(topChar == '{' && c != '}')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void runArrayQueue(){
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if(i%3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    public static void runLoopQueue(){
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if(i%3 ==0)
                queue.dequeue();
            System.out.println(queue);
        }
    }
}

