package com.ccyang._05_BinarySearchTree._02_BinarySearchTree;

public class TestBST {

    // 测试二分搜索树
    public static void main(String[] args) {

        int N = 1000000;

        // 创建一个数组，包含[0...N)的所有元素
        Integer[] arr = new Integer[N];
        for(int i = 0 ; i < N ; i ++)
            arr[i] = new Integer(i);

        // 打乱数组顺序
        for(int i = 0 ; i < N ; i ++){
            int pos = (int) (Math.random() * (i+1));
            Integer t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }

        // 由于我们实现的二分搜索树不是平衡二叉树，
        // 所以如果按照顺序插入一组数据，我们的二分搜索树会退化成为一个链表
        // 有时间查看资料自学红黑树的实现

        // 测试用的二分搜索树的键类型为Integer，值类型为String
        // 键值的对应关系为每个整型对应代表这个整型的字符串
        BST<Integer,String> bst = new BST();
        for (int i=0; i<N; i++)
            bst.insert(new Integer(arr[i]),Integer.toString(arr[i]));

        // 对 0...2N 的所有整型进行测试
        // 若i在[0...N)之间，则能查找到整型所对应的字符串
        // 若i在[N...2*N)之间，则结果为null
        for(int i=0; i < 2*N; i++){
            String str = bst.search(i);

            if(i < N){
                assert str.equals(Integer.toString(i));
            }else{
                assert str == null;
            }
        }
    }
}
