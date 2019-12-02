package main.com.liubin.queue;

import main.com.liubin.linklist.LinkedList;

/**
* Title:LinkQueue.java
* @discription: 
* @author liubin@segi.com
* @created 2019-10-25 11:06
*/
public class LinkQueue<E> implements Queue<E> {

	private LinkedList<E> linkedList;

	public LinkQueue() {
		linkedList = new LinkedList<>();
	}

	@Override
	public void enQueue(E e) {
		linkedList.addFirst(e);
	}

	@Override
	public E deQueue() {
		return linkedList.removeLast();
	}

	@Override
	public E getHead() {
		return linkedList.getFirst();
	}

	@Override
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}

	@Override
	public int getSize() {
		return linkedList.getSize();
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Queue: head");
		sb.append(linkedList).append(" tail");
		return sb.toString();
	}
}
