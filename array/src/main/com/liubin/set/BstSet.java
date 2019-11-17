package main.com.liubin.set;

import main.com.liubin.tree.bst.BinarySearchTree;

/**
 * @ClassName BstSet
 * @Description: 基于二分搜索树的集合Set
 * @Author Arthas_liubin@Foxmail.com
 * @Date 2019/11/17 12:14
 * @Version V1.0
 **/
public class BstSet<E extends Comparable<E>> implements Set<E> {

    private BinarySearchTree<E> binarySearchTree;

    public BstSet() {
        binarySearchTree = new BinarySearchTree<>();
    }

    @Override
    public void add(E e) {
        binarySearchTree.add(e);
    }

    @Override
    public void remove(E e) {
        binarySearchTree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return binarySearchTree.contains(e);
    }

    @Override
    public int getSize() {
        return binarySearchTree.size();
    }

    @Override
    public boolean isEmpty() {
        return binarySearchTree.isEmpty();
    }
}
