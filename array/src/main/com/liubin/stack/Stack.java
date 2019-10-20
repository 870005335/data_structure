package main.com.liubin.stack;

/**
 * Title:Stack.java
 *
 * @author liubin@segi.com
 * @discription:
 * @created 2019-10-15 17:43
 */
public interface Stack<E> {
	int getSize();

	boolean isEmpty();

	void push(E e);

	E pop();

	E peek();
}
