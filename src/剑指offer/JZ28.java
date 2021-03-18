package 剑指offer;

//对称的二叉树
public class JZ28 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return help(root.left, root.right);
    }

    private boolean help(TreeNode L, TreeNode R) {
        if (L == null && R == null)
            return true;
        if (L == null || R == null || L.val != R.val || L.left.val != R.right.val || L.right.val != R.left.val)
            return false;
        return help(L.left, R.right) && help(L.right, R.left);
    }
}
