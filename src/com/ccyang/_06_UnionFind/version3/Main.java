package com.ccyang._06_UnionFind.version2;


/**
 * 测试 UF1 & UF2
 */
public class Main {

    public static void main(String[] args) {

        // 测试数据规模
        int n = 10000;

        // 虽然 isConnected 时间复杂度为 O(1), 但是 union 时间复杂度为 O(n)
        // 所以整体时间复杂度为 O(n^2).  // n 次 union操作
        UnionFindTestHelper.testUF1(n);

        // 对于UF2来说, 其时间性能是O(n*h)的, h为并查集表达的树的最大高度
        // 这里严格来讲, h和log(n)没有关系, 不过大家可以简单这么理解
        // 后续会对h进行优化, 总体而言, 这个h是远小于n的
        // 所以我们实现的UF2测试结果远远好于UF1, n越大越明显:)
        UnionFindTestHelper.testUF2(n);
    }
}
