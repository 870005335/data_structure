package main.com.liubin.queue;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int head;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        head = 0;
        tail = 0;
        size = 0;
    }


    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }


    @Override
    public void enQueue(E e) {
        if ((tail + 1) % data.length == head) {
            resize(getCapacity() *2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + head) % data.length];
        }
        data = newData;
        head = 0;
        tail = size;
    }

    @Override
    public E deQueue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty, can not deQueue");
        }
        E ret = data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getHead() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return data[head];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        sb.append("head [");
        for (int i = head; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail) {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
