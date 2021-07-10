package com.guangya.data_structure_by_java.ScapeGoatTreeDemo.V3ScapeGoatTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class V3NewScapeGoatTree<E extends Comparable<E>> {

     V3ScapegoatTreeNode<E> root;
    private static final double ALPHA_MAX = 1;
    private static final double ALPHA_MIN = 0.5;
    private double alpha = 0.7;
    int creditGivenOut=0;
    int creditForRebuid = 0;
    int creditForNormalAdd = 0;

    private List<V3ScapegoatTreeNode<E>> insertPath = new ArrayList<>();

    public V3NewScapeGoatTree() {
    }

    public V3NewScapeGoatTree(V3ScapegoatTreeNode<E> root) {
        this.root = root;
    }

    public V3NewScapeGoatTree(double alpha) {
        if (alpha < 0.5) {
            alpha = 0.5;
        }
        if (alpha > 1) {
            alpha = 0.99;
        }
        this.alpha = alpha;
    }

    public void insert(E value) {
        V3ScapegoatTreeNode<E> tempNode = new V3ScapegoatTreeNode<>(value);
        if (root == null) {
            root = new V3ScapegoatTreeNode<>(value);
        } else {
            boolean successfullyInsertion = insertValue(root, tempNode, value);
            if (successfullyInsertion) {
                insertPath.forEach(node->node.size++);
                tryAdjust(value);
            }
            clearInsertPath();
        }
    }

    private boolean insertValue(V3ScapegoatTreeNode<E> parent, V3ScapegoatTreeNode<E> node, E value) {
        if (parent == null || node == null) {
            return false;
        }
        insertPath.add(parent);
        // since you checked the node, which is on the path, you give credit to this noe
        // and the credit given out ++

        int com = node.getValue().compareTo(parent.getValue());
        if (com < 0) {
            if (parent.getLeftChild() != null) {
                return insertValue(parent.getLeftChild(), node, value);
            } else {
                parent.setLeftChild(node);

                System.out.println("I have inserted: "+value);
                System.out.println("The current tree is :");
                BTreePrinter bTreePrinter = new BTreePrinter();
                System.out.println("=============================================");
                bTreePrinter.printNode(this.root);

                creditGivenOut++;
                creditForNormalAdd++;
                return true;
            }
        } else if (com > 0) {
            if (parent.getRightChild() != null) {
                return insertValue(parent.getRightChild(), node,value);
            } else {
                parent.setRightChild(node);

                System.out.println("I have inserted: "+value);
                System.out.println("The current tree is :");
                BTreePrinter bTreePrinter = new BTreePrinter();
                System.out.println("=============================================");
                bTreePrinter.printNode(this.root);

                creditGivenOut++;
                creditForNormalAdd++;

                return true;
            }
        }
        return false;
    }

    private void tryAdjust(E value) {
        for (int i = 0; i < insertPath.size(); i++) {
            V3ScapegoatTreeNode<E> node = insertPath.get(i);
            int leftChildNodeCount = Optional.ofNullable(node.getLeftChild())
                    .map(left -> left.size)
                    .orElse(0);
            if (leftChildNodeCount > (int)(node.size * alpha) || leftChildNodeCount < (int)(node.size * (1 - alpha))) {

                System.out.println("when inersting: "+value);
                System.out.println("The current tree is :");
                BTreePrinter bTreePrinter = new BTreePrinter();
                System.out.println("I am going to call rebuild");
                System.out.println("=============================================");
                bTreePrinter.printNode(this.root);

                rebuild(node, i == 0 ? null : insertPath.get(i - 1));

                return;
            }
        }
    }

    private void rebuild(V3ScapegoatTreeNode<E> root, V3ScapegoatTreeNode<E> parent) {
        List<E> elements = new ArrayList<>();
        inOrderTraversal(root, elements);

        V3ScapegoatTreeNode<E> newRoot = reBuildCore(elements,0, elements.size() - 1);
        if (parent == null) {
            this.root = newRoot;
        } else if (parent.getLeftChild() == root) {
            parent.setLeftChild(newRoot);
        } else {
            parent.setRightChild(newRoot);
        }
    }

    private void inOrderTraversal(V3ScapegoatTreeNode<E> root, List<E> elements) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.getLeftChild(), elements);
        elements.add(root.getValue());
        inOrderTraversal(root.getRightChild(), elements);
    }

    public V3ScapegoatTreeNode<E> reBuildCore(List<E> elements, int start, int end) {
        // every time, you run rebuild core, you need to check the node
        // and give out credit

        if (start > end) {
            creditForRebuid++;
            return null;
        }
        int middle = (int)Math.ceil((start + end) / 2.0);
        if (middle >= elements.size()) {
            creditForRebuid++;
            return null;
        }

        V3ScapegoatTreeNode<E> root = new V3ScapegoatTreeNode<>(elements.get(middle));
        root.size = end - start + 1;
        root.setLeftChild(reBuildCore(elements, start, middle - 1));
        root.setRightChild(reBuildCore(elements, middle + 1, end));
        creditForRebuid++;
        return root;
    }

    private void clearInsertPath() {
        insertPath.clear();
    }
}


