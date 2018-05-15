package com.ccyang._07_graph._03_DFSAndComponent;


/**
 * 使用深度优先算法， 求无权图的联通分量
 */
public class Components {

    private Graph g;
    private boolean[] visited; // 记录节点是否访问过
    private int ccount;  // 联通分量个数
    private int[] id;  // 每个节点对应的联通分量标记

    public Components(Graph g) throws Exception {
        this.g = g;
        // 算法初始化
        ccount = 0;
        visited = new boolean[g.V()];
        id = new int[g.V()];
        for(int i=0; i < g.V(); i++){
            visited[i] = false;
            id[i] = -1;
        }

        // 求图的联通分量
        for(int i=0; i < g.V(); i++)
            if(!visited[i]){
                dfs(i);
                ccount ++;
            }
    }

    // 图的深度优先遍历
    private void dfs(int v) throws Exception {
        visited[v] = true;
        id[v] = ccount;
        for(int i : g.adj(v))
            if( !visited[i] ){
                dfs(i);
            }
    }

    /**
     * 返回联通分量的个数
     */
    public int count(){
        return ccount;
    }

    /**
     * 查询点 v 和 w 是否联通
     */
    public boolean isConnected(int v, int w){
        return id[v] == id[w];
    }


}
