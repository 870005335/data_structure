package test.com.liubin;


import main.com.liubin.LinkedList.SinglyLinkedList;
import main.com.liubin.tree.bst.BinarySearchTree;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
	    Integer[] arr = new Integer[]{12,5,4,8,9,18,25,69,47,24,36};
	    BinarySearchTree<Integer> bst = new BinarySearchTree<>(arr);
	    bst.inOrderTraversalNr();
	    bst.remove(12);
	    bst.inOrderTraversal();
    }


    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val? head.next : head;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }



        public ListNode(int[] arr) {
            this.val = arr[0];
            ListNode cur = this;
            for (int i : arr) {
                cur.next = new ListNode(i);
                cur = cur.next;
            }
        }

        public static boolean add(ListNode head, int e) {
            if (head == null) {
                return  false;
            }
            head.next = new ListNode(e);
            return  add(head.next, e);
        }

        public static boolean contains(ListNode head, int e) {
            if (head == null) {
                return  false;
            }
            if (head.val == e) {
                return true;
            }
            return contains(head.next, e);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("[");
            ListNode cur = this;
            while (cur != null) {
                if (cur.next == null) {
                    sb.append(cur.val);
                } else {
                    sb.append(cur.val).append("->");
                }
                cur = cur.next;
            }
                sb.append(']');
            return sb.toString();
        }
    }

}
