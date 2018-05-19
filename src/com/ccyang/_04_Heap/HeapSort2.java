package com.ccyang._04_Heap.Heap;

import java.util.Arrays;

import com.ccyang.util.SortUtil;

/**
 * 使用堆进行排序
 * @author 杨Sir
 *
 */
public class HeapSort2{

	/**
	 * 借住heapify创建堆，此时创建堆的时间复杂度为 O(n)，再依次取出来即完成了排序，取时间复杂度为O(nlogn)
	 * 
	 * 整个堆排序的总体时间复杂度为 O(nlogn),但是比 HeapSort1性能更优。
	 */
	public static void sort(Comparable[] arr){

		int n = arr.length;
		//创建堆
		MaxHeap3<Comparable> heap = new MaxHeap3<>(arr);
		
		//从小到大
		for(int i=n-1; i>=0; i--){
			arr[i] = heap.extractMax();  //将堆的最大值在数组中从后往前放
		}
	}
	
	
	public static void main(String[] args) {
		
		int N = 1000000;
		Integer[] arr = SortUtil.creatArray(N, 0,1000000);
		Integer[] arr2 = Arrays.copyOf(arr, arr.length);
		SortUtil.testSort("com.ccyang.Heap.HeapSort1", arr);
		SortUtil.testSort("com.ccyang.Heap.HeapSort2", arr2);
	}
	
	
}
