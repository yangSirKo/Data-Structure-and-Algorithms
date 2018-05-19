package com.ccyang._03_Sorting_Advance.merge_sort;

import java.util.Arrays;

import com.ccyang.util.SortUtil;
/**
 * 归并排序，时间复杂度：O( nlog(n) )
 * 
 * 归并排序是我学的第一个log(n)复杂度算法，。
 * 可以在 1秒之内处理 100万级数据。
 * 
 * 注意：不要轻易使用 selection，insertion，bubble，merge处理100万的数据，否则会很涨见识。
 * @author 杨Sir
 *
 */
public class MergeSort {

	private MergeSort() {	}

	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] arr){
		
		mergeSort(arr,0,arr.length-1);
		
	}
	
	//递归使用归并排序，对 arr[l,r]范围进行排序
	@SuppressWarnings({ "rawtypes" })
	private static void mergeSort(Comparable[] arr, int l, int r) {
		
		if(l>=r){
			return;
		}

		int mid = (l+r)/2;
		mergeSort(arr,l,mid);
		mergeSort(arr,mid+1,r);

		merge(arr,l,mid,r);
	}

	//将arr[1,mid] 和  arr[mid+1,r]进行排序
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void merge(Comparable[] arr, int l, int mid, int r) {

		//aux辅助空间中的值进行比较，插入到对应的arr的位置。
		Comparable[] aux = Arrays.copyOfRange(arr,l,r+1);

		// 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
		int i = l, j = mid+1;
		for(int k=l; k<=r ; k++){
			
			if(i> mid){  //如果左半部分元素已经全部处理完毕
				arr[k] = aux[j-l];
				j++;
			}
			else if(j > r){   //如果右半部分已经处理完毕
				arr[k] = aux[i-l];
				i++;
			}
			else if(aux[i-l].compareTo(aux[j-l]) >= 0){   //aux[i]值大于aux[j]，则将aux[j]赋给arr[k]，j++
				arr[k] = aux[j-l];
				j++;
			}
			else if(aux[i-l].compareTo(aux[j-l])< 0){  //aux[i]值小于等于aux[j]，则将aux[i]赋给arr[k]，i++
				arr[k] = aux[i-l];
				i++;
			}
		}
	}

	public static void main(String[] args) {
		
		int N = 2000000;
		
		Integer[] arr = SortUtil.creatArray(N, 0, 100000);
//		Integer[] arr = {11,3,5,7,2,4,9,7,8,1};
		
		SortUtil.testSort("com.ccyang._03_Sorting_Advance.merge.MergeSort", arr);
	}
}
