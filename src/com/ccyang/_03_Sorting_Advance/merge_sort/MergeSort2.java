package com.ccyang._03_Sorting_Advance.merge_sort;

import java.util.Arrays;

import com.ccyang.util.SortUtil;

/**
 * 优化归并排序
 * @author 杨Sir
 *
 */
@SuppressWarnings({"unchecked" ,"rawtypes"})
public class MergeSort2 {
	
	public static void sort(Comparable[] arr){
		mergeSort(arr,0,arr.length-1);
	}
	

	//递归的使用归并排序，对arr[l,r]进行排序
	private static void mergeSort(Comparable[] arr, int l, int r) {
		
		if(l>=r){
			return ;
		}
		
		int mid = (l+r)/2;  
		mergeSort(arr,l,mid);
		mergeSort(arr,mid+1,r);
		
		// 优化1
		// 对于arr[mid] <= arr[mid+1]的情况,不进行merge
		// 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
		if(arr[mid].compareTo(arr[mid+1]) > 0)  
			merge(arr,l,mid,r);	
	}


	//对 arr[l,mid]和 arr[mid+1,r]进行归并
	private static void merge(Comparable[] arr, int l, int mid, int r) {
		
		//截取要排序的数组片段
		Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);
		
		int i=l, j=mid+1;
		for(int k=l; k<=r; k++){
			
			if(i>mid){
				arr[k] = aux[j-l];  j++;
			}else if(j>r){
				arr[k] = aux[i-l];  i++;
			}else if(aux[i-l].compareTo(aux[j-l])>0){
				arr[k] = aux[j-l];
				j++;
			}else {
				arr[k] = aux[i-l];
				i++;
			}
		}
	}

	public static void main(String[] args) {
		
		int N = 2000000;
		Integer[] arr = SortUtil.creatArray(N, 0, 100000);
//		Integer[] arr = {11,3,5,7,2,4,9,7,8,1};
		
		SortUtil.testSort("com.ccyang._03_Sorting_Advance.merge.MergeSort2", arr);
		Arrays.toString(arr);
	}
}
