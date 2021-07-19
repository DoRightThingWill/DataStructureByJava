package com.guangya.data_structure_by_java.Set;

public interface Set<E> {

    void add (E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
