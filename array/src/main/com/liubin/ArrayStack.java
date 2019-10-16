package main.com.liubin;
/**
* Title:ArrayStack.java
* @discription: 
* @author liubin@segi.com
* @created 2019-10-15 17:49
*/
public class ArrayStack<E> implements Stack<E> {

	private Array<E> array;

	public ArrayStack() {
		array = new Array<>();
	}

	public ArrayStack(int capacity) {
		array = new Array<>(capacity);
	}

	@Override
	public int getSize() {
		return array.getSize();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	@Override
	public void push(E e) {
		array.add(e);
	}

	@Override
	public E pop() {
		return array.removeLast();
	}

	@Override
	public E peek() {
		return array.getLast();
	}

	public int getCapacity() {
		return array.getCapacity();
	}
}
