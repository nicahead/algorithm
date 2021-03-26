package 剑指offer;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 */
public class JZ53_1 {
    public static int search(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        int index = 0;
        int count = 0;
        // 二分查找，找到一个等于target的位置
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) right = mid - 1;
            if (nums[mid] < target) left = mid + 1;
            if (nums[mid] == target) {
                index = mid;
                count++;
                break;
            }
        }
        int i = index, j = index;
        // 左右移动，记录有多少等于target的数
        while (i > 0) {
            i--;
            if (nums[i] == target) count++;
            else break;
        }
        while (j < nums.length - 1) {
            j++;
            if (nums[j] == target) count++;
            else break;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,3};
        System.out.println(search(nums, 1));
    }
}
