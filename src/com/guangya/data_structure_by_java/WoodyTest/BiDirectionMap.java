package com.guangya.data_structure_by_java.WoodyTest;

import java.util.TreeMap;

public class BiDirectionMap<K,V> {

    public static void main(String[] args) {

        BiDirectionMap biDirectionMap = new BiDirectionMap();

        biDirectionMap.insert(1,2);
        biDirectionMap.insert(3, 4);
        System.out.println(biDirectionMap.toString());

        System.out.println(biDirectionMap.lookup(1).toString());


        biDirectionMap.insert(4, 2);







        System.out.println(biDirectionMap.rLookup(2));



        biDirectionMap.delete(4);

        System.out.println(biDirectionMap.toString());


    }

    TreeMap<K, V> forward ;
    TreeMap<V,K> back ;

    public BiDirectionMap(){
        forward = new TreeMap<K, V>();
        back = new TreeMap<V,K>();
    }

    public V lookup(K key){
        return forward.get(key);
    }

    public K rLookup(V value){

        return back.get(value);
    }

    public void insert (K key, V value){
        V vv = forward.get(key);
        if(vv!=null) {
            forward.remove(key);
            back.remove(vv);
        }

        K kk = back.get(value);

        if(kk!=null){
            back.remove(value);
            forward.remove(kk);
        }

        forward.put(key, value);
        back.put(value,key);

    }

    public void delete(K key){
        V vv= forward.get(key);

        if(vv==null){
            return;
        } else{
            forward.remove(key);
            back.remove(vv);
        }
    }

    @Override
    public String toString() {
        return "BiDirectionMap{" +
                "forward=" + forward +
                '}';
    }
}
