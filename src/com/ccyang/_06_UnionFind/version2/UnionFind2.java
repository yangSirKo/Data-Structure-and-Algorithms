package com.ccyang._06_UnionFind.version2;

/**
 * 第二版的 Union-Find
 */
public class UnionFind2 {

    // 第二版的 Union-Find, 使用一个数组构建一棵指向父节点的树
    private int[] parent;
    private int count;   // 数据个数

    public UnionFind2(int n){
        count = n;
        parent = new int[n];

        // 初始化，每一个 parent[i] 都指向它自己
        for (int i = 0; i < n; i++ ){
            parent[i] = i;
        }
    }

    // 查找元素 p 所对应的集合编号
    // 时间复杂度是 O(h)，h 为树的高度
    public int find(int p){

        assert count > p && p >= 0;

        // 不断的去查找父节点，直到找到根节点
        // 根节点的标志： parent[p] = p
        while( parent[p] != p)
            p = parent[p];
        return p;
    }

    // 判断 元素p 和 元素q 是否属于一个集合
    // 时间复杂度 O(h), h 为树的高度
    public boolean isConnected(int p, int q){
        return (find(p) == find(q));
    }

    // 合并 元素p 和 元素q 所属的集合
    // 时间复杂度为 O(h), h 为树高
    public void unionElements(int p, int q){

        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot)
            return ;

        parent[p] = qRoot;  // p的根节点的parent值 指向 q的根节点的parent值
    }

}








