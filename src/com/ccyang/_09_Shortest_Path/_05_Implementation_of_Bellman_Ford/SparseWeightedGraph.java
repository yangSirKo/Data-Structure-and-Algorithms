package com.ccyang._09_Shortest_Path._05_Implementation_of_Bellman_Ford;

/**
 * 稀疏图 -- 邻接表
 */

import java.util.ArrayList;

public class SparseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph<Weight> {

    private int n , m;  // 节点数 和 边数
    private boolean dericted;  // 是否是无向边
    private ArrayList<Edge<Weight>>[] g;    // 图的具体数据

    // Constructor
    public SparseWeightedGraph(int n, boolean dericted){

        assert n >= 0;
        this.dericted = dericted;
        this.n = n;
        this.m = 0;
        g = (ArrayList<Edge<Weight>>[])new ArrayList[n];
        for(int i=0; i<n; i++)
            g[i] = new ArrayList<>();
    }

    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    // 添加边
    @Override
    public void addEdge(Edge<Weight> e) {
        assert e.v() >= 0 && e.v() < n;
        assert e.w() >= 0 && e.w() < n;

        // 注意, 由于在邻接表的情况, 查找是否有重边需要遍历整个链表
        // 我们的程序允许重边的出现

        g[e.v()].add(e);     // v - w
        if(!dericted && (e.v() != e.w()))
            g[e.w()].add(new Edge<>(e.w(),e.v(),e.wt()));   // w - v , 要特别只注意这里添加边的方式
        m ++;  // 边数 +1
    }

    // 是否有 从 v 到 w 的边
    @Override
    public boolean hasEdge(int v, int w) {

        for(int i=0; i<g[v].size(); i++)
            if(g[v].get(i).other(v) == w)
                return true;
        return false;
    }

    // 显示图
    @Override
    public void show() {

        for( int i = 0 ; i < n ; i ++ ){
            System.out.print("vertex " + i + ":\t");
            for( int j = 0 ; j < g[i].size() ; j ++ ){
                Edge e = g[i].get(j);
                System.out.print( "( to:" + e.other(i) + ",wt:" + e.wt() + ")\t");
            }
            System.out.println();
        }
    }

    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个Vector不会带来额外开销,
    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }
}
