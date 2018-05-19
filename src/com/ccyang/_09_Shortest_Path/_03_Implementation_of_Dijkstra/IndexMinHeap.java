package com.ccyang._08_Minimim_span_tree._06_Kruskal_Algorithm;

/**
 * 最小索引堆
 */
public class IndexMinHeap<Item extends Comparable> {

    private Item[] data;  // 最小索引堆中的数据
    private int[] indexes;  // 最小堆中的索引，indexes[x] = i 其中 'x 指堆中的位置','i 是数据在 data中存放的索引'；数据根据 data[i] 获取。
    private int[] reverse;  // 最小堆中的反向索引，indexes[i] = x 其中 'i 是数据在 data中存放的索引'，'x 指堆中的位置'；元素索引在堆中的位置为 x.
    private int count;
    private int capacity;

    /**
     * 构造函数, 构造一个空堆, 可容纳capacity个元素
     */
    public IndexMinHeap(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        data = (Item[]) new Comparable[capacity + 1];
        indexes = new int[capacity + 1];
        reverse = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++)
            reverse[i] = 0;
    }

    /**
     * 返回堆中元素个数
     */
    public int size(){
        return count;
    }

    /**
     * 返回一个布尔值，表示索引堆是否为空
     */
    public boolean isEmpty(){
        return count == 0;
    }

    /**
     * 向最小索引堆中插入一个新的元素, 新元素的索引为i, 元素为item
     * 传入的i对用户而言,是从0索引的
     */
    public void insert(int i, Item item){

        assert count + 1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;

        // 插入新元素前，保证索引 i 所在的位置在是没有元素的
        assert !contain(i);
        i += 1;
        data[i] = item;
        indexes[count+1] = i;
        reverse[i] = count + 1;
        count ++;

        shiftUp(count);
    }

    /**
     * 从索引堆中取出最小的元素
     */
    public Item extractMin(){
        assert count > 0;
        Item it = data[indexes[1]];
        swapIndexes(1,count);
        reverse[indexes[count]] = 0;
        count --;
        shiftDown(1);

        return it;
    }

    /**
     * 从最小索引堆中取出堆顶元素的索引,并删除堆顶元素
     */
     public int extractIndexMin(){

        assert count > 0;
        int ret = indexes[1] - 1;
        swapIndexes( 1 , count );
        reverse[indexes[count]] = 0;
        count --;
        shiftDown(1);

        return ret;
    }

    /**
     * 获取最小索引堆中的堆顶元素
      * @return
     */
    public Item getMin(){
        assert count > 0;
        return data[indexes[1]];
    }

    /**
     * 获取最小索引堆中的堆顶元素的索引
     * @return
     */
    public int getMinIndex(){
        assert count > 0;
        return indexes[1]-1;
    }

    /**
     *  获取最小索引堆中索引为i的元素
     */
    public Item getItem( int i ){
        assert contain(i);
        return data[i+1];
    }

    /**
     * 将最小索引堆中索引为i的元素修改为newItem
     */
    public void change( int i , Item newItem ) {
        assert contain(i);

        i += 1;
        data[i] = newItem;
        // 有了 reverse 之后,
        // 我们可以非常简单的通过reverse直接定位索引i在indexes中的位置
        shiftUp(reverse[i]);
        shiftDown(reverse[i]);
    }


    /**
     * 看索引i所在的位置是否存在元素
     */
    public boolean contain(int i) {
        assert  i + 1 >= 1 && i + 1 <= capacity;
        return reverse[i+1] != 0;
    }

    // 交换索引堆中的索引i和j
    // 由于有了反向索引reverse数组，
    // indexes数组发生改变以后， 相应的就需要维护reverse数组
    private void swapIndexes(int i, int j) {
        int tmp = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = tmp;

        reverse[indexes[i]] = i;
        reverse[indexes[j]] = j;
    }


    //-----------------------------
    // 最小索引堆核心辅助函数
    //-----------------------------

    // 索引堆中, 数据之间的比较根据data的大小进行比较, 但实际操作的是索引
    private void shiftUp(int k) {

        while( k > 1 && data[indexes[k/2]].compareTo(data[indexes[k]]) > 0){
            swapIndexes(k, k/2);
            k = k/2;
        }
    }


    // 索引堆中, 数据之间的比较根据data的大小进行比较, 但实际操作的是索引
    private void shiftDown(int k) {
        while( 2 * k <= count ){

            int j = 2 * k;
            if( j+1 <= count && data[indexes[j]].compareTo(data[indexes[j+1]]) > 0)
                j += 1;

            if(data[indexes[k]].compareTo(data[indexes[j]]) <= 0)
                break;

            swapIndexes(j, k);
            k = j;
        }
    }


}











