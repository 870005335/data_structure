package main.com.liubin.map;
/**
* Title:LinkedMap.java
* @discription: 基于链表的映射实现
* @author liubin@segi.com
* @created 2019-11-18 15:17
*/
public class LinkedMap<K, V> implements Map<K, V> {

	private Node dummyHead;
	private int size;

	public LinkedMap() {
		dummyHead = new Node();
		size = 0;
	}

	/**
	 * @discription 根据key得到对应的节点
	 * @author liubin@segimail.com
	 * @date 2019年11月18日 16:14:00
	 * @param key
	 * @return : main.com.liubin.map.LinkedMap<K,V>.Node
	*/
	private Node getNode(K key) {
		Node cur = dummyHead.next;
		while (cur != null) {
			if (cur.key.equals(key)) {
				return cur;
			}
			cur = cur.next;
		}
		return null;
	}

	@Override
	public void add(K key, V value) {
		Node node = getNode(key);
		if (node == null) {
			dummyHead.next = new Node(key, value, dummyHead.next);
			size++;
		} else {
			node.value = value;
		}
	}

	@Override
	public V remove(K key) {
		Node prev = this.dummyHead;
		while (prev.next != null) {
			if (prev.next.key.equals(key)) {
				break;
			}
			prev = prev.next;
		}
		if (prev.next != null) {
			Node delNode = prev.next;
			prev.next = delNode.next;
			delNode.next = null;
			size--;
			return delNode.value;
		}
		return null;
	}

	@Override
	public boolean contains(K key) {
		return getNode(key) != null;
	}

	@Override
	public V get(K key) {
		Node node = getNode(key);
		return node == null ? null : node.value;
	}

	@Override
	public void set(K key, V value) {
		Node node = getNode(key);
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
		public Node next;

		public Node(K key, V value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public Node(K key, V value) {
			this(key, value, null);
		}

		public Node() {
			this(null, null, null);
		}

		@Override
		public String toString() {
			return key.toString() + " " + value.toString();
		}
	}
}
