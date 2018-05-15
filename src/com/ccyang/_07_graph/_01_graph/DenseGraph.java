package com.ccyang._07_graph._01_graph;

import java.util.Vector;

/**
 * 基于 邻接矩阵 实现图： 邻接矩阵适用于稠密图
 */
public class DenseGraph {

    private int n, m ;  // n -> 节点数；m -> 边数
    private boolean dericted;  // 是否是有向图, 无向图：false
    private boolean[][] g;   // 图的具体数据

    public DenseGraph(int n, boolean dericted) {
        assert n > 0;
        this.n = n;
        this.m = 0;  // 初始化没有任何边
        this.dericted = dericted;

        // g 初始化为 n*n 的布尔矩阵，每个 g[i][i]== false 表示没有任何边
        // boolean 默认值为 false
        g = new boolean[n][n];
    }

    /**
     * @return 返回节点个数
     */
    public int V(){
        return n ;
    }

    /**
     * @return 返回边的总数
     */
    public int E(){
        return m ;
    }

    /**
     * 向图中添加一个边
     */
    public void addEdge(int v, int w) throws Exception {

        if(!((v >= 0 && v < n) && (w >= 0 && w < n)))
            throw new Exception("图中无此节点");

        if(hasEdge(v,w))  // 排除了 平行边 的存在
           return ;

        g[v][w] = true;
        if(!dericted){
            g[w][v] = true;
        }
        m ++;
    }

    /**
     * 判断图中是否存在 由 v 到 w 的边
     */
    public boolean hasEdge(int v, int w) throws Exception {

        if(!((v >= 0 && v < n) && (w >= 0 && w < n)))
            throw new Exception("图中无此节点");
        return g[v][w];
    }

    /**
     * 返回一个顶点的所有临边
     * java 使用引用机制，返回一个 vector 不会带来额外的开销
     */
    public Iterable<Integer> adj(int v) throws Exception {

        if(!(v >= 0 && v < n))
            throw new Exception("图中无此节点");

        Vector<Integer> adjV = new Vector<>();
        for (int i=0; i<n; n++){
            if(g[v][i])  // true 表示有边
                adjV.add(i);
        }
        return adjV;
    }
}
