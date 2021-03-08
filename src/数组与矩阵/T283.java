package 数组与矩阵;
//283. 移动零
public class T283 {
    public void moveZeroes(int[] nums) {
        // 双指针
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] != 0) {
                i++;
                j++;
            } else if (nums[i] == 0 && nums[j] != 0) {
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
                j++;
            } else if (nums[j] == 0) {
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        T283 t283 = new T283();
        t283.moveZeroes(nums);
    }
}
