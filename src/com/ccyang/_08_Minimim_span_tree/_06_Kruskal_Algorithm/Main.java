package com.ccyang._08_Minimim_span_tree._05_Prim;


public class Main {

    // 测试我们实现的两种Prim算法的性能差距
    // 这一节使用索引堆实现的Prim算法优于上一小节的Lazy Prim算法
    public static void main(String[] args) {

        String filename1 = ".\\src\\com\\ccyang\\_08_Minimim_span_tree\\testG1";
        int V1 = 8;

        String filename2 = ".\\src\\com\\ccyang\\_08_Minimim_span_tree\\testG2";
        int V2 = 250;

        String filename3 = ".\\src\\com\\ccyang\\_08_Minimim_span_tree\\testG3";
        int V3 = 1000;

        String filename4 = ".\\src\\com\\ccyang\\_08_Minimim_span_tree\\testG4";
        int V4 = 10000;

        // 文件读取
        SparseWeightedGraph<Double> g1 = new SparseWeightedGraph<>(V1, false);
        ReadWeightedGraph readGraph1 = new ReadWeightedGraph(g1, filename1);
        System.out.println( filename1 + " load successfully.");

        SparseWeightedGraph<Double> g2 = new SparseWeightedGraph<>(V2, false);
        ReadWeightedGraph readGraph2 = new ReadWeightedGraph(g2, filename2);
        System.out.println( filename2 + " load successfully.");

        SparseWeightedGraph<Double> g3 = new SparseWeightedGraph<>(V3, false);
        ReadWeightedGraph readGraph3 = new ReadWeightedGraph(g3, filename3);
        System.out.println( filename3 + " load successfully.");

        SparseWeightedGraph<Double> g4 = new SparseWeightedGraph<>(V4, false);
        ReadWeightedGraph readGraph4 = new ReadWeightedGraph(g4, filename4);
        System.out.println( filename4 + " load successfully.");

        System.out.println();

        long startTime, endTime;

        // Test Lazy Prim MST
        System.out.println("Test Lazy Prim MST:");

        startTime = System.currentTimeMillis();
        LazyPrimMST<Double> lazyPrimMST1 = new LazyPrimMST<>(g1);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G1: " + (endTime-startTime) + "ms.");

        startTime = System.currentTimeMillis();
        LazyPrimMST<Double> lazyPrimMST2 = new LazyPrimMST<>(g2);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G2: " + (endTime-startTime) + "ms.");

        startTime = System.currentTimeMillis();
        LazyPrimMST<Double> lazyPrimMST3 = new LazyPrimMST<>(g3);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G3: " + (endTime-startTime) + "ms.");

        startTime = System.currentTimeMillis();
        LazyPrimMST<Double> lazyPrimMST4 = new LazyPrimMST<>(g4);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G4: " + (endTime-startTime) + "ms.");

        System.out.println();

        // Test Prim MST
        System.out.println("Test Prim MST:");

        startTime = System.currentTimeMillis();
        PrimMST<Double> primMST1 = new PrimMST<>(g1);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G1: " + (endTime-startTime) + "ms.");

        startTime = System.currentTimeMillis();
        PrimMST<Double> primMST2 = new PrimMST<>(g2);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G2: " + (endTime-startTime) + "ms.");

        startTime = System.currentTimeMillis();
        PrimMST<Double> primMST3 = new PrimMST<>(g3);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G3: " + (endTime-startTime) + "ms.");

        startTime = System.currentTimeMillis();
        PrimMST<Double> primMST4 = new PrimMST<>(g4);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G4: " + (endTime-startTime) + "ms.");

        System.out.println();
    }
}
