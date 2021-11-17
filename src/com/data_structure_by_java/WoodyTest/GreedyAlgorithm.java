package com.data_structure_by_java.WoodyTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {

    public static void main(String[] args) {
        // create the set of broadcasts
        HashMap<String, HashSet<String>> broadcasts= new HashMap<String, HashSet<String>>();

        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("Beijing");
        hashSet1.add("Shanghai");
        hashSet1.add("Tianjin");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("Guangzhou");
        hashSet2.add("Beijing");
        hashSet2.add("Shenzhen");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("Chengdu");
        hashSet3.add("Shanghai");
        hashSet3.add("Hangzhou");

        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("Shanghai");
        hashSet4.add("Tianjin");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("Hangzhou");
        hashSet5.add("Dalian");


        broadcasts.put("k1",hashSet1);
        broadcasts.put("k2",hashSet2);
        broadcasts.put("k3",hashSet3);
        broadcasts.put("k4",hashSet4);
        broadcasts.put("k5",hashSet5);


        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("Beijing");
        allAreas.add("Shanghai");
        allAreas.add("Tianjin");
        allAreas.add("Guangzhou");
        allAreas.add("Shenzhen");
        allAreas.add("Chengdu");
        allAreas.add("Hangzhou");
        allAreas.add("Dalian");

        ArrayList<String> selects = new ArrayList<String>();

        // define a temp set, to store the areas that has been covered and and not covered
        HashSet<String> temp = new HashSet<>();
        String maxKey = null;

        while(allAreas.size() != 0){// not all areas are covered
            // for any iteration, reset maxKey
            maxKey = null;

            // iterate all broadcasts
            for(String key : broadcasts.keySet()){
                // for each for loop
                temp.clear();

                HashSet<String> areas = broadcasts.get(key);
                // put all areas into the temp set
                temp.addAll(areas);
                // get the common areas and assign the value to the temp set
                temp.retainAll(allAreas);
                if(temp.size() > 0 && (maxKey == null || temp.size() > broadcasts.get(maxKey).size())){
                    maxKey = key;
                }
            }

            if(maxKey != null){
                selects.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
            }

        }


        System.out.println("the final result is "+selects);

    }
}
