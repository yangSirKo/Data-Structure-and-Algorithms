package com.ccyang._04_Heap;

/**
 * 
 * @author 杨Sir
 *
 * @param <Item>
 *            堆中元素可能会比较大小进行排序
 */
public class MaxHeap2<Item extends Comparable> {

	protected Item[] data;
	protected int count;
	protected int capacity;

	@SuppressWarnings("unchecked")
	public MaxHeap2(int capacity) {
		// 初始化堆，底层是数组，从1号位置开始存储元素
		data = (Item[]) new Comparable[capacity + 1];
		count = 0;
		this.capacity = capacity;
	}

	/**
	 * 堆中元素个数
	 * 
	 * @return
	 */
	public int size() {
		return count;
	}

	/**
	 * 堆中是否是空堆
	 * 
	 * @param args
	 */
	public boolean isEmpty() {
		return count == 0;
	}

	/**
	 * 插入元素
	 * 
	 * @param args
	 */
	public void insert(Item item) {

		if (count + 1 >= capacity) {
			System.out.println("堆容量已满");
		}

		data[++count] = item;
		shift(count);

	}

	/**
	 * 最大堆核心辅助函数
	 * 
	 * @param count2
	 */
	private void shift(int k) {

		while (k > 1 && data[k].compareTo(data[k / 2]) > 0) {
			swap(k, k / 2);
			k /= 2;
		}
	}

	private void swap(int i, int j) {
		Item t = data[i];
		data[i] = data[j];
		data[j] = t;
	}

	public static void main(String[] args) {

		MaxHeap2<Integer> maxHeap = new MaxHeap2<>(100);
		int N = 50; // 堆元素个数
		int M = 100; // 堆取值范围 [0,100)

		for (int i = 0; i < N; i++) {

			maxHeap.insert((int) (Math.random() * M));
		}
		System.out.println(maxHeap.size());

	}

}
