package 剑指offer;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class JZ33 {
    public boolean verifyPostorder(int[] postorder) {
        return resur(postorder, 0, postorder.length - 1);
    }

    private boolean resur(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        // 传进来的是一个子树，最右边（j）是根节点，左子树全部比根节点小，右子树全部比根节点大
        // 从最左边找到第一个比根节点大的值，假设他是右子树的第一个节点
        int tempI = i;
        while (postorder[tempI] < postorder[j]) {
            tempI++;
        }
        int tempII = tempI;
        // 判断剩下的部分是否全都比根节点大
        while (tempII < j) {
            // 出现一个比根节点小的，就不满足，直接返回false
            if (postorder[tempII] < postorder[j]) {
                return false;
            }
            tempII++;
        }
        // 此时[i,tempI-1]是根节点的左子树,[tempI,j-1]是根节点的右子树
        // 递归下去，左右子树仍然满足二叉搜索树的条件
        return resur(postorder, i, tempI - 1) && resur(postorder, tempI, j - 1);
    }
}
