package 字符串;
//409. 最长回文串
public class T409 {
    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int[] count = new int[58];  //从A到z，ascii码65到122（中间隔了几个不是字母）
        for (int i = 0; i < chars.length; i++) {
            count[chars[i] - 'A']++;
        }
        int flag = 0;
        int res = 0;
        for (int j = 0; j < count.length; j++) {
            if (count[j] > 1)
                res += (count[j] / 2) * 2;
            if (count[j] % 2 == 1)
                flag = 1;
        }
        return res + flag;
    }

    public static void main(String[] args) {
        String s = "abccccdda";
        T409 t409 = new T409();
        System.out.println(t409.longestPalindrome(s));
    }
}
