package 树;
// 617. 合并二叉树
public class T617 {
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
        TreeNode root1 = new TreeNode(1);
        TreeNode three1 = new TreeNode(3);
        TreeNode two1 = new TreeNode(2);
        TreeNode five1 = new TreeNode(5);
        root1.left = three1;
        root1.right = two1;
        three1.left = five1;

        TreeNode root2 = new TreeNode(2);
        TreeNode one2 = new TreeNode(1);
        TreeNode four2 = new TreeNode(4);
        TreeNode three2 = new TreeNode(3);
        TreeNode seven2 = new TreeNode(7);
        root2.left = one2;
        root2.right = three2;
        one2.right = four2;
        three2.right = seven2;

        T617 t = new T617();
        TreeNode treeNode = t.mergeTrees(root1, root2);
        System.out.println();
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        // 先合并根节点
        root1.val += root2.val;
        // 再递归合并左右子树
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
