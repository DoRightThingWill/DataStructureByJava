package com.data_structure_by_java.WillTest;

import java.util.Arrays;

public class PrimAlgorithm {

    public static void main(String[] args) {
        char[] data = {'a', 'b','c','d','e','f','g'};
        int numVertex = data.length;

        // weight is huge, means they are not connected since you are not going to choose this connection
        int[][] weight = {
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}
        };

        MGraph graph = new MGraph(numVertex);

        MST mst = new MST();

        mst.createGraph(graph, numVertex, data, weight);

        mst.showGraph(graph);

        System.out.println();
        mst.prim(graph,1);
    }
    // create the min tree
    static class MST {
        /**
         *
         * @param graph, the graph that we have used
         * @param numVertex, qty of vertex in the graph
         * @param data, value or name of the vertex
         * @param weight, adjacent matrix of the graph
         */
        public void createGraph (MGraph graph, int numVertex, char[] data, int[][] weight){
            int i, j;
            for(i=0; i<numVertex; i++){
                graph.data[i] = data[i];
                for(j=0; j<numVertex; j++){
                    graph.weight[i][j] = weight[i][j];
                }
            }
        }
        
        public void showGraph(MGraph graph){
            for(int[] link : graph.weight){
                System.out.println(Arrays.toString(link));
            }
        }

        /**
         *
         * @param graph, input the graph
         * @param v, mst starts from vertex v
         */
        public void prim(MGraph graph, int v){
            // recorded the visited vertex
            int[] visited = new int[graph.numVertex];

            // record the current input vertex as 1
            visited[v] = 1;
            int h1 =-1;
            int h2 = -1;
            int minWeight = 20000; // initiate the value at max

            for (int k = 1; k <graph.numVertex; k++) { // since graph has n vertex, when the process is done
                // there should be n-1 edges
                // ensure the sub-graph, to which vertex has closest distance
                for (int i = 0; i < graph.numVertex; i++) { // i vertex is visited
                    for (int j = 0; j < graph.numVertex; j++) { // j is not visited
                        if(visited[i] ==1 && visited[j]==0 && graph.weight[i][j] < minWeight){
                            minWeight = graph.weight[i][j];
                            h1 = i;
                            h2 = j;
                        }
                    }
                }

                // find the vertex which has the smallest weight
                System.out.println("edge " +graph.data[h1]+"-->"+graph.data[h2]+" of weight: "+minWeight);
                // current vertex recorded as visited
                visited[h2] = 1;
                minWeight = 20000;
            }
        }
    }


    static class MGraph {
        int numVertex;
        char[] data; // store the data value
        int[][] weight; // adjacent matrix to store edges

        public MGraph (int numVertex){
            this.numVertex = numVertex;
            data = new char[numVertex];
            weight = new int[numVertex][numVertex];
        }

    }

}
