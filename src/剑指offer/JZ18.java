package 剑指offer;

//剑指 Offer 18. 删除链表的节点
public class JZ18 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode p = head;
        // 特殊情况，p.next指不到val对应节点
        if (head.val == val)
            return head.next;
        // 一般情况，直接越过这个节点
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }
        return head;
    }
}
