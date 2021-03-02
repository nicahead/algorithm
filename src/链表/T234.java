package 链表;

//234. 回文链表
public class T234 {
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
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l4;
        l3.next = l4;
        T234 t = new T234();
        System.out.println(t.isPalindrome(l1));
    }

    public boolean isPalindrome(ListNode head) {
        // 找到链表的中间节点
        ListNode halfNode = getHalfNode(head);
        // 反转右半链表
        ListNode reverse = reverse(halfNode.next);
        // 逐位比较两部分
        while (reverse != null) {
            if (head.val == reverse.val) {
                head = head.next;
                reverse = reverse.next;
            } else {
                return false;
            }
        }
        return true;
    }

    /*
    快慢指针找链表中间节点
    - 若链表长度为奇数，则返回的slow节点刚好在中间
    - 若链表长度为偶数，则返回的slow节点在左半链表的末尾
     */
    private ListNode getHalfNode(ListNode head) {
        ListNode slow = new ListNode(-1, head);
        ListNode fast = new ListNode(-1, head);
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /*
    头插法反转链表
     */
    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        ListNode current = head;  // 当前处理节点，用于控制循环结束
        while (current != null) {
            // 暂存当前处理节点的下一节点
            ListNode temp = current.next;
            // 头插法
            current.next = newHead;
            newHead = current;
            // 还原当前处理节点
            current = temp;
        }
        return newHead;
    }

}
