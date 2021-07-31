package com.guangya.data_structure_by_java.WoodyTest;

import java.util.Arrays;
import java.util.Collections;

public class Kruskal {
    public static void main(String[] args) {
        char[] vertex = {'a','b','c','d','e','f','g'};
        int[][] matrix = {
                {0,12,INF,INF,INF,16,14},
                {12,0,10,INF,INF,7,INF},
                {INF,10,0,3,5,6,INF},
                {INF,INF,3,0,4,INF,INF},
                {INF,INF,5,4,0,2,8},
                {16,7,6,INF,2,0,9},
                {14,INF,INF,INF,8,9,0}
        };

        Kruskal kruskal = new Kruskal(vertex, matrix);
        kruskal.print();

        System.out.println();

        System.out.println(" un sorted ");
        System.out.println(Arrays.toString(kruskal.getEdges()));

        EData[] edges = kruskal.getEdges();
        System.out.println("  sorted edges");
        kruskal.sortEdges(edges);
        System.out.println(Arrays.toString(edges));

        kruskal.kruskal();


    }

    private int edgeNum;
    private char[] vertex;
    private int[][] matrix;
    private static final  int INF = Integer.MAX_VALUE;

    public Kruskal (char[] vertexes, int[][] matrix){
        int vlen = vertexes.length;
        // initiate the vertex

        this.vertex = new char[vlen];
        for (int i = 0; i < vlen; i++) {
            this.vertex[i] = vertexes[i];

        }

        // what is the difference between
        // this.vertex = vertexes;

        // initiate the edges;
        this.matrix = new int[vlen][vlen];
        for (int i = 0; i <vlen; i++) {
            for (int j = 0; j <vlen ; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }

        // hom many edges??
        for (int i = 0; i <vlen; i++) {
            for (int j = i+1; j < vlen; j++) {
                if(this.matrix[i][j] != INF){
                    edgeNum++;
                }
            }
        }
        
    }
    
    public void print(){
        System.out.println("adjacent matrix is : ");
        for (int i = 0; i < vertex.length; i++) {
            for (int j = 0; j < vertex.length; j++) {
                System.out.printf("%15d",this.matrix[i][j]);
            }
            System.out.println();
        }

        System.out.println();
    }

    public void kruskal (){
        int index = 0;
        int[] ends = new int[edgeNum];

        EData[] rets = new EData[edgeNum];

        EData[] edges = getEdges();

        // sorted edges by weight
        sortEdges(edges);

        // iterate the added vertex, check if circular
        for (int i = 0; i < edgeNum; i++) {
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);

            int m = getEnd(ends,p1);
            int n = getEnd(ends,p2);
            if(n != m){
                ends[m] = n;
                rets[index++] = edges[i];
            }
        }

        System.out.println(" mst is ->");
        for (int i = 0; i < index; i++) {
            System.out.println(rets[i]);
        }

    }

    // sort the edges by weight
    private void sortEdges (EData[] edges){
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length-1-i; j++) {
                if(edges[j].weight > edges[j+1].weight){
                    EData temp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = temp;
                }
            }
        }
    }

    private int getPosition (char ch){
        for (int i = 0; i < vertex.length; i++) {
            if(vertex[i]== ch)
                return i;
        }

        return -1;
    }

    // get the edges from the graph and put it into the array
    // EData[['a','b',12]]
    private EData[] getEdges(){
        int index = 0;
        EData[] edges = new EData[edgeNum];

        for (int i = 0; i < vertex.length; i++) {
            for (int j = i+1; j < vertex.length; j++) {
                if(matrix[i][j] != INF){
                    edges[index++] = new EData(vertex[i],vertex[j],matrix[i][j]);
                }
            }
        }

        return edges;

    }

    private int getEnd (int[] ends, int i){
        while(ends[i] !=0){
            i = ends[i];
        }

        return i;
    }



}

class EData {
    char start;
    char end;
    int weight;

    public EData (char start, char end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}
