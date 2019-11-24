package main.com.liubin.tree.trie;

import org.w3c.dom.Node;

import java.util.HashMap;

/**
 * @ClassName Trie
 * @Description: 字典树
 * @Author Arthas_liubin@Foxmail.com
 * @Date 2019/11/24 19:39
 * @Version V1.0
 **/
public class Trie {

    private Node root;

    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(String word) {
        Node node = this.root;
        add(word, node, 0);
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//            if (node.next.get(c) == null) {
//                node.next.put(c, new Node());
//            }
//            node = node.next.get(c);
//        }
//        if (!node.isWord) {
//            node.isWord = true;
//            size++;
//        }
    }

    private void add(String word, Node node, int i) {
        if (i == word.length()) {
            if (!node.isWord) {
                node.isWord = true;
                size++;
            }
            return;
        }
        char c = word.charAt(i);
        if (node.next.get(c) == null) {
            node.next.put(c, new Node());
        }
        add(word, node.next.get(c), i + 1);
    }


    public boolean contains(String word) {
        Node node = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.next.get(c) == null) {
                return false;
            }
            node = node.next.get(c);
        }
        return node.isWord;
    }


    private class Node {
        public boolean isWord;
        public HashMap<Character, Node> next;


        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new HashMap<>();
        }

        public Node() {
            this(false);
        }
    }

}
