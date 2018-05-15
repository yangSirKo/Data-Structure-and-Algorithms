package com.ccyang._07_graph._05_BFS_and_Shortest_path;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class ShortestPath {

    private Graph G;   // 图的引用
    private int s;     // 起始点
    private boolean[] visited;  // 记录dfs的过程中节点是否被访问
    private int[] from;         // 记录路径, from[i]表示查找的路径上i的上一个节点
    private int[] ord;          // 记录路径中节点的次序。ord[i]表示i节点在路径中的次序。

    // 构造函数, 寻路算法, 寻找图graph从s点到其他点的路径
    public ShortestPath(Graph graph, int s) throws Exception {

        // 算法初始化
        G = graph;
        assert s >= 0 && s < G.V();

        visited = new boolean[G.V()];
        from = new int[G.V()];
        ord = new int[G.V()];
        for( int i = 0 ; i < G.V() ; i ++ ){
            visited[i] = false;
            from[i] = -1;
            ord[i] = -1;
        }
        this.s = s;

        // 无向图无权图最短路径算法，从 s 开始广度优先遍历整张图
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        ord[s] = 0;

        while(!queue.isEmpty()) {
            int v = queue.remove();
            for(int i : graph.adj(v))
                if( !visited[i]) {
                    queue.add(i);
                    from[i] = v;
                    visited[i] = true;
                    ord[i] = ord[v] + 1;
                }
        }
    }

    // 查询从s点到w点是否有路径
    public boolean hasPath(int w) throws Exception {
        if(!(w >= 0 && w < G.V()))
            throw new Exception("节点"+ w +"不存在");

        return visited[w];
    }

    // 查询从s点到w点的路径, 存放在vec中
    public Vector<Integer> path(int w) throws Exception {

        assert hasPath(w) ;

        Stack<Integer> stack = new Stack<>();

        int p = w;
        // 通过from数组逆向查找到从s到w的路径, 存放到栈中
        while (p != -1){
            stack.push(p);
            p = from[p];
        }

        // 从栈中依次取出元素, 获得顺序的从s到w的路径
        Vector<Integer> vec = new Vector<>();
        while (!stack.empty())
            vec.add(stack.pop());

        return vec;
    }

    // 打印出从s点到w点的路径
    public void showPath(int w) throws Exception {
        assert hasPath(w) ;

        Vector<Integer> vec = path(w);
        for(int i=0; i<vec.size(); i++){
            System.out.print(vec.elementAt(i));
            if( i ==  vec.size() - 1 )
                System.out.println();
            else
                System.out.print(" -> ");
        }
    }

    // 查看从s点到w点的最短路径长度
    // 若从s到w不可达，返回-1
    public int length(int w){
        assert w >= 0 && w < G.V();

        return ord[w];
    }
}
