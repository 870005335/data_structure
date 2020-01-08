package main.com.liubin.tree.redblack;

import main.com.liubin.tree.avl.AvlTree;

/**
 * @ClassName RedBlackTree
 * @Description: 红黑树
 * @Author liubin
 * @Date 2020/1/8 0008
 * @Version V1.0
 **/
public class RedBlackTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private int size;

    public RedBlackTree() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return BLACK;
        }
        return node.color;
    }

    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;
        private boolean color;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            color = RED;
        }

    }
}
