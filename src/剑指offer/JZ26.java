package 剑指offer;

//剑指 Offer 26. 树的子结构
public class JZ26 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        } else {
            // 若根节点不匹配，则向子节点寻找
            return help(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
    }

    private boolean help(TreeNode A, TreeNode B) {
        // B遍历完成，说明匹配成功
        if (B == null) {
            return true;
        }
        // A遍历完成，此时B肯定还有节点，说明匹配失败
        if (A == null || A.val != B.val) {
            return false;
        }
        boolean res = true;
        // 当前节点匹配，且左右子树也匹配
        return help(A.left, B.left) && help(A.right, B.right);
    }
}
