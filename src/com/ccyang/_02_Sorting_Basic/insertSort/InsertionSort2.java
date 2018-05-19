package com.ccyang._02_Sorting_Basic.insertSort;

import com.ccyang.util.SortUtil;

/**
 * 插入排序改进版  : 插入排序对于近乎有序的数组进行排序，时间复杂度可降到 O(n)
 * @author 杨Sir
 *
 */
public class InsertionSort2 {

	public static void sort(Comparable[] arr){
		int n = arr.length;
		for(int i=0; i<n; i++){
			
			//寻找arr[i]合适的插入位置

			//写法1
//			for(int j=i; j>0; j--){
//				if(arr[j-1].compareTo(arr[j]) > 0)
//					swap(arr,j-1,j);
//				else
//					break;
//			}
			
			//写法2
//			for(int j=i; j>0 && (arr[j-1].compareTo(arr[j])>0);j--){
//				swap(arr,j-1,j);
//			}
			
			//写法3
			Comparable t = arr[i];
			int j = i;
			for( ; j>0 && arr[j-1].compareTo(t)>0 ; j--)
				arr[j] = arr[j-1];
			
			arr[j] = t;
		}
	}
	
	
	public static void swap(Object[] arr, int i, int j) {
		Object t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	


	public static void main(String[] args) {

		int N = 20000;
		Integer[] arr = SortUtil.creatArray(N, 0, 100000);
		SortUtil.testSort("com.ccyang._02_Sorting_Basic.insertSort.InsertionSort2", arr);
	}

}
