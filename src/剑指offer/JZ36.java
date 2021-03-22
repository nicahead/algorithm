package 剑指offer;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

/*
剑指 Offer 36. 二叉搜索树与双向链表
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class JZ36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private Node pre = null, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        help(root);
        // 首尾相连
        head.left = pre;
        pre.right = head;
        return head;
    }

    // cur指向当前遍历到的节点
    private void help(Node cur) {
        if (cur == null) return;
        // 中序遍历
        help(cur.left);

        // pre==null，第一次遍历到底
        if (pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        // 保存cur,pre后移
        pre = cur;

        help(cur.right);
    }
}
