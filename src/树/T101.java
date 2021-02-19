package 树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class T101 {
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
        TreeNode root = new TreeNode(1);
        TreeNode two1 = new TreeNode(2);
        TreeNode two2 = new TreeNode(2);
        TreeNode three1 = new TreeNode(3);
        TreeNode three2 = new TreeNode(3);
        TreeNode four1 = new TreeNode(4);
        TreeNode four2 = new TreeNode(4);
        root.left = two1;
        root.right = two2;
        two1.left = three1;
        two2.right = three2;
        two1.right = four1;
        two2.left = four2;
        T101 t = new T101();
        System.out.println(t.isSymmetric(root));
    }

    // 递归方法
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        return check(root.left, root.right);
//    }
//
//    private boolean check(TreeNode t1, TreeNode t2) {
//        if (t1 == null && t2 == null) {
//            return true;
//        }
//        if (t1 == null || t2 == null) {
//            return false;
//        }
//        // 两个子树的值相等 且 子树1的左孩子等于子树2的右孩子 且 子树1的右孩子等于子树2的左孩子
//        return t1.val == t2.val && check(t1.left, t2.right) && check(t1.right, t2.left);
//    }

    // 迭代方法
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root, root);
    }

    private boolean check(TreeNode t1, TreeNode t2) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(t1);
        queue.add(t2);
        while (!queue.isEmpty()) {
            TreeNode remove1 = queue.remove();
            TreeNode remove2 = queue.remove();
            if (remove1.val != remove2.val) {
                return false;
            }
            if (remove1.left != null && remove2.right != null) {
                queue.add(remove1.left);
                queue.add(remove2.right);
            }
            if (remove1.right != null && remove2.left != null) {
                queue.add(remove1.right);
                queue.add(remove2.left);
            }
            // 一个为null一个不为null
            if ((remove1.left == null && remove2.right != null) || remove1.right == null && remove2.left != null) {
                return false;
            }
        }
        return true;
    }
}
