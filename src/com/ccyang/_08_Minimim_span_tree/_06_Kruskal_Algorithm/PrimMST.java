package com.ccyang._08_Minimim_span_tree._06_Kruskal_Algorithm;

import java.util.Vector;

/**
 * 使用 优化后的 Prim算法求图的最小生成树-- 带权图，无向图
 */
public class PrimMST<Weight extends Number & Comparable> {

    private WeightedGraph G;  // 图的引用
    private IndexMinHeap<Weight> ipq;   // 最小索引堆，算法辅助数据结构
    private Edge<Weight>[] edgeTo;  // 访问的点所对应的边，算法辅助数据结构
    private boolean[] marked;  // 标记数组，算法运行过程中标记节点 i 是否被访问过
    private Vector<Edge<Weight>> mst;  // 最小生成树所包含的边
    private Number mstWeight;

    // 构造函数, 使用Prim算法求图的最小生成树
    public PrimMST(WeightedGraph graph){
        this.G = graph;

        assert (graph.E() > 0);
        ipq = new IndexMinHeap<>(graph.V());

        // 算法初始化
        marked = new boolean[G.V()];
        edgeTo = new Edge[G.V()];
        for( int i = 0 ; i < G.V() ; i ++ ){
            marked[i] = false;
            edgeTo[i] = null;
        }
        mst = new Vector<>();

        // Prim
        visit(0);

        while(!ipq.isEmpty()){
            // 使用最小索引堆找出已经访问过的权值最小的边，
            // 最小索引堆中存储的是点的索引，通过点的索引找出对应的边
            int v = ipq.extractIndexMin();
            assert (edgeTo[v] != null);
            mst.add(edgeTo[v]);
            visit(v);
        }

        // 计算最小生成树的权值
        mstWeight = mst.elementAt(0).wt().doubleValue();
        for(int i=1; i<mst.size(); i++)
            mstWeight = mstWeight.doubleValue() + mst.elementAt(i).wt().doubleValue();
    }

    // 访问节点 v
    private void visit(int v) {

        assert !marked[v];
        marked[v] = true;

        // 将和节点 v相连的未访问的另一端点，和与之相连的边，放入最小索引堆中
        for(Object item : G.adj(v)){

            Edge<Weight> e = (Edge<Weight>) item;
            int w = e.other(v);

            // 如果另一个端点未访问，
            if(!marked[w]){
                // 如果从没有考虑过这个端点，则将这个端点和与之相连的边加入最小索引堆
                if(edgeTo[w] == null){
                    edgeTo[w] = e;
                    ipq.insert(w , e.wt());
                }
                // 如果曾经考虑这个端点, 但现在的边比之前考虑的边更短, 则进行替换
                if(e.wt().compareTo(edgeTo[w].wt()) < 0) {
                    edgeTo[w] = e;
                    ipq.change(w, e.wt());
                }
            }
        }
    }

    /**
     * 返回最小生成树的所有边
     */
    public Vector<Edge<Weight>> mstEdges(){
        return mst;
    }

    /**
     * 返回最小生成树的权值
     */
    public Number result(){
        return mstWeight;
    }

    // 测试 Prim
    public static void main(String[] args) {

        String filename = ".\\src\\com\\ccyang\\_08_Minimim_span_tree\\testG1";
        int V = 8;

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<>(V, false);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

        // Test Prim MST
        System.out.println("Test Prim MST:");
        PrimMST<Double> primMST = new PrimMST<>(g);
        Vector<Edge<Double>> mst = primMST.mstEdges();
        for( int i = 0 ; i < mst.size() ; i ++ )
            System.out.println(mst.elementAt(i));
        System.out.println("The MST weight is: " + primMST.result());

        System.out.println();
    }
}







