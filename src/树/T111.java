package 树;

import java.util.ArrayDeque;
import java.util.Queue;

public class T111 {
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
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        root.left = two;
        root.right = three;
        two.left = four;
        two.right = five;
        T111 t = new T111();
        System.out.println(t.minDepth(root));
    }

    public int minDepth(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            res++;
            // 把这一层全部处理完
            int size = queue.size();  //该层的节点数
            for (int i = 0; i < size; i++) {
                TreeNode remove = queue.remove();
                if (remove.left == null && remove.right == null) {
                    return res;
                }
                if (remove.left != null) {
                    queue.add(remove.left);
                }
                if (remove.right != null) {
                    queue.add(remove.right);
                }
            }
        }
        return res;
    }
}
