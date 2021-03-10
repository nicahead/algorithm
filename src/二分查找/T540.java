package 二分查找;

//540. 有序数组中的单一元素
public class T540 {
    // 对所有偶数索引进行搜索，直到遇到第一个其后元素不相同的索引
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // 若mid是奇数，则其左边有奇数个元素，右边偶数个
            if (mid % 2 == 1) mid--;
            // 此时mid一定为偶数，mid左边有偶数个元素，右边奇数个
            // 若和后面元素相同，且此时左边有偶数个元素，则说明特殊的数出现在右边
            if (nums[mid] == nums[mid + 1]) left = mid + 2;
            else right = mid;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 7, 7, 10, 11, 11};
        T540 t540 = new T540();
        System.out.println(t540.singleNonDuplicate(nums));
    }
}
