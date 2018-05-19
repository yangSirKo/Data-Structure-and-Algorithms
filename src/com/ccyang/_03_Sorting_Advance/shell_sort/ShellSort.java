package com.ccyang._03_Sorting_Advance.shell;


import com.atyang.util.SortUtil;

/**
 * 希尔排序： 时间复杂度 O( log(n^(3/2)) ) 可以看做 log(n^2)
 * 选择、冒泡、插入、希尔这四种排序里性能最好的一个就是希尔排序
 * 
 * @author 杨Sir
 *
 */
public class ShellSort {

	private ShellSort() {	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void sort(Comparable[] arr){
		
		int n = arr.length;
		//计算 increment sequence：1,4,13,40,121,364...
		int h = 1;
		while(h<n/3)
			h = 3*h+1;    //计算第一次排序元素间的间隔
		
		while(h>=1){
			
			for(int i=h; i<n; i++){
				
				//对 arr[i],arr[i-h],arr[i-2*h]...做插入排序
				Comparable t = arr[i];
				int j;
				for(j=i; j>=h && arr[j-h].compareTo(t)>0 ; j-=h)
						arr[j] = arr[j-h];
				arr[j] = t;
			}
			h = h/3;
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
//		Integer[] arr = {10,9,8,3,5,6,2,1,11,21,4,33,12,13,9,8,3,5,6,2,1,11,21,4,33,12,5};
		
		SortUtil.testSort("com.atyang.shell.ShellSort", arr);
//		System.out.println(Arrays.toString(arr));
		
	}
	
}
