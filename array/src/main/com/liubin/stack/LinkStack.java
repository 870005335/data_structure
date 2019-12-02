package main.com.liubin.stack;

import main.com.liubin.linklist.LinkedList;

/**
* Title:LinkStack.java
* @discription: 
* @author liubin@segi.com
* @created 2019-10-25 09:38
*/
public class LinkStack<E> implements Stack<E> {

	private LinkedList<E> linkedList;

	public LinkStack() {
		linkedList = new LinkedList<>();
	}

	@Override
	public int getSize() {
		return linkedList.getSize();
	}

	@Override
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}

	@Override
	public void push(E e) {
		linkedList.addFirst(e);
	}

	@Override
	public E pop() {
		return linkedList.removeFirst();
	}

	@Override
	public E peek() {
		return linkedList.getFirst();
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Stack: top ");
		sb.append(linkedList);
		return sb.toString();
	}
}
