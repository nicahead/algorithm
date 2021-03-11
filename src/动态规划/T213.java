package 动态规划;

import java.util.Arrays;

//213. 打家劫舍 II
public class T213 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        // 第一个房子和最后一个房子中只能选择一个偷窃
        // 两种情况，抢劫第一家，不抢最后一家；抢劫最后一家，不抢第一家。取较大的方案
        // 将环形街道看作两个直的街道
        return Math.max(getMax(Arrays.copyOfRange(nums, 0, nums.length - 1)), getMax(Arrays.copyOfRange(nums, 1, nums.length)));
    }
//    // 常规解法
//    private int getMax(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n];
//        dp[0] = nums[0];
//        if (n > 1) dp[1] = Math.max(nums[0], nums[1]);
//        for (int i = 2; i < n; i++) {
//            dp[i] = dp[i - 1];
//            for (int j = 0; j < i - 1; j++) {
//                dp[i] = Math.max(dp[j] + nums[i], dp[i]);
//            }
//        }
//        return dp[n - 1];
//    }

    // dp[n]只与dp[n-1]和dp[n-2]有关系，因此我们可以设两个变量cur和pre交替记录，将空间复杂度降到 O(1)
    private int getMax(int[] nums) {
        int pre = 0, cur = 0, temp;
        for (int num : nums) {
            temp = cur;
            cur = Math.max(pre + num, cur);
            pre = temp;
        }
        return cur;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        T213 t213 = new T213();
        System.out.println(t213.getMax(nums));
    }
}
