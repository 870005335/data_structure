package main.com.liubin.unionfind;

/**
 * @ClassName UnionFind
 * @Description: 并查集
 * @Author Arthas_liubin@Foxmail.com
 * @Date 2019/12/2 21:01
 * @Version V1.0
 **/
public interface UnionFind {

    boolean isConnected(int p, int q);

    void union (int p, int q);

    int getSize();
}
