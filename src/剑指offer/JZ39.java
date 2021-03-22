package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/*
剑指 Offer 39. 数组中出现次数超过一半的数字
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class JZ39 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            int count = 0;
            if (map.containsKey(num)) {
                count = map.get(num);
            }
            if (count + 1 >= Math.ceil((double) n / 2)) return num;
            map.put(num, ++count);
        }
        return -1;
    }

    public static void main(String[] args) {
        JZ39 jz39 = new JZ39();
        int[] a = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(jz39.majorityElement(a));
    }
}

