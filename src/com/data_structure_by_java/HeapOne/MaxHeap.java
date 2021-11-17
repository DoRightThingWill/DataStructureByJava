package com.data_structure_by_java.HeapOne;

import java.util.ArrayList;

public class MaxHeap<E extends Comparable<E>> {


    private ArrayList<E> data;

    public MaxHeap (){
        this.data = new ArrayList();
    }


    // heapify: form any array to a heap
    // index of the last non-leaf node is parent (last node)
    // from the last non-leaf node, sift down, until the root node.
    // this is a heapify process.

    public MaxHeap(E[] arr){
        for(E e : arr){
            data.add(e);
        }

        for (int i=parent(arr.length)-1; i>=0;i--)
            siftDown(i);
    }

    // get the size of the heap
    public int size(){
        return data.size();
    }

    // check the heap is empty
    public boolean isEmpty(){
        return data.isEmpty();
    }

    // get the index of the parent node, reppresented in the complete binary tree array
    private int parent(int index){
        if(index ==0)
            throw new IllegalArgumentException("index -0 does not have a parent");
        return (index -1)/2;
    }

    // get the index of the left child, prepresented in the complete binary tree array
    private int leftChild(int index){
        return index*2+1;
    }

    private int rightChild(int index){
        return index*2+2;
    }


    // extract max from the heap

    public E extractMax (){
        E ret = findMax();

        // swap the last element and the head element in the array list
        swap(data, data.size()-1,0 );
        // remove the last element from the array list
        data.remove(data.size()-1);
        siftDown(0);

        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k)<data.size()){
            int j = leftChild(k);
            if(j+1 <data.size() &&
                        data.get(j+1).compareTo(data.get(j))>0){
                // data j is larger of the left and right child of k
                j=rightChild(k);
            }

            if(data.get(k).compareTo(data.get(j))>=0){
                break;
            }

            // otherwise
            swap(data,k,j);
            // move forward to the next loop
            k=j;
        }
    }

    public E findMax (){
        if(data.size()==0)
            throw new IllegalArgumentException("Can not find max since the heap is empty");
        return data.get(0);
    }

    // adding element by sifting up
    public void add (E e){
        data.add(e);
        siftUP(data.size()-1);
    }

    private void siftUP (int k){
        while (k>0 && data.get(parent(k)).compareTo(data.get(k))<0){
            swap(data,parent(k),k);
            k=parent(k);
        }
    }

    private void swap(ArrayList<E> arrayList, int x, int y){
        if(x<0 || x>=arrayList.size() || y<0 || y>=arrayList.size())
            throw new IllegalArgumentException("Idex is illegal");
        E temp = arrayList.get(x);
        arrayList.set(x,arrayList.get(y));
        arrayList.set(y,temp);
    }

    // logn running time
    public E replace(E e){
        E ret = findMax();

        data.set(0, e);

        siftDown(0);

        return ret;
    }




}
