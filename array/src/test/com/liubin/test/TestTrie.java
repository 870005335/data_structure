package test.com.liubin.test;

import main.com.liubin.tree.trie.Trie;

/**
 * @ClassName TestTrie
 * @Description: TODO
 * @Author Arthas_liubin@Foxmail.com
 * @Date 2019/11/24 21:36
 * @Version V1.0
 **/
public class TestTrie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("catty");
        trie.add("cat");
        trie.add("dog");
        System.out.println(trie.getSize());
        System.out.println(trie.contains("cat"));
    }
}
