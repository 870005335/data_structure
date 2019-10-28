package main.com.liubin.LinkedList;

/**
 * @ClassName SinglyLinkedList
 * @Description: 单向链表
 * @Author Arthas_liubin@Foxmail.com
 * @Date 2019/10/20 21:31
 * @Version V1.0
 **/
public class SinglyLinkedList<E> {

	private final int ZERO = 0;

    private Node<E> dummyHead;
    private int size;

    public SinglyLinkedList() {
        dummyHead = new Node<>(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        Node<E> dummyHead = this.dummyHead;
        dummyHead.next = new Node<>(e, dummyHead.next);
        size++;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is illegal");
        }
        Node<E> prev = this.dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node<>(e, prev.next);
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void set(int index, E e) {
        checkIndex(index);
        Node<E> node = this.dummyHead;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.data = e;
    }


    public boolean contains(E e) {
        Node<E> dummyHead = this.dummyHead;
        while (dummyHead != null) {
            if (dummyHead.next.data.equals(e)) {
                return true;
            }
            dummyHead = dummyHead.next;
        }
        return false;
    }

    public E get(int index) {
        checkIndex(index);
        Node<E> prev = this.dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        return prev.next.data;
    }

    public E getFirst() {
    	return get(ZERO);
    }

    public E getLast() {
    	return get(size - 1);
    }

    public E remove(int index) {
    	checkIndex(index);
	    Node<E> prev = this.dummyHead;
	    for (int i = 0; i < index; i++) {
		    prev = prev.next;
	    }
	    Node<E> del = prev.next;
	    prev.next = del.next;
	    del.next = null;
	    size--;
	    return del.data;
    }

    public E removeFirst() {
    	return remove(ZERO);
    }

    public E removeLast() {
    	return remove(size - 1);
    }

    private void checkIndex(int index) {
	    if (index < 0 || index >= size) {
		    throw new IllegalArgumentException("index is illegal");
	    }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> node = this.dummyHead;
        sb.append("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(get(i)).append("->");
        }
        sb.append(get(size - 1)).append("]");
        return sb.toString();
    }



    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E e, Node<E> next) {
            this.data = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
