package com.guangya.data_structure_by_java.WoodyTest;

public interface UnionFind {
    int getSize();
    boolean isConnected(int p, int q);
    void unionElements (int p, int q);

}
