package 树;
// 这题没搞懂

public class T687 {
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
        TreeNode root = new TreeNode(5);
        TreeNode four1 = new TreeNode(4);
        TreeNode five1 = new TreeNode(5);
        TreeNode five2 = new TreeNode(5);
        TreeNode one1 = new TreeNode(1);
        TreeNode one2 = new TreeNode(1);
        root.left = four1;
        root.right = five1;
        four1.left = one1;
        four1.right = one2;
        five1.right = five2;
        T687 t = new T687();
        System.out.println(t.longestUnivaluePath(root));
    }

    int maxPath = 0;

    public int longestUnivaluePath(TreeNode root) {
        maxPath = 0;
        getMaxPath(root);
        return maxPath;
    }

    private int getMaxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int temp = 0;
        int left = longestUnivaluePath(root.left);
        int right = longestUnivaluePath(root.right);
        if (root.right != null && root.right.val == root.val && root.left != null && root.left.val == root.val) {
            maxPath = Math.max(maxPath, left + 1 + right + 1);
        }
        if (root.left != null && root.left.val == root.val) {
            temp = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            temp = Math.max(temp, right + 1);
        }
        maxPath = Math.max(maxPath, temp);
        return temp;
    }
}
