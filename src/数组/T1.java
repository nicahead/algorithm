package 数组;

// 1. 两数之和
public class T1 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        T1 t = new T1();
        System.out.println(t.twoSum(nums, target));
        ;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }
}
