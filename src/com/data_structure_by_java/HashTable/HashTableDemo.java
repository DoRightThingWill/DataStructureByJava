package com.data_structure_by_java.HashTable;

import java.util.Scanner;

public class HashTableDemo {

    public static void main(String[] args) {
        // initiate a hash table
        HashTable hashTable = new HashTable(7);

        // create a menu
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add: add emp");
            System.out.println("list: list out all emp");
            System.out.println("exit: exit from current operation");
            System.out.println("find: find employee by id");
            System.out.println();

            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("enter the id");
                    int id = scanner.nextInt();
                    System.out.println("enter the name");
                    String name = scanner.next();
                    Emp emp = new Emp(id,name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("please enter the employee id");
                    int searchId = scanner.nextInt();
                    hashTable.findEmpById(searchId);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }

    }
}

// define the hashtable
class HashTable{
    private EmpLinkedList[] empLinkedListArr;
    private int size;

    //define the constructor
    public HashTable(int size){
        // initiate the empLinkedListArr
        empLinkedListArr = new EmpLinkedList[size];
        this.size = size;
        // do not forget, initiate all linked list
        for (int i=0; i<size ; i++)
            empLinkedListArr[i]=new EmpLinkedList();
    }

    public void add (Emp emp){
        // find which linked list to add the employee by a hash number
        int empLinkedListNo = hashFun(emp.id);
        // add the employee to the linked list
        empLinkedListArr[empLinkedListNo].add(emp);
    }

    public void list(){
        for (int i=0;i<size; i++){
            empLinkedListArr[i].list(i+1);
        }
    }

    // search employee bye their id
    // if found the employee, return employee, otherwise return null
    public void findEmpById(int id){
        int linkedListNo = hashFun(id);
        Emp emp = empLinkedListArr[linkedListNo].findEmpByID(id);
        if (emp != null){
            System.out.printf("in the # %d linked list, emp id=%d\n",(linkedListNo+1),id);
        } else {
            System.out.println(" can not find the employee in the hash table");
        }
    }

    public int hashFun (int id){
        return id % size;
    }

}


// define the employee class
class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp (int id, String name){
        this.id = id;
        this.name = name;
        // next bydefault is null
    }
}

// define a linked list to store the employe node
class EmpLinkedList {
    // the head node points to the first Emp
    private Emp head; // is null by default

    // add a new employee to the linked list
    // assume, the id is auto-increment
    // so just need to add the employee to the end of the linked list
    public void add (Emp newEmp){
        // if now the linked list is empty
        if(head==null) {
            newEmp.next = null;
            head = newEmp;
            return;
        }
        // if the list is not empty, find the last element via a while loop
        // define a node mover
        Emp temp = head;
        while(true){
            if(temp.next == null) {
                temp.next = newEmp;
                newEmp.next = null;// you do not need to add this actually, since when initiation,
                // the next was set to null by default
                break;
            }
            temp= temp.next;
        }
    }

    // iterate all elements of the linked list
    public void list(int No){
        // if the list is empty
        if(head == null) {
            System.out.println("#"+No+" list is empty");
            return;
        }
        System.out.println("Elments in # "+No+" linked list are:");
        Emp curEmp = head;
        while(true){
            System.out.printf("=> id=%d name=%s\t",curEmp.id,curEmp.name);
            if(curEmp.next==null)
                break;
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    public Emp getHead(){
        return this.head;
    }

    public Emp findEmpByID(int id){
        if(head == null) {
            System.out.println(" the list is empty");
            return null;
        }
        Emp temp = head;
        while (true) {
            if (temp.id == id)
                break;
            if (temp.next == null){
                temp = null;
                break;
            }
            temp = temp.next;
        }
        return temp;
    }
}
