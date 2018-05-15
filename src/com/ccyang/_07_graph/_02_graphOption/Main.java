package com.ccyang._07_graph._02_graphOption;

/**
 * 测试 ReadGraph
 */
public class Main {

    public static void main(String[] args) throws Exception {

        // 使用两种图的形式存储 testG1
        String fileName = ".\\src\\com\\ccyang\\_07_graph\\testG1";

        SparseGraph sparseGraph = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(sparseGraph, fileName);
        System.out.println("test G1 in Sparse Graph ");
        sparseGraph.show();
        System.out.println();

        DenseGraph denseGraph = new DenseGraph(13, false);
        ReadGraph readGraph2 = new ReadGraph(denseGraph, fileName);
        System.out.println("test G1 in Dense Graph ");
        denseGraph.show();
        System.out.println();

        // 使用两种图的形式存储 testG2
        String fileName2 = ".\\src\\com\\ccyang\\_07_graph\\testG2";

        SparseGraph sparseGraph2 = new SparseGraph(6, false);
        ReadGraph readGraph3 = new ReadGraph(sparseGraph2, fileName2);
        System.out.println("test G2 in Sparse Graph ");
        sparseGraph2.show();
        System.out.println();

        DenseGraph denseGraph2 = new DenseGraph(6, false);
        ReadGraph readGraph4 = new ReadGraph(denseGraph2, fileName2);
        System.out.println("test G2 in Dense Graph ");
        denseGraph2.show();

    }
}
