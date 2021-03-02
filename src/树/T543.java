package 树;

// 543. 二叉树的直径
public class T543 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);
        root.left = nine;
        root.right = twenty;
        twenty.left = fifteen;
        twenty.right = seven;
        T543 t = new T543();
        System.out.println(t.diameterOfBinaryTree(root));
    }

    int MAX = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return MAX;
    }

    // 错误解答： 最大直径是左子树和右子树的最大深度之和，但是万一最大直径没有经过根节点呢？
    // 所以说对于树中的每一个结点，都要把它视为根节点，然后比较所有结点的左子树和右子树的最大深度之和，取其中的最大值。
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = maxDepth(root.left);
        int R = maxDepth(root.right);
        if (L + R > MAX) {
            MAX = L + R;
        }
        return Math.max(L, R) + 1;
    }
}
