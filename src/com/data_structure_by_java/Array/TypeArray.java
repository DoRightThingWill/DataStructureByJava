package com.data_structure_by_java.Array;

public class TypeArray<T> {
    // you could replace T with E, A, B whatever you want
    // you do not have to specify the type here,
    // instead, when you initialize the object, you specify the type
    // so, here, T is just a symbol, not actual meaning
    private T[] data;
    private int size;

    /**
     *
     */
    // create the constructor with parameters
    public TypeArray(int capacity){
        // object is parent class to any other class in Java
        // we first make an object array and then covert to type T
        data = (T[])new Object[capacity];
        size = 0;
    }
    // constructor without parameters
    public TypeArray(){
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
    public void addLast (T element){
        add(size,element);
    }
    // add an element in the first spot of the array
    public void addFirst (T element){
        add(0,element);
    }
    // add an element in the X spot
    public void add (int index, T element){
        if (index <0 || index >size)
            throw new IllegalArgumentException(" Add failed. Require index >=0 and index <=size");
        if (size == data.length)
            resize(2*data.length);
        for(int i=size-1; i>= index; i--)
            data[i+1] = data[i];
        data[index] = element;
        size ++;
    }
    // check if the array contains an element
    public boolean contain( T element){
        for (int i = 0; i < size; i++) {
            // object compares, equals
            if (data[i].equals(element))
                return true;
        }
        return false;
    }
    // find a certain element and return the index
    public int find( T element){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element))
                return i;
        }
        return -1;
    }
    // remove an element as per index from the array
    public T remove (int index){
        if(index <0 || index>=size)
            throw new IllegalArgumentException(" Remove failed, index is illegal");
        T rtn = data[index];
        for (int i = index; i <size-1 ; i++)
            data[i] = data[i+1];
        size--;
        if (size == data.length/2){
            resize(data.length/2);
        }
        return rtn;
    }
    // remove the first element from the array
    public T removeFirst (){
        return remove(0);
    }
    // remove the last element from the array
    public T removeLast(){
        return remove(size-1);
    }
    //remove an element of a value from the array
    public void removeElement(T element){
        int index = find(element);
        if(index != -1)
            remove(index);
    }
    // get the value from the data index
    public T get(int index){
        if (index <0 || index >=size)
            throw new IllegalArgumentException("Get failed, Index is illegal");
        return data[index];
    }
    // get the last element from the array
    public T getLast(){
        return get(size-1);
    }
    // get the first element from the array
    public T getFirst(){
        return get(0);
    }
    // update the value in the index spot
    void set(int index, T element){
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

    private void resize (int capacity){
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i <size ; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
