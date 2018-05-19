package com.ccyang._04_Heap;
/**
 * 最大堆
 * @author 杨Sir
 *
 */
public class MaxHeap<Item>{

	private Item[] data;
	
	//记录元素数量
	private int count;
	
	//构造函数，构造一个空堆，容量为capacity
	@SuppressWarnings("unchecked")
	public MaxHeap(int capacity){
		data = (Item[])new Object[ capacity + 1 ];   //数组从1号位置开始存储元素
		this.count = 0;
	}
	
	//返回堆中元素数量
	public int size(){
		return count;
	}
	
	//返回布尔值，确定堆是不是为空
	public boolean isEmpty(){
		return count==0;
	}
	
	//测试 MaxHeap
	public static void main(String[] args) {
		MaxHeap<Integer> maxHeap = new MaxHeap<>(100); 
		System.out.println(maxHeap.size());
	}
	
	
	
}
