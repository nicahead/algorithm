package 链表;

//725. 分隔链表
public class T725 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int length = 0;
        ListNode[] res = new ListNode[k];
        // 获取链表长度
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        // 链表平均长度
        int avg = length / k, mod = length % k;
        cur = root; // 遍历
        // 共处理k段
        for (int i = 0; i < k; i++) {
            ListNode newHead = cur;
            // 处理一段
            for (int j = 0; j < avg + (mod > 0 ? 1 : 0) - 1; j++) {
                if (cur != null)
                    cur = cur.next;
            }
            // 断开链表（这里注意一下）
            if (cur != null) {
                // 创建一个节点记录cur节点，这样本段链表和cur节点没有关系了
                ListNode pre = cur;
                // cur节点往后移
                cur = cur.next;
                // 截断
                pre.next = null;
            }
            res[i] = newHead;
            mod--;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
//        l1.next = l2;
//        l2.next = l3;
//        T725 t = new T725();
//        ListNode[] listNodes = t.splitListToParts(l1, 5);
//        System.out.println();
        ListNode[] res = new ListNode[2];
        res[0] = l1;
        res[1] = null;
        System.out.println(res);
    }
}
