package 剑指offer;

/*
剑指 Offer 66. 构建乘积数组
给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 */
public class JZ66 {
    public int[] constructArr(int[] a) {
        int n = a.length;
        int[] B = new int[n];
        if (n == 0) return B;
        // 自上向下，计算下三角，记录B数组的值
        B[0] = 1;
        for (int i = 1; i < n; i++) {
            // 借用上一步结果
            B[i] = B[i - 1] * a[i - 1];
        }
        // 自下而上，计算上三角，继续计算B数组的值
        int temp = 1;
        for (int i = n - 2; i >= 0; i--) {
            temp = temp * a[i + 1];
            B[i] = B[i] * temp;
        }
        return B;
    }
}
