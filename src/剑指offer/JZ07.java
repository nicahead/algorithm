package 剑指offer;

//剑指 Offer 07. 重建二叉树
public class JZ07 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
       前序遍历的第一个是树的根节点，往后x个是根节点的左子树的前序遍历，再往后y个是根节点的右子树的前序遍历 [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
       中序遍历的中间那个是树的根节点，往左x个是根节点的左子树的中序遍历，往右是根节点的右子树的中序遍历 [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
       通过不断对前序中序划分，每次都能对左孩子右孩子进行划分
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return help(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    // preLeft，preRight：前序遍历中两个子区间的范围 [1],[2,4,7],[3,5,6,8]
    // inLeft，inRight：中遍历中两个子区间的范围 [4,7,2],[1],[5,3,8,6]
    private TreeNode help(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        // 递归终止条件
        if (preLeft >= preorder.length || inLeft >= inorder.length || preLeft > preRight || inLeft > inRight) {
            return null;
        }
        // 拿到前序遍历第一个，作为根节点
        int value = preorder[preLeft];  // value=1
        TreeNode root = new TreeNode(value);
        // 找到其在中序遍历中的位置，并计算长度count
        int count = inLeft;
        while (inorder[count] != value) {
            count++;
        } // count=3,是value在中序遍历中的位置
        // count-中序左边界，得到左子树的节点个数
        count = count - inLeft;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从preLeft + 1 到preLeft + count」个元素就对应了中序遍历中「从inLeft 开始到 inLeft + count - 1」的元素
        root.left = help(preorder, inorder, preLeft + 1, preLeft + count, inLeft, inLeft + count - 1);
        // 先序遍历中「从preLeft + 1 到preLeft + count」个元素就对应了中序遍历中「从inLeft 开始到 inLeft + count - 1」的元素
        root.right = help(preorder, inorder, preLeft + count + 1, preRight, inLeft + count + 1, inRight);
        return root;
    }
}
