package com.ccyang._08_Minimim_span_tree._05_Prim;

import java.util.Vector;

/**
 * 稠密图 -- 邻接矩阵 -- 带权图
 */
public class DenseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph<Weight> {

    private int n;  // 节点数
    private int m;  // 边数
    private boolean dericted;  // 是否为有向图
    private Edge<Weight>[][] g;  // 图的具体数据

    // 构造函数
    public DenseWeightedGraph(int n, boolean dericted){
        assert n >= 0;

        this.n = n;
        this.dericted = dericted;
        this.m = 0;
        g = new Edge[n][n];
        for (int i=0; i<n ; i++)
            for (int j=0; j<n; j++)
                g[i][j] = null;
    }

    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    @Override
    public void addEdge(Edge<Weight> e) {

        assert e.v() >= 0 && e.v() < n;
        assert e.w() >= 0 && e.w() < n;
        if ( !hasEdge(e.v(), e.w())) {
            int a = e.v();
            int b = e.w();
            g[a][b] = e;
            if (!dericted && a != b) // 排除 环形边
                g[b][a] = e;
        }
        m ++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        return g[v][w] != null;
    }

    @Override
    public void show() {

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                if( g[i][j] != null )
                    System.out.print(g[i][j].wt()+"\t");
                else
                    System.out.print("NULL\t");
            System.out.println();
        }

    }

    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个Vector不会带来额外开销,
    @Override
    public Iterable<Edge<Weight>> adj(int v) {

        assert v >= 0 && v < n;
        Vector<Edge<Weight>> adjV = new Vector<>();
        for(int i = 0 ; i < n ; i ++ )
            if( g[v][i] != null )
                adjV.add( g[v][i] );
        return adjV;
    }
}
