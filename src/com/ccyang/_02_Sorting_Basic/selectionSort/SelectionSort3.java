package com.ccyang._02_Sorting_Basic.selectionSort;


import com.ccyang.util.SortUtil;

/**
 * 优化选择排序
 * 在每一轮中可以找出当前未处理元素中的最小值和最大值
 *
 */
public class SelectionSort3 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void sort(Comparable[] arr){
		
		int left=0, right=arr.length-1;
		while(left<right){
			
			int minIndex = left;
			int maxIndex = right;
			
			//在每一轮的查找中，要保证arr[minIndex] <= arr[maxIndex]
			if(arr[minIndex].compareTo(arr[maxIndex])>0)
				swap(arr,minIndex,maxIndex);
				
			for(int i=left+1; i<right; i++)
				if(arr[i].compareTo(arr[minIndex]) < 0)   //arr[i] < arr[minIndex]
					minIndex = i;
				else if(arr[i].compareTo(arr[maxIndex]) > 0)
					maxIndex = i;
			
			swap(arr,left,minIndex);
			swap(arr,right,maxIndex);
			
			left++;
			right--;

		}
	}
	
	public static void swap(Object[] arr, int i, int j){
		Object t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	public static void main(String[] args) {

		int N = 20000;

		Integer[] arr = SortUtil.creatArray(N, 0, 100000);
		
		SortUtil.testSort("com.ccyang._02_Sorting_Basic.selectionSort.SelectionSort3", arr);
	}

}
