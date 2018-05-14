package com.ccyang._05_BinarySearchTree._02_BinarySearchTree;

import org.junit.Test;

/**
 * 测试二分搜索树中的removeMin和removeMax
 */
public class TestDeleteNode {

    public static void main(String[] args) {

        BST<Integer, Integer> bst = new BST<Integer, Integer>();

        // 取n个取值范围在[0...m)的随机整数放进二分搜索树中
        int N = 100;
        int M = 100;
        for(int i = 0 ; i < N ; i ++){
            Integer key = new Integer((int)(Math.random()*M));
            // 为了后续测试方便,这里value值取和key值一样
            bst.insert(key, key);
        }
        // 注意, 由于随机生成的数据有重复, 所以bst中的数据数量大概率是小于n的

        // 测试 removeMin
        // 输出的元素应该是从小到大排列的
        System.out.println("Test removeMin: ");
        while( !bst.isEmpty() ){
            System.out.print("min: " + bst.minimum() + " , ");
            bst.removeMin();
            System.out.println("After removeMin, size = " + bst.size() );
        }
        System.out.println();


        for(int i = 0 ; i < N ; i ++){
            Integer key = new Integer((int)(Math.random()*M));
            // 为了后续测试方便,这里value值取和key值一样
            bst.insert(key, key);
        }
        // 注意, 由于随机生成的数据有重复, 所以bst中的数据数量大概率是小于n的

        // 测试 removeMax
        // 输出的元素应该是从大到小排列的
        System.out.println("Test removeMax: ");
        while( !bst.isEmpty() ){
            System.out.print("max: " + bst.maximum() + " , ");
            bst.removeMax();
            System.out.println("After removeMax, size = " + bst.size() );
        }
    }

    //测试删除最小值的逻辑
    @Test
    public void testRemoveMin(){

        BST<Integer,Integer> bst = new BST<>();
        bst.insert(10,10);
        bst.insert(6,6);
        bst.insert(9,9);
        bst.insert(7,7);
        bst.insert(8,8);
        bst.insert(11,11);

        bst.inOrder();
        System.out.println();

//        bst.removeMin();
//        bst.inOrder();

        bst.remove(8);
        bst.inOrder();

    }

    // 测试floor
    @Test
    public void testFloorAndCeil(){
        BST<Integer,Integer> bst = new BST<>();
        bst.insert(10,10);
        bst.insert(6,6);
        bst.insert(9,9);
        bst.insert(8,8);
        bst.insert(11,11);

        System.out.println(bst.floor(7));
        System.out.println(bst.ceil(7));

    }

}
