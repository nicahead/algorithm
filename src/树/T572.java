package 树;

import java.util.ArrayDeque;
import java.util.Queue;

//572. 另一个树的子树
public class T572 {
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
        TreeNode root1 = new TreeNode(3);
        TreeNode four1 = new TreeNode(4);
        TreeNode five1 = new TreeNode(5);
        TreeNode one1 = new TreeNode(1);
        TreeNode two1 = new TreeNode(2);
        root1.left = four1;
        root1.right = five1;
        four1.left = one1;
        four1.right = two1;

        TreeNode root2 = new TreeNode(4);
        TreeNode one2 = new TreeNode(1);
        TreeNode two2 = new TreeNode(2);
        root2.left = one2;
        root2.right = two2;
        T572 t = new T572();
        System.out.println(t.isSubtree(root1, root2));
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return check(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    // 判断以当前节点作为根节点是否存在子树
    private boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }

}
