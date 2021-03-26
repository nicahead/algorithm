package 剑指offer;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 */
public class JZ52 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pa = headA, pb = headB;
        while (!(pa == null && pb == null)) {
            if (pa == pb) return pa;
            if (pa == null) pa = headB;
            else  pa = pa.next;
            if (pb == null) pb = headA;
            else pb = pb.next;
        }
        return null;
    }
}
