package com.atyang.Heap.indexHeap;

import java.util.Arrays;

/**
 * 优化后最大索引堆，元素从 1开始放
 * @author 杨Sir
 *
 * @param <Item>
 */
@SuppressWarnings("rawtypes")
public class MaxIndexHeap2<Item extends Comparable> {

	// 存放最大索引堆的元素
	protected Item[] data;
	// 存放最大索引堆中的索引,表征堆的数组，indexes[x]=i;表示索引i在x的位置
	protected int[] indexes;
	//最大索引堆的反向索引，reverse[i]=x;表示索引i在x的位置
	protected int[] reverse;
	// 堆容量
	protected int capacity;
	// 堆中元素数量, count==0时，表示无元素；count==1时，表示有一个元素
	protected int count;

	/**
	 * 构造一个空的 最大索引堆
	 * 
	 * @param capacity
	 *            ： 可以容纳的元素数量。 元素从数组下标为 1的地方开始存储
	 */
	@SuppressWarnings("unchecked")
	public MaxIndexHeap2(int capacity) {
		data = (Item[]) new Comparable[capacity + 1];
		indexes = new int[capacity + 1];
		reverse = new int[capacity + 1];
		for(int i=0;i<=capacity; i++){
			reverse[i]=0;
		}
		
		this.capacity = capacity;
		count = 0;
	}

	// 返回堆中的元素个数
	public int size() {
		return count;
	}

	// 返回堆是否为空堆
	public boolean isEmpty() {
		return count == 0;
	}

	/**
	 * 向最大索引堆中插入一个新元素，新元素索引为 i，元素为 item 传入的 i 对用户而言，是从索引0开始的。
	 * 
	 * @param i
	 * @param item
	 */
	public void insert(int i, Item item) {

		// 判断容量是否已满
		if (count + 1 > capacity) { // count+1 就是下个元素要存储的位置
			System.out.println("堆已满");
			return;
		}
		if (i + 1 < 1 && i + 1 > capacity) {
			System.out.println("索引下标越界");
		}
		i += 1;
		data[i] = item;
		indexes[count+1] = i; // 第 i 个元素，索引中就存放 i，，data[] 和 indexes[]均从1开始
		reverse[i] = count+1;
		count++;
		shiftUp(count);
	}

	/**
	 * 从最大索引堆中取出索引元素，即最大索引堆的堆顶元素。 取出就相当于删除了堆顶元素的值
	 * 
	 * @return
	 */
	public Item extractMax() {
		if (count == 0) {
			System.out.println("堆中无元素");
			return null;
		}

		Item item = data[indexes[1]]; // indexes 是堆的底层数据结构，堆的节点上存放的是 indexes[]
										// 中的值，indexes中的值和data中的值一一对应
		swapIndexes(count, 1);
		shiftDown(1);
		return item;
	}

	/**
	 * 从最大索引堆中取出堆顶元素的索引，extract即删除
	 * 
	 * @return
	 */
	public int extractMaxIndex() {

		if (count == 0) {
			System.out.println("堆中没有元素！");
			return -1;
		}

		int ret = indexes[1] - 1;
		swapIndexes(1, count);
		reverse[indexes[count]] = 0;
		count--;
		shiftDown(1);
		return ret;
	}

	/**
	 * 获取最大索引堆中的堆顶元素，即堆顶元素对应的data中的值
	 * 
	 * @return
	 */
	public Item getMax() {
		return data[indexes[1]];
	}

	/**
	 * 获取最大索引堆中堆顶元素的索引。 最大索引堆中堆顶元素值(索引值)不一定最大，但这个索引值对应的data中的值一定是最大的。
	 * 
	 * @return
	 */
	public int getMaxIndex() {
		if (count == 0) {
			System.out.println("堆中无元素");
			return -1;
		}
		// 对用户而言索引从0开始
		return indexes[1] - 1;
	}
		
	private boolean contain(int i){
		if (!(i + 1 >= 1 && i + 1 <= capacity)) {
			System.out.println("无法找到索引为 " + i + " 的元素");
			return false;
		}
		return reverse[i+1]!=0;
	}
	
	/**
	 * 获取最大索引堆中的索引为 i 的元素
	 * 
	 * @param i
	 * @return
	 */
	public Item getItem(int i) {
		if(contain(i)){
			
			return data[i + 1];
		}
		return null;
	}

	/**
	 * 将最大索引堆中的索引为 i 的元素改为 newData
	 * 
	 * @param i
	 * @param newData
	 */
	public void change(int i, Item newData) {
		i++;
		data[i] = newData;

		// 找到indexes[j] = i; j 表示data[i]在堆中的位置
		// 之后先进行 shiftUp(j),再进行 shiftDown(j)操作
//		for (int j = 1; j <= count; j++) {
//			if (indexes[j] == i) {
//				shiftUp(j);
//				shiftDown(j);
//			}
//		}
		
		// 有了 reverse 之后,
        // 我们可以非常简单的通过reverse直接定位索引i在indexes中的位置
		shiftUp(reverse[i]);
		shiftDown(reverse[i]);
	}

	// 交换索引堆中的索引i和j
    // 由于有了反向索引reverse数组，
    // indexes数组发生改变以后， 相应的就需要维护reverse数组
	private void swapIndexes(int i, int j) {
		int t = indexes[i];
		indexes[i] = indexes[j];
		indexes[j] = t;
		
		reverse[indexes[i]] = i;
		reverse[indexes[j]] = j;
	}

	// -------------------------
	// 最大索引堆核心辅助函数
	// -------------------------
	@SuppressWarnings("unchecked")
	// 索引堆中，数据之间的比较 根据data的大小进行，但实际操作的是索引
	private void shiftUp(int k) {

		while (k > 1 && data[indexes[k]].compareTo(data[indexes[k / 2]]) > 0) {
			swapIndexes(k, k / 2); // 交换索引
		}
	}

	// 索引堆中，数据之间的比较是 根据data进行，但实际进行操作的是索引
	@SuppressWarnings("unchecked")
	private void shiftDown(int k) {

		while (2 * k <= count) {

			int j = 2 * k;
			if (j + 1 <= count
					&& data[indexes[j]].compareTo(data[indexes[j + 1]]) < 0)
				j++;

			if (data[indexes[k]].compareTo(data[indexes[j]]) > 0)
				break;

			swapIndexes(k, j);
			k = j;
		}

	}

	// 测试 MaxIndexHeap
	public static void main(String[] args) {

		int N = 1000000;
		MaxIndexHeap2<Integer> indexMaxHeap = new MaxIndexHeap2<Integer>(N);
		for (int i = 0; i < N; i++)
			indexMaxHeap.insert(i, (int) (Math.random() * N));
		assert indexMaxHeap.testIndexes();
		System.out.println("调试OK");
	}

	// 测试索引堆中的数组index
	// 注意：这个测试是在向堆中插入元素以后，不进行extract有效。即不能删除某一个元素
	private boolean testIndexes() {

		int[] copyIndex = new int[count + 1];

		for (int i = 0; i <= count; i++)
			copyIndex[i] = indexes[i];
		copyIndex[0] = 0;

		Arrays.sort(copyIndex);

		// 在对索引堆中索引进行排序之后，应该正好是 1...count 这count个索引
		boolean res = true;
		for (int i = 1; i <= count; i++) {

			if (copyIndex[i - 1] + 1 != copyIndex[i]) {  //判断 count是否是依次递增。如果是：1,2,3,4....count，则 if条件判断不成立
				res = false;
				break;
			}
		}
		if(!res){
			System.out.println("Error");
			return false;
		}
		return true;
	}
}
