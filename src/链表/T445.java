package 链表;

import java.util.Stack;

public class T445 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(5);
//        ListNode l12 = new ListNode(2);
//        ListNode l13 = new ListNode(4);
//        ListNode l14 = new ListNode(3);
//        l11.next = l12;
//        l12.next = l13;
//        l13.next = l14;
        ListNode l21 = new ListNode(5);
//        ListNode l22 = new ListNode(6);
//        ListNode l23 = new ListNode(4);
//        l21.next = l22;
//        l22.next = l23;
        T445 t = new T445();
        t.addTwoNumbers(l11, l21);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        // 链表分别进栈
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        int carry = 0; // 存储进位
        ListNode head = null; // head是当前已经得到的列表
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int temp = (stack1.isEmpty() ? 0 : stack1.pop().val) + (stack2.isEmpty() ? 0 : stack2.pop().val) + carry;
            if (temp >= 10) {
                carry = temp / 10;
                temp = temp % 10;
            } else {
                carry = 0;
            }
            // 这里比较难想，头插法建立链表
            ListNode tempNode = new ListNode(temp);
            // 当前节点接上已经得到的列表
            tempNode.next = head;
            // 更新当前列表，即把指针往前移了一位
            head = tempNode;
        }
        return head;
    }
}
