package main.com.liubin.tree.bst;


import java.util.*;

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

	public BinarySearchTree(E[] arr) {
		for (E e : arr) {
			add(e);
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * @MethodName: contains
	 * @Description: 二分搜索树：是否包含元素e
	 * @param e
	 * @Return: boolean
	 * @Author: Arthas_liubin@Foxmail.com
	 * @Date: 2019/11/15 21:23
	**/
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

	/**
	 * @MethodName: add
	 * @Description: 二分搜索树：添加节点
	 * @param e
	 * @Return: void
	 * @Author: Arthas_liubin@Foxmail.com
	 * @Date: 2019/11/15 21:24
	**/
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

	/**
	 * @MethodName: preOrderTraversal
	 * @Description: 二分搜索树：前序遍历
	 * @param
	 * @Return: void
	 * @Author: Arthas_liubin@Foxmail.com
	 * @Date: 2019/11/15 21:25
	**/
	public List<E> preOrderTraversal() {
		List<E> result = new ArrayList<>();
		preOrderTraversal(root, result);
		return result;
	}

	private void preOrderTraversal(Node node, List<E> list) {
		if (node == null) {
			return;
		}
		list.add(node.e);
		preOrderTraversal(node.left, list);
		preOrderTraversal(node.right, list);
	}

	/**
	 * @MethodName: preOrderTraversalNr
	 * @Description: 二分搜索树：非递归方式前序遍历
	 * @param
	 * @Return: void
	 * @Author: Arthas_liubin@Foxmail.com
	 * @Date: 2019/11/15 21:26
	**/
	public List<E> preOrderTraversalNr() {
		List<E> resultList = new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		Node node = this.root;
		while (node != null || !stack.isEmpty()) {
			if (node != null) {
				resultList.add(node.e);
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop().right;
			}
		}
		return resultList;
	}

	/**
	 * @MethodName: inOrderTraversal
	 * @Description: 二分搜索树：中序遍历
	 * @param
	 * @Return: void
	 * @Author: Arthas_liubin@Foxmail.com
	 * @Date: 2019/11/15 21:26
	**/
	public List<E> inOrderTraversal() {
		List<E> resultList = new ArrayList<>();
		inOrderTraversal(root, resultList);
		return resultList;
	}

	private void inOrderTraversal(Node node, List<E> list) {
		if (null == node) {
			return;
		}
		inOrderTraversal(node.left, list);
		list.add(node.e);
		inOrderTraversal(node.right, list);
	}

	/**
	 * @MethodName: inOrderTraversalNr
	 * @Description: 二分搜索树：非递归中序遍历
	 * @param
	 * @Return: void
	 * @Author: Arthas_liubin@Foxmail.com
	 * @Date: 2019/11/15 21:27
	**/
	public List<E> inOrderTraversalNr() {
		List<E> resultList = new ArrayList<>();
		Node node = this.root;
		Stack<Node> stack = new Stack<>();
		while (node != null || !stack.isEmpty()) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				resultList.add(node.e);
				node = node.right;
			}
		}
		return resultList;
	}

	/**
	 * @MethodName: postOrderTraversal
	 * @Description: 二分搜索树：后序遍历
	 * @param
	 * @Return: void
	 * @Author: Arthas_liubin@Foxmail.com
	 * @Date: 2019/11/15 21:27
	**/
	public List<E> postOrderTraversal() {
		List<E> resultList = new ArrayList<>();
		postOrderTraversal(root, resultList);
		return resultList;
	}

	private void postOrderTraversal(Node node, List<E> list) {
		if (null == node) {
			return;
		}
		postOrderTraversal(node.left, list);
		postOrderTraversal(node.right, list);
		list.add(node.e);
	}

	/**
	 * @MethodName: postOrderTraversalNr
	 * @Description: 二分搜索树：非递归后序遍历
	 * @param
	 * @Return: void
	 * @Author: Arthas_liubin@Foxmail.com
	 * @Date: 2019/11/15 21:27
	**/
	public List<E> postOrderTraversalNr() {
		List<E> resultList = new ArrayList<>();
		Stack<Node> inStack = new Stack<>();
		Stack<Node> outStack = new Stack<>();
		inStack.push(root);
		while (!inStack.isEmpty()) {
			Node node = inStack.pop();
			outStack.push(node);
			if (node.left != null) {
				inStack.push(node.left);
			}
			if (node.right != null) {
				inStack.push(node.right);
			}
		}
		while (!outStack.isEmpty()) {
			resultList.add(outStack.pop().e);
		}
		return resultList;
	}

	/**
	 * @MethodName: levelTraversal
	 * @Description: 二分搜索树：层序遍历
	 * @param
	 * @Return: void
	 * @Author: Arthas_liubin@Foxmail.com
	 * @Date: 2019/11/15 21:27
	**/
	public List<E> levelTraversal() {
		List<E> resultList = new ArrayList<>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			resultList.add(node.e);
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
		return resultList;
	}


	/**
	 * @MethodName: getMin
	 * @Description: 二分搜索树：最小值
	 * @param
	 * @Return: E
	 * @Author: Arthas_liubin@Foxmail.com
	 * @Date: 2019/11/15 21:28
	**/
	public E getMin() {
		if (size == 0) {
			return null;
		}
		return getMin(root).e;
	}

	private Node getMin(Node node) {
		if (node.left == null) {
			return node;
		}
		return getMin(node.left);
	}

	/**
	 * @MethodName: removeMin
	 * @Description: 二分搜索树：移除最小值节点
	 * @param
	 * @Return: E
	 * @Author: Arthas_liubin@Foxmail.com
	 * @Date: 2019/11/15 21:28
	**/
	public E removeMin() {
		E min = getMin();
		removeMin(root);
		return min;
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

	/**
	 * @MethodName: getMax
	 * @Description: 二分搜索树：最大值
	 * @param
	 * @Return: E
	 * @Author: Arthas_liubin@Foxmail.com
	 * @Date: 2019/11/15 21:28
	**/
	public E getMax() {
		if (size == 0) {
			return null;
		}
		return getMax(root).e;
	}

	private Node getMax(Node node) {
		if (node.right == null) {
			return node;
		}
		return getMax(node.right);
	}

	/**
	 * @MethodName: removeMax
	 * @Description: 二分搜索树：移除最大值
	 * @param
	 * @Return: E
	 * @Author: Arthas_liubin@Foxmail.com
	 * @Date: 2019/11/15 21:28
	**/
	public E removeMax() {
		E max = getMax();
		removeMax(root);
		return max;
	}

	private Node removeMax(Node node) {
		if (node.right == null) {
			Node leftNode = node.left;
			node.left = null;
			size--;
			return leftNode;
		}
		node.right = removeMax(node.right);
		return node;
	}


	/**
	 * @MethodName: remove
	 * @Description: 二分搜索树：移除任意元素
	 * @param e
	 * @Return: void
	 * @Author: Arthas_liubin@Foxmail.com
	 * @Date: 2019/11/15 21:29
	**/
	public void remove(E e) {
		root = remove(root, e);
	}

	private Node remove(Node node, E e) {
		if (node == null) {
			return null;
		}
		if (e.compareTo(node.e) < 0) {
			node.left = remove(node.left, e);
			return node;
		} else if (e.compareTo(node.e) > 0) {
			node.right = remove(node.right, e);
			return node;
		} else {
			//当所移除节点的左子树为空，和移除最小值思路一致
			if (node.left == null) {
				Node right = node.right;
				node.right = null;
				size--;
				return right;
			}
			//当所移除节点的右子树为空，和移除最大值思路一致
			if (node.right == null) {
				Node left = node.left;
				node.left = null;
				size--;
				return left;
			}
			//当所移除节点的左右子树均不为空时，将右子树最小节点替代该节点并移除右子树的最小值节点
			Node preSuccessor = getMax(node.left);
			preSuccessor.left = removeMax(node.left);
			preSuccessor.right = node.right;
			node.left = node.right = null;
			return preSuccessor;
		}

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
