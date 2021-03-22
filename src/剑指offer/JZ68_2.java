package 剑指offer;

/*
剑指 Offer 68 - II. 二叉树的最近公共祖先
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class JZ68_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件,root.val等于p或q的值
        // 这里的判断是从上往下的
        if (root == null || root.val == p.val || root.val == q.val) return root;
        // 后续遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 下面的步骤是从下往上的（类似回溯）
        // 当 left 和 right 同时为空 ：说明 root 的左 / 右子树中都不包含 p,q ，返回 null
        if (left == null && right == null) return null;
        // 当 left 为空 ，right 不为空 ：p,q 都不在 root的左子树中，直接返回 right
        if (left == null) return right;
        if (right == null) return left;
        // 当 left 和 right 同时不为空 ：说明 p, q 分列在 root的 异侧 （分别在 左 / 右子树），因此 root为最近公共祖先，返回 root
        return root;
    }
}
