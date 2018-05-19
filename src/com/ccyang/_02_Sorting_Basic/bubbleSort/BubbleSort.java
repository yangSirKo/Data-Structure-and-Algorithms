package com.ccyang._02_Sorting_Basic.bubbleSort;

import java.util.Arrays;

import com.ccyang.util.SortUtil;

/**
 * 冒泡排序
 * @author 杨Sir
 */
public class BubbleSort {

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void sort(Comparable[] arr){
		
		//方式1
//		int n = arr.length;
//		for(int i=0; i<n; i++){
//			for(int j=0; j<n-i-1; j++){
//				if(arr[j].compareTo(arr[j+1])>0)
//					swap(arr,j,j+1);
//			}
//		}
	
		//方式2
		int n = arr.length;
		boolean swapped = false;
		
		do{
			swapped = false;
			for(int i=1; i<n; i++){
				if(arr[i-1].compareTo(arr[i])>0){
					swap(arr,i-1,i);
					swapped = true;
				}
			}
			//优化，每一次都不用管最后一个元素
			n--;
		}while(swapped);
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
