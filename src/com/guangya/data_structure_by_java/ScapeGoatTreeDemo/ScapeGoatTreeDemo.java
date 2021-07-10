package com.guangya.data_structure_by_java.ScapeGoatTreeDemo;

public class ScapeGoatTreeDemo {
    public static void main(String[] args) {
        Integer[] arr = {7,3,10,12,5,1,9,2};
        ScapeGoatTree scapeGoatTree = new ScapeGoatTree();
        for(Integer i=0;i<arr.length;i++){
            scapeGoatTree.add(new ScapeNode(arr[i]));
        }

        scapeGoatTree.inOrder();


    }
}



class ScapeGoatTree {
    private ScapeNode root;
    
    public ScapeNode getRoot(){
        return this.root;
    }

    // add node
    public void add(ScapeNode newNode){
        if(root==null)
            root=newNode;
        else {
            root.add(newNode);
        }
    }

    public void inOrder(){
        if(root!=null)
            root.inOrder();
        else {
            System.out.println("the bst is empty");
        }
    }

    public ScapeNode search (Integer value){
        if(root==null)
            return null;
        return root.search(value);
    }

    public ScapeNode searchParent (Integer value){
        if(root==null)
            return null;
        return root.searchParent(value);
    }

    /**
     *
     * @param node
     * @return
     */
    public Integer delRightTreeMin(ScapeNode node){
        ScapeNode temp = node;
        //
        while (temp.left!=null){
            temp = temp.left;
        }
        delNode(temp.getValue());
        return temp.getValue();
    }

    public void delNode (Integer value){
        if(root==null)
            return;
        ScapeNode targetNode = search(value);
        if(targetNode==null)
            return;
        //if the parent node of target node does not exist
        if(root.left==null && root.right==null) {
            root = null;
            return;
        }
        // find the parenet node of the target node
        ScapeNode parent = searchParent(value);
        if(targetNode.left==null && targetNode.right==null) {
            if (parent.left != null && parent.left.getValue() == value) {
                parent.left = null;
                return;
            } else if (parent.right != null && parent.right.getValue() == value) {
                parent.right = null;
                return;
            }
        } else if (targetNode.left!=null && targetNode.right!=null){
            Integer minValue = delRightTreeMin(targetNode.right);
            targetNode.setValue(minValue);
        } else {
             if(targetNode.left!=null){
                 if(parent==null)
                     root=targetNode.left;
                 else {
                     if (parent.left != null && parent.left.getValue() == value) {
                         parent.left = targetNode.left;
                     } else {
                         parent.right = targetNode.right;
                     }
                 }
             } else {
                 if(parent.right==null)
                     root=targetNode.right;
                 else {
                     if (parent.left != null && parent.left.getValue() == value) {
                         parent.left = targetNode.right;
                     } else {
                         parent.right = targetNode.right;
                     }
                 }
             }
        }
    }


}




