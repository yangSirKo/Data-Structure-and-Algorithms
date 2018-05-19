package com.ccyang._09_Shortest_Path._05_Implementation_of_Bellman_Ford;

public interface WeightedGraph<Weight extends Number & Comparable>{

    int V();
    int E();

    void addEdge(Edge<Weight> e);
    boolean hasEdge(int v, int w);

    void show();
    Iterable<Edge<Weight>> adj(int v);

}
