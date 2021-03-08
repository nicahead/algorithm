package 哈希表;

import java.util.HashMap;

//1. 两数之和
public class T1 {
    public int[] twoSum(int[] nums, int target) {
        // 哈希表
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i]))
                return new int[]{i, hashMap.get(target - nums[i])};
            // 值：index
            hashMap.put(nums[i], i);
        }
        return new int[-1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        T1 t1 = new T1();
        int[] ints = t1.twoSum(nums, 9);
    }
}
