package 剑指offer;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;

/*
剑指 Offer 32 - III. 从上到下打印二叉树 III
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 */
public class JZ32_3 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 判断奇偶层，决定倒序还是顺序
        boolean flag = true;
        while (!queue.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList<>();
            // 注意这里比较巧妙，i = queue.size()避免栈size变化影响循环
            for (int i = queue.size(); i > 0; i--) {
                TreeNode poll = queue.poll();
                // 奇数层正序
                if (flag) {
                    temp.addLast(poll.val);
                }
                // 偶数层倒序
                else {
                    temp.addFirst(poll.val);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            // 切换奇偶
            flag = !flag;
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode l3 = new TreeNode(3);
        TreeNode l9 = new TreeNode(9);
        TreeNode l20 = new TreeNode(20);
        TreeNode l15 = new TreeNode(15);
        TreeNode l7 = new TreeNode(7);
        l3.left = l9;
        l3.right = l20;
        l20.left = l15;
        l20.right = l7;
        JZ32_3 jz32_3 = new JZ32_3();
        jz32_3.levelOrder(l3);
    }
}
