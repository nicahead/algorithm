package 链表;

public class T83 {
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
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l5.next = l5;
        T83 t = new T83();
        System.out.println(t.deleteDuplicates(l1));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.val == p.next.val)
                p.next = p.next.next;
            else
                p = p.next;
        }
        return head;
    }
}
