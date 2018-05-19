package com.ccyang._02_Sorting_Basic.bubbleSort;

import com.ccyang.util.SortUtil;

public class BubbleSort2 {

	private BubbleSort2() {}

	private static void sort(Comparable[] arr){
		
		int n = arr.length;
		int newn;
		
		do{
			newn = 0;
			for(int i=1; i<n; i++){
				if(arr[i-1].compareTo(arr[i]) > 0){
					swap(arr, i-1, i);
					
					//记录最后一次的交换位置，在此之后的元素下一轮扫描均不考虑
					newn = i;
				}
			}
			n = newn;
			
		}while(newn > 0);
	}
	
	
	public static void swap(Object[] arr, int i, int j){
		Object t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	
	public static void main(String[] args) {
		
		int N = 20000;

		Integer[] arr = SortUtil.creatArray(N, 0, 100000);
//		Integer[] arr = {10,9,8,3,5,6,2,1};
		
		SortUtil.testSort("com.ccyang._02_Sorting_Basic.bubble.BubbleSort", arr);
//		System.out.println(Arrays.toString(arr));
		
	}
}
