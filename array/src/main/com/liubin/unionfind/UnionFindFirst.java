package main.com.liubin.unionfind;

/**
 * @ClassName UnionFindOne
 * @description: 并查集第一种实现
 * @author Arthas_liubin@Foxmail.com
 * @date 2019/12/2 21:29
 * @version V1.0
 **/
public class UnionFindFirst implements UnionFind {

    private int[] id;

    public UnionFindFirst(int size) {
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    private boolean checkIndex(int index) {
        if (index > 0 && index < id.length) {
            return true;
        }
        return false;
    }

    /**
     * @discription 查询元素p所对应的集合编号
     */
    private int find(int p) {
        if (checkIndex(p)) {
            return id[p];
        }
        return -1;
    }

    /**
     * @discription 元素p、q是否相连(是否在同一个集合)
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * @discription 将元素p、q连接(放入同一个集合)
     */
    @Override
    public void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if (pid != qid) {
            for (int i = 0; i < id.length; i++) {
                if (id[i] == pid) {
                    id[i] = qid;
                }
            }
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }


}
