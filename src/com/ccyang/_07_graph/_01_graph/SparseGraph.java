package com.ccyang._07_graph;

import java.util.Vector;

/**
 * 基于邻接表 实现图： 邻接表适用于稀疏图
 */
public class SparseGraph {

    private int n, m;    // n -> 节点数；m -> 边数
    private boolean dericted;   // 是否是无向图
    private Vector<Integer>[] g;

    public SparseGraph(int n, boolean dericted) throws Exception {
        if( n <= 0)
            throw new Exception("图的节点数必须大于零");
        this.n = n;
        this.m = 0;
        this.dericted = dericted;

        // 初始化 n个 vector，每个g[i] 都为空，即没有任何边
        g = (Vector<Integer>[]) new Vector[n];
        for (int i=0; i<n; i++)
            g[i] = new Vector<>();
    }

    /**
     * @return 返回节点个数
     */
    private int V(){
        return n;
    }

    /**
     * @return 返回边的个数
     */
    private int E(){
        return m;
    }

    /**
     * add 边
     */
    public void addEdge(int v , int w) throws Exception {

        if(!((v >= 0 && v < n) && (w >= 0 && w < n)))
            throw new Exception("图中无此节点");

        g[v].add(w);
        if( v != w && !dericted )   // v != w 排除了 自环边的存在
            g[w].add(v);
        m++;
    }

    /**
     * 判断 节点v 和 节点w 的连通性
     */
    public Boolean hasEdge(int v, int w) throws Exception {
        if(!((v >= 0 && v < n) && (w >= 0 && w < n)))
            throw new Exception("图中无此节点");

        for(int i=0; i<g[v].size(); i++)
            if (g[v].elementAt(i) == w)
                return true;
        return false;
    }

    /**
     * 返回图中顶点的所有临边
     * 由于java使用引用机制，返回一个Vector不会带来额外开销,
     */
    public Iterable<Integer> adj(int v) throws Exception {

        if(!(v >= 0 && v < n))
            throw new Exception("图中无此节点");

        return g[v];
    }
}
