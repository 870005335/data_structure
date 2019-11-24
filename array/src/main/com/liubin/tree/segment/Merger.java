package main.com.liubin.tree.segment;

/**
 * @ClassName Merger
 * @Description: TODO
 * @Author Arthas_liubin@Foxmail.com
 * @Date 2019/11/24 11:27
 * @Version V1.0
 **/
public interface Merger<E> {

    E merge(E e1, E e2);
}
