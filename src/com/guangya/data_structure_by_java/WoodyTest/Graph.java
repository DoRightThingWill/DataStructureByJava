package com.guangya.data_structure_by_java.WoodyTest;

import java.util.*;

public class Graph<T> {

    public static void main(String[] args) {
        Graph graph = new Graph();

//        String vertex = "ABCDE";
        String[] vertex = {"A","B","C","D","E","F"};
        for(int i =0; i<vertex.length;i++){
            graph.addVertex(vertex[i]);
        }

        graph.addEdge("A","B");
        graph.addEdge("A","C");
        graph.addEdge("B","D");
        graph.addEdge("B","E");
        graph.addEdge("C","D");
        graph.addEdge("D","E");
        graph.addEdge("E","F");



        System.out.println(graph);
        System.out.println("********** dfs by recursion ****");
        graph.dfsRecursion("A");
        System.out.println();
        System.out.println("********** dfs by iteration ****");
        graph.dfsIteration("A");


        System.out.println();
        System.out.println("********** bfs by iteration one ****");
        graph.bfsIteration("A");
        System.out.println();

        System.out.println("********** bfs by iteration two ****");
        graph.bfsIteration2("A");

        System.out.println();
        System.out.println("**** most far vertex ***********");
        System.out.println(graph.farVertex("A"));
    }

    // we use hashmap to store the edges in the graph
    private Map<T, List<T>> map;
    private int numberVertex;
    private int numberEdges;

    // define the constructor
    public Graph (){
        this.map = new HashMap<>();
        this.numberEdges = 0;
        this.numberVertex = 0;
    }


    public void bfsIteration(T v){
        HashMap<T, Boolean> visited = new HashMap<>();
        for(T key : this.map.keySet())
            visited.put(key, false);

        bfsIteration(v, visited);
    }

    private void bfsIteration(T v, HashMap<T, Boolean> visited){
        Queue<T> queue = new ArrayDeque();
        queue.add(v);
//        if(!visited.get(v))
//            System.out.println(v+"-->");

        while(!queue.isEmpty()){

            T currentVertex = queue.remove();
            if(!visited.get(currentVertex)) {
                System.out.print(currentVertex + "-->");
                visited.put(currentVertex, true);
            }

            Iterator<T> iterator = this.map.get(currentVertex).listIterator();
            while(iterator.hasNext()){
                currentVertex = iterator.next();
                if(!visited.get(currentVertex))
                    queue.add(currentVertex);
            }
        }
    }

    public T farVertex(T v){

        HashMap<T, Boolean> visited = new HashMap<>();
        for(T key : this.map.keySet())
            visited.put(key, false);

        Queue<T> queue = new ArrayDeque();
        queue.add(v);
//        if(!visited.get(v))
//            System.out.println(v+"-->");

        T currentVertex = null;
        while(!queue.isEmpty()){

            currentVertex = queue.remove();
            if(!visited.get(currentVertex)) {
//                System.out.print(currentVertex + "-->");
                visited.put(currentVertex, true);
            }

            Iterator<T> iterator = this.map.get(currentVertex).listIterator();
            while(iterator.hasNext()){
                T newVertex = iterator.next();
                if(!visited.get(newVertex) && !queue.contains(newVertex))
                    queue.add(newVertex);
            }
        }

        return currentVertex;
    }



    public void bfsIteration2(T v){
        HashMap<T, Boolean> visited = new HashMap<>();
        for(T key : this.map.keySet())
            visited.put(key, false);

        bfsIteration2(v, visited);
    }

    private void bfsIteration2(T v, HashMap<T, Boolean> visited){
        Queue<T> queue = new ArrayDeque();
        queue.add(v);
//        if(!visited.get(v))
//            System.out.println(v+"-->");

        while(!queue.isEmpty()){

            T currentVertex = queue.remove();
            if(!visited.get(currentVertex)) {
                System.out.print(currentVertex + "-->");
                visited.put(currentVertex, true);
            }

            for(T key : this.map.get(currentVertex))
                if(!visited.get(key))
                    queue.add(key);

        }
    }


    // dfs by recursion

    public void dfsRecursion(T v){
        if(hasVertex(v)){

            // internal and temporary storage for the visit record
            HashMap<T, Boolean> visited = new HashMap<>();
            for(T key : this.map.keySet())
                visited.put(key, false);

            // call the actual dfs method
            dfsRecursion(v, visited);

        } else {
            throw new IllegalArgumentException("Graph does not have vertex "+v );
        }
    }

    private void dfsRecursion(T v, HashMap<T, Boolean> visited){
        // visit the starting vertex
        visited.put(v,true);
        System.out.print(v+"-->");


        // if the current vertex has not been visited
        // visit this vertex
        // otherwise, move to the next connect vertex
        Iterator<T> iterator = this.map.get(v).listIterator();


        while(iterator.hasNext()){// this is when a certain route ends, come back to the vertex who has connected vertex not visited
            v  = iterator.next();

            if(!visited.get(v)){
                // this is where the depth first happen
                dfsRecursion(v, visited);
            }
        }

    }

    public void dfsIteration (T v){
        if(hasVertex(v)){
            HashMap<T, Boolean> visited = new HashMap<>();
            for(T key : this.map.keySet())
                visited.put(key, false);

            dfsIteration(v, visited);
        } else {
            throw new IllegalArgumentException("Graph does not has vertex "+v);
        }
    }

    private void dfsIteration(T v, HashMap<T, Boolean> visited){
//        System.out.print(v+"-->");

        Stack<T> stack = new Stack<>();
        stack.push(v);

        while(!stack.isEmpty()){
            T currentVertex = stack.pop();
            if(!visited.get(currentVertex)) {
                visited.put(currentVertex, true);
                System.out.print(currentVertex + "-->");
            }


            // visit the vertex if not visited before
                // push all its connected vertex into the stack
//            Iterator<T> iterator = this.map.get(v).listIterator();
                for (T vertex : this.map.get(currentVertex)) {
                    if(!visited.get(vertex))
                        stack.push(vertex);
                }
        }

    }


    // add vertex
    public void addVertex(T s){
        map.put(s, new LinkedList<>());
    }

    // add edge between source to destination
    public void addEdge(T source, T destination){
        Boolean hasVertex = hasVertex(source);
        if(!hasVertex(source))
            throw new IllegalArgumentException("Graph does not have the vertex "+source);

        if(!map.containsKey(destination))
            throw new IllegalArgumentException("Graph does not have the vertex "+ destination);

        map.get(source).add(destination);
        map.get(destination).add(source);
    }

    public void deleteEdge(T source, T destination){
        if(hasEdge(source, destination)){
            this.map.get(source).remove(destination);
            this.map.get(destination).remove(source);
        } else{
            throw new IllegalArgumentException("Graph does not have the edge "+source+"->"+destination);
        }
    }

    public boolean hasVertex(T v){
        Boolean hasKey = this.map.containsKey(v);
        return hasKey;
//        return this.map.containsKey(v);
    }

    public boolean hasEdge(T source, T destination){
        return this.map.get(source).contains(destination);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        for(T key : this.map.keySet()){
            res.append(String.format(key+"--->"+this.map.get(key).toString()+"\n"));
        }

        return res.toString();
    }

}
