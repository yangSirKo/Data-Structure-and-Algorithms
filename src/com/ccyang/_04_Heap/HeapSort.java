package com.ccyang._04_Heap.Heap;

import java.util.Arrays;

import com.ccyang.util.SortUtil;

/**
 * 原地堆排序: 不使用一个额外的堆，直接在数组上进行原地排序
 * 
 * @author 杨Sir
 *
 */
public class HeapSort {

	public static void sort(Comparable[] arr) {

		int n = arr.length;

		// 此时堆的索引从 0开始
		// 最后一个元素的索引也将成为 (n-1); 那么最后一个元素的父元素为((n-1)/2)),因为此堆从零开始
		// 将数组排列为最大堆的形式
		for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
			shiftDown2(arr, n, i);
		}
		
		//将堆转换为 从小到大排列的数组
		for(int i= n-1; i>=0; i--){
			swap(arr,i,0);  //将堆顶的元素放在数组的最后。  
			
			shiftDown2(arr,i,0);  //每轮对 arr的第0个元素进行 shiftDown操作，此时arr长度为  n-1
			
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void shiftDown1(Comparable[] arr,int n, int i) {

		while (2 * i + 1 < n) {
			int j = i * 2 + 1;
			if (j+1<n && arr[j].compareTo(arr[j + 1]) < 0)
				j++;
			if (arr[i].compareTo(arr[j]) <= 0)
				swap(arr, i, j);
			else
				break;
			i = j;
		}
	}

	//优化后的 shiftDown操作，和插入排序时的优化思想一致
	@SuppressWarnings("unchecked")
	private static void shiftDown2(Comparable[] arr, int n,int i) {
		
		Comparable it = arr[i];
		while(2*i+1<n){
			int j = 2*i+1;
			if(j+1 < n && arr[j].compareTo(arr[j+1])<0)
				j++;
			
			if(it.compareTo(arr[j]) > 0 )
				break;
			
			arr[i] = arr[j];
			i = j;
		}
		arr[i] = it;
	}

	private static void swap(Object[] arr, int i, int j) {
		Object t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	public static void main(String[] args) {

		int N = 1000000;
		Integer[] arr = SortUtil.creatArray(N, 0, 1000000);
		SortUtil.testSort("com.ccyang.Heap.HeapSort", arr);

	}
}
