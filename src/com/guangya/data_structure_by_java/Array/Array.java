package com.guangya.data_structure_by_java.Array;

public class Array {
    private int[] data;
    private int size;

    /**
     *
     */
    // create the constructor with parameters
    public Array(int capacity){
        data = new int[capacity];
        size = 0;
    }
    // constructor without parameters
    public Array(){
        this(10);
    }
    // get how many elements in the array
    public int getSize(){
        return size;
    }
    // get the capacity of the array
    public int getCapacity (){
        return data.length;
    }
    // check if the array is empty
    public boolean isEmpty (){
        return size == 0;
    }
    // add an element in the last spot of the array
    public void addLast (int element){
        add(size,element);
    }
    // add an element in the first spot of the array
    public void addFirst (int element){
        add(0,element);
    }
    // add an element in the X spot
    public void add (int index, int element){
        if (size == data.length)
            throw new IllegalArgumentException(" Add failed, since array is full");
        if (index <0 || index >size)
            throw new IllegalArgumentException(" Add failed. Require index >=0 and index <=size");
        for(int i=size-1; i>= index; i--)
            data[i+1] = data[i];
        data[index] = element;
        size ++;
    }

    // get the value from the data index
    public int get(int index){
        if (index <0 || index >=size)
            throw new IllegalArgumentException("Get failed, Index is illegal");
        return data[index];
    }
    // update the value in the index spot
    void set(int index, int element){
        if (index <0 || index >=size)
            throw new IllegalArgumentException("Get failed, Index is illegal");
        data[index] =  element;
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n",size,data.length));
        res.append('[');
        for (int i=0; i<size; i++) {
            res.append(data[i]);
            if(i != size-1)
                res.append(',');
        }
        res.append(']');
        return res.toString();
    }
}
