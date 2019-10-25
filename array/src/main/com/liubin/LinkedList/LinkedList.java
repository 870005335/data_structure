package main.com.liubin.LinkedList;

/**
 * @ClassName LinkedList
 * @Description: 双向链表
 * @Author Arthas_liubin@Foxmail.com
 * @Date 2019/10/20 2:23
 * @Version V1.0
 **/
public class LinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public LinkedList() {
        first = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @MethodName: addFirst
     * @Description: 向链表表头添加元素，让新增元素的node指向head
     * head再指向新增元素
     * @param e
     * @Return: void
     * @Author: Arthas_liubin@Foxmail.com
     * @Date: 2019/10/20 11:49
    **/
    public void addFirst(E e) {
        linkFirst(e);
    }

    private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(e, f, null);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(e, null, l);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    /**
     * @MethodName: linkBefore
     * @Description: 在指定节点插入新的节点
     * @param e
     * @param node
     * @Return: void
     * @Author: Arthas_liubin@Foxmail.com
     * @Date: 2019/10/20 19:20
    **/
    private void linkBefore(E e, Node<E> node) {
        Node<E> prev = node.prev;
        Node<E> newNode = new Node<>(e, node, prev);
        if (null == prev) {
            first = newNode;
        } else {
            prev.next = newNode;
        }
        size++;
    }

    public void addLast(E e) {
        linkLast(e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        }
        if (index == size) {
            linkLast(e);
        } else {
            linkBefore(e, node(index));
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        }
        Node<E> node = node(index);
        return node.data;
    }

    public E getFirst() {
    	return get(0);
    }

    public E getLast() {
    	return get(size - 1);
    }


    public E remove(int index) {
	    Node<E> delNode = node(index);
	    E data = delNode.data;
	    Node<E> prev = delNode.prev;
	    Node<E> next = delNode.next;
	    if (null == prev) {
	    	first = next;
	    } else {
	    	prev.next = next;
	    	delNode.prev = null;
	    }

	    if (null == next) {
	    	last = prev;
	    } else {
	    	next.prev = prev;
	    	delNode.next = null;
	    }
	    delNode.data = null;
	    size --;
	    return data;
    }

    public E removeFirst() {
    	return remove(0);
    }

    public E removeLast() {
    	return remove(size - 1);
    }

    /**
     * @MethodName: node
     * @Description: 返回指定索引非空节点
     * @param index
     * @Return: main.com.liubin.LinkedList.LinkedList.Node<E>
     * @Author: Arthas_liubin@Foxmail.com
     * @Date: 2019/10/20 18:56
    **/
    Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> f = this.first;
            for (int i = 0; i < index; i++) {
                f = f.next;
            }
            return f;
        } else {
            Node<E> l = this.last;
            for (int i = size - 1; i > index; i--) {
                l = l.prev;
            }
            return l;
        }
    }

    @Override
    public String toString() {
        Node<E> first = this.first;
        final StringBuilder sb = new StringBuilder("[");
        while (first.next != null) {
            sb.append(first).append("⇄");
            first = first.next;
        }
        sb.append(last);
        sb.append("]");
        return sb.toString();
    }

    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        Node(E data, Node<E> next, Node<E> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
           return data.toString();
        }
    }

}
