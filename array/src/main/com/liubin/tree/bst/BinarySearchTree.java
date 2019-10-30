package main.com.liubin.tree.bst;


import java.util.Stack;

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

	public void preOrderTraversal() {
		preOrderTraversal(root);
	}

	private void preOrderTraversal(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.e);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}

	public void preOrderTraversalNR() {
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			if (null != cur.right) {
				stack.push(cur.right);
			}
			if (null != cur.left) {
				stack.push(cur.left);
			}
		}
	}

	public void inOrderTraversal() {
		inOrderTraversal(root);
	}

	private void inOrderTraversal(Node node) {
		if (null == node) {
			return;
		}
		inOrderTraversal(node.left);
		System.out.println(node.e);
		inOrderTraversal(node.right);
	}

	public void postOrderTraversal() {
		preOrderTraversal(root);
	}

	private void postOrderTraversal(Node node) {
		if (null == node) {
			return;
		}
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.println(node.e);
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
