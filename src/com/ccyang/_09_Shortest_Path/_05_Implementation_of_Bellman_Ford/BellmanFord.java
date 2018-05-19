package com.ccyang._09_Shortest_Path._05_Implementation_of_Bellman_Ford;

import java.util.Stack;
import java.util.Vector;

/**
 * BellmanFord 算法求图的最短路径 -- 单源最短路径 -- 适合于 有向图
 * 图中可以包含负权边，但是不能包含负权环。 可以判断出是否存在负权环
 * O(E*V) 时间复杂度
 */
public class BellmanFord<Weight extends Number & Comparable> {

    private WeightedGraph<Weight> G;  // 图的引用
    private int s;                    // 起始点
    private Number[] distTo;        // distTo[i] 存储从起点到节点 i 的最短路径长度
    private Edge<Weight>[] from;    // from[i] 用来记录最短路径中，到达节点 i 的边是哪一条，用来恢复整个最短路径

    private boolean hasNegativeCycle;  // 是否是 负权图

    // Constructor
    public BellmanFord( WeightedGraph graph , int s ){

        assert s >= 0 && s < graph.V();
        this.s = s;
        this.G = graph;

        distTo = new Number[G.V()];
        from = new Edge[G.V()];
        // 初始化所有的节点 s 都不可达，由 from[] 来表示
        for (int i=0; i < G.V(); i++)
            from[i] = null;

        // 设置 distTo[s] = 0; 并且让 from[s] 节点不为null， 表示节点s 可达，且距离为 0.0
        distTo[s] = 0.0;
        from[s] = new Edge<Weight>(s , s , (Weight) (Number)0.0);

        // Bellman - ford 过程
        // 进行 V-1 次循环，每一次循环求出从起点到其余所有点，最多使用pass步可达到的最短距离
        for(int pass=1 ; pass < G.V(); pass++){

            // 每次循环对所有边进行一编松弛操作
            // 遍历所有边的方式是先遍历一遍所有的顶点，然后遍历和所有顶点相邻的所有边
            for(int i=0; i < G.V(); i++){
                // 使用我们实现的邻边迭代器遍历和所有顶点相邻的所有边
                for(Object item : G.adj(i)) {
                    Edge<Weight> e = (Edge<Weight>) item;
                    // 对于每个边，首先判断 e-> v() 可达
                    // 之后看如果 e-> w()以前没有到达过，显然我们可以更新 distTo[e->w()]
                    // 或者e-> w() 之前到达过，但通过这个e 我们可以获得一个更短的距离，即可以进行一次松弛操作，我们也可以更新 distTo[e->w()]
                    if (from[e.v()] != null
                            && (from[e.w()] == null
                            || distTo[e.v()].doubleValue() + e.wt().doubleValue() < distTo[e.w()].doubleValue())){

                        distTo[e.w()] = distTo[e.v()].doubleValue() + e.wt().doubleValue();
                        from[e.w()] = e;
                    }
                }
            }
        }
        hasNegativeCycle = detectNegative();
    }

    // 判断图中是否有负权环
    private boolean detectNegative(){
        for (int i = 0; i < G.V(); i++) {
            for(Object item : G.adj(i)){
                Edge<Weight> e = (Edge<Weight>) item;
                if(from[e.v()] != null && distTo[e.v()].doubleValue() + e.wt().doubleValue() < distTo[e.w()].doubleValue())
                    return true;
            }
        }
        return false;
    }

    // 返回图中是否有负权环
    public boolean negativeCycle(){
        return hasNegativeCycle;
    }

    // 返回从 s点到 w点的最短路径长度
    public Number shortestPathTo(int w){
        assert w >= 0 && w < G.V();
        assert !hasNegativeCycle;
        assert hasPathTo(w);
        return distTo[w];
    }

    // 判断 点s 和点w 是否联通
    public boolean hasPathTo(int w) {
        assert w >= 0 && w < G.V();
        return from[w] != null;
    }

    // 寻找从s到w的最短路径, 将整个路径经过的边存放在vec中
    public Vector<Edge<Weight>> shortestPath(int w){
        assert w >= 0 && w < G.V();
        assert !hasNegativeCycle;
        assert hasPathTo(w);

        // 通过 from数组逆向找到 s -> w 的最短路径
        Stack<Edge<Weight>> stack = new Stack<>();
        Edge<Weight> e = from[w];
        while (e.v() != s){
            stack.push(e);
            e = from[e.v()];
        }
        stack.push(e);

        // 从栈中依次取出元素，获得顺序的从 s-> v 的路径
        Vector<Edge<Weight>> vec = new Vector<>();
        while(!stack.empty()){
            e = stack.pop();
            vec.add(e);
        }
        return vec;
    }

    // 打印出从s点到w点的路径
    void showPath(int w){
        assert( w >= 0 && w < G.V() );
        assert( !hasNegativeCycle );
        assert( hasPathTo(w) );

        Vector<Edge<Weight>> res = shortestPath(w);
        for( int i = 0 ; i < res.size() ; i ++ ){
            System.out.print(res.elementAt(i).v() + " -> ");
            if( i == res.size()-1 )
                System.out.println(res.elementAt(i).w());
        }
    }
}
