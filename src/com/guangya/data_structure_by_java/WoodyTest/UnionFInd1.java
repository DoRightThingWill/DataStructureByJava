package com.guangya.data_structure_by_java.WoodyTest;

public class UnionFInd1 implements UnionFind{


private int[] id;
public UnionFInd1 (int size){
    id = new int[size];
    for(int i=0; i<id.length; i++)
        id[i] = i;
}


@Override
    public int getSize(){
    return id.length;
}


private int find(int p){
    if(p<0 || p>= id.length)
        throw new IllegalArgumentException(" p is out of bound");

    return id[p];
}

@Override
    public boolean isConnected(int p, int q){
    return find(0) == find(q);
}

@Override
    public void unionElements(int p, int q){
    int pID = find(p);
    int qID = find(q);

    if(pID == qID)
        return;

    for(int i=0; i<this.id.length; i++){
        if(id[i]==pID)
            id[i]=qID;
    }
}

}
