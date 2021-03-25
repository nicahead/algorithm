package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/*
剑指 Offer 57. 和为s的两个数字
输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 */
public class JZ57 {
    public int[] twoSum(int[] nums, int target) {
        // key是target-num，value是num
        // 若遍历到的num1和key对应，则说明num1+num=target
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) return new int[]{num, map.get(num)};
            map.put(target - num, num);
        }
        return new int[0];
    }
}
