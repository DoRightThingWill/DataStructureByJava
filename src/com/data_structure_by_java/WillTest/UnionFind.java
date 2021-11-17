package com.data_structure_by_java.WillTest;

public interface UnionFind {
    int getSize();
    boolean isConnected(int p, int q);
    void unionElements (int p, int q);

}
