package com.atyang.quick;

import java.util.Random;

import com.atyang.util.SortUtil;

/**
 * 3路快排 处理 arr[l...r]， 处理重复键值的情况非常好。
 * 
 * 将 arr[l,r]分为： < V, = V, > V 三种情况。
 * 之后递归  < V 和 > V 两种情况。
 */
public class QuickSort3Ways {
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] arr){
		int n = arr.length;
		quickSort(arr,0,n-1);
	}
	
	//对 [l,r]部分进行快速排序
	@SuppressWarnings("rawtypes")
	private static void quickSort(Comparable[] arr, int l, int r) {

		if(r-l <= 15){
			insertSort(arr,l,r);
			return;
		}
		
		//partition
		swap(arr,l,(int) (Math.random()*(r-l+1)+l));
		Comparable v = arr[l];
		
		int lt = l; // arr[l+1...lt] < v
		int gt = r+1; // arr[gt...r] > v
		int i = l+1;  // arr[lt+1...i) == v
		
		while(i < gt){
			if(arr[i].compareTo(v) < 0){
				swap(arr,i,lt+1);
				i++;
				lt++;
			}else if(arr[i].compareTo(v) > 0){
				swap(arr,i,gt-1);
				gt--;
			}else{  //arr[i] == v
				i++;
			}
		}
		
		swap(arr,l,lt);
		
		quickSort(arr,l,lt-1);
		quickSort(arr,gt,r);
		
	}
	
	

	@SuppressWarnings({ "rawtypes", "unchecked", "rawtypes", "unchecked" })
	private static void insertSort(Comparable[] arr, int l, int r) {

		for(int i=l+1; i<=r; i++){
			Comparable t = arr[i];
			int j = i;
			for(; j>l && arr[j-1].compareTo(t) > 0; j--){
				arr[j] = arr[j-1];
			}
			arr[j] = t;
		}
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
		SortUtil.testSort("com.atyang.quick.QuickSort3", arr);
	}
}
