package 剑指offer;

import java.util.HashMap;

//剑指 Offer 35. 复杂链表的复制
public class JZ35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        // 第一次遍历原链表，建立新节点，并保存原节点和新节点的映射
        Node p = head;
        HashMap<Node, Node> map = new HashMap<>();
        while (p != null) {
            Node newNode = new Node(p.val);
            map.put(p, newNode);
            p = p.next;
        }
        p = head;
        // 第二次遍历原链表，复制节点的指向
        while (p != null) {
            Node newNode = map.get(p);
            newNode.next = map.get(p.next);
            newNode.random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }
}
