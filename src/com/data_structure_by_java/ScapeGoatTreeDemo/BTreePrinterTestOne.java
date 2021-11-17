package com.data_structure_by_java.ScapeGoatTreeDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BTreePrinterTestOne {

    private static ScapeNode test1() {
        ScapeNode root = new ScapeNode(2);
        ScapeNode n11 = new ScapeNode(7);
        ScapeNode n12 = new ScapeNode(5);
        ScapeNode n21 = new ScapeNode(2);
        ScapeNode n22 = new ScapeNode(6);
        ScapeNode n23 = new ScapeNode(3);
        ScapeNode n24 = new ScapeNode(6);
        ScapeNode n31 = new ScapeNode(5);
        ScapeNode n32 = new ScapeNode(8);
        ScapeNode n33 = new ScapeNode(4);
        ScapeNode n34 = new ScapeNode(5);
        ScapeNode n35 = new ScapeNode(8);
        ScapeNode n36 = new ScapeNode(4);
        ScapeNode n37 = new ScapeNode(5);
        ScapeNode n38 = new ScapeNode(8);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;
        n12.left = n23;
        n12.right = n24;

        n21.left = n31;
        n21.right = n32;
        n22.left = n33;
        n22.right = n34;
        n23.left = n35;
        n23.right = n36;
        n24.left = n37;
        n24.right = n38;

        return root;
    }

    private static ScapeNode test2() {
        ScapeNode root = new ScapeNode(2);
        ScapeNode n11 = new ScapeNode(7);
        ScapeNode n12 = new ScapeNode(5);
        ScapeNode n21 = new ScapeNode(2);
        ScapeNode n22 = new ScapeNode(6);
        ScapeNode n23 = new ScapeNode(9);
        ScapeNode n31 = new ScapeNode(5);
        ScapeNode n32 = new ScapeNode(8);
        ScapeNode n33 = new ScapeNode(4);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;

        n12.right = n23;
        n22.left = n31;
        n22.right = n32;

        n23.left = n33;

        return root;
    }  
    
    private static ScapeNode test3() {

        Integer[] arr = {1,5,2,43};
        ScapeGoatTree scapeGoatTree = new ScapeGoatTree();
        for(Integer i=0;i<arr.length;i++){
            scapeGoatTree.add(new ScapeNode(arr[i]));
        }

//        scapeGoatTree.inOrder();

        return scapeGoatTree.getRoot();
    }



    public static void main(String[] args) {

//        BTreePrinter.printNode(test1());
//        BTreePrinter.printNode(test2());
        BTreePrinterOne.printNode(test3());

    }
}



class BTreePrinterOne {

    public static void printNode(ScapeNode root) {
        int maxLevel = BTreePrinterOne.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<ScapeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinterOne.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinterOne.printWhitespaces(firstSpaces);

        List<ScapeNode> newNodes = new ArrayList<ScapeNode>();
        for (ScapeNode node : nodes) {
            if (node != null) {
                System.out.print(node.value);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinterOne.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinterOne.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinterOne.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinterOne.printWhitespaces(1);

                BTreePrinterOne.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinterOne.printWhitespaces(1);

                BTreePrinterOne.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(ScapeNode node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinterOne.maxLevel(node.left), BTreePrinterOne.maxLevel(node.right)) + 1;
    }

    private static  boolean isAllElementsNull(List list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}