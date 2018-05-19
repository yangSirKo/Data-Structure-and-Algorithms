package com.ccyang._02_Sorting_Basic.selectionSort;

import com.ccyang.util.SortUtil;

public class SelectionSort2 {

	private SelectionSort2() { }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void sort(Comparable[] arr){
		int n = arr.length;
		for(int i = 0; i < n; i++){
			
			int minIndex = i;
			for(int j = i+1; j < n; j++){
				if( arr[minIndex].compareTo( arr[j]) > 0)
					minIndex = j;
			}
			swap(arr,minIndex,i);
		}
	}
	
	private static void swap(Object[] arr, int minIndex, int i) {

		Object t = arr[minIndex];
		arr[minIndex] = arr[i];
		arr[i] = t;
	}

	public static void main(String[] args) {
		
		int N = 20000;
		//创建长度为 20000的数组
		Integer[] arr = SortUtil.creatArray(N, 0, 100000);
		
		SortUtil.testSort("com.ccyang._02_Sorting_Basic.selectionSort.SelectionSort2", arr);
	}
}
