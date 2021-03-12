package 动态规划;

//376. 摆动序列
public class T376 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        // 两种情况取最好
        // 该序列是摆动序列，且最后一个元素呈上升趋势
        int[] dpUp = new int[n];
        // 该序列是摆动序列，且最后一个元素呈下降趋势
        int[] dpDown = new int[n];
        dpUp[0] = 1;
        dpDown[0] = 1;
        int maxL = 1;
        for (int i = 1; i < n; i++) {
            dpUp[i] = 1;
            dpDown[i] = 1;
            for (int j = 0; j < i; j++) {
                // j到i是上升的趋势
                if (nums[i] > nums[j]) {
                    // j-1到j是下降的趋势，所以取 dpDown[j] + 1
                    dpUp[i] = Math.max(dpUp[i], dpDown[j] + 1);
                }
                // j到i是下降的趋势
                if (nums[i] < nums[j]) {
                    dpDown[i] = Math.max(dpDown[i], dpUp[j] + 1);
                }
            }
            maxL = Math.max(maxL, Math.max(dpUp[i], dpDown[i]));
        }
        return maxL;
    }
}
