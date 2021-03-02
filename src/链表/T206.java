package 链表;

//206. 反转链表
public class T206 {
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
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        T206 t = new T206();
        ListNode listNode = t.reverseList(one);
        System.out.println();
    }

    // 递归反转链表
    // https://zhuanlan.zhihu.com/p/86745433
    public ListNode reverseList(ListNode head) {
        // 只有一个节点，则直接返回该节点
        if (head == null || head.next == null)
            return head;
        // 反转后面的子列表，使用last节点暂存
        ListNode last = reverseList(head.next);
        // 改变反转后的子列表尾节点指向head节点
        head.next.next = head;
        // head节点和之前的第二个节点断开
        head.next = null;
        return last;
    }
}
