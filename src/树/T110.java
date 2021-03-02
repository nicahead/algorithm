package 树;

//110. 平衡二叉树
public class T110 {
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
        TreeNode root = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);
        root.left = nine;
        root.right = twenty;
        twenty.left = fifteen;
        twenty.right = seven;
        T110 t = new T110();
        System.out.println(t.isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 依次遍历各节点，判断是否是平衡树，这里是先序遍历
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 计算子树深度
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
