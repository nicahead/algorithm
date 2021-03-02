package 链表;

// 328. 奇偶链表
public class T328 {
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

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode odd = head, even = head.next;
        ListNode evenHead = even; // 偶节点的头
        while (even != null && even.next != null) {
            // 交替前进，改变链表指向
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        // 连接两条链表
        odd.next = evenHead;
        // head一直指向第一个没有改动，所以是奇节点的头
        return head;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(4);
        ListNode l15 = new ListNode(5);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        T328 t = new T328();
        t.oddEvenList(l11);
    }
}
