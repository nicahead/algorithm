package 链表;

//21. 合并两个有序链表
public class T21 {
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
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;
        T21 t = new T21();
        System.out.println(t.mergeTwoLists(l11, l21));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 设定一个哑节点来简化边界条件的处理，作为合并链表的头节点之前
        ListNode prehead = new ListNode(0);
        // 临时指针，指向链表合并的当前节点
        ListNode p = prehead;
        // l1和l2分别指向两个链表中正在被指向的节点
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                // 加入新的节点
                p.next = l1;
                // 原链表指针后移
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        // 如果某一条链表还没结束，直接放在尾部
        p.next = l1 == null ? l2 : l1;
        return prehead.next;
    }
}
