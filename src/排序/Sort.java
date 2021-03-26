package 排序;

public class Sort {
    /**
     * 冒泡排序
     * 步骤1: 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 步骤2: 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 步骤3: 针对所有的元素重复以上的步骤，除了最后一个；
     * 步骤4: 重复步骤1~3，直到排序完成。
     *
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * 步骤1：初始状态：无序区为R[1…n]，有序区为空；
     * 步骤2：第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1…i-1]和R(i…n）。
     * 该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1…i]和R[i+1…n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     * 步骤3：n-1趟结束，数组有序化了。
     *
     * @param nums
     */
    public static void selectionSort(int[] nums) {
        int minIndex;
        for (int i = 0; i < nums.length; i++) {
            // nums[i]是无序区第一个元素
            minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                // 找到当前无序区最小元素的下标
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            // 将其与无序区第一个元素交换，即无序区元素减一，有序区加一
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }

    /**
     * 插入排序
     * 步骤1: 从第一个元素开始，该元素可以认为已经被排序；
     * 步骤2: 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 步骤3: 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 步骤4: 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 步骤5: 将新元素插入到该位置后；
     * 步骤6: 重复步骤2~5。
     *
     * @param nums
     */
    public static void insertionSort(int[] nums) {
        // i表示已排序区间的右边界
        for (int i = 0; i < nums.length - 1; i++) {
            // 当前处理的元素是第一个未排序的数字
            int cur = nums[i + 1];
            // 指针初始位于cur的前一个
            int preIndex = i;
            // 在未找到第一个小于cur的数字之前，或已经到达边界
            // 数字后移，指针前移
            while (preIndex >= 0 && nums[preIndex] > cur) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            // 放到该数字后面
            nums[preIndex + 1] = cur;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 3, 5, 2, 8, 4, 9, 1};
        insertionSort(nums);
        System.out.println();
    }
}
