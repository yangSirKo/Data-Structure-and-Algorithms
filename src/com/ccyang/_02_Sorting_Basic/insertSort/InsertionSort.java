package com.ccyang._02_Sorting_Basic.insertSort;

import com.ccyang.util.SortUtil;
/**
 * 插入排序，时间复杂度：O(n^2)
 * @author 杨Sir
 *
 */
public class InsertionSort {

	private InsertionSort() {	}
	
	public static void sort(Comparable[] arr){
		int n = arr.length;
		for(int i=0; i<n; i++){
			
			//寻找元素 arr[i]插入的位置
			
			//写法1
//			for(int j=i; j>0; j--){
//				if(arr[j].compareTo( arr[j-1]) < 0)
//					swap(arr,j,j-1);
//			}
			
			//写法2
			for(int j=i; j>0 && (arr[j-1].compareTo(arr[j])>0); j--){
				swap(arr,j,j-1);
			}
			
		}
	}
	
	private static void swap(Object[] arr, int i, int j) {
		Object t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	public static void main(String[] args) {
	
		int N = 20000;
		Integer[] arr = SortUtil.creatArray(N, 0, 100000);
		SortUtil.testSort("com.ccyang._02_Sorting_Basic.insertSort.InsertionSort", arr);
	}
	
}
