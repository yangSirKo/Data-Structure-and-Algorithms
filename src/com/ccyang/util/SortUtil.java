/**
 * @author :yangSir
 * date: 2018年3月14日
 * context: 
 */
package com.ccyang.util;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * @author 杨Sir
 * 产生需要排序的数组
 */
public class SortUtil {
	
	//生成长度为length的数组，数组中元素为随机数，范围是[rangeL, rangeR]
	public static Integer[] creatArray(int length,int rangeL, int rangeR){

		if(rangeL > rangeR){
			System.out.println("数组范围输入错误");
			return null;
		}
		
		Integer[] arr = new Integer[length];
		Random random = new Random(System.currentTimeMillis());
		
		for(int i=0; i<length; i++ )
			arr[i] = (random.nextInt(rangeR - rangeL + 1)) + rangeL;

		return arr;
	}
	
	/**
	 * 生成一个近乎有序的数组
	 * 首先生成一个 [0,n-1]的完全有序数组，之后随机交换 swapTimes对数据
	 * swapTimes定义了数组的无序程度
	 * swapTimes越大，数组越无序
	 * swapTimes等于0，数组完全有序
	 */
	public static Integer[] generateNearlyOrderdArray(int n,int swapTimes){

		Integer[] arr = new Integer[n];
		for(int i=0; i<n; i++)
			arr[i] = i;
		
		for(int i=0; i<swapTimes; i++){
			int a = (int) (Math.random()*n);
			int b = (int) (Math.random()*n);
			int t = arr[a];
			arr[a] = arr[b];
			arr[b] = t;
		}
		
		return arr; 
	}
	
	//打印数组所有内容
	public static void printArray(Integer[] arr){
		for(Integer i : arr){
			System.out.println(arr[i]+" ");
		}
		System.out.println();
	}
	
	//判断数组是否有序
	public static Boolean isSorted(Integer[] arr){
		int n = arr.length;
		for(int i=0; i<n-1; i++){
			if((arr[i].compareTo(arr[i+1]) > 0)){
				return false;
			}
		}
		return true;
	}
	
	// 测试sortClassName所对应的排序算法 排序arr数组所得到结果的正确性和算法运行时间
	@SuppressWarnings("rawtypes")
	public static void testSort(String sortClassName, Comparable[] arr){
		//通过反射机制，根据sortClassName调用排序算法进行排序
		try{
			Class sortClass = Class.forName(sortClassName);
			
			@SuppressWarnings("unchecked")
			//通过排序函数的Class对象获得排序方法	
			Method sortMethod = sortClass.getMethod("sort", Comparable[].class);
			//排序参数 arr
			Object[] param = new Object[]{arr};
			
			long startTime = System.currentTimeMillis();
			//调用排序函数
			sortMethod.invoke(null, param[0]);
			long endTime = System.currentTimeMillis();
			if(!(isSorted((Integer[]) arr))){
				System.out.println("数组不是完全有序！");
			}
			
			System.out.println(sortClass.getSimpleName()+" : "+ (endTime - startTime)+"ms");
			
		}catch(Exception e){
			System.out.println(e.getStackTrace());
			System.out.println("反射这里出错");
		}
		
		
		
	}
	
	
}










