package 剑指offer;

/*
剑指 Offer 64. 求1+2+…+n
求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class JZ64 {

    int res = 0;
    public int sumNums(int n) {
        // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归
        // 开启递归函数需改写为 sumNums(n - 1) > 0 ，此整体作为一个布尔量输出，否则会报错
        boolean x = (n > 1) && (sumNums(n - 1) > 0);
        res += n;
        return res;
    }
}
