package main.com.liubin.unionfind;

/**
 * @ClassName UnionFindOne
 * @Description: 并查集第一种实现
 * @Author Arthas_liubin@Foxmail.com
 * @Date 2019/12/2 21:29
 * @Version V1.0
 **/
public class UnionFindOne implements UnionFind {

    private int[] id;

    public UnionFindOne(int size) {
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return false;
    }

    @Override
    public void union(int p, int q) {

    }

    @Override
    public int getSize() {
        return id.length;
    }


}
