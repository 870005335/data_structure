package main.com.liubin.map;

/**
* Title:BstMap.java
* @discription: 基于二分搜索树的映射Map
* @author liubin@segi.com
* @created 2019-11-18 17:39
*/
public class BstMap<K extends Comparable<K>, V> implements Map<K, V> {

	private Node root;
	private int size;

	public BstMap() {
		root = null;
		size = 0;
	}

	@Override
	public void add(K key, V value) {
		root = add(root, key, value);
	}

	private Node add(Node node, K key, V value) {
		if (node == null) {
			size++;
			return new Node(key, value);
		}
		if (key.compareTo(node.key) < 0) {
			node.left = add(node.left, key, value);
		}else if (key.compareTo(node.key) > 0) {
			node.right = add(node.right, key, value);
		} else {
			node.value = value;
		}
		return node;
	}

	/**
	 * @MethodName: getNode
	 * @Description: 返回以node节点为根的二分搜索树，key所在的节点
	 * @param node
	 * @param key
	 * @Return: main.com.liubin.map.BstMap<K,V>.Node
	 * @Author: Arthas_liubin@Foxmail.com
	 * @Date: 2019/11/18 20:51
	**/
	private Node getNode(Node node, K key) {
		if (node == null) {
			return null;
		}
		if (node.key.equals(key)) {
			return node;
		} else if (node.key.compareTo(key) > 0) {
			return getNode(node.left, key);
		} else {
			return getNode(node.right, key);
		}
	}

	private Node getMin(Node node) {
		if (node.left == null) {
			return node;
		}
		return getMin(node.left);
	}

	private Node removeMin(Node node) {
		if (node.left == null) {
			Node right = node.right;
			node.right = null;
			size--;
			return right;
		}
		node.left = removeMin(node.left);
		return node;
	}

	@Override
	public V remove(K key) {
		Node node = getNode(root, key);
		if (node != null) {
			root = remove(root, key);
			return node.value;
		}
		return null;
	}

	private Node remove(Node node, K key) {
		if (node == null) {
			return null;
		}
		if (key.compareTo(node.key) < 0) {
			node.left = remove(node.left, key);
			return node;
		} else if (key.compareTo(node.key) > 0) {
			node.right = remove(node.right, key);
			return node;
		} else {
			if (node.left == null) {
				Node right = node.right;
				node.right = null;
				size--;
				return right;
			}
			if (node.right == null) {
				Node left = node.left;
				node.left = null;
				size--;
				return left;
			}
			Node successor = node.right;
			successor.left = node.left;
			successor.right = removeMin(node.right);
			return successor;
		}
	}

	@Override
	public boolean contains(K key) {
		Node node = getNode(root, key);
		return node != null;
	}


	@Override
	public V get(K key) {
		return getNode(root, key).value;
	}

	@Override
	public void set(K key, V value) {
		Node node = getNode(root, key);
		if (node != null) {
			node.value = value;
		}
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	private class Node {
		public K key;
		public V value;
		public Node left;
		public Node right;


		public Node(K key, V value, Node left, Node right) {
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
		}

		public Node(K key, V value) {
			this(key, value, null, null);
		}

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder("Node{");
			sb.append("key=").append(key);
			sb.append(", value=").append(value);
			sb.append('}');
			return sb.toString();
		}
	}
}
