package com.ccyang._03_Sorting_Advance.merge_sort;

import java.util.Arrays;

import com.ccyang._02_Sorting_Basic.insertSort.InsertionSort;
import com.ccyang.util.SortUtil;
/**
 * 自底向上进行归并排序
 * @author 杨Sir
 *
 */
public class MergeSortBU {
	public static void sort(Comparable[] arr){
		
		int n = arr.length;


		// Merge Sort Bottom Up 无优化版本
        for (int sz = 1; sz < n; sz *= 2)
            for (int i = 0; i < n - sz; i += sz+sz)
                // 对 arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1] 进行归并
                merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1));

		// Merge Sort Bottom Up 优化
		// 对于小数组, 使用插入排序优化
//		for( int i = 0 ; i < n ; i += 16 )
//			InsertionSort.sort(arr, i, Math.min(i+15, n-1) );
//
//		for( int sz = 16; sz < n ; sz += sz )
//			for( int i = 0 ; i < n - sz ; i += sz+sz )
//				// 对于arr[mid] <= arr[mid+1]的情况,不进行merge
//				if( arr[i+sz-1].compareTo(arr[i+sz]) > 0 )
//					merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1) );


	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void merge(Comparable[] arr, int l, int mid, int r) {

		Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);
		
		int i=l, j=mid+1;
		for(int k=l; k <= r; k++){
			if(i>mid){
				arr[k] = aux[j-l]; 
				j++;
			}
			else if(j>r){
				arr[k] = aux[i-l]; 
				i++;
			}
			else if(aux[i-l].compareTo(aux[j-l]) > 0 ){
				arr[k] = aux[j-l];
				j++;
			}
			else{
				arr[k] = aux[i-l];
				i++;
			}
		}
	}

	public static void main(String[] args) {
		
		Integer N = 1000000;
//		Integer[] arr = {5,56,3,4,6,9,12,33};
		Integer[] arr = SortUtil.creatArray(N, 0, 1000000);
		
		SortUtil.testSort("com.ccyang._03_Sorting_Advance.merge.MergeSortBU", arr);
		Arrays.toString(arr);
	}
	
}
