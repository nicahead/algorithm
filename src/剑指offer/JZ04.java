package 剑指offer;

//剑指 Offer 04. 二维数组中的查找
public class JZ04 {
    // 从右上角往左下角看，是一棵二叉搜索树
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // {} 空，没有matrix[0]
        int m = matrix.length;
        if (m == 0) return false;

        // {{},{}}, m > 1, n = 0, j = n - 1会报错
        int n = matrix[0].length;
        if (n == 0) return false;

        int i = 0, j = n - 1;
        // 找到最左边都没有，说明没有更小的了，找不到了
        // 找到最下边都没有，说明没有更大的了，找不到了
        while (i <= m - 1 && j >= 0) {
            // matrix[i][j]为根，target比它大，在其右侧
            if (target > matrix[i][j]) {
                i++;
            } else if (target < matrix[i][j]) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 1}};
        JZ04 jz04 = new JZ04();
        jz04.findNumberIn2DArray(a, 2);
    }
}
