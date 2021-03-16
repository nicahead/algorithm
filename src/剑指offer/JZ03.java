package 剑指offer;

//剑指 Offer 03. 数组中重复的数字
public class JZ03 {
    public int findRepeatNumber(int[] nums) {
        int[] count = new int[nums.length];
        for (int num : nums) {
            count[num]++;
            if (count[num] > 1) return num;
        }
        return -1;
    }
}
