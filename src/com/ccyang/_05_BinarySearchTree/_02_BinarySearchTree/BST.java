package com.ccyang._05_BinarySearchTree._02_BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

// 二分搜索树
// 由于 key需要进行比较，因此需要 extends Comparable<Key>
public class BST<Key extends Comparable<Key>, Value> {

    // 树中的节点为私有的类，外界不需要了解二分搜索树的具体实现
    private class Node{
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }

        public Node(Node node){
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
        }
    }

    private Node root; // 根节点
    private int count; // 树中节点的个数

    /**
     * 构造函数，默认构造一颗空的二叉树
     */
    public BST() {
        this.root = null;
        this.count = 0;
    }

    /**
     * return BST 的节点的个数
     */
    public int size(){
        return count;
    }

    /**
     *  return BST 是否为空
     */
    public boolean isEmpty(){
        return count==0;
    }

    /**
     * 向二叉搜索树插入一个新的节点
     */
    public void insert(Key key , Value value){
        root = insert(root, key, value);
    }

    /**
     * 查看二分搜索树中是否存在键key
     */
     public Boolean contain(Key key){
        return contain(root, key);
    }

    /**
     * 在二分搜索树中查找key对应的值。如果值不存在，则返回null
     */
    public Node search(Key key){
        return search(root,key);
    }

    /**
     * BST 前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }

    /**
     * BST 中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    /**
     * BST 后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    /**
     * 层序遍历
     */
    public void levelOrder(){

        // 使用LinkedList做为队列
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){

            Node node = queue.remove();
            System.out.print(node.key + "  ");

            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }
    }

    /**
     * 寻找二分搜索树的最小的键值
     */
    public Key minimum(){
        assert count != 0;
        Node node = minimum(root);
        return node.key;
    }

    /**
     * 寻找二分搜索树的最大的键值
     */
    public Key maximum(){
        assert count != 0;
        Node node = maximum(root);
        return node.key;
    }

    /**
     * 删除二分搜索树的最小值所在节点
     */
    public void removeMin(){
        if( root != null )
            root = removeMin( root );
    }

    /**
     * 删除二分搜索树的最大值所在节点
     */
    public void removeMax(){
        if(root != null){
            root = removeMax( root );
        }
    }

    /**
     * 从二叉搜索树中删除键值为 key的节点
     */
    public void remove(Key key){
        remove( root , key);
    }

    /**
     * 寻找key的floor值(key 的前驱), 递归算法
     * 如果不存在key的floor值(key比BST中的最小值还小), 返回NULL
     */
    public Key floor(Key key) {

        if(count == 0 || minimum().compareTo(key) > 0){
            return null;
        }
        Node floorNode = floor(root, key);
        return floorNode.key;
    }

    /**
     * 寻找key的ceil值(key 的后继), 递归算法
     * 如果不存在key的ceil值(key比BST中的最大值还大), 返回NULL
     */
    public Key ceil(Key key) {

        if(count == 0 || maximum().compareTo(key) < 0){
            return null;
        }
        Node ceilNode = ceil(root, key);
        return ceilNode.key;
    }

    /**
     * 查找key的前驱
     * 如果不存在key的前驱(key不存在, 或者key是整棵二叉树中的最小值), 则返回NULL
     */
    public Key predecessor(Key key) {

        Node node = search(root, key);
        // 如果key所在的节点不存在, 则key没有前驱, 返回NULL
        if(node == null){
            return null;
        }

        // node存在的话，key的前驱肯定是node左子树的最大值
        if(node.left != null)
            return maximum(node.left).key;

        // 否则, key的前驱在从根节点到key的路径上, 在这个路径上寻找到比key小的最大值, 即为key的前驱
        Node preNode = predecessorFromAncestor(root, key);
        return preNode == null ? null : preNode.key;
    }

    /**
     * 查找key的后继, 递归算法
     * 如果不存在key的后继(key不存在, 或者key是整棵二叉树中的最大值), 则返回NULL
     */
    public Key successor(Key key){

        Node node = search(root, key);
        // 如果key所在的节点不存在, 则key没有前驱, 返回NULL
        if(node == null)
            return null;

        // 如果key所在的节点右子树不为空,则其右子树的最小值为key的后继
        if(node.right != null)
            return minimum(node.right).key;

        // 否则, key的后继在从根节点到key的路径上, 在这个路径上寻找到比key大的最小值, 即为key的后继
        Node sucNode = successorFromAncestor(root, key);
        return sucNode == null ? null : sucNode.key;
    }


    //--------------------
    // 二查搜索数的辅助函数
    //--------------------

    // 向以node节点为根的二叉搜索树中插入节点(key,value),使用递归的方法
    // 返回插入新节点的二叉树的根
    private Node insert(Node node, Key key, Value value){

        if(node == null){
            count ++;
            return new Node(key,value);
        }

        if(node.key.compareTo(key) == 0){
            node.value = value;
        }else if(node.key.compareTo(key) > 0){
            node.left = insert(node.left, key, value);
        }else{  // node.key < key
            node.right = insert(node.right, key, value);
        }
        return node;
    }

    // 查看二分搜索树中是否存在键key
    private boolean contain(Node node, Key key){

        if(node == null){
            return false;
        }

        if(node.key.compareTo(key) == 0){
            return true;
        }else if(node.key.compareTo(key) > 0){
            return contain(node.left, key);
        }else{
            return contain(node.right, key);
        }
    }

    // 在以node为根的二分搜索树中查找key所对应的node, 递归算法
    // 若Node不存在, 则返回NULL
    private Node search(Node node, Key key){

        if(node == null){
            return null;
        }

        if(node.key.compareTo(key) == 0){
            return node;
        }else if(node.key.compareTo(key) > 0){
            return search(node.left, key);
        }else{
            return search(node.right, key);
        }
    }

    // 以node为根的二叉树的前序遍历，递归算法
    // 前序遍历：根左右
    private void preOrder(Node node){

        if(node != null){
            System.out.print(node.key + "  ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 以node为根的二叉树的中序遍历，递归算法
    // 中序遍历：左根右
    private void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.print(node.key + "  ");
            inOrder(node.right);
        }
    }

    // 以node为根的二叉树的后序遍历，递归算法
    // 后序遍历：左右根
    private void postOrder(Node node){
        if(node != null){
            inOrder(node.left);
            inOrder(node.right);
            System.out.print(node.key + "  ");
        }
    }

    // 寻找以 node节点为根的二叉搜索树的 key最小的节点
    private Node minimum(Node node){

        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    // 寻找以 node节点为根的二叉搜索树的 key最大的节点
    private Node maximum(Node node){

        if(node.right == null)
            return node;
        return maximum(node.right);
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            count --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node){
        if( node.right == null ){
            Node leftNode = node.left;
            node.left = null;
            count --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    // 删除掉以 node为根的二叉搜索树中键值为 key的节点
    // 返回删除节点后新的二叉搜索树的根
    private Node remove(Node node, Key key){

        if(node == null){
            return null;
        }

        if(node.key.compareTo(key) > 0){
            node.left =  remove(node.left, key);
            return node;
        }
        else if(node.key.compareTo(key) < 0){
            node.right = remove(node.right, key);
            return node;
        }
        else{  // node.key == key
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                count--;
                return rightNode;
            }
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                count -- ;
                return leftNode;
            }

            // node.left != null && node.right != null
            Node successor = new Node(minimum(node.right));
            count ++ ;

            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            count -- ;
            return successor;
        }
    }

    // 寻找key的floor值, 递归算法
    // 如果不存在key的floor值(key比BST中的最小值还小), 返回NULL
    private Node floor(Node node , Key key){

        if(node == null){
            return null;
        }

        // 如果node的key值和要寻找的key值相等
        // 则node本身就是key的floor节点
        if(node.key.compareTo(key) == 0){
            return node;
        }

        // 如果node的key值比要寻找的key值大
        // 则要寻找的key的floor节点一定在node的左子树中
        if(node.key.compareTo(key) > 0){
           return floor(node.left, key);
        }

        // if node.key < key
        // then，node can is key 的floor节点，node can is't key 的floor节点(存在比 node.key大但比key小的其余节点)。
        // 需要尝试向node的右子树寻找
        Node tmpNode = floor(node.right, key);

        if(tmpNode != null)
            return tmpNode;

        return node;
    }

    // 寻找key的ceil值, 递归算法
    // 如果不存在key的ceil值(key比BST中的最大值还大), 返回NULL
    private Node ceil(Node node , Key key){

        if(node == null)
            return null;

        if(node.key.compareTo(key) == 0)
            return node;

        if(node.key.compareTo(key) < 0)
            return ceil(node.right, key);

        // node.key > key
        Node tmpNode = ceil(node.left, key);

        if(tmpNode != null)
            return tmpNode;
        return node;
    }

    // 在以node为根的二叉搜索树中, 寻找key的祖先中,比key小的最大值所在节点, 递归算法
    // 算法调用前已保证key存在在以node为根的二叉树中
    private Node predecessorFromAncestor(Node node , Key key){

        if(node.key.compareTo(key) == 0)
            return null;

        if(node.key.compareTo(key) > 0)   // 遍历左子树
            return predecessorFromAncestor(node.left, key);
        else{
            assert node.key.compareTo(key) < 0;

            // 如果当前节点小于key, 则当前节点有可能是比key小的最大值
            // 向右继续搜索, 将结果存储到tempNode中
            Node tempNode = predecessorFromAncestor(node.right, key);
            if(tempNode != null)
                return tempNode;
            else
                // 如果tempNode为空, 则当前节点即为结果
                return node;
        }
    }

    // 在以node为根的二叉搜索树中, 寻找key的祖先中,比key大的最小值所在节点, 递归算法
    // 算法调用前已保证key存在在以node为根的二叉树中
    private Node successorFromAncestor(Node node, Key key){

        if(key.compareTo(node.key) > 0)
            // 如果当前节点小于key, 则当前节点不可能是比key大的最小值
            // 向下搜索到的结果直接返回
            return successorFromAncestor(node.right, key);
        else{
            assert(key.compareTo(node.key) < 0);
            // 如果当前节点大于key, 则当前节点有可能是比key大的最小值
            // 向左继续搜索, 将结果存储到tempNode中
            Node tempNode = successorFromAncestor(node.left, key);
            if(tempNode != null)
                return tempNode;
            else
                // 如果tempNode为空, 则当前节点即为结果
                return node;
        }
    }

    public static void main(String[] args) {

    }

}




















