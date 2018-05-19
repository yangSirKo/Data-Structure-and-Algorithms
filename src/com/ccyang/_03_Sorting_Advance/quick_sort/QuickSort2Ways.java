package com.atyang.quick;

import java.util.Random;

import com.atyang.util.SortUtil;

/**
 * 2路排序
 *
 */
public class QuickSort2Ways {
	
	@SuppressWarnings("rawtypes")
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

		swap(arr,l,new Random().nextInt(r-l+1)+l);
		Comparable t = arr[l];
		
		// arr[l+1...i) <= v,  arr(j...r] >= v
		int i = l+1, j = r;
		while(true){
			// arr[i].compareTo(t) <= 0,会造成两颗子树不平衡
			while(i <= r && arr[i].compareTo(t) < 0) 
				i++;
			while(j >= l+1 && arr[j].compareTo(t) > 0)
				j--;
			if(i>j)
				break;
			swap(arr,i,j);
			i++;
			j--;
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
		
//		Integer[] arr = SortUtil.generateNearlyOrderdArray(N, 10);
		
//		Integer[] arr = SortUtil.creatArray(N, 0, 100);
		
		Integer[] arr = SortUtil.creatArray(N, 0, 1000000);
		SortUtil.testSort("com.atyang.quick.QuickSort2Ways", arr);
	}
}
