package com.data_structure_by_java.WoodyA3;

import com.data_structure_by_java.Graph.Graph;

import java.util.Arrays;

public class Q5Test {

    public static void main(String[] args) {

        String[] vertexList =  {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"};
        Graph graph = new Graph(vertexList.length);
        int[] indexArr = new int[vertexList.length];
        System.out.println(Arrays.toString(vertexList));
        for (int i=0; i< vertexList.length;i++){
            indexArr[i]=i;
            graph.insertVertex(vertexList[i]);
        }
        System.out.println(Arrays.toString(indexArr));


        graph.insertEdges(0,1,1);
        graph.insertEdges(0,4,1);
        graph.insertEdges(0,5,1);
        graph.insertEdges(1,2,1);
        graph.insertEdges(2,3,1);
        graph.insertEdges(2,5,1);
        graph.insertEdges(3,6,1);
        graph.insertEdges(4,8,1);
        graph.insertEdges(5,9,1);
        graph.insertEdges(6,7,1);
        graph.insertEdges(6,9,1);
        graph.insertEdges(6,10,1);
        graph.insertEdges(7,14,1);
        graph.insertEdges(8,12,1);
        graph.insertEdges(8,9,1);
        graph.insertEdges(8,12,1);
        graph.insertEdges(10,14,1);
        graph.insertEdges(11,15,1);
        graph.insertEdges(13,14,1);
        graph.insertEdges(14,15,1);

        System.out.println("*****************Q5 A, depth first search starting at g, index of 6");
        graph.dfs(6);
        System.out.println();


        System.out.println("*****************Q5 B, breadth first search starting at b, index of 1");
        graph.bfs(1);
        System.out.println();

        System.out.println("*****************Q5 C, adjacent matrix");
        System.out.println("   "+graph.getVertexList().toString());
        graph.showGraph();

//        graph.insertEdges();




    }
}
