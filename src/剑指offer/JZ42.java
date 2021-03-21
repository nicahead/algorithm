package 剑指offer;

/*
剑指 Offer 42. 连续子数组的最大和
输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
要求时间复杂度为O(n)。
 */
public class JZ42 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        // dp[i]表示以元素nums[i]为结尾的连续子数组最大和
        // 由于 dp[i]只与 dp[i-1]和 nums[i]有关系，
        // 因此可以将原数组 nums 用作 dp 列表，即直接在 nums 上修改即可。
        for (int i = 1; i < n; i++) {
            // dp[i - 1] 为正数，对nums[i]起到了积极的作用
            if (nums[i - 1] > 0) {
                nums[i] = nums[i - 1] + nums[i];
            }
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
