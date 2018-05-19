package com.ccyang._04_Heap.Heap;


/**
 * 
 * @author 杨Sir
 *
 * @param <Item>
 * 堆中元素可能会比较大小进行排序
 */
public class MaxHeap3<Item extends Comparable> {

	protected Item[] data;
	protected int count;
	protected int capacity;
	
	@SuppressWarnings("unchecked")
	public MaxHeap3(int capacity){
		//初始化堆，底层是数组，从1号位置开始存储元素
		data = (Item[])new Comparable[capacity+1];
		count = 0;
		this.capacity = capacity;
	}
	
	/**
	 * 通过 heapify过程创建堆

	 * 该构造堆的过程，时间复杂度为 O(n)
	 */
	@SuppressWarnings("unchecked")
	public MaxHeap3(Item[] arr) {
		
		int n = arr.length;
		data = (Item[]) new Comparable[n+1];
		capacity = n;
		
		for(int i=0; i<n; i++){
			data[i+1] = arr[i];
		}
		count = n;
		
		for(int i=count/2; i>=1; i--){
			shiftDown(i);
		}
	}
	
	/**
	 * 堆中元素个数
	 * @return
	 */
	public int size(){
		return count;
	}
	
	/**
	 * 堆中是否是空堆
	 * @param args
	 */
	public boolean isEmpty(){
		return count == 0;
	}
	
	/**
	 * 插入元素
	 * @param args
	 */
	public void insert(Item item){
		
		if(count+1 > capacity){
			System.out.println("堆容量已满");
		}
		
		data[++count] = item;
		shiftUp(count);
	}
	
	//获取堆顶元素
	public Item getMax(){
		if(count == 0)
			System.out.println("堆中没有元素");
		return data[1];
	}
	
	/**
	 * 取出最大的元素，即堆顶元素
	 */
	public Item extractMax(){
		if(count == 0 ){
			System.out.println("堆中没有元素");
		}
		Item item = data[1];
		swap(1,count);
		count--;
		shiftDown(1);
		
		return item;
	}
		
	//最大堆核心辅助函数
	@SuppressWarnings("unchecked")
	private void shiftDown(int i) {
		
		while(2*i <= count){
			int j = i * 2;
			if(j+1<=count && data[j+1].compareTo(data[j])>0)
				j++;
			if(data[j].compareTo(data[i]) <= 0) 
				break;
			swap(i,j);
			i = j;
		}
	}

	/**
	 * 最大堆核心辅助函数	
	 * @param count2
	 */
	@SuppressWarnings("unchecked")
	private void shiftUp(int k) {

		while(k>1 && data[k].compareTo(data[k/2]) > 0){
			swap(k, k/2);
			k/=2;
		}
	}

	private void swap(int i, int j) {
		Item t = data[i];
		data[i] = data[j];
		data[j] = t;
	}

	public static void main(String[] args) {

		MaxHeap3<Integer> maxHeap = new MaxHeap3<>(100);
		int N = 10;  //堆元素个数
		int M = 100;  //堆取值范围 [0,100)
		
		for(int i =0; i<N; i++){
			maxHeap.insert((int) (Math.random()*M));
		}
		
		//将数据通过 extractMax取出来，顺序应该是从大到小的
		Integer[] num = new Integer[N];
		for(int i=0; i<N; i++){
			num[i] = maxHeap.extractMax();
		}
		
		for(int i=0; i<N; i++){
			System.out.print(num[i]+ " ");
		}
	
	}

}
