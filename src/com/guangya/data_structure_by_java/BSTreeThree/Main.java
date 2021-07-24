package com.guangya.data_structure_by_java.BSTreeThree;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        BinarySearchTreeTest();
    }

    public static void BinarySearchTreeTest (){
        class PersonComparator1 implements Comparator<Person>{
            public int compare(Person e1, Person e2){
                return e1.getAge() - e2.getAge();
            }
        };


        class PersonComparator2 implements Comparator<Person> {
            public int compare(Person e1, Person e2){
                return e2.getAge() - e1.getAge();
            }
        };

        Integer[] data = {7,4,9,2,5,8,11,3};

//        for (int i =0; i<data.length;i++){
//            bst.add(data[i]);
//        }

        BinarySearchTree<Person> bst1 = new BinarySearchTree<>( new PersonComparator1());
        BinarySearchTree<Person> bst2 = new BinarySearchTree<>( new PersonComparator2());



    }
}
