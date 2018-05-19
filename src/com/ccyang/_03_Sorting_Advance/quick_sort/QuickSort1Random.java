package com.ccyang._03_Sorting_Advance.quick_sort;

import java.util.Random;

import com.ccyang.util.SortUtil;

/**
 * 随机化快速排序法，是对普通快速排序的改进
 * 当数组近乎有序时，快速排序法会退化成为一个 O(n^2)级别的算法
 * 
 * 改进1：  当 r-l <= 15时，采用插入排序法
 * 
 * 改进2： 每次选取比较的元素不是第一个，而是从数组片段中随机找一个，这个快排的期望值就为 O(nlogn)级别，
 *       退化为O(n^2)的概率会非常低。
 *
 */
public class QuickSort1Random {
	
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

		Random random = new Random();
		//改进2
		swap(arr,l,random.nextInt(r-l+1)+l);
		
		Comparable v = arr[l];
		
		int j = l;
		//arr[l+1...j]< v ; arr[j+1...i) > v; i用的开区间，最后一个i指定arr[r]
		for(int i=l+1; i <= r; i++){
			
			//arr[i]>= v;位置不变
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
		
		//近乎有序，则使用了随机快排进行优化
//		Integer[] arr = SortUtil.generateNearlyOrderdArray(N, 10);
		
		//大量重复，在 QuickSort3中进行优化，否则会退化为 n^2 级别
//		Integer[] arr = SortUtil.creatArray(N, 0, 100);
		
		Integer[] arr = SortUtil.creatArray(N, 0, 1000000);
		SortUtil.testSort("com.ccyang._03_Sorting_Advance.quick.QuickSort1Random", arr);
	}
}
