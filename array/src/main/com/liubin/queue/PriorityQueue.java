package main.com.liubin.queue;

import main.com.liubin.maxheap.MaxHeap;

/**
* Title:PriorityQueue.java
* @discription: 
* @author liubin@segi.com
* @created 2019-11-21 11:04
*/
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

	private MaxHeap<E> maxHeap;

	public PriorityQueue() {
		maxHeap = new MaxHeap<>();
	}

	@Override
	public void enQueue(E e) {
		maxHeap.add(e);
	}

	@Override
	public E deQueue() {
		return maxHeap.extractMax();
	}

	@Override
	public E getHead() {
		return maxHeap.findMax();
	}

	@Override
	public boolean isEmpty() {
		return maxHeap.isEmpty();
	}

	@Override
	public int getSize() {
		return maxHeap.size();
	}
}
