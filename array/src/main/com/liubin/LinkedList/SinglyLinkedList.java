package main.com.liubin.LinkedList;

/**
 * @ClassName SinglyLinkedList
 * @Description: 单向链表
 * @Author Arthas_liubin@Foxmail.com
 * @Date 2019/10/20 21:31
 * @Version V1.0
 **/
public class SinglyLinkedList<E> {

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
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        Node<E> node = this.dummyHead;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.data = e;
    }

    public boolean contains(E e) {
        Node<E> dummyHead = this.dummyHead;
        while (dummyHead.next != null) {
            if (dummyHead.next.data.equals(e)) {
                return true;
            }
            dummyHead = dummyHead.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> node = this.dummyHead;
        while (node.next != null) {
            sb.append(node).append("->");
            node = node.next;
        }
        sb.append("NULL");
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
