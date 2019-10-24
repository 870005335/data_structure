package main.com.liubin.stack;

import main.com.liubin.LinkedList.SinglyLinkedList;

/**
* Title:SingleLinkStack.java
* @discription: 
* @author liubin@segi.com
* @created 2019-10-24 16:37
*/
public class SinglyLinkStack<E> implements Stack<E> {

	private SinglyLinkedList<E> singlyLinkedList;

	public SinglyLinkStack() {
		singlyLinkedList = new SinglyLinkedList<>();
	}

	@Override
	public int getSize() {
		return singlyLinkedList.getSize();
	}

	@Override
	public boolean isEmpty() {
		return singlyLinkedList.isEmpty();
	}

	@Override
	public void push(E e) {
		singlyLinkedList.addFirst(e);
	}

	@Override
	public E pop() {
		return singlyLinkedList.removeFirst();
	}

	@Override
	public E peek() {
		return singlyLinkedList.getFirst();
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Stack: top ").append(singlyLinkedList);
		return sb.toString();
	}
}
