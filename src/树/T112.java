package 树;

import java.util.ArrayDeque;
import java.util.Queue;

//112. 路径总和
public class T112 {
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode eleven = new TreeNode(11);
        TreeNode seven = new TreeNode(7);
        TreeNode two = new TreeNode(2);
        TreeNode eight = new TreeNode(8);
        TreeNode thirteen = new TreeNode(13);
        TreeNode four2 = new TreeNode(4);
        TreeNode one = new TreeNode(1);
        root.left = four;
        root.right = eight;
        four.left = eleven;
        eleven.left = seven;
        eleven.right = two;
        eight.left = thirteen;
        eight.right = four2;
        four2.right = one;
        T112 t = new T112();
        System.out.println(t.hasPathSum(root, 22));
    }
    // 深度优先遍历（递归）
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root == null) {
//            return false;
//        }
//        // 叶子节点是否满足
//        if (root.left == null && root.right == null && targetSum == root.val) {
//            return true;
//        }
//        // 否则递归判断其子节点
//        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
//    }

    // 广度优先遍历（迭代）
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> nodes = new ArrayDeque<>();
        Queue<Integer> vals = new ArrayDeque<>();
        nodes.add(root);
        vals.add(root.val);
        while (!nodes.isEmpty()) {
            // 取出队头
            TreeNode node = nodes.remove();
            Integer val = vals.remove();
            if (node.left != null) {
                nodes.add(node.left);
                vals.add(val + node.left.val);
            }
            if (node.right != null) {
                nodes.add(node.right);
                vals.add(val + node.right.val);
            }
            if (node.left == null && node.right == null && val == targetSum) {
                return true;
            }
        }
        return false;
    }
}
