package main.com.liubin.unionfind;
/**
* Title:UnionFindThird.java
* @discription: 并查集基于rank的优化和路径压缩
* @author liubin@segi.com
* @created 2019-12-03 16:32
*/
public class UnionFindThird implements UnionFind {

	private int[] parent;

	//用一个数组记录深度 rank[i]表示以i为根的集合所表示的树的层数
	private int[] rank;

	public UnionFindThird(int size) {
		parent = new int[size];
		rank = new int[size];
		for (int i = 0; i < size; i++) {
			parent[i] = i;
			rank[i] = 1;
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
			//路径压缩
			parent[p] = parent[parent[p]];
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


	@Override
	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (parent[pRoot] != parent[qRoot]) {
			//将rank低的元素合并到rank高的元素
			if (rank[pRoot] < rank[qRoot]) {
				parent[pRoot] = qRoot;
			} else if (rank[qRoot] < rank[pRoot]) {
				parent[qRoot] = pRoot;
			} else {
				//当两个根节点高度相同时 被指向的节点高度+1
				parent[pRoot] = qRoot;
				rank[qRoot] += 1;
			}
		}
	}

	@Override
	public int getSize() {
		return parent.length;
	}
}
