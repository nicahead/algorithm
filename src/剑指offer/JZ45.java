package 剑指offer;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 */
public class JZ45 {
    public String minNumber(int[] nums) {
        mySort(nums, 0, nums.length - 1);
        StringBuffer buffer = new StringBuffer();
        for (int num : nums) {
            buffer.append(num);
        }
        return buffer.toString();
    }

    /*
        自定义排序
        先根据首位排序，再根据次位，以此类推，基于快速排序实现
     */
    private void mySort(int[] nums, int left, int right) {
        if (left < right) {
            int p = partition(nums, left, right);
            mySort(nums, left, p);
            mySort(nums, p + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left, j = right;
        while (i < j) {
            // 比较，右边比nums[pivot]大则继续左移
            while (i < j && compare(nums[j], pivot)) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && !compare(nums[i], pivot)) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        return i;
    }

    // 排序判断规则 为：
    // 若拼接字符串 x + y > y + x，则 x “大于” y
    // 反之，若 x + y < y，则 x “小于” y
    private boolean compare(int a, int b) {
        return Long.valueOf(a + "" + b) >= Long.valueOf(b + "" + a);
    }

    public static void main(String[] args) {
        JZ45 jz45 = new JZ45();
        int[] nums = new int[]{999999998,999999997,999999999};
        System.out.println(jz45.minNumber(nums));
    }
}
