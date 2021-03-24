package 剑指offer;

/*
剑指 Offer 56 - II. 数组中数字出现的次数 II
在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 */
public class JZ56_2 {
    /*
        1. 申请一个长度为32的int数组，用于记录 数组中所有数字 的 每一位的和
        2. 遍历nums数组中的每一个数字：由高到低，遍历当前数字的每一位，若 当前位为1，则使bitSumArray数组的相应的单元的值+1
        3. 根据步骤(2) 计算结果：遍历bitSumArray数组的每一位，取每一位和3取余的结果（肯定为0或1）并将其 加入到 结果result的适当位上
     */
    public int singleNumber(int[] nums) {
        int[] byteSum = new int[32];
        for (int num : nums) {
            int a = 1;
            for (int i = 31; i >= 0; i--) {
                // 一遍历当前数字的每一位，注意存数组是从右往左存的
                // a & num，相同则为1，则num该位置本来就是1。不同的话加0
                // 若 当前位为1，则使byteSum数组的相应的单元的值+1
                if ((a & num) != 0) {
                    byteSum[i]++;
                }
                // a左移一位，处理num的下一位
                a <<= 1;
            }
        }
        int res = 0;
        // 二进制转十进制
        for (int i = 31; i >= 0; i--) {
            res += (int) Math.pow(2, (31 - i)) * (byteSum[i] % 3);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 6, 1};
        JZ56_2 jz56_2 = new JZ56_2();
        System.out.println(jz56_2.singleNumber(nums));
    }
}
