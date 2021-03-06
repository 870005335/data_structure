package test.com.liubin.test;

import main.com.liubin.tree.avl.AvlTree;

/**
 * @ClassName TestAVLTree
 * @Description: AVL树测试
 * @Author liubin
 * @Date 2019/12/31 0031
 * @Version V1.0
 **/
public class TestAVLTree {

    public static void main(String[] args) {
        AvlTree<Integer, Integer> avlTree = new AvlTree<>();
        avlTree.add(10, 10);
        avlTree.add(9, 9);
        avlTree.add(12, 12);
        avlTree.add(11, 11);
        System.out.println(avlTree.getHeight(12));
        avlTree.remove(10);
        System.out.println(avlTree.getHeight(11));
    }
}
