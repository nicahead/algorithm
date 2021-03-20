package 剑指offer;

import java.util.Arrays;

//剑指 Offer 40. 最小的k个数
public class JZ40 {
    // 方法1：快速排序
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSort(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSort(int[] arr, int left, int right, int k) {
        // 每快排切分1次，找到排序后基准元素的下标index，如果index恰好等于k就返回index以及index左边所有的数；
        int index = sort(arr, left, right);
        // 此时k左边都是比k小的，加上k刚好满足前k小
        if (index == k) {
            return Arrays.copyOf(arr, index + 1);
        }
        return index > k ? quickSort(arr, left, index - 1, k) : quickSort(arr, index + 1, right, k);
    }

    private int sort(int[] arr, int left, int right) {
        //如果开始位置和结束位置重合，实际上就是一个数字，所以开始位置一定要比结束位置小，而且不能相等
//        if (left >= right) return;
        int i = left, j = right;
        // 为了方便，第一位数作为基准，这个位置空出来了
        int pivot = arr[left];
        // 对当前区间执行操作，大于pivot的放右边，小于它的放左边
        while (i < j) {
            // 左右交替进行
            while (i < j && arr[j] >= pivot) j--;
            // 此时arr[j]比基准要小，则这个数字要覆盖低位的数字
            arr[i] = arr[j];
            // 然后这个时候低位开始移动，如果低位比标准数字小，则低位的下标向后移动一位
            while (i < j && arr[i] <= pivot) i++;
            // 此时arr[i]比基准要大，则这个数字要覆盖高位的数字
            arr[j] = arr[i];
        }
        // 经过上面的一番折腾，这个时候就会出现一个情况，i和j相遇，那么这个位置就用基准去替换
        arr[i] = pivot;
        // 此时第一列排序结束
//        sort(arr, left, i);
//        sort(arr, i + 1, right);
        // 每次排序之后返回基准的位置
        return i;
    }
}
