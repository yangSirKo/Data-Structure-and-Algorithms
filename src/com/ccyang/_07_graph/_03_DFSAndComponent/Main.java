package com.ccyang._07_graph._03_DFSAndComponent;

/**
 * 测试 ReadGraph
 */
public class Main {

    public static void main(String[] args) throws Exception {

        // TestG1.txt
        String filename1 = ".\\src\\com\\ccyang\\_07_graph\\testG1";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename1);
        Components component1 = new Components(g1);
        System.out.println("TestG1.txt, Component Count: " + component1.count());
        System.out.println();

        // TestG2.txt
        String filename2 = ".\\src\\com\\ccyang\\_07_graph\\testG2";
        SparseGraph g2 = new SparseGraph(6, false);
        ReadGraph readGraph2 = new ReadGraph(g2, filename2);
        Components component2 = new Components(g2);
        System.out.println("TestG2.txt, Component Count: " + component2.count());

    }
}
