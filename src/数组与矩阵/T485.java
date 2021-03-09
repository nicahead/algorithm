package 数组与矩阵;

//485. 最大连续 1 的个数
public class T485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, res = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                res = count > res ? count : res;
                count = 0;
            }
        }
        // 避免最大连续1出现在末尾
        res = count > res ? count : res;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0, 1, 1, 1};
        T485 t485 = new T485();
        System.out.println(t485.findMaxConsecutiveOnes(nums));
    }
}
