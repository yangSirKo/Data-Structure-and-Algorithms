package com.atyang.insertSort;

import java.util.Arrays;

import com.atyang.util.SortUtil;

/**
 * 插入排序的选择排序进行效率比较：此时插入排序可能性能略低
 * Insertion_PK_Selection2
 * 
 * @author 杨Sir
 */
public class Insertion_Selection2_PK {

	public static void main(String[] args) {
		
		int N = 20000;
		
		System.out.println("Test for random array , size = "+ N + " , random range[0 , "+ N +"]");
		Integer[] arr = SortUtil.creatArray(N, 0, N);
		Integer[] arr2 = Arrays.copyOf(arr,arr.length);
		
		SortUtil.testSort("com.atyang.insertSort.InsertionSort", arr);
		SortUtil.testSort("com.atyang.selectionSort.SelectionSort2", arr2);
	}
	//结果如下：
	//InsertionSort : 870ms
	//SelectionSort2 : 478ms
}
