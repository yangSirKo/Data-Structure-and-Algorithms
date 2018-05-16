package com.ccyang._08_Minimim_span_tree._03_Lazy_Prim;

import java.util.Vector;

public class Main {

    // 测试通过文件读取图的信息
    public static void main(String[] args) {

        String filename = ".\\src\\com\\ccyang\\_08_Minimim_span_tree\\testG1";
        int V = 8;

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<>(V, false);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

        // Test Lazy Prim MST
        System.out.println("Test Lazy Prim MST:");
        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<>(g);
        Vector<Edge<Double>> mst = lazyPrimMST.mstEdges();
        for( int i = 0 ; i < mst.size() ; i ++ )
            System.out.println(mst.elementAt(i));
        System.out.println("The MST weight is: " + lazyPrimMST.result());

        System.out.println();
    }
}
