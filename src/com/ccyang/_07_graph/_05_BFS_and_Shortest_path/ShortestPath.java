package com.ccyang._07_graph;

public class ShortestPath {

    private Graph G;   // 图的引用
    private int s;     // 起始点
    private boolean[] visited;  // 记录dfs的过程中节点是否被访问
    private int[] from;         // 记录路径, from[i]表示查找的路径上i的上一个节点
    private int[] ord;          // 记录路径中节点的次序。ord[i]表示i节点在路径中的次序。

}
