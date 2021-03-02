package 链表;

//160. 相交链表
public class T160 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(8);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        headA.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        ListNode headB = new ListNode(5);
        ListNode e = new ListNode(0);
        ListNode f = new ListNode(1);
        headB.next = e;
        e.next = f;
        f.next = b;
        T160 t = new T160();
        System.out.println(t.getIntersectionNode(headA, headB).val);
    }

    // 可以理解成两个人速度一致， 走过的路程一致。那么肯定会同一个时间点到达终点。
    // 如果到达终点的最后一段路两人都走的话，那么这段路上俩人肯定是肩并肩手牵手的。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
            if (pA == null && pB == null) {
                return null;
            }
            if (pA == null) {
                pA = headB;
            }
            if (pB == null) {
                pB = headA;
            }
        }
        return pA;
    }
}
