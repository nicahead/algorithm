package 剑指offer;

//剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
public class JZ21 {
    public int[] exchange(int[] nums) {
        int n = nums.length;
        if (n < 2) return nums;
        // 双指针
        int i = 0, j = n - 1;
        while (i < j) {
            if (nums[i] % 2 == 1) {
                i++;
                continue;
            }
            if (nums[j] % 2 == 0) {
                j--;
                continue;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            // 交换完nums[i]肯定是奇数，nums[j]肯定是偶数
            // 可以减少2次遍历
            i++;
            j--;
        }
        return nums;
    }
}
