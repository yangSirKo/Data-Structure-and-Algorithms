package com.ccyang._08_Minimim_span_tree._03_Lazy_Prim;

import java.util.Vector;

/**
 *  使用Prim算法求图的最小生成树-- 带权图，无向图
 */
public class LazyPrimMST<Wight extends Number & Comparable> {

    private WeightedGraph<Wight> G; // 图的引用
    private MinHeap<Edge<Wight>> pq; // 最小堆，算法辅助数据结构
    private boolean[] marked;    // 标记数组，在算法执行过程中标记节点是否被访问过
    private Vector<Edge<Wight>> mst;  // 最小生成树包含的所有边
    private Number mstWeight;  // 最小生成树的权值

    // Constructor, 使用 Prim算法求最小生成树
    public LazyPrimMST(WeightedGraph g){

        // Init
        this.G = g;
        pq = new MinHeap<>(G.E());
        marked = new boolean[G.V()];
        mst = new Vector<>();

        // Lazy Prim
        visit(0);
        while(!pq.isEmpty()){
            // 使用最小堆找出 已经访问的边中 权值最小的边
            Edge<Wight> e = pq.extractMin();
            // 如果这条边的两端已经被访问过了，则抛弃这条边
            if( marked[e.v()] && marked[e.w()])
                continue;

            //否则这条边应该存在在最小生成树中
            mst.add(e);

            // 访问和这条边连接的还没有被访问过的节点
            if(!marked[e.v()])
                visit(e.v());
            else
                visit(e.w());
        }

        // 计算最小生成树的权值
        mstWeight = mst.elementAt(0).wt();
        for(int i=1; i < mst.size(); i++)
            mstWeight = mstWeight.doubleValue() + mst.elementAt(i).wt().doubleValue();
        }

    // 访问节点 v
    private void visit(int v) {
        assert !marked[v];

        marked[v] = true;
        for(Edge<Wight> e : G.adj(v)){
            if( !marked[e.other(v)] )  // 没有访问过这条边和 v 相连的另一个节点
                pq.insert(e);
        }
    }

    // 返回最小生成树的所有边
    public Vector<Edge<Wight>> mstEdges(){
        return mst;
    }

    // 返回最小生成树的权值
    public Number result(){
        return mstWeight;
    }
}
