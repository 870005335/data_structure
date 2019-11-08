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

    private Node dummyHead;
    private int size;

    public SinglyLinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public SinglyLinkedList(E[] arr) {
        dummyHead = new Node(null, null);
        Node cur = this.dummyHead;
        for (E e : arr) {
            cur.next = new Node(e, null);
            cur = cur.next;
            size++;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        Node dummyHead = this.dummyHead;
        dummyHead.next = new Node(e, dummyHead.next);
        size++;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is illegal");
        }
        Node prev = this.dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addByRecursion(E e) {
	    Node node = dummyHead;
	    addByRecursion(node, e);
    }

    private void  addByRecursion(Node node, E e) {
    	if (node.next == null) {
		    node.next = new Node(e, null);
    		size++;
    		return;
	    }
    	addByRecursion(node.next, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void set(int index, E e) {
        checkIndex(index);
        Node node = this.dummyHead;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.data = e;
    }


    public boolean contains(E e) {
        Node dummyHead = this.dummyHead;
        while (dummyHead != null) {
            if (dummyHead.next.data.equals(e)) {
                return true;
            }
            dummyHead = dummyHead.next;
        }
        return false;
    }

    public boolean containsByRecursion(E e) {
	    Node node = dummyHead.next;
		return containsByRecursion(node, e);
    }

    private boolean containsByRecursion(Node node, E e) {
    	if (node == null) {
    		return false;
	    }
    	if (node.data == e) {
    		return true;
	    }
    	return containsByRecursion(node.next, e);
    }

    public E get(int index) {
        checkIndex(index);
        Node prev = this.dummyHead;
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
	    Node prev = this.dummyHead;
	    for (int i = 0; i < index; i++) {
		    prev = prev.next;
	    }
	    Node del = prev.next;
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
        sb.append("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(get(i)).append("->");
        }
        sb.append(get(size - 1)).append("]");
        return sb.toString();
    }



    private class Node {
        private E data;
        private Node next;

        public Node(E e, Node next) {
            this.data = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }


	public static void main(String[] args) {
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
		singlyLinkedList.addByRecursion(15);
		singlyLinkedList.addByRecursion(26);
		System.out.println(singlyLinkedList);
		System.out.println(singlyLinkedList.containsByRecursion(30));
	}
}
