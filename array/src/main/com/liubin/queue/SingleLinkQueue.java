package main.com.liubin.queue;

import main.com.liubin.linklist.SinglyLinkedList;

/**
* Title:SingleLinkQueue.java
* @discription: 
* @author liubin@segi.com
* @created 2019-10-24 16:33
*/
public class SingleLinkQueue<E> implements Queue<E> {

	private SinglyLinkedList<E> singlyLinkedList;

	public SingleLinkQueue() {
		singlyLinkedList = new SinglyLinkedList<>();
	}

	@Override
	public void enQueue(E e) {
		singlyLinkedList.addFirst(e);
	}

	@Override
	public E deQueue() {
		return singlyLinkedList.removeLast();
	}

	@Override
	public E getHead() {
		return singlyLinkedList.getFirst();
	}

	@Override
	public boolean isEmpty() {
		return singlyLinkedList.isEmpty();
	}

	@Override
	public int getSize() {
		return singlyLinkedList.getSize();
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Queue: head ");
		sb.append(singlyLinkedList).append(" tail");
		return sb.toString();
	}
}
