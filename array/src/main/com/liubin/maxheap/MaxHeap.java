package main.com.liubin.maxheap;

import main.com.liubin.array.Array;

/**
* Title:MaxHeap.java
* @discription: 基于数组实现最大堆
* @author liubin@segi.com
* @created 2019-11-20 14:40
*/
public class MaxHeap<E extends Comparable<E>> {

	private Array<E> array;

	public MaxHeap(int capacity) {
		array = new Array<>(capacity);
	}

	public MaxHeap() {
		array = new Array<>();
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
	 * @discription 向最大堆中添加元素
	*/
	public void add(E e) {
		array.add(e);
		siftUp(array.getSize() - 1);
	}

	/**
	 * @discription sift up（上浮操作）
	 */
	private void siftUp(int index) {
		while (index > 0 && array.get(parent(index)).compareTo(array.get(index)) < 0) {
			array.swap(parent(index), index);
			index = parent(index);
		}
	}

	/**
	 * @discription 查看当前堆中最大元素
	 */
	public E findMax() {
		if (array.isEmpty()) {
			return null;
		}
		return array.get(0);
	}

	/**
	 * @discription 取出当前堆中最大元素
	 */
	public E extractMax() {
		E result = findMax();
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
		//当节点存在左孩子的时间进行循环
		while (leftChild(index) < array.getSize() ) {
			int larger = leftChild(index);
			//如果节点右孩子不为空并且大于左孩子
			if (larger + 1 < array.getSize() &&
					array.get(larger + 1).compareTo(array.get(larger)) > 0) {
				larger = rightChild(index);
			}
			//当节点比左右孩子中的最大的孩子更大时，说明不需要继续下沉操作了
			if (array.get(index).compareTo(array.get(larger)) >= 0) {
				break;
			}
			//交换位置
			array.swap(index, larger);
			index = larger;
		}
	}

	/**
	 * @discription 取出最大元素并放入一个新的元素
	 */
	public E replace(E e) {
		E result = findMax();
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
		for (int i = lastParent; i >= 0; i --) {
			siftDown(i);
		}
	}
}
