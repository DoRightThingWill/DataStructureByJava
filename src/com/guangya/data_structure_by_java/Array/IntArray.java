package com.guangya.data_structure_by_java.Array;

public class IntArray {
    private int[] data;
    private int size;

    /**
     *
     */
    // create the constructor with parameters
    public IntArray(int capacity){
        data = new int[capacity];
        size = 0;
    }
    // constructor without parameters
    public IntArray(){
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
    // check if the array contains an element
    public boolean contain( int element){
        for (int i = 0; i < size; i++) {
            if (data[i]==element)
                return true;
        }
        return false;
    }
    // find a certain element and return the index
    public int find( int element){
        for (int i = 0; i < size; i++) {
            if (data[i]==element)
                return i;
        }
        return -1;
    }
    // remove an element as per index from the array
    public int remove (int index){
        if(index <0 || index>=size)
            throw new IllegalArgumentException(" Remove failed, index is illegal");
        int rtn = data[index];
        for (int i = index; i <size-1 ; i++)
            data[i] = data[i+1];
        size--;
        return rtn;
    }
    // remove the first element from the array
    public int removeFirst (){
        return remove(0);
    }
    // remove the last element from the array
    public int removeLast(){
        return remove(size-1);
    }
    //remove an element of a value from the array
    public void removeElement(int element){
        int index = find(element);
        if(index != -1)
            remove(index);
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
