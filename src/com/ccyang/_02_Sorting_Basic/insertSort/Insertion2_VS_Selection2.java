package com.atyang.insertSort;

import java.util.Arrays;

import com.atyang.util.SortUtil;

/**
 * 优化后 插入排序和选择排序效率比较： 插入排序效率较好
 * 
 * 对于有序性强的数组，插入排序远远优于选择排序
 * 
 * Insertion2_PK_Selection2
 * 
 * @author 杨Sir
 */
public class Insertion2_VS_Selection2 {

	public static void main(String[] args) {

		int N = 20000;

		// 测试1，一般测试
		Integer[] arr1 = SortUtil.creatArray(N, 0, 100000);
		Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
		Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

		System.out.println("一般测试：");
		SortUtil.testSort("com.atyang.insertSort.InsertionSort2", arr1);
		SortUtil.testSort("com.atyang.selectionSort.SelectionSort2", arr2);
		SortUtil.testSort("com.atyang.selectionSort.SelectionSort3", arr3);

		System.out.println();

		// 测试2 有序性更强的测试
		Integer[] arr4 = SortUtil.creatArray(N, 0, 10);
		Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);
		Integer[] arr6 = Arrays.copyOf(arr1, arr1.length);

		System.out.println("有序性更强的测试：[0,3]");
		SortUtil.testSort("com.atyang.insertSort.InsertionSort2", arr4);
		SortUtil.testSort("com.atyang.selectionSort.SelectionSort2", arr5);
		SortUtil.testSort("com.atyang.selectionSort.SelectionSort3", arr6);

		System.out.println();

		// 测试2 有序性更强的测试
		Integer[] arr7 = SortUtil.generateNearlyOrderdArray(N, 100);
		Integer[] arr8 = Arrays.copyOf(arr1, arr1.length);
		Integer[] arr9 = Arrays.copyOf(arr1, arr1.length);

		System.out.println("测试近乎有序的数组：");
		SortUtil.testSort("com.atyang.insertSort.InsertionSort2", arr7);
		SortUtil.testSort("com.atyang.selectionSort.SelectionSort2", arr8);
		SortUtil.testSort("com.atyang.selectionSort.SelectionSort3", arr9);

		System.out.println();

	}

}
