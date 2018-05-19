/**
 * @author :yangSir
 * date: 2018年3月19日
 * context: 
 */
package com.ccyang._02_Sorting_Basic.selectionSort;

import java.util.Arrays;

/**
 * @author 杨Sir
 * 选择排序 , 时间复杂度：O(n^2)
 */
public class SelectionSort {

	//私有化构造函数
	private SelectionSort() {}
	/**
	 * 排序
	 * @param arr
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void sort(Comparable[] arr) {
		
		int n = arr.length;
		for(int i=0; i<n; i++){
			
			int minIndex = i;
			//寻找 arr[i,n)最小值的索引
			for(int j=i+1; j<n;j++){
				if((arr[minIndex].compareTo(arr[j])>0))
					minIndex = j;
			}
			swap(arr, i, minIndex);
		}
		
	}
	/**
	 * 交换元素位置
	 * @param arr
	 * @param i
	 * @param minIndex
	 */
	private static void swap(Object[] arr, int i, int minIndex) {
		Object t = arr[i];
		arr[i] = arr[minIndex];
		arr[minIndex] = t;
	}

	public static void main(String[] args) {
		
		//测试Integer
		Integer[] intArr = {10,9,8,7,6,5,4,3,2,1};
		SelectionSort.sort(intArr);
		System.out.println(Arrays.toString(intArr));
	
		//测试Double
		Double[] douArr = {10.1,9.3,8.4,7.2,6.6,5.7};
		SelectionSort.sort(douArr);
		System.out.println(Arrays.toString(douArr));
		
		//测试String
		String[] strArr = {"ali","meituan","baidu","jingdong"};
		SelectionSort.sort(strArr);
		System.out.println(Arrays.toString(strArr));

		//测试自定义对象排序
		Student[] stuArr = new Student[5];
		stuArr[0] = new Student("zhangsan",14);
		stuArr[1] = new Student("lisi",12);
		stuArr[2] = new Student("wnagwu",12);
		stuArr[3] = new Student("jingdong",16);
		stuArr[4] = new Student("ali",18);
		sort(stuArr);
		System.out.println(Arrays.toString(stuArr));
		
	}

}
