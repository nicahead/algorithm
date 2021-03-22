package 剑指offer;

/*
剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class JZ68 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    /*
    若 root是 p,q的 最近公共祖先 ，则只可能为以下情况之一：
    p 和 q 在 root 的子树中，且分列 root 的 异侧（即分别在左、右子树中）；
    p = root，且 q 在 root 的左或右子树中；
    q = root，且 p 在 root 的左或右子树中
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        int maxValue = Math.max(p.val, q.val), minValue = Math.min(p.val, q.val);
        if (minValue > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (maxValue < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}
