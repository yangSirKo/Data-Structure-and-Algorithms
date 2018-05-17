package com.ccyang._08_Minimim_span_tree._05_Prim;

/**
 * 最小堆
 *
 * 使用泛型，需要比较元素大小，所以继承Comparable
 *
 */
public class MinHeap<Item extends Comparable> {

    private Item[] data;
    private int count;
    private int capacity;

    // Constructor, create a empty Heap, 可容纳 capacity个元素
    public MinHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];   // from index = 1 start store.
        this.count = 0;
        this.capacity = capacity;
    }

    // Constructor , 通过一个给定数组创建一个最小堆
    // 构造堆的时间复杂度：O(n)
    public MinHeap(Item[] arr) {

        int n = arr.length;
        this.capacity = n;
        data = (Item[]) new Comparable[n + 1];

        for (int i = 0; i < n; i++)
            data[i + 1] = arr[i];

        count = n;

        for (int i = count / 2; i >= 1; i--)
            shiftDown(i);
    }

    // 返回堆中元素
    public int size(){
        return count;
    }

    // 返回一个boolean, 堆中是否有元素
    public boolean isEmpty(){
        return count == 0;
    }

    // 向最小堆中插入一个新元素 item
    public void insert(Item t){
        assert count + 1 <= capacity;

        data[count+1] = t;
        count ++ ;
        shiftUp(count);
    }

    // 从最小堆中取出堆顶元素, 即堆中所存储的最小数据
    public Item extractMin(){

        assert count > 0;

        Item it = data[1];

        swap(1, count);
        count--;
        shiftDown(1);
        return it;
    }

    // 获取最小堆中的堆顶元素
    public Item getMin(){
        return data[1];
    }

    //------------------------------------
    // 最小堆核心辅助函数
    //------------------------------------

    // 小元素向上换
    private void shiftUp(int k) {

        while(k > 1 && data[k/2].compareTo(data[k]) > 0 ){
            swap(k, k/2);
            k /= 2;
        }
    }

    // 大元素向下swap
    private void shiftDown(int k) {

        while(2*k <= count){   // 表示 k 有左子节点

            int j = 2 * k;
            // 判断是否有右子节点，并且右子节点的值是否大于左子节点。
            if( j + 1 <= count && data[j+1].compareTo(data[j]) < 0)
                j++;

            if(data[k].compareTo(data[j]) < 0 )
                break;

            swap(k,j);
            k = j;
        }
    }

    // 交换 k, j 两个元素位置
    private void swap(int k , int j) {
        Item tmp = data[k];
        data[k] = data[j];
        data[j] = tmp;
    }

    // 测试 MinHeap
    public static void main(String[] args) {

        MinHeap<Integer> minHeap = new MinHeap<>(100);
        int N = 100; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for( int i = 0 ; i < N ; i ++ )
            minHeap.insert( new Integer((int)(Math.random() * M)) );

        Integer[] arr = new Integer[N];
        // 将minheap中的数据逐渐使用extractMin取出来
        // 取出来的顺序应该是按照从小到大的顺序取出来的
        for( int i = 0 ; i < N ; i ++ ){
            arr[i] = minHeap.extractMin();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从小到大排列的
        for( int i = 1 ; i < N ; i ++ )
            assert arr[i-1] <= arr[i];
    }


}

