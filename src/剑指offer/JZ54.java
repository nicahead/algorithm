package 剑指offer;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 */
public class JZ54 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 中序遍历（左根右） -> 正序
    // 右根左 -> 逆序
    int res = 0, count;

    public int kthLargest(TreeNode root, int k) {
        this.count = k;
        help(root);
        return res;
    }

    private void help(TreeNode root) {
        if (root == null) return;
        help(root.right);
        ///////////////////////////////////////
        if (count == 0) return;
        if (--count == 0) {
            res = root.val;
            return;
        }
        ///////////////////////////////////////
        help(root.left);
    }

    public static void main(String[] args) {
        TreeNode l3 = new TreeNode(3);
        TreeNode l1 = new TreeNode(1);
        TreeNode l4 = new TreeNode(4);
        TreeNode l2 = new TreeNode(2);
        l3.left = l1;
        l3.right = l4;
        l1.right = l2;
        JZ54 jz54 = new JZ54();
        jz54.kthLargest(l3, 2);
    }
}
