package 数组与矩阵;

public class T240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        T240 t240 = new T240();
        System.out.println(t240.searchMatrix(nums, 5));
    }
}
