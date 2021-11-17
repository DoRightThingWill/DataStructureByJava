package com.data_structure_by_java.LinkedList;

public class SinglyLinkedListDemo {


    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1,"jiang song", "ji shi yu");
        HeroNode node4 = new HeroNode(4,"lin chong", "bao zi tou");
        HeroNode node2 = new HeroNode(2,"junyi lu", "yu qi lin");
        HeroNode node3 = new HeroNode(3,"yong wu", "zhi duo xing");


        SingleLinkedList singlylinkedlist = new SingleLinkedList();
//        singlylinkedlist.addLast(node4);
//        singlylinkedlist.addLast(node1);
//        singlylinkedlist.addLast(node2);
//        singlylinkedlist.addLast(node3);
//        singlylinkedlist.list();

        singlylinkedlist.addByOrder(node4);
        singlylinkedlist.addByOrder(node3);
        singlylinkedlist.addByOrder(node1);
        singlylinkedlist.addByOrder(node2);
        singlylinkedlist.list();
        System.out.println("_______________");

        HeroNode node3_3 = new HeroNode(3,"lu zhi shen", "hua he shang");
        System.out.println(singlylinkedlist.update(node3_3));
        singlylinkedlist.list();
        System.out.println("_______________");

        singlylinkedlist.delete(node3_3);
        singlylinkedlist.list();
        System.out.println("_______________");

    }

}


//define a singlelinkedlist to manage all heros
class SingleLinkedList{
    // initiate the head node, which does not move and has no data;
    private HeroNode head = new HeroNode(0,"","");

    // add an node to the singly linked list
    // this is not sorted linked list
    // add the node to the end of the linked list
    public void addLast(HeroNode heroNode){
        HeroNode tem = head;
        while (true){
            if(tem.next==null) {
                tem.next = heroNode;
                heroNode.next = null;
                break;
            }
            tem = tem.next;
        }
    }

    /**
     *
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode){
        HeroNode tem1 = head;
        boolean orderExist = false;

        // linked list is asec order,
        // mathematically, you need to find the last node which is smaller than heronode.
        while (true){

            if(tem1.next == null){// mean the list is empty or loop to the end now
                break;
            }
            if(tem1.next.getNo() > heroNode.getNo()){// means, tem1 is the last one smaller than heronode. next one is bigger
                break;
            }
            if(tem1.getNo()==heroNode.getNo()){
                System.out.println("order exists, add by order failed");
                break;
            }
            tem1 = tem1.next;
        }

        heroNode.next = tem1.next;
        tem1.next = heroNode;

//        if(tem1.next==null) {
//            head.next = heroNode;
//            heroNode.next = null;
//            System.out.printf("this to  insert the first element\n");
//        } else {
//            HeroNode tem2 = tem1.next;
//            while (true){
////                System.out.println(tem1);
////                System.out.println(tem2);
//                if(tem2.getNo() == heroNode.getNo()){
//                    System.out.println("the order of this node "+heroNode+ "are equal  to "+tem2+", add by order failed");
//                    break;
//                }
////                if(tem2.getNo() > heroNode.getNo()) {
////                    heroNode.next = tem2;
////                    tem1.next = heroNode;
////                    break;
////                }
//
//                if(tem1.next.getNo() > heroNode.getNo()){
//                    heroNode.next = tem1.next;
//                    tem1.next = heroNode;
//                    break;
//                }
////                if(tem2.next==null)
////                    break;
//                tem1 = tem1.next;
////                tem2 = tem2.next;
//            }
//        }

    }

    public Boolean update(HeroNode heroNode){
        HeroNode tem = head;
        boolean updateGood = false;
        while (true){
            if(tem.getNo() == heroNode.getNo()) {
//                heroNode.next = tem.next;
//                tem = heroNode; // this will not work, you only change the reference, rather than the value
                tem.setName(heroNode.getName());
                tem.setNickname(heroNode.getNickname());
                System.out.println(tem);
                updateGood = true;
                break;
            }
            if(tem.next == null)
                break;
            tem =  tem.next;
        }
        return updateGood;
    }


    public void delete (HeroNode heroNode){
        // since it is a singly list, you need to find the pre-element;
        HeroNode tem = head;
        boolean deleteGood =  false;
        while (true){
            if(tem.next.getNo() == heroNode.getNo()){
                tem.next = tem.next.next;
                deleteGood = true;
                break;
            }
            tem = tem.next;
        }
        if(deleteGood){
            System.out.println("delete succeeds");
        } else {
            System.out.println("Delete failed");
        }
    }
    public void list(){
        if (head.next == null) {
            System.out.printf("Linked list is empty");
            return;
        }
        HeroNode tem = head.next;
        while (true){
            if(tem == null)
                break;
            System.out.println(tem);
            tem =  tem.next;
        }
    }

}


// is this an inner class?
class HeroNode {
    private int no;
    private String name;
    private String nickname;
    public HeroNode next;

    // constructor
    public HeroNode(int no, String name, String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    public int getNo(){
        return this.no;
    }

    // to print the ode out
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public HeroNode getNext() {
        return next;
    }
}
