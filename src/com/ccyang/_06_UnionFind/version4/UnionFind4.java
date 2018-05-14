package com.ccyang._06_UnionFind.version4;

/**
 * 第三版的 UnionFind
 *
 * 基于 rank的优化，建议使用 rank实现并查集
 */
public class UnionFind4 {

    private int[] parent;
    private int[] rank;
    private int count;

    public UnionFind4(int count) {
        this.count = count;
        parent = new int[count];
        rank = new int[count];

        // 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
        for(int i=0; i < count; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    // 查找过程, 查找元素p所对应的集合编号
    // O(h)复杂度, h为树的高度
    public int find(int p){
        assert count > p && p >= 0;

        while(p != parent[p])
            p = parent[p];
        return p;
    }

    // 查看元素p和元素q是否所属一个集合
    // O(h)复杂度, h为树的高度
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    // 合并元素p和元素q所属的集合
    // O(h)复杂度, h为树的高度
    public void unionElements(int p, int q){

        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
           return ;

        // 根据两个元素所在树的元素个数不同判断合并方向
        // 将元素个数少的集合合并到元素个数多的集合上
        if(rank[pRoot] < rank[qRoot])
            parent[pRoot] = qRoot;

        else if(rank[pRoot] > rank[qRoot])
            parent[qRoot] = pRoot;

        else{   rank[pRoot] = rank[qRoot]
            parent[pRoot] = qRoot;
            rank[qRoot] ++;
        }
    }
}
