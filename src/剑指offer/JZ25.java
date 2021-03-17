package 剑指offer;

//剑指 Offer 25. 合并两个排序的链表
public class JZ25 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 由于初始状态合并链表中无节点，因此循环第一轮时无法将节点添加到合并链表中
        // 故添加伪节点
        ListNode preHead = new ListNode(-1);
        ListNode p1 = l1, p2 = l2, p = preHead;
        while (p1 != null && p2 != null) {
            if (p1.val >= p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        p.next = p1 == null ? p2 : p1;
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(3);
        ListNode l13 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;
        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;
        JZ25 jz25 = new JZ25();
        ListNode listNode = jz25.mergeTwoLists(null, null);
    }
}
