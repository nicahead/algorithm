package 剑指offer;

/*
剑指 Offer 44. 数字序列中某一位的数字
数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
请写一个函数，求任意第n位对应的数字。
 */
public class JZ44 {
    /*
      取值    个数    位数
      1-9     9       9
      10-99   90      180
      100-999 900     2700
     */
    public int findNthDigit(int n) {
        if (n < 10) return n;
        // count记录9+190+、、、、
        // index记录第几层（多少位），开始是第一层，即1-9
        long count = 0, index = 1;
        while (count < n) {
            count += 9 * index * (int) Math.pow(10, index - 1);
            index++;
        }
        index--;
        count -= 9 * index * (int) Math.pow(10, index - 1);
        // 在第index层则一个数字占index位，算出是这一层的第几个数(从1开始)
        int a = (int) Math.ceil((n - count) / (float) index);
        // 得到这个数的真实值
        long digit = (int) Math.pow(10, index - 1) + a - 1;
        // n是这个数字digit的第几位
        long b = (n - count) % index == 0 ? index - 1 : (n - count) % index - 1;
        // 数字转字符串，并定位
        char res = Long.toString(digit).charAt((int)b);
        return res - '0';
    }

    public static void main(String[] args) {
        JZ44 jz44 = new JZ44();
        System.out.println(jz44.findNthDigit(1000000000));
    }
}
