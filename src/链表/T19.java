package 链表;

public class T19 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
        T19 t = new T19();
        ListNode listNode = t.removeNthFromEnd(null, 1);
        System.out.println();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 加入辅助哑节点
        ListNode prehead = new ListNode(-1);
        prehead.next = head;
        // 当 fast 指向末尾的 NULL，slow 与 fast 之间相隔的元素个数为 n 时，那么删除掉 slow 的下一个指针就完成了要求
        ListNode slow = prehead, fast = prehead;
        // 先将快指针往后移动，直到快慢指针间隔为n
        while (n != 0) {
            fast = fast.next;
            n--;
            // n不合法
            if (fast == null)
                return null;
        }
        // 然后一起移动，直到快节点到链表末尾
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 删除该节点
        slow.next = slow.next.next;
        return prehead.next;
    }
}
