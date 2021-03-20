package 剑指offer;

//剑指 Offer 17. 打印从1到最大的n位数
public class JZ17 {
    //    public int[] printNumbers(int n) {
//        int size = (int) Math.pow(10, n);
//        int[] res = new int[size - 1];
//        for (int i = 1; i < size; i++) {
//            res[i - 1] = i;
//        }
//        return res;
//    }
    // 考虑到n可能会非常大，使用int或者long这种数据类型无法表示。这个时候可以用字符串或字符数组表示
    public void printNumbers(int n) {
        StringBuffer res = new StringBuffer();
        dfs(res, n);
    }

    private void dfs(StringBuffer res, int n) {
        if (n == 0) {
            String s = delZero(res.toString());
            if (!s.equals("0")) {
                System.out.println(s);
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            res.append(i);
            dfs(res, n - 1);
            // 回溯
            res.delete(res.length() - 1, res.length());
        }
    }

    // 删除前面的0，如"001" -> "1"
    private String delZero(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(0) != '0')
                return s;
            else {
                s = s.substring(1, s.length());
            }
        }
        return s;
    }

    public static void main(String[] args) {
        JZ17 jz17 = new JZ17();
        jz17.printNumbers(3);
    }
}
