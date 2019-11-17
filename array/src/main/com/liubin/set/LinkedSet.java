package main.com.liubin.set;


import main.com.liubin.LinkedList.SinglyLinkedList;

/**
 * @ClassName LinkedSet
 * @Description: 基于链表的Set集合
 * @Author Arthas_liubin@Foxmail.com
 * @Date 2019/11/17 17:13
 * @Version V1.0
 **/
public class LinkedSet<E> implements Set<E> {

    private SinglyLinkedList<E> linkedList;

    public LinkedSet() {
        linkedList = new SinglyLinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!linkedList.contains(e)) {
            linkedList.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        linkedList.removeRecursion(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
