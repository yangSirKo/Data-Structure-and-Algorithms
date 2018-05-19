package com.ccyang._09_Shortest_Path._03_Implementation_of_Dijkstra;


import java.util.Stack;
import java.util.Vector;

/**
 * Dijkstra 算法求最短路径, 适用于有向图和无向图
 * 单源最短路径（指其他节点到根节点的路径都是最短的）
 * 需要求出任意两个节点的最短路径，一种办法是循环求V 次单源最短路径。
 * 局限性：不能有负权边
 */
public class Dijkstra<Weight extends Number & Comparable> {

    private WeightedGraph G;   // 图的引用
    private int s; // 起始点
    private Number[] distTo;    // distTo[i] 用来存储起始节点到 i 的最短路径长度
    private boolean[] marked;   // 标记数组，在算法执行过程中标记节点 i 是否被访问
    private Edge<Weight>[] from;   // from[i]记录最短路径中, 到达i点的边是哪一条,用来恢复整个最短路径

    // Constructor , 使用 Dijkstra 算法求最短路径
    public Dijkstra(WeightedGraph graph, int s){

        //算法初始化
        assert s >= 0 && s < G.V();
        this.s = s;
        this.G = graph;

        distTo = new Number[G.V()];
        marked = new boolean[G.V()];
        from = new Edge[G.V()];
        for (int i=0; i<G.V(); i++){
            distTo[i] = 0;
            marked[i] = false;
            from[i] = null;
        }

        // 使用索引堆记录当前找到的节点到达每个顶点的最短距离
        IndexMinHeap<Weight> ipq = new IndexMinHeap(G.V());

        // 初始化 s
        distTo[s] = 0.0;
        from[s] = new Edge(s,s,(Weight)(Number) (0.0));
        ipq.insert(s, (Weight) distTo[s]);
        marked[s] = true;
        while(!ipq.isEmpty()){

            int v = ipq.extractIndexMin();

            // distTo[v] 就是 s 到 v 的最短距离
            marked[v] = true;
            for(Object item : G.adj(v)){
                Edge<Weight> e = (Edge<Weight>) item;
                int w = e.other(v);
                // 如果 点s 到 w的最短路径没有找到
                if( !marked[w]){
                    // 如果 w点以前没有被访问过
                    // 或者被访问过，但是 通过当前节点 v 到 w 点的距离更短
                    if(from[w] == null || distTo[v].doubleValue() + e.wt().doubleValue() < distTo[w].doubleValue())
                        distTo[w] = distTo[v].doubleValue() + e.wt().doubleValue();
                        from[w] = e;
                        if(ipq.contain(w))
                            ipq.change(w, (Weight) distTo[w]);
                        else
                            ipq.insert(w, (Weight)distTo[w]);
                }
            }
        }
    }

    // 返回 s点到w点的最短路径
    public Number shortestPathTo(int w){
        assert w >= 0 && w < G.V();
        hasPathTo(w);
        return distTo[w];
    }

    // 判断 s点到 w点是否联通
    public boolean hasPathTo(int w){
        assert w >= 0 && w < G.V();
        return marked[w];
    }

    // 寻找从s到w的最短路径, 将整个路径经过的边存放在vec中
    public Vector<Edge<Weight>> shortestPath(int w){
        assert w >= 0 && w < G.V();
        hasPathTo(w);

        // 通过from[] 逆向查找 s 到 w 的路径，放到栈中
        Stack<Edge<Weight>> stack = new Stack<>();
        Edge<Weight> e = from[w];
        while(e.v() != s){
            stack.push(e);
            e = from[e.v()];
        }
        stack.push(e);

        // 从栈中取出元素，获得顺序的从 s 到 w 的路径
        Vector<Edge<Weight>> vector = new Vector<>();
        while(!stack.isEmpty()){
            vector.add(stack.pop());
        }
        return vector;
    }

    // 打印从 s 节点到 w节点 的路径
    public void showPath(int w){
        assert w >= 0 && w <G.V();
        hasPathTo(w);

        Vector<Edge<Weight>> path = shortestPath(w);
        for(int i=0; i<path.size(); i++){
            System.out.print(path.elementAt(i).v() + "->" );
            if(i == path.size() -1)
                System.out.println(path.elementAt(i).w());
        }
    }
}
