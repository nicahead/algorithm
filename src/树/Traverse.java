package 树;

public class Traverse {
    static class TreeNode {
        char value;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(char value) {
            this.value = value;
        }
    }

    public static void preOrder(TreeNode treeNode) {
        if (treeNode == null) return;
        System.out.print(treeNode.value);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    public static void midOrder(TreeNode treeNode) {
        if (treeNode == null) return;
        midOrder(treeNode.left);
        System.out.print(treeNode.value);
        midOrder(treeNode.right);
    }

    public static void postOrder(TreeNode treeNode) {
        if (treeNode == null) return;
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        System.out.print(treeNode.value);
    }

    public static void main(String[] args) {
        // 构造树
        TreeNode root = new TreeNode('F');
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        TreeNode I = new TreeNode('I');
        root.left = B;
        root.right = G;
        B.left = A;
        B.right = D;
        D.left = C;
        D.right = E;
        G.right = I;
        I.left = H;
        System.out.println("前序遍历:");
        preOrder(root);
        System.out.println();
        System.out.println("中序遍历:");
        midOrder(root);
        System.out.println();
        System.out.println("后序遍历:");
        postOrder(root);
    }
}
