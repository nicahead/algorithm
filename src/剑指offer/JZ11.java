package 剑指offer;

//剑指 Offer 11. 旋转数组的最小数字
public class JZ11 {
    public int minArray(int[] numbers) {
        if (numbers.length == 0) return 0;
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 左排序数组任意一个数都大于右排序数组中的值
            // mid位于右排序数组，则旋转点在左边
            if (numbers[mid] < numbers[right]) {
                right = mid;
            }
            // mid位于左排序数组，则旋转点在右边
            else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                // 相等的情况下无法判断，移动right缩小范围
                right--;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1};
        JZ11 jz11 = new JZ11();
        int i = jz11.minArray(a);
    }
}
