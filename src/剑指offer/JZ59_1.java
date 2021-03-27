package 剑指offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class JZ59_1 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        int i = 0, j = 0;
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        while (j < nums.length) {
            // 保证队列单调不增，对于新进入窗口的数字，移去前面比他小的数
            while (!deque.isEmpty() && nums[j] > nums[deque.peekLast()]) {
                deque.removeLast();
            }
            // 存入新进入窗口数字的下标
            deque.offer(j);
            // 如果队首已经是窗口之外，则删除
            if (deque.getFirst() < i) {
                deque.removeFirst();
            }
            // 队首是当前窗口最大值，记录该答案
            res[i] = nums[deque.getFirst()];
            // 还未形成k大小的窗口，则只移动右边界
            if (j - i < k - 1) {
                j++;
            } else {
                i++;
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{};
        maxSlidingWindow(nums, 0);
    }
}
