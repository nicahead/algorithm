package 树;

public class T437 {
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
        TreeNode root = new TreeNode(10);
        TreeNode five = new TreeNode(5);
        TreeNode fthree = new TreeNode(-3);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode eleven = new TreeNode(11);
        TreeNode three2 = new TreeNode(3);
        TreeNode ftwo = new TreeNode(-2);
        TreeNode one = new TreeNode(1);
        root.left = five;
        root.right = fthree;
        five.left = three;
        five.right = two;
        fthree.right = eleven;
        three.left = three2;
        three.right = ftwo;
        two.right = one;
        T437 t = new T437();
        System.out.println(t.pathSum(root, 8));
    }

    // 双重递归
    // 遍历所有节点
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // 当前节点判断完之后再判断当前节点的左孩子、右孩子
        return getPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    // 计算以当前节点为根节点存在几条路径
    private int getPath(TreeNode root, int sum) {
        int temp = 0;
        if (root == null) {
            return 0;
        }
        // 去掉了是否为叶子节点的判断
        if (root.val == sum) {
            temp++;
        }
        return temp + getPath(root.left, sum - root.val) + getPath(root.right, sum - root.val);
    }
}
