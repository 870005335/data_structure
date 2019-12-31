package main.com.liubin.tree.avl;


import java.util.ArrayList;
import java.util.List;

/**
* Title:AvlTree.java
* @discription: AVL(平衡二叉树) 二分搜索树
* @author liubin@segi.com
* @created 2019-12-12 18:16
*/
public class AvlTree<K extends Comparable<K>, V>{

	private Node root;
	private int size;

	public AvlTree() {
		root = null;
		size = 0;
	}


	/**
	 * @discription 获取节点的高度
	 */
	private int getHeight(Node node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}

	/**
	 * @discription 计算node节点的平衡因子
	 */
	private int getBalanceFactor(Node node) {
		if (node == null) {
			return 0;
		}
		return getHeight(node.left) - getHeight(node.right);
	}

	/**
	 * @discription 判断一棵树是否是平衡二叉树
	 */
	public boolean isBalanced() {
		return isBalanced(root);
	}

	/**
	 * @discription 判断一棵树是否是平衡二叉树 递归算法
	 */
	private boolean isBalanced(Node node) {
		if (node == null) {
			return true;
		}
		int balanceFactor = getBalanceFactor(node);
		if (Math.abs(balanceFactor) > 1) {
			return false;
		}
		return isBalanced(node.left) && isBalanced(node.right);
	}

	/**
	 * @discription 判断以root为根的二叉树是不是二分搜索树
	 */
	public boolean isBinarySearchTree() {
		List<K> keyList = new ArrayList<>();
		inOrderTraversal(root, keyList);
		for (int i = 1; i < keyList.size(); i++) {
			if (keyList.get(i - 1).compareTo(keyList.get(i)) > 0) {
				return false;
			}
		}
		return true;
	}

	private void inOrderTraversal(Node node, List<K> keyList) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.left, keyList);
		keyList.add(node.key);
		inOrderTraversal(node.right, keyList);
	}



	/**
	 * @discription 对以node为根的二叉树进行左旋转操作
	 */
	private Node leftRotate(Node node) {
		//找到当前节点的右孩子节点
		Node right = node.right;
		//将右孩子节点的左子树挂接到node的右节点
		node.right = right.left;
		//将操作后的node挂接到右孩子节点的左边
		right.left = node;
		//更新需要更新节点的高度值
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		right.height = Math.max(getHeight(right.left), getHeight(right.right)) + 1;
		//返回以右孩子为根的二叉树
		return right;
	}



	/**
	 * @discription 对以node为根的二叉树进行右旋转操作
	 */
	private Node rightRotate(Node node) {
		//找到当前节点的左孩子节点
		Node left = node.left;
		//将左孩子节点的右子树挂接到node的左边
		node.left = left.right;
		//将更新后的节点挂接到左孩子节点的右边
		left.right = node;
		//更新节点的高度值
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		left.height = Math.max(getHeight(left.left), getHeight(left.right)) + 1;
		//返回以左孩子为根的二叉树
		return left;
	}


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
		//更新node的高度值
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		//计算平衡因子
		int balanceFactor = getBalanceFactor(node);
		//节点的平衡因子的绝对值大于一，说明不是平衡二叉树，进行处理
		if (balanceFactor > 1) {
			//插入的节点在不平衡节点左侧的右侧(LR)，进行右旋转操作 转化为LL的情况
			if (getBalanceFactor(node.left) < 0) {
				node.left = leftRotate(node.left);
			}
			//不平衡为LL的情况下，对整棵子树进行右旋转操作
			return rightRotate(node);
		}
		if (balanceFactor < -1) {
			//插入的节点在不平衡节点右侧的左侧(RL)，进行右旋转操作 转化为RR的情况
			if (getBalanceFactor(node.right) > 0) {
				node.right = rightRotate(node.right);
			}
			//不平衡为RR的情况下，对整棵子树进行左旋转操作
			return leftRotate(node);
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

	public boolean contains(K key) {
		Node node = getNode(root, key);
		return node != null;
	}


	public V get(K key) {
		return getNode(root, key).value;
	}

	public void set(K key, V value) {
		Node node = getNode(root, key);
		if (node != null) {
			node.value = value;
		}
	}

	public int getSize() {
		return size;
	}


	public boolean isEmpty() {
		return size == 0;
	}


	private class Node {
		private K key;
		private V value;
		private Node left;
		private Node right;
		private int height;

		Node(K key, V value, Node left, Node right, int height) {
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
			this.height = height;
		}

		private Node(K key, V value) {
			this(key, value, null, null, 1);
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
