package com.ccyang._06_UnionFind.version1;

/**
 * 测试UF1
 */
public class Main {

    public static void main(String[] args) {

        // 测试数据规模
        int n = 10000;

        // 虽然 isConnected 时间复杂度为 O(1)
        // 但是 union 时间复杂度为 O(n)
        // 所以整体时间复杂度为 O(n^2).  // n 次 union操作
        UnionFindTestHelper.testUF1(n);
    }
}
