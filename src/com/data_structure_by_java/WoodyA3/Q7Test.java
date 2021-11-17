package com.data_structure_by_java.WoodyA3;

import java.util.Random;

public class Q7Test<E> {

    public static void main(String[] args) {
        MeldableHeap<Integer> meldableHeap = new MeldableHeap<Integer>();
        V4BTPrinter v4BTPrinter = new V4BTPrinter();
        Random random = new Random();
        for (int i =0; i<8; i++){
            meldableHeap.add(random.nextInt(50));
            System.out.println("********************Adding element to heap**************");
            v4BTPrinter.printNode(meldableHeap.getRoot());
        }
        System.out.println("********************Adding element to heap**************");
        meldableHeap.add(80);
        meldableHeap.add(60);
        meldableHeap.add(50);
        v4BTPrinter.printNode(meldableHeap.getRoot());

        System.out.println("******************** after Remove()  **************");
        meldableHeap.remove();
        v4BTPrinter.printNode(meldableHeap.getRoot());
        System.out.println("******************** after Remove()  **************");
        meldableHeap.remove();
        v4BTPrinter.printNode(meldableHeap.getRoot());
        System.out.println("******************** after Remove()  **************");
        meldableHeap.remove();
        v4BTPrinter.printNode(meldableHeap.getRoot());

        System.out.println("******************** after Remove(80)  **************");
        meldableHeap.remove(80);
        v4BTPrinter.printNode(meldableHeap.getRoot());
        System.out.println("******************** after Remove(50)  **************");
        meldableHeap.remove(50);
        v4BTPrinter.printNode(meldableHeap.getRoot());
        System.out.println("******************** after Remove(60)  **************");
        meldableHeap.remove(60);
        v4BTPrinter.printNode(meldableHeap.getRoot());
    }



}
