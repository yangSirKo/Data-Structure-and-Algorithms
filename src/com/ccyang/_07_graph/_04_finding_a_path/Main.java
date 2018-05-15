package com.ccyang._07_graph._04_finding_a_path;

import com.ccyang._07_graph._03_DFSAndComponent.Components;

/**
 * 测试 ReadGraph
 */
public class Main {

    // 测试寻路算法
    public static void main(String[] args) throws Exception {

        String filename = ".\\src\\com\\ccyang\\_07_graph\\testG";
        SparseGraph g = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();
        System.out.println();

        Path path = new Path(g,0);
        System.out.println("Path from 0 to 6 : ");
        path.showPath(6);
    }
}
