package test.com.liubin.test;


import main.com.liubin.LinkedList.SinglyLinkedList;
import main.com.liubin.Student;
import main.com.liubin.array.Array;
import main.com.liubin.tree.bst.BinarySearchTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;


public class Test {
    public static void main(String[] args) {

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
