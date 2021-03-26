package 剑指offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 */
public class JZ61 {
    /*
    1. 首先需满足，五张牌不能有重复
    2. max-min<5
        0张大小王 -> max-min=4
        1张大小王 -> max-min=4或3
        2张大小王 -> max-min=4或3或2
     */
    public static boolean isStraight(int[] nums) {
        // 使用hashset判断牌有没有重复
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num != 0) {
                if (!set.add(num)) return false;
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
        }
        return max - min < 5;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 7, 5, 9, 2};
        System.out.println(isStraight(nums));
    }
}
