package com.atyang.selectionSort;

import java.util.Arrays;

import com.atyang.util.SortUtil;

/**
 * 优化后 插入排序和选择排序效率比较： 
 * 插入排序效率较好
 * 
 * 对于有序性强的数组，插入排序远远优于选择排序
 * 
 * Insertion2_PK_Selection2
 * 
 * @author 杨Sir
 */
public class Insertion2_VS_Selection3 {


	public static void main(String[] args) {
		
		int N = 20000;
		
		//测试1，一般测试
		Integer[] arr1 = SortUtil.creatArray(N, 0, 100000);
		Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
		
		System.out.println("一般测试：");
		SortUtil.testSort("com.atyang.insertSort.InsertionSort2", arr1);
		SortUtil.testSort("com.atyang.selectionSort.SelectionSort2", arr2);
		
		System.out.println();

		//测试2 有序性更强的测试
		Integer[] arr3 = SortUtil.creatArray(N, 0, 10);
		Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
		
		System.out.println("有序性更强的测试：[0,3]");
		SortUtil.testSort("com.atyang.insertSort.InsertionSort2", arr3);
		SortUtil.testSort("com.atyang.selectionSort.SelectionSort2", arr4);
		
		System.out.println();

		//测试2 有序性更强的测试
		Integer[] arr5 = SortUtil.generateNearlyOrderdArray(N, 100);
		Integer[] arr6 = Arrays.copyOf(arr1, arr1.length);
		
		System.out.println("测试近乎有序的数组：");
		SortUtil.testSort("com.atyang.insertSort.InsertionSort2", arr5);
		SortUtil.testSort("com.atyang.selectionSort.SelectionSort2", arr6);
		
		System.out.println();

		
		
	}
	
	
}
