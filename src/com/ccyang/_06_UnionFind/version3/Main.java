package com.ccyang._06_UnionFind.version3;

/**
 * 测试 UF1 & UF2
 */
public class Main {

    public static void main(String[] args) {

        // 测试数据规模
        int n = 1000000;

        // 虽然 isConnected 时间复杂度为 O(1), 但是 union 时间复杂度为 O(n)
        // 所以整体时间复杂度为 O(n^2).
//        UnionFindTestHelper.testUF1(n);   // 100000 级数据该方法太慢太慢

        // 对于UF2来说, 其时间性能是O(n*h)的, h为并查集表达的树的最大高度
        // 这里严格来讲, h和log(n)没有关系, 不过大家可以简单这么理解
        // 后续会对h进行优化, 总体而言, 这个h是远小于n的
        // 所以我们实现的UF2测试结果远远好于UF1, n越大越明显:)
        UnionFindTestHelper.testUF2(n);

        // 对于UF3来说, 其时间性能依然是O(n*h)的, h为并查集表达的树的最大高度
        // 但由于UF3能更高概率的保证树的平衡, 所以性能更优
        UnionFindTestHelper.testUF3(n);
    }
}
