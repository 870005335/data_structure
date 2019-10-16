package main.com.liubin;
/**
* Title:ArrayQueue.java
* @discription: 
* @author liubin@segi.com
* @created 2019-10-16 17:47
*/
public class ArrayQueue<E> implements Queue<E> {

	Array<E> array;

	public ArrayQueue() {
		array = new Array<>();
	}

	public ArrayQueue(int capacity) {
		array = new Array<>(capacity);
	}

	@Override
	public void enQueue(E e) {
		array.add(e);
	}

	@Override
	public E deQueue() {
		return array.removeFirst();
	}

	@Override
	public E getFront() {
		return array.getFirst();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	@Override
	public int getSize() {
		return array.getSize();
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Queue: front [");
		for (int i = 0; i < array.getSize(); i++) {
			sb.append(array.get(i));
			if (i != array.getSize() - 1) {
				sb.append(", ");
			}
		}
		sb.append("] tail");
		return sb.toString();
	}
}
