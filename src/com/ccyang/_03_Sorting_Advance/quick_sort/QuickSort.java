package com.ccyang._03_Sorting_Advance.quick_sort;

import com.ccyang.util.SortUtil;

public class QuickSort {

	public static void sort(Comparable[] arr){
		int n = arr.length;
		quickSort(arr,0,n-1);
	}
	
	//对 [l,r]部分进行快速排序
	@SuppressWarnings("rawtypes")
	private static void quickSort(Comparable[] arr, int l, int r) {

		if(l>=r)
			return;
		
		int p = partition(arr,l,r);
		quickSort(arr,l,p-1);
		quickSort(arr,p+1,r);
		
	}
	
	// 对 arr[l,r] 部分进行 partition操作；
	// 返回 p; 使得 arr[l...p-1]<arr[p] 并且  arr[p+1]< arr[p+1...r]
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static int partition(Comparable[] arr, int l, int r) {

		Comparable v = arr[l];
		
		int j = l;
		//arr[l+1...j]< v ; arr[j+1...i) > v; i用的开区间，最后一个i指定arr[r]
		for(int i=l+1; i <= r; i++){
			
			//arr[i]> v;位置不变
			if(arr[i].compareTo(v) < 0){  //arr[i]小于 v, 交换 arr[j+1] 和 arr[i]
//				swap(arr,j+1,i);  j++;
				swap(arr,++j,i);
			}
		}
		swap(arr,l,j);
		return j;
	}

	@SuppressWarnings("rawtypes")
	private static void swap(Comparable[] arr, int i, int j) {
		Comparable t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	public static void main(String[] args) {
		
		int N = 1000000;
		
		Integer[] arr = SortUtil.creatArray(N, 0, 10000000);
		SortUtil.testSort("com.ccyang._03_Sorting_Advance.quick.QuickSort", arr);
	}
}
