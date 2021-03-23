package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
剑指 Offer 32 - II. 从上到下打印二叉树 II
从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class JZ32_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 层次遍历变形
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        // 记录每一层的节点数
        int count = 1;
        while (!queue.isEmpty()) {
            int temp = 0;
            List<Integer> tempList = new ArrayList<>();
            // 处理一层节点
            for (int i = 0; i < count; i++) {
                TreeNode poll = queue.poll();
                tempList.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                    temp++;
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    temp++;
                }
            }
            // 更新层节点数
            count = temp;
            // 保存一层节点
            res.add(tempList);
        }
        return res;
    }
}
