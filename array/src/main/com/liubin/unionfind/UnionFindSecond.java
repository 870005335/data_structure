package main.com.liubin.unionfind;
/**
* Title:UnionFindSecond.java
* @discription: 并查集第二种实现并基于size进行优化
* @author Arthas_liubin@Foxmail.com
* @created 2019-12-03 11:58
*/
public class UnionFindSecond implements UnionFind {

	private int[] parent;

	//添加一个数组 eSize[i]表示以i为根的集合所表示的树的元素个数
	private int[] eSize;

	public UnionFindSecond(int size) {
		parent = new int[size];
		eSize = new int[size];
		for (int i = 0; i < size; i++) {
			parent[i] = i;
			eSize[i] = 1;
		}
	}

	private boolean checkIndex(int index) {
		if (index > 0 && index < parent.length) {
			return true;
		}
		return false;
	}

	/**
	 * @discription 查询元素p所对应的根节点
	 */
	private int find(int p) {
		if (!checkIndex(p)) {
			throw new IllegalArgumentException("index is out of bound");
		}
		while (p != parent[p]) {
			p = parent[p];
		}
		return p;
	}

	/**
	 * @discription 元素p、q是否相连(是否在同一个集合) 时间复杂度O(h) h为树的高度
	 */
	@Override
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	/**
	 * @discription 合并元素p、q所在集合 时间复杂度O(h) h为树的高度
	 */
	@Override
	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (qRoot != pRoot) {
			//将p、q所在树中元素size较小的挂接到较大的
			if (eSize[pRoot] < eSize[qRoot]) {
				parent[pRoot] = qRoot;
				eSize[qRoot] += eSize[pRoot];
			} else {
				parent[qRoot] = pRoot;
				eSize[pRoot] += eSize[qRoot];
			}
		}
	}

	@Override
	public int getSize() {
		return parent.length;
	}
}
