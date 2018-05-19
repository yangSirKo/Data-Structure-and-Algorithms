package com.ccyang._09_Shortest_Path._05_Implementation_of_Bellman_Ford;
import com.ccyang._09_Shortest_Path._03_Implementation_of_Dijkstra.Dijkstra;

/**
 * 测试 Dijkstra 最短路径算法
 */
public class Main {

    // 测试我们的Bellman-Ford最短路径算法
    public static void main(String[] args) {

        String filename = ".\\src\\com\\ccyang\\_09_Shortest_Path\\testG2";
//        String filename = ".\\src\\com\\ccyang\\_09_Shortest_Path\\testG_negative_circle.txt";
        int V = 5;

        SparseWeightedGraph<Integer> g = new SparseWeightedGraph<Integer>(V, true);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

        System.out.println("Test Bellman-Ford:\n");

        int s = 0;
        BellmanFord<Integer> bellmanFord = new BellmanFord<Integer>(g, s);
        if( bellmanFord.negativeCycle() )  // 是否有 负权环
            System.out.println("The graph contain negative cycle!");
        else
            for( int i = 0 ; i < V ; i ++ ){
                if(i == s)
                    continue;

                if(bellmanFord.hasPathTo(i)) {
                    System.out.println("Shortest Path to " + i + " : " + bellmanFord.shortestPathTo(i));
                    bellmanFord.showPath(i);
                }
                else
                    System.out.println("No Path to " + i );

                System.out.println("----------");
            }

    }
}
