package 剑指offer;

/*
剑指 Offer 56 - I. 数组中数字出现的次数
一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class JZ56_1 {
    public int[] singleNumbers(int[] nums) {
        // 异或满足交换律，第一步异或，相同的数都抵消了，剩下两个不同的数
        // 这两个数异或结果肯定有某一位为1（即不同），不然都是0的话就是相同数了
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        // 找出这位不相同的二进制数，使用mask表示
        // mask是一个二进制数，且其中只有一位是1，其他位全是0
        // 设置mask为1，则其二进制为0001
        // & 操作只有 1&1 时等于1 其余都等于0。
        // 比如，mask = 0001，xor = 1010,则 xor & mask = 0
        // 那么mask左移，直到找到第一个xor为1的那一位，比如mask = 0010, 则xor & mask = 0010，则可以确定mask
        // 对应到这两个数上来看的话，他们在倒数第二位上肯定不同
        int mask = 1;
        while ((xor & mask) == 0) {
            mask <<= 1;
        }
        // 按此位将所有数分成两组，倒数第二位是0的数字分到一组，倒数第二位是1的分到另一组
        // 这样相同的数字肯定能分到同一组，同时这两个不同的数也能因此分开，然后分别全员异或
        int a = 0, b = 0;
        for (int num : nums) {
            // 组1全员异或
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
