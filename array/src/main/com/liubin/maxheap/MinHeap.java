package main.com.liubin.maxheap;

import main.com.liubin.array.Array;

/**
* Title:MinHeap.java
* @discription: 基于完全二叉树的数组表现实现最小堆
* @author liubin@segi.com
* @created 2019-11-21 11:36
*/
public class MinHeap<E extends Comparable<E>> {

	private Array<E> array;

	public MinHeap() {
		array = new Array<>();
	}

	public MinHeap(int capacity) {
		array = new Array<>(capacity);
	}

	public int size() {
		return array.getSize();
	}

	public boolean isEmpty() {
		return array.isEmpty();
	}

	/**
	 * @discription 返回完全二叉树的数组表示中，一个索引所表示的元素的父节点的索引
	 */
	private int parent(int index) {
		if (index != 0) {
			return (index - 1) / 2;
		}
		return -1;
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
	 * @discription 向最小堆中添加元素
	 */
	public void add(E e) {
		array.add(e);
		siftUp(array.getSize() - 1) ;
	}

	/**
	 * @discription sift up（最小堆上浮操作）
	 */
	private void siftUp(int index) {
		while (index > 0 && array.get(index).compareTo(array.get(parent(index))) < 0) {
			array.swap(index, parent(index));
			index = parent(index);
		}
	}

	/**
	 * @discription 查看最小堆中最小元素
	 */
	public E findMin() {
		if (array.isEmpty()) {
			return null;
		}
		return array.get(0);
	}

	/**
	 * @discription 取出最小堆中最小元素
	 */
	public E extractMin() {
		E result = findMin();
		if (result != null) {
			array.swap(0, array.getSize() - 1);
			array.removeLast();
			siftDown(0);
		}
		return result;
	}

	/**
	 * @discription sift down（下沉操作）
	 */
	private void siftDown(int index) {
		while (leftChild(index) < array.getSize()) {
			int smaller = leftChild(index);
			if (smaller + 1 < array.getSize() &&
			array.get(rightChild(index)).compareTo(array.get(smaller)) < 0) {
				smaller = rightChild(index);
			}
			//当节点比左右孩子中的较小值还小时，不要下沉了
			if (array.get(index).compareTo(array.get(smaller)) <= 0) {
				break;
			}
			//否则交换节点与较小值的位置，继续下沉
			array.swap(index, smaller);
			index = smaller;
		}
	}

	/**
	 * @discription 取出最小元素并放入一个新的元素
	 */
	public E replace(E e) {
		E result = findMin();
		if (result != null) {
			array.set(0, e);
			siftDown(0);
		}
		return result;
	}

	/**
	 * @discription 将任意一个数组转变完全二叉树的数组形式
	 */
	public void heapify(E[] arr) {
		array = new Array<>(arr);
		int lastParent = parent(array.getSize() - 1);
		for (int i = lastParent; i >=0; i--) {
			siftDown(i);
		}
	}
}
