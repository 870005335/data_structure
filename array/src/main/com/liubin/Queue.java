package main.com.liubin;

/**
 * Title:Queue.java
 *
 * @author liubin@segi.com
 * @discription:
 * @created 2019-10-16 17:34
 */
public interface Queue<E> {

	void enQueue(E e);

	E deQueue();

	E getHead();

	boolean isEmpty();

	int getSize();
}
