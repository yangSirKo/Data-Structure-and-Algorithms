package com.ccyang._06_UnionFind.version1;

/**
 * 第一版的 Union-Find本质就是一个数组
 */
public class UnionFind1 {

    private int[] id;
    private int count;  // 数据个数

    public UnionFind1(int n){

        count = n;
        id = new int[n];
        // init , 每个id[i] 都指向自己，没有合并的元素
        for (int i = 0 ; i < n ; i++ ){
            id[i] = i;
        }
    }

    // 查找过程，查找元素 p 所对应的集合编号。
    // O(1)复杂度
    public int find(int p){
        assert p >= 0 && p < count;
        return id[p];
    }

    // 查看元素p和元素q是否所属一个集合
    // O(1)复杂度
    public boolean isConnected(int p, int q){
       return (find(p) == find(q));
    }


    // 合并元素p和元素q所属的集合
    // O(n) 复杂度
    public void unionElements(int p, int q){
        int pId = find(p);
        int qId = find(q);

        if(pId == qId)
            return ;

        // 合并过程需要遍历一遍所有元素，将两个元素的所属集合编号合并
        for(int i=0; i<count; i++){
            if ( id[i] == pId )
                id[i] = qId;   // 将 p 的 pId 变为 qId；
        }
    }

}
