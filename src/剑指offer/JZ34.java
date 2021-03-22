package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/*
面试题34. 二叉树中和为某一值的路径
输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
*/
public class JZ34 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        help(root, target, res, path);
        return res;
    }

    private void help(TreeNode root, int target, List<List<Integer>> res, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target = target - root.val;
        if (target == 0 && root.left == null && root.right == null) {
            // 新建并复制了一个 path 列表，以防受到 path 变化的影响
            res.add(new ArrayList<>(path));
        }
        help(root.left, target, res, path);
        help(root.right, target, res, path);
        // 由于每层迭代时对应的target不同，所以最后的回溯操作时，不需要再加上当前层减去的root.val值
        // 但是，path是容器，相当于每次迭代共用这一个path，所以必须有回溯语句删除当前路径的最后一个值
        path.remove(path.size() - 1);
        return;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(11);
        TreeNode t5 = new TreeNode(13);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(2);
        TreeNode t9 = new TreeNode(5);
        TreeNode t10 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t5;
        t3.right = t6;
        t4.left = t7;
        t4.right = t8;
        t6.left = t9;
        t6.right = t10;
        JZ34 jz34 = new JZ34();
        System.out.println(jz34.pathSum(t1, 22));
    }
}
