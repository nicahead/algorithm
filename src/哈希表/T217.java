package 哈希表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//217. 存在重复元素
public class T217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        T217 t217 = new T217();
        System.out.println(t217.containsDuplicate(nums));
    }
}
