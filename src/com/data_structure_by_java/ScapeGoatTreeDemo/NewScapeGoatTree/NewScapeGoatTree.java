package com.data_structure_by_java.ScapeGoatTreeDemo.NewScapeGoatTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NewScapeGoatTree<E extends Comparable<E>> {

    private ScapegoatTreeNode<E> root;
    private static final double ALPHA_MAX = 1;
    private static final double ALPHA_MIN = 0.5;
    private double alpha = 0.7;

    private List<ScapegoatTreeNode<E>> insertPath = new ArrayList<>();

    public NewScapeGoatTree() {
    }

    public NewScapeGoatTree(double alpha) {
        if (alpha < 0.5) {
            alpha = 0.5;
        }
        if (alpha > 1) {
            alpha = 0.99;
        }
        this.alpha = alpha;
    }

    public void insert(E value) {
        ScapegoatTreeNode<E> tempNode = new ScapegoatTreeNode<>(value);
        if (root == null) {
            root = new ScapegoatTreeNode<>(value);
        } else {
            boolean successfullyInsertion = insertValue(root, tempNode);
            if (successfullyInsertion) {
                insertPath.forEach(node->node.size++);
                tryAdjust();
            }
            clearInsertPath();
        }
    }

    private boolean insertValue(ScapegoatTreeNode<E> parent, ScapegoatTreeNode<E> node) {
        if (parent == null || node == null) {
            return false;
        }
        insertPath.add(parent);
        int com = node.getValue().compareTo(parent.getValue());
        if (com < 0) {
            if (parent.getLeftChild() != null) {
                return insertValue(parent.getLeftChild(), node);
            } else {
                parent.setLeftChild(node);
                return true;
            }
        } else if (com > 0) {
            if (parent.getRightChild() != null) {
                return insertValue(parent.getRightChild(), node);
            } else {
                parent.setRightChild(node);
                return true;
            }
        }
        return false;
    }

    private void tryAdjust() {
        for (int i = 0; i < insertPath.size(); i++) {
            ScapegoatTreeNode<E> node = insertPath.get(i);
            int leftChildNodeCount = Optional.ofNullable(node.getLeftChild())
                    .map(left -> left.size)
                    .orElse(0);
            if (leftChildNodeCount > (int)(node.size * alpha) || leftChildNodeCount < (int)(node.size * (1 - alpha))) {
                rebuild(node, i == 0 ? null : insertPath.get(i - 1));
                return;
            }
        }
    }

    private void rebuild(ScapegoatTreeNode<E> root, ScapegoatTreeNode<E> parent) {
        List<E> elements = new ArrayList<>();
        inOrderTraversal(root, elements);

        ScapegoatTreeNode<E> newRoot = reBuildCore(elements,0, elements.size() - 1);
        if (parent == null) {
            this.root = newRoot;
        } else if (parent.getLeftChild() == root) {
            parent.setLeftChild(newRoot);
        } else {
            parent.setRightChild(newRoot);
        }
    }

    private void inOrderTraversal(ScapegoatTreeNode<E> root, List<E> elements) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.getLeftChild(), elements);
        elements.add(root.getValue());
        inOrderTraversal(root.getRightChild(), elements);
    }

    private ScapegoatTreeNode<E> reBuildCore(List<E> elements, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = (int)Math.ceil((start + end) / 2.0);
        if (middle >= elements.size()) {
            return null;
        }

        ScapegoatTreeNode<E> root = new ScapegoatTreeNode<>(elements.get(middle));
        root.size = end - start + 1;
        root.setLeftChild(reBuildCore(elements, start, middle - 1));
        root.setRightChild(reBuildCore(elements, middle + 1, end));
        return root;
    }

    private void clearInsertPath() {
        insertPath.clear();
    }
}

class ScapegoatTreeNode<E> {
    // 以此节点为根的子树的总节点个数
    int size = 1;
    private E value;
    private ScapegoatTreeNode<E> leftChild;
    private ScapegoatTreeNode<E> rightChild;
    ScapegoatTreeNode(E value) {
        this.value = value;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public ScapegoatTreeNode<E> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(ScapegoatTreeNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    public ScapegoatTreeNode<E> getRightChild() {
        return rightChild;
    }

    public void setRightChild(ScapegoatTreeNode<E> rightChild) {
        this.rightChild = rightChild;
    }
}
