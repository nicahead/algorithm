package 数组与矩阵;

//566. 重塑矩阵
public class T566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r * c != nums.length * nums[0].length)
            return nums;
        int[][] res = new int[r][c];
        int m = nums.length, n = nums[0].length;
        for (int i = 0; i < m * n; i++)
            res[i / c][i % c] = nums[i / n][i % n];
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2}, {3, 4}};
        T566 t566 = new T566();
        t566.matrixReshape(nums, 1, 4);
    }
}
