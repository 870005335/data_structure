package main.com.liubin.tree.bst;

import org.w3c.dom.Node;

/**
* Title:BinarySearchTree.java
* @discription: 二分搜索树
* @author liubin@segi.com
* @created 2019-10-29 13:49
*/
public class BinarySearchTree<E extends Comparable<E>> {

	/**
	 * 根节点
	 */
	private Node root;
	private int size;

	public BinarySearchTree() {
		root = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(E e) {
		Node node = this.root;
		return contains(node, e);
	}

	private boolean contains(Node node, E e) {
		if (node == null) {
			return false;
		}
		if (node.e.equals(e)) {
			return true;
		}
		if (node.e.compareTo(e) > 0) {
			return contains(node.left, e);
		}
		if (node.e.compareTo(e) < 0) {
			return contains(node.right, e);
		}
		return false;
	}

	public void add(E e) {
		root = add(root, e);
	}

	private Node add(Node node, E e) {
		if (node == null) {
			size++;
			return new Node(e);
		}
		if (e.compareTo(node.e) < 0) {
			node.left = add(node.left, e);
		}
		if (e.compareTo(node.e) > 0) {
			node.right = add(node.right, e);
		}
		return node;
	}

	private class Node {
		public E e;
		public Node left;
		public Node right;

		public Node(E e) {
			this.e = e;
			left = null;
			right = null;
		}
	}
}
