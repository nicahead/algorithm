package 剑指offer;

public class JZ24 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 方法1：迭代
//    public ListNode reverseList(ListNode head) {
//        ListNode temp = null;
//        while (head != null) {
//            // 头插法建立链表
//            // p指向head
//            ListNode p = head;
//            // head后移
//            head = head.next;
//            // 将该节点从原链表断开，从头部插入到新链表
//            p.next = temp;
//            // 更新新链表头部指针
//            temp = p;
//        }
//        return temp;
//    }
    // 方法2：递归，原地反转
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = reverseList(head.next);
        // return之后首先是 head->node->null
        // 链接node到head
        head.next.next = head;
        // 断开head到node
        head.next = null;
        return temp;
    }
}
