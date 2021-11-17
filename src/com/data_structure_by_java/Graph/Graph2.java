package com.data_structure_by_java.Graph;
import ods.SLList;

import java.util.*;

public class Graph2<T> {

    public static void main(String[] args) {

        String[] vertexList = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"};
        Graph2 graph2 = new Graph2(vertexList.length);
        for (String vertext : vertexList){
            graph2.addVertex(vertext);
        }

        // the elements in the textbook

        graph2.addEdge("a",new String[]{"b","e","f"});
        graph2.addEdge("b",new String[]{"a","c"});
        graph2.addEdge("c",new String[]{"b","d","f"});
        graph2.addEdge("d",new String[]{"c","g"});
        graph2.addEdge("e",new String[]{"a","i"});
        graph2.addEdge("f",new String[]{"a","c","j"});
        graph2.addEdge("g",new String[]{"d","h","j","k"});
        graph2.addEdge("h",new String[]{"g","o"});
        graph2.addEdge("i",new String[]{"e","j","m","n"});
        graph2.addEdge("j",new String[]{"f","g","i"});
        graph2.addEdge("k",new String[]{"g","o"});
        graph2.addEdge("l",new String[]{"p"});
        graph2.addEdge("m",new String[]{"i"});
        graph2.addEdge("n",new String[]{"i","o"});
        graph2.addEdge("o",new String[]{"h","k","n","p"});
        graph2.addEdge("p",new String[]{"l","o"});

        String[] vertexList3 = {"a","b","c","d","e","f"};
        Graph2 graph3 = new Graph2(vertexList3.length);
        for (String vertext : vertexList3){
            graph3.addVertex(vertext);
        }

        graph3.addEdge("a",new String[]{"b","c"});
        graph3.addEdge("b",new String[]{"a","c","d"});
        graph3.addEdge("c",new String[]{"a","b","d","e"});
        graph3.addEdge("d",new String[]{"b","c","e","f"});
        graph3.addEdge("e",new String[]{"c","d"});
        graph3.addEdge("f",new String[]{"d"});


        System.out.println("******************bfs***************");
        graph2.bfs("b");
        System.out.println();

        System.out.println("******************dfs***************");
        graph2.dfs("g");
        System.out.println();


        graph3.bfs("a");
        System.out.println();
//        graph3.bfs("e");

        HashMap parent = graph3.bfs("e");
        System.out.println();
        System.out.println("path parent");
        System.out.println(parent.toString());

        System.out.println();
        graph3.dfs("a");
        System.out.println();
        graph3.dfs("e");
        System.out.println();

        // find the path from b to e
        Integer indexVertex = 1;
        while(indexVertex != null){
            String vertexName = (String) graph3.vertexIndex.get(indexVertex);
            System.out.print(vertexName+"->");
            indexVertex = (Integer) parent.get(indexVertex);
        }
    }


    private int numVertex; // qty of vertex
    private ArrayList<ArrayList<Integer>> adj; // to store the connection of vertex
    private ArrayList<String> vertexIndex; // to the name of vertex


    Graph2 (int numVertex){
        this.numVertex = 0;
        vertexIndex = new ArrayList<String>();
        adj = new ArrayList();
        for(int i =0; i<numVertex; i++){
            // initiate and add the array list into adj
            ArrayList list = new ArrayList<Integer>();
            adj.add(i,list);
        }
    }

    public void addVertex (String vertexName){
        vertexIndex.add(vertexName);
        numVertex++;
    }

    public HashMap bfs(String vertexName){
        boolean[] seen = new boolean[numVertex];
        Queue<Integer> q = new SLList<Integer>();
        int vertexIndex = getIndexOfVertex(vertexName);

        HashMap parent = new HashMap();
        parent.put(vertexIndex,null);


        q.add(vertexIndex);
        seen[vertexIndex] = true;

        while (!q.isEmpty()){
            int headIndex = q.remove();
            String vertex = this.vertexIndex.get(headIndex);
            ArrayList<Integer> tempEdges = outEdges(vertex);
            for (Integer j : tempEdges){
                if(!seen[j]){
                    q.add(j);
                    seen[j]=true;
                    parent.put(j,headIndex);
                }
            }
            System.out.print(vertex+"->");
        }

        return parent;
    }

    public void dfs (String inputVertex){
        boolean[] seen = new boolean[numVertex];
        Stack<Integer> stack = new Stack<Integer>();
        int vertexIndex = getIndexOfVertex(inputVertex);

        stack.push(vertexIndex);
        seen[vertexIndex] = true;

        while (!stack.isEmpty()){
            int headIndex = stack.pop();
            String vertex = this.vertexIndex.get(headIndex);
            ArrayList<Integer> tempEdges = outEdges(vertex);
            for (Integer j : tempEdges){
                if(!seen[j]){
                    stack.push(j);
                    seen[j]=true;
                }
            }
            System.out.print(vertex+"->");
        }
    }



    // get index by vertex name
    private int getIndexOfVertex (String vertex){
        return vertexIndex.indexOf(vertex);
    }

    public void addEdge(String x, String[] connectedVertexArr){
        for(String vertexY : connectedVertexArr){
            addEdge(x,vertexY);
        }
    }

    // add edge between vertex i and j
    // add j to the stack list of adj[i]
    public void addEdge(String x, String y){
        int indexOfX = getIndexOfVertex(x);
        int indexOfY = getIndexOfVertex(y);
        adj.get(indexOfX).add(indexOfY);
    }

    void removeEdge(String x, String y){
        int indexOfX = getIndexOfVertex(x);
        int indexOfY = getIndexOfVertex(y);
        Iterator<Integer> it = adj.get(indexOfX).iterator();
        while(it.hasNext()){
            if(it.next()==indexOfY){
                it.remove();
                return;
            }
        }
    }

    // check if vertex i and j connected
    boolean hasEdge (String x, String y){
        int indexOfX = getIndexOfVertex(x);
        int indexOfY = getIndexOfVertex(y);
        return adj.get(indexOfX).contains(indexOfY);
    }

    // check all vertex that are connected with i and i is the source
    public ArrayList<Integer> outEdges(String x){
        int indexOfX = getIndexOfVertex(x);
        return adj.get(indexOfX);
    }

    // check all vertex that are connected with i and i is the target
    public ArrayList<Integer> inEdges(String x){
        ArrayList inEdges = new ArrayList<Integer>();
        int indexOfX = getIndexOfVertex(x);
        for(int j=0; j<numVertex; j++)
            if(adj.get(j).contains(indexOfX)) inEdges.add(j);
            return inEdges;
    }
}
