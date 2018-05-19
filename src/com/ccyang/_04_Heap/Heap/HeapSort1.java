package com.atyang.Heap;

import java.util.Arrays;

import com.atyang.util.SortUtil;

/**
 * 使用堆进行排序
 * @author 杨Sir
 *
 */
public class HeapSort1{

	/**
	 * 对整个数组进行 HeapSort1排序，将数组元素依次insert到heap中，在依次取出来即完成了排序
	 * 无论是创建堆还是取出元素，时间复杂度都是 O(nlogn)
	 * 
	 * 整个堆排序的总体时间复杂度为 O(nlogn)
	 * @param arr
	 */
	public static void sort(Comparable[] arr){
		
		int n = arr.length;
		//创建一个堆对象
		MaxHeap3<Comparable> heap = new MaxHeap3<>(n);
		for(int i=0; i<n; i++){
			heap.insert(arr[i]);
		}
		
		//从大到小放入数组
//		for(int i=1; i<=n; i++){
//			arr[i] = heap.extractMax();
//			System.out.println(arr[i]);
//		}
		
		//从小到大
		for(int i=n; i>=1; i--){
			arr[i-1] = heap.extractMax();  //将堆的最大值在数组中从后往前放
		}
	}
	
	
	public static void main(String[] args) {
		
		int N = 1000000;
		Integer[] arr = SortUtil.creatArray(N, 0,1000000);
		SortUtil.testSort("com.atyang.Heap.HeapSort1", arr);
	}
	
	
}
