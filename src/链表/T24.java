package 链表;

//24. 两两交换链表中的节点
public class T24 {
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
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        T24 t = new T24();
        t.swapPairs(l1);
        System.out.println();
    }

    // 三指针迭代
    public ListNode swapPairs(ListNode head) {
        ListNode prehead = new ListNode(-1, head);
        // temp 表示当前到达的节点
        // 每次需要交换 temp 后面的两个节点
        ListNode temp = prehead, p1 = head, p2 = head.next;
        while (temp.next != null && temp.next.next != null) {
            // 交换
            temp.next = p2;
            p1.next = p2.next;
            p2.next = p1;
            // 重新归位
            temp = p1;
            p1 = p1.next;
            p2 = p1.next;
        }
        return prehead.next;
    }
    // 递归
}
