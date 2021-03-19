package 剑指offer;

//剑指 Offer 29. 顺时针打印矩阵
public class JZ29 {
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[0];
        int n = matrix[0].length;
        int[] res = new int[m * n];
        // 初始情况下四个方向的边界
        int top = 0, right = n - 1, bottom = m - 1, left = 0;
        int count = 0;
        while (true) {
            for (int i = left; i <= right; i++) res[count++] = matrix[top][i];
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) res[count++] = matrix[i][right];
            if (--right < left) break;
            for (int i = right; i >= left; i--) res[count++] = matrix[bottom][i];
            if (--bottom < top) break;
            for (int i = bottom; i >= top; i--) res[count++] = matrix[i][left];
            if (++left > right) break;
        }
        return res;
    }
}
