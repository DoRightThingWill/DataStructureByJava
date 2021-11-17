package com.data_structure_by_java.LinkedList;

public class DoublyLinkedListDemo {

    public static void main(String[] args) {

        DoubleNode node1 = new DoubleNode(1, "aaa", "she");
        DoubleNode node2 = new DoubleNode(2, "bbb", "she");
        DoubleNode node3 = new DoubleNode(3, "ccc", "she");
        DoubleNode node4 = new DoubleNode(4, "ddd", "she");
        DoubleNode node5 = new DoubleNode(5, "eee", "she");
        DoubleNode node6 = new DoubleNode(6, "eee", "she");
        DoubleNode node3_3 = new DoubleNode(3, "ccc-33", "she");

        DoublyLinkedList dllist = new DoublyLinkedList();



        //insert an item
        dllist.insertByOrder(node5);
        dllist.insertByOrder(node3);
        dllist.insertByOrder(node2);
        dllist.insertByOrder(node4);
        dllist.insertByOrder(node1);

        //print all item
        dllist.printAll();
        System.out.println("==============");
        //update
        dllist.update(node3_3);
        dllist.printAll();
        System.out.println("==============");
        //delete an item
        dllist.delete(node3);
        dllist.printAll();
        System.out.println("==============");
        dllist.delete(node6);
        dllist.delete(node1);
        dllist.delete(node5);
        dllist.printAll();
        System.out.println("==============");
        //update an item
        dllist.update(node3_3);
        dllist.printAll();
        System.out.println("==============");
        //get an item
        // get the size
        System.out.println(dllist.getSize());
    }
}

class DoublyLinkedList {
    private int size;
    private DoubleNode head;
    //constructor?
    public DoublyLinkedList (){
        this.size = 0;
        head = new DoubleNode(-1,"","");
        head.nex =null;
    }

    //methods

    //add-insert
    public void insertByOrder(DoubleNode doubleNode){
        //find the last node
        DoubleNode temp =  head;
        boolean insertGood = true;
        while(true){
            if(temp.getRank() == doubleNode.getRank()) {
                insertGood = false;
                break;
            }
            if(temp.nex ==null)
                break;
            if(temp.nex.getRank() > doubleNode.getRank()) {
                break;
            }
            temp= temp.nex;
        }
        if(insertGood) {
            doubleNode.nex = temp.nex;
            temp.nex = doubleNode;
            size++;
        }

    }
    //delete

    public void delete (DoubleNode doubleNode){
        DoubleNode temp = head;
        boolean deleteGood = false;
        while (true){
            if(temp.nex==null)
                break;
            if(temp.nex.getRank() == doubleNode.getRank()){
                deleteGood = true;
                temp.nex = temp.nex.nex;
                break;
            }
            temp = temp.nex;
        }
        if(deleteGood){
            size--;
            System.out.println("Delete Succeed");
        } else {
            System.out.println("Delete failed. Node not found.");
        }
    }
    //update
    public void update(DoubleNode doubleNode){
        DoubleNode temp = head;
        boolean updateGood = false;
        while (true){
            if(temp.nex==null)
                break;
            if(temp.getRank()==doubleNode.getRank()) {
                temp.setPlayerName(doubleNode.getPlayerName());
                temp.setTeamName(doubleNode.getTeamName());
                updateGood = true;
                break;
            }
            temp = temp.nex;
        }
        if(updateGood){
            System.out.println("Update succeed");
        } else{
            System.out.println("Update failed. Node not found");
        }
    }
    //get size
    public int getSize(){
        return size;
    }
    //print
    public void printAll (){
        DoubleNode tem = head;
        while (true){
            if(tem.nex ==null) {
                System.out.println("Print Finished");
                break;
            }
            System.out.println(tem.nex);
            tem = tem.nex;
        }
    }


}

class DoubleNode {
    //instance fields
    private int rank;
    private String playerName;
    private String teamName;

    public DoubleNode pre;
    public DoubleNode nex;

    //constructor
    public DoubleNode(int rank, String playerName, String teamName){
        this.rank = rank;
        this.playerName = playerName;
        this.teamName = teamName;
    }

    //instance methods
    public void setRank(int rank){
        this.rank = rank;
    }
    public int getRank (){
        return rank;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


    @Override
    public String toString(){
        return "DoubleNode : [" +
                "rank :" + rank+
                ", playerName : "+playerName+
                ", teamName : "+teamName
                +"]";
    }
}
