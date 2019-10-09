package com.liubin;

public class Array {

    private int[] data;
    private int size;

    private static final int ZERO = 0;

    private Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    Array() {
        this(10);
    }

    int getSize() {
        return this.size;
    }

    int[] getData() {
        return data;
    }

    public int getCapacity() {
        return this.data.length;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    void add(int e) {
        add(this.size, e);
    }

    void addFirst(int e) {
        add(ZERO, e);
    }

    void add(int index, int e) {
        if (this.size == data.length) {
            throw new IllegalArgumentException("add failed,Array is full");
        }
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("index is not required");
        }
        System.arraycopy(data, index, data, index + 1, this.size - index);
        this.data[index] = e;
        this.size++;
    }

    int get(int index) {
        if (index > this.size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return this.data[index];
    }

    boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e){
                return true;
            }
        }
        return false;
    }

    int getIndex(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e){
                return i;
            }
        }
        return -1;
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
