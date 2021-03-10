package 动态规划;

//70. 爬楼梯
public class T70 {
//    public int climbStairs(int n) {
//        if (n == 1) return 1;
//        else if (n == 2) return 2;
//        return climbStairs(n - 1) + climbStairs(n - 2);
//    }

    // 递归算法会超时
    public int climbStairs(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public static void main(String[] args) {
        T70 t70 = new T70();
        System.out.println(t70.climbStairs(45));
    }
}
