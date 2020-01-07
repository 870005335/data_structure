package main.com.liubin.map;

import main.com.liubin.tree.avl.AvlTree;

/**
 * @ClassName AVLMap
 * @Description: 基于AVL树实现的Map
 * @Author liubin
 * @Date 2020/1/2 0002
 * @Version V1.0
 **/
public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {

    private AvlTree<K, V> avlTree;

    public AVLMap() {
        avlTree = new AvlTree<>();
    }

    @Override
    public void add(K key, V value) {
        avlTree.add(key, value);
    }

    @Override
    public V remove(K key) {
        return avlTree.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return avlTree.contains(key);
    }

    @Override
    public V get(K key) {
        return avlTree.get(key);
    }

    @Override
    public void set(K key, V value) {
        avlTree.set(key, value);
    }

    @Override
    public int getSize() {
        return avlTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }
}
