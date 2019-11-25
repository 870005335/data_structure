package main.com.liubin.tree.segment;

import java.util.Arrays;

/**
 * @ClassName SegmentTree
 * @Description: 线段树
 * @Author Arthas_liubin@Foxmail.com
 * @Date 2019/11/23 0:51
 * @Version V1.0
 **/
public class SegmentTree<E> {

    private E[] data;

    private E[] tree;

    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        System.arraycopy(arr, 0, data, 0, arr.length);
        //开辟4n空间的数组
        tree = (E[]) new Object[4 * arr.length];
        //构建线段树
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * @discription 通过根索引和区间左右索引构建线段树
     */
    private void buildSegmentTree(int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = data[left];
            return;
        }
        //计算分割后中间位置索引
        int mid = left + (right - left) / 2;
        //计算左右子树根索引
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);
        //构建左右子树
        buildSegmentTree(leftChildIndex, left, mid);
        buildSegmentTree(rightChildIndex, mid + 1, right);
        tree[treeIndex] = merger.merge(tree[leftChildIndex], tree[rightChildIndex]);
    }

    public int getSize() {
        return data.length;
    }

    /**
     * @discription 索引检查
     */
    private boolean checkIndex(int index) {
        if (index < 0 || index >= data.length) {
            return false;
        }
        return true;
    }

    public E get(int index) {
        if (checkIndex(index)) {
            return data[index];
        }
        return null;
    }

    /**
     * @discription 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * @discription 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     */
    private int rightChild(int index) {
        return 2 * index + 2 ;
    }

    /**
     * @discription 查询区间[leftQueryIndex,rightQueryIndex]
     */
    public E query(int leftQueryIndex, int rightQueryIndex) {
        if (!checkIndex(leftQueryIndex) && !checkIndex(rightQueryIndex) && leftQueryIndex > rightQueryIndex) {
            throw new IllegalArgumentException("index is illegal");
        }
        return query(0, 0, data.length - 1, leftQueryIndex, rightQueryIndex);
    }

    private E query(int treeIndex, int left, int right, int leftQueryIndex, int rightQueryIndex) {
        if (left == leftQueryIndex && right == rightQueryIndex) {
            return tree[treeIndex];
        }
        //计算分割后中间位置索引
        int mid = left + (right - left) / 2;
        //计算左右子树根索引
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);
        //要查找区间被一分为二的右区间包含
        if (leftQueryIndex > mid) {
            return query(rightChildIndex, mid + 1, right, leftQueryIndex, rightQueryIndex);
        }
        //要查找区间被一分为二的左区间包含
        if (rightQueryIndex <= mid) {
            return query(leftChildIndex, left, mid, leftQueryIndex, rightQueryIndex);
        }
        //要查找区间在一分为二的左右区间上均有一部分
        E leftResult = query(leftChildIndex, left, mid, leftQueryIndex, mid);
        E rightResult = query(rightChildIndex, mid + 1, right, mid + 1, rightQueryIndex);
        return merger.merge(leftResult, rightResult);
    }

    /**
     * @discription 更新某个元素
     */
    public E set(int index, E e) {
        if (!checkIndex(index)) {
            throw new IllegalArgumentException("index is illegal");
        }
        E result = data[index];
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
        return result;
    }

    private void set(int treeIndex, int left, int right, int index, E e) {
        if (left == right) {
            tree[treeIndex] = e;
            return;
        }
        //计算分割后中间位置索引
        int mid = left + (right - left) / 2;
        //计算左右子树根索引
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        //判断要修改元素所在区间
        if (index > mid) {
            set(rightTreeIndex, mid + 1, right, index, e);
        } else {
            set(leftTreeIndex, left, mid, index, e);
        }
        //更新祖辈节点
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SegmentTree{");
        sb.append(", tree=").append(Arrays.toString(tree));
        sb.append('}');
        return sb.toString();
    }
}
