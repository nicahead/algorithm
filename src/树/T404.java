package 树;

public class T404 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
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
        T404 t = new T404();
        System.out.println(t.sumOfLeftLeaves(root));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumOfLeftLeave(root.left, true) + sumOfLeftLeave(root.right, false);
    }

    public int sumOfLeftLeave(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            if (isLeft == true) {
                return root.val;
            } else {
                return 0;
            }
        }
        return sumOfLeftLeave(root.left, true) + sumOfLeftLeave(root.right, false);
    }
}
