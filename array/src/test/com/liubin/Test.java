package test.com.liubin;


public class Test {
    public static void main(String[] args) {
        int[] arr = {1,3,5,9,4,8,6};
        ListNode head = new ListNode(arr);
        System.out.println(head);
        ListNode node = removeElements(head, 1);
        System.out.println(node);
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
