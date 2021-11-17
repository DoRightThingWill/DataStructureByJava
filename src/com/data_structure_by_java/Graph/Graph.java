package com.data_structure_by_java.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    public static void main(String[] args) {


//        String[] vertexValue = {"a", "b", "c", "d", "e"};
        String[] vertexValue = {"1", "2", "3", "4", "5","6","7","8"};

        int n = vertexValue.length; // qyt of vertex

        // initiate a graph
        Graph graph = new Graph(n);

        // add vertex into the graph via a loop
        for (String vertex : vertexValue){
            graph.insertVertex(vertex);
        }

        // insert edges to the vertex
        // a-b, a-c, b-c, b-d, b-e
//        graph.insertEdges(0,1,1);
//        graph.insertEdges(2,0,1);
//        graph.insertEdges(2,1,1);
//        graph.insertEdges(3,1,1);
//        graph.insertEdges(4,1,1);


        graph.insertEdges(0,1,1);
        graph.insertEdges(0,2,1);
        graph.insertEdges(1,3,1);
        graph.insertEdges(1,4,1);
        graph.insertEdges(3,7,1);
        graph.insertEdges(4,7,1);
        graph.insertEdges(2,5,1);
        graph.insertEdges(2,6,1);
        graph.insertEdges(5,6,1);


        System.out.println("   "+graph.getVertexList().toString());
        graph.showGraph();

        System.out.println("***************************");
        System.out.println(" d f s");
        graph.dfs();

        System.out.println();
        System.out.println("***************************");
        System.out.println(" b f s");
        graph.bfs();
    }


    private ArrayList<String> vertexList; // store the vertext value
    private int[][] edges; // store the adjacent matrix
    private int numberOfEdges; // quantity of
    private boolean[] isVisted; // record if the vertex got visited or not

    // define the constructor
    public Graph (int n){
        // initiate the adjacent matrix and vertex list
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numberOfEdges = 0;
    }


    public void bfs (){
        bfs(0);
    }

    public void bfs(int startIndex){
        isVisted = new boolean[vertexList.size()];
//        Arrays.fill(isVisted,false);
        int curIndex = 0;
        for (int i =0; i<getNumOfVertex(); i++){
            curIndex = (i+startIndex) % getNumOfVertex();
            if(!isVisted[curIndex]){
                bfs(isVisted,curIndex);
            }
        }
    }

    // bfs for one node
    private void bfs (boolean[] isVisited, int i){
        int u; // index of the head node in the queue
        int w; // index the connect vertex
        // record the order of vertex get visited
        Queue<Integer> queue = new LinkedList();

        // visit current vertext
        System.out.print(getValueByIndex(i)+"->");
        // mark it as visited
        isVisited[i] = true;

        // add this vertex into the queue
        queue.add(i);

        while(! queue.isEmpty()){
            // get the head node from queue
            u = queue.remove();

            w= getFirstNeighbor(u);
            while(w!=-1){
                // check visited or not
                if(!isVisted[w]) {
                    System.out.print(getValueByIndex(w) + "->");
                    isVisited[w] = true;
                    queue.add(w);
                }

                // move to the next vertex
                w = getNextNeighbor(u,w);
            }
        }
    }


    // traver all vertex by depth first search
    public void dfs(){
        dfs(0);
    }

    public void dfs(int startIndex ){
        isVisted = new boolean[vertexList.size()];
//        Arrays.fill(isVisted,false);
        int curIndex = 0;
        for (int i =0; i<getNumOfVertex(); i++){
            curIndex = (i+startIndex) % getNumOfVertex();
            if(!isVisted[curIndex]){
                dfs(isVisted,curIndex);
            }
        }
    }



    // depth first traversal method
    private void dfs (boolean[] isVisted, int i){
        // visit the current vertex
        System.out.print(getValueByIndex(i)+"->");
        // mark the verxt as visted
        isVisted[i] = true;

        // get the index of the first connected vertex
        int w = getFirstNeighbor(i);
        while (w!=-1){
            if(!isVisted[w])
                dfs(isVisted,w);
            // if w got visited before
            w= getNextNeighbor(i,w);
        }
    }

    // lets say, a connect b, and a connect with c;
    // now, input is a, b,
    // we need to get c
    // get the index of the previous vertex
    public int getNextNeighbor(int v1, int v2){
        for (int j=v2+1; j<vertexList.size();j++){
            if(edges[v1][j]>0)
                return j;
        }
        return -1;
    }

    // get the index of the first connected vertex
    public int getFirstNeighbor(int index){
        for (int j=0; j<vertexList.size(); j++){
            if(edges[index][j]>0 && j>index){
                return j;
            }
        }
        return -1;
    }
    // common method of a graph class


    public ArrayList<String> getVertexList() {
        return vertexList;
    }

    // get the qty of vertex
    public int getNumOfVertex(){
        return vertexList.size();
    }

    // get the qyt of edges
    public int getNumberOfEdges(){
        return numberOfEdges;
    }

    // get the name in string by its index in the array list
    public String getValueByIndex (int index ){
        return vertexList.get(index);
    }

    // get the connection weight between v1 and v2
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    // print out the dajacent matrix of the graph
    public void showGraph(){
        for (int i=0; i<edges.length;i++){
            System.out.println(vertexList.get(i)+"->"+Arrays.toString(edges[i]));
        }
    }

    // insert the vertex
    public void insertVertex (String vertex){
        vertexList.add(vertex);
    }

    // add edges
    /**
     *
     * @param v1, the index of the vertex in the array list
     * @param v2, the index of second vertex in the array list
     * @param weight, 0, means no direct connection; 1, means with direct connection
     */
    public void insertEdges(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numberOfEdges++;
    }



}
