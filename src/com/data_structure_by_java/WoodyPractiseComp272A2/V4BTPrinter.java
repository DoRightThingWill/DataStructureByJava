package com.data_structure_by_java.WoodyPractiseComp272A2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class V4BTPrinter {

    public static <T extends Comparable<T>> void printNode(BinaryTNode<T> root) {
        int maxLevel = V4BTPrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<T>> void printNodeInternal(List<BinaryTNode<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || V4BTPrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        V4BTPrinter.printWhitespaces(firstSpaces);

        List<BinaryTNode<T>> newNodes = new ArrayList<BinaryTNode<T>>();
        for (BinaryTNode<T> node : nodes) {
            if (node != null) {
                System.out.print(node.value);
                newNodes.add(node.leftChild);
                newNodes.add(node.rightChild);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            V4BTPrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                V4BTPrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    V4BTPrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).leftChild != null)
                    System.out.print("/");
                else
                    V4BTPrinter.printWhitespaces(1);

                V4BTPrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).rightChild != null)
                    System.out.print("\\");
                else
                    V4BTPrinter.printWhitespaces(1);

                V4BTPrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<T>> int maxLevel(BinaryTNode<T> node) {
        if (node == null)
            return 0;
//        System.out.println(" the max level is " + Math.max(V4BTPrinter.maxLevel(node.leftChild), V4BTPrinter.maxLevel(node.rightChild)) + 1);
        return Math.max(V4BTPrinter.maxLevel(node.leftChild), V4BTPrinter.maxLevel(node.rightChild)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}
