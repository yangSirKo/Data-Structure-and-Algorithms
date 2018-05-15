package com.ccyang._07_graph._03_DFSAndComponent;


/**
 * 图的接口
 */
public interface Graph {

    int V();
    int E();

    void addEdge(int v, int w) throws Exception;
    boolean hasEdge(int v, int w) throws Exception;

    Iterable<Integer> adj(int v) throws Exception;
    void show();



}
