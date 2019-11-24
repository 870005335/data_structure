package test.com.liubin.test;

import main.com.liubin.tree.segment.SegmentTree;

/**
 * @ClassName TestSegmentTree
 * @Description: 测试线段树
 * @Author Arthas_liubin@Foxmail.com
 * @Date 2019/11/24 12:10
 * @Version V1.0
 **/
public class TestSegmentTree {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,-5,6,8,9,-6};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(arr, (e1, e2) -> e1 + e2);
        System.out.println(segmentTree.query(0, 5));
        segmentTree.set(3, 5);
        System.out.println(segmentTree.query(0, 5));
    }
}
