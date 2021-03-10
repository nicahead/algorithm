package 二分查找;

//278. 第一个错误的版本
public class T278 {
    public boolean isBadVersion(int n) {
        return true;
    }

    public int firstBadVersion(int n) {
        //  int left = 1, right = n;
        //  while (left < right) {
        // 上面这种写法就会超出时间限制....

        int left = 1, right = n;
        while (left < right) {
            // 若写成 (left+right)/2,(left+right)有超出int上限的可能性,导致
            int mid = left + (right - left) / 2;
            // mid出错，则第一个错误的在左边
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
