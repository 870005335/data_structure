package main.com.liubin.array;

import java.util.ArrayList;
import java.util.List;


public class Array<E> {

    private E[] data;
    private int size;

    private static final int ZERO = 0;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public Array(E[] arr) {
    	data = (E[]) new Object[arr.length];
	    for (int i = 0; i < arr.length; i++) {
		    data[i] = arr[i];
	    }
    }

    public int getSize() {
        return this.size;
    }

    E[] getData() {
        return data;
    }

    public int getCapacity() {
        return this.data.length;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void set(int index, E e) {
    	checkIndex(index);
    	data[index] = e;
    }

    public void add(E e) {
        add(this.size, e);
    }

    void addFirst(E e) {
        add(ZERO, e);
    }

    void add(int index, E e) {
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("index is illegal");
        }
        if (this.size == data.length) {
            resize(2 * data.length);
        }
        System.arraycopy(data, index, data, index + 1, this.size - index);
        this.data[index] = e;
        this.size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    public E get(int index) {
        if (index > this.size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return this.data[index];
    }

    public E getFirst() {
    	return this.get(ZERO);
    }

    public E getLast() {
    	return this.get(this.size - 1);
    }

    boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    int getIndex(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    List<Integer> getAllIndex(E e) {
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                indexList.add(i);
            }
        }
        return indexList;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        E rev = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        data[--size] = null; //loitering objects
        if (size == data.length / 4 && data.length / 2 !=0) {
            resize(data.length/2);
        }
        return rev;
    }

    public E removeFirst() {
        return this.remove(ZERO);
    }

    public E removeLast() {
        return this.remove(size - 1);
    }

    public void removeElement(E e) {
        int index = getIndex(e);
        if (index != -1) {
            this.remove(index);
        }
    }

    public void removeAllElement(E e) {
        List<Integer> indexList = this.getAllIndex(e);
        if (!indexList.isEmpty()) {
            for (Integer index : indexList) {
                if (index != size) {
                    remove(index);
                } else {
                    size--;
                }
            }
        }
    }

    /**
     * @discription 根据索引交换数组两个的两个元素位置
     * @author liubin@segimail.com
     * @date 2019年11月20日 17:12:26
     * @param firstIndex
     * @param secondIndex
     * @return : void
    */
    public void swap(int firstIndex, int secondIndex) {
        checkIndex(firstIndex);
        checkIndex(secondIndex);
        E t = data[firstIndex];
        data[firstIndex] = data[secondIndex];
        data[secondIndex] = t;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("index is out of bound");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array: size=%d, capacity=%d\n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }
}
