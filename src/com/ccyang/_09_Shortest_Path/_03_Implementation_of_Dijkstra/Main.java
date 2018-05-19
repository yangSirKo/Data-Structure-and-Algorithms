package com.ccyang._09_Shortest_Path._03_Implementation_of_Dijkstra;
import com.ccyang._08_Minimim_span_tree._06_Kruskal_Algorithm.KruskalMST;
import com.ccyang._08_Minimim_span_tree._06_Kruskal_Algorithm.LazyPrimMST;
import com.ccyang._08_Minimim_span_tree._06_Kruskal_Algorithm.PrimMST;

/**
 * 测试 Dijkstra 最短路径算法
 */
public class Main {

    public static void main(String[] args) {
        String fileName = ".\\src\\com\\ccyang\\_09_Shortest_Path\\testG1";
        int V = 5;

        SparseWeightedGraph<Integer> g = new SparseWeightedGraph<>(V, true);
        // Dijkstra 最短路径算法同样适合有向图
        // SparseGraph<int> g = SparseGraph<int>(V, false);

        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, fileName);
        System.out.println("Test Dijkstra:\n");

        Dijkstra dij = new Dijkstra(g,0);
        for(int i=0; i<V; i++){
            if(dij.hasPathTo(i)){
                System.out.println("Shortest Path to " + i + " : " + dij.shortestPathTo(i));
                dij.showPath(i);
            }
            else
                System.out.println("No Path to " + i );

            System.out.println("----------");
        }
    }
}
