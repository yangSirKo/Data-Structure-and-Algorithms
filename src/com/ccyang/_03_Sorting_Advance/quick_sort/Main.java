package com.ccyang._03_Sorting_Advance.quick_sort;

import java.util.Arrays;

import com.ccyang.util.SortUtil;

public class Main {

	public static void main(String[] args) {

		int N = 100000;
		
		//测试1，一般测试
		Integer[] arr1 = SortUtil.creatArray(N, 0, 100000);
		Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
		Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
		Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
		
		System.out.println("一般测试：");
		SortUtil.testSort("com.ccyang._03_Sorting_Advance.merge.MergeSort2", arr1);
		SortUtil.testSort("com.ccyang._03_Sorting_Advance.quick.QuickSort1Random", arr2);
		SortUtil.testSort("com.ccyang._03_Sorting_Advance.quick.QuickSort2Ways", arr3);
		SortUtil.testSort("com.ccyang._03_Sorting_Advance.quick.QuickSort3Ways", arr4);
		
		System.out.println();

		//测试2 有序性更强的测试,重复元素多
		Integer[] arr5 = SortUtil.creatArray(N, 0, 10);
		Integer[] arr6 = Arrays.copyOf(arr1, arr1.length);
		Integer[] arr7 = Arrays.copyOf(arr1, arr1.length);
		Integer[] arr8 = Arrays.copyOf(arr1, arr1.length);
		
		System.out.println("有序性更强的测试：[0,3]");
		SortUtil.testSort("com.ccyang._03_Sorting_Advance.merge.MergeSort2", arr5);
		SortUtil.testSort("com.ccyang._03_Sorting_Advance.quick.QuickSort1Random", arr6);
		SortUtil.testSort("com.ccyang._03_Sorting_Advance.quick.QuickSort2Ways", arr7);
		SortUtil.testSort("com.ccyang._03_Sorting_Advance.quick.QuickSort3Ways", arr8);
		
		System.out.println();

		//测试2 有序性更强的测试
		Integer[] arr9 = SortUtil.generateNearlyOrderdArray(N, 100);
		Integer[] arr10 = Arrays.copyOf(arr1, arr1.length);
		Integer[] arr11 = Arrays.copyOf(arr1, arr1.length);
		Integer[] arr12 = Arrays.copyOf(arr1, arr1.length);
		
		System.out.println("测试近乎有序的数组：");
		SortUtil.testSort("com.ccyang._03_Sorting_Advance.merge.MergeSort2", arr9);
		SortUtil.testSort("com.ccyang._03_Sorting_Advance.quick.QuickSort1Random", arr10);
		SortUtil.testSort("com.ccyang._03_Sorting_Advance.quick.QuickSort2Ways", arr11);
		SortUtil.testSort("com.ccyang._03_Sorting_Advance.quick.QuickSort3Ways", arr12);
		
		System.out.println();
	}
}
