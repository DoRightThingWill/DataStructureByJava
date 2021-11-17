package com.data_structure_by_java.WoodyPractiseComp272A2;


import java.util.Arrays;

public class LinearHashTable {
    // define the instance fields
    private Integer[] table;          // the table to store value
    private int dataSize;       // the size of elements in the table
    private int capacity;       // table.legnth = capacity;

    //define the constructor with no input parameters
    public LinearHashTable(){
        this(10);
    }
    // and with input capacity of the table
    public LinearHashTable(int capacity){
        this.capacity = capacity;
        dataSize = 0;
        table = new Integer[capacity];
    }

    // define the setter and getter for all instance fields
    public Integer[] getTable() {
        return table;
    }

    public void setTable(Integer[] table) {
        this.table = table;
    }

    public int getDataSize() {
        return dataSize;
    }

    public void setDataSize(int dataSize) {
        this.dataSize = dataSize;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // define methods
    public boolean add(Integer key){
        // if the element already exists in the table, return false
        if(find(key)!=-1)
            return false;

        // if the element not exists in the table, go ahead for adding
        if (2*(dataSize+1)>capacity) resize(); // max 50% occupancy
         int index = hashFun(key);
         while (table[index]!=null){
             index = (index +1)%capacity;
         }
         dataSize ++;
         table[index] = key;
         return true;
    }

    public boolean remove(Integer key){
        // min 12.5% occupancy
        if(8*dataSize<capacity) resize();
        int index = find(key);
        if(index==-1){
            return false;
        }

        table[index] = null;
        dataSize--;
        int nextIndex = (index+1)%capacity;
        while(table[nextIndex]!=null){
            Integer temKey = table[nextIndex];
            table[nextIndex] = null;
            dataSize--;
            add(temKey);
            nextIndex = (nextIndex+1)%capacity;
        }
        return true;
    }

    public int find (Integer key){
        int index = hashFun(key);
        while(table[index]!=null){
            if(table[index].equals(key)) {
                return index;
            }
            index = (index+1)%capacity;
        }
        return -1;
    }

    private void resize(){
        capacity = 3*dataSize;
        Integer[] tempArr = new Integer[capacity];
        for (int i =0; i<table.length; i++){
            if(table[i]!=null){
                Integer temKey = table[i];
                int temIndex = hashFun(temKey);
                while (tempArr[temIndex]!=null)
                    temIndex = (temIndex+1)%capacity;
                tempArr[temIndex] = table[i];
            }
        }
        table = tempArr;
        tempArr=null;
    }

    public int hashFun(Integer key){
        return (key % 13)%capacity;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LinearHashTable, capacity->%d, dataSize->%d, elements: \n",capacity,dataSize));
        for(int i=0; i<table.length; i++){
            if(table[i]!=null){
                res.append(String.format("index #%d-->value: %s \n",i,table[i].toString()));
            } else {
                res.append(String.format("index #%d-->value: null  \n",i));
            }
        }
        return res.toString();
    }
}
