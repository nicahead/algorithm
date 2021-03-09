package 二分查找;

//69. x 的平方根
//寻找右侧边界
public class T69 {
    // x平方根的整数部分ans是满足 k^2 小于等于x的最大 k 值
    public int mySqrt(int x) {
        int left = 0, right = x;
        int res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            // 返回的答案向下取整
            if ((long) mid * mid <= x) {
                left = mid + 1;
                res = mid;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        T69 t69 = new T69();
        System.out.println(t69.mySqrt(2147395599));
    }
}
