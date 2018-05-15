package com.ccyang._07_graph._04_finding_a_path;

import java.util.Stack;
import java.util.Vector;

public class Path {

    private Graph g;
    private int s;  // 起始点
    private boolean[] visited; // 记录dfs的过程中节点是否被访问
    private int[] from;  // 记录路径, from[i]表示查找的路径上i的上一个节点

    // 构造函数, 寻路算法, 寻找图graph从s点到其他点的路径
    public Path(Graph g ,int s) throws Exception {

        // 算法初始化
        this.g = g;
        if(!(s >= 0 && s < g.V()))
            throw new Exception( "点 " + s + " 不存在!");

        visited = new boolean[g.V()];
        from = new int[g.V()];
        for(int i=0; i < g.V(); i++){
            visited[i] = false;
            from[i] = -1;
        }
        this.s = s;

        // 寻路算法
        dfs(s);
    }

    // 图的深度优先遍历
    private void dfs(int v) throws Exception {
        visited[v] = true;
        for(int i : g.adj(v)){
            if(!visited[i]){
                from[i] = v;
                dfs(i);
            }
        }
    }

    // 查询从s点到w点是否有路径
    boolean hasPath(int w){
        assert w >= 0 && w < g.V();
        return visited[w];   // w 被访问，则意味着有路径
    }

    // 查询从s点到w点的路径, 存放在vec中
    public Vector<Integer> path(int w){
        assert hasPath(w);

        Stack<Integer> stack = new Stack<>();

        // 通过from数组逆向查找到从s到w的路径, 存放到栈中
        int p = w;
        while ( p != -1){
            stack.push(p);
            p = from[p];
        }

        // 从栈中取元素
        Vector<Integer> res = new Vector<>();
        while(!stack.empty())
            res.add(stack.pop());

        return res;
    }

    // 打印出从s点到w点的路径
    void showPath(int w){

        assert hasPath(w) ;

        Vector<Integer> vec = path(w);
        for( int i = 0 ; i < vec.size() ; i ++ ){
            System.out.print(vec.elementAt(i));
            if( i == vec.size() - 1 )
                System.out.println();
            else
                System.out.print(" -> ");
        }
    }
}
