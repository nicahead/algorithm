package 剑指offer;

import java.util.Stack;

//剑指 Offer 06. 从尾到头打印链表
public class JZ06 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        ListNode p = head;
        Stack<ListNode> stack = new Stack<>();
        while (p != null) {
            stack.add(p);
            p = p.next;
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i] = stack.pop().val;
            i++;
        }
        return res;
    }
}
