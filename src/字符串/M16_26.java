package 字符串;

import java.util.Stack;

//面试题 16.26. 计算器
public class M16_26 {
    public static void main(String[] args) {
        String s = "3+2*2";
        M16_26 m = new M16_26();
        System.out.println(m.calculate(s));
    }

    /*
     * 数字：直接入栈，考虑是否是连续数字
     * +-x/: 看下一位数字num
     *       + ：直接入栈
     *       - ：-num入栈
     *       * ：前一个数字出栈 * num，然后入栈
     *       / ：前一个数字出栈 / num，然后入栈
     * */
    public int calculate(String s) {
        char[] c = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int num = 0;  // 运算符后的数字
        char op = ' '; // 暂存运算符
        // 遍历字符串
        while (i < c.length) {
            if (c[i] == ' ') {
                i++;
                continue;
            }
            if (c[i] == '+' || c[i] == '-' || c[i] == '*' || c[i] == '/') {
                op = c[i];
                i++;
                continue;
            }
            // 符号后的数字
            while (i < c.length && Character.isDigit(c[i])) {
                num = num * 10 + (c[i] - '0');
                i++;
            }
            switch (op) {
                // 遇到减号，需要将符号后的数字作为负数入栈
                case '-':
                    num = -num;
                    break;
                // 遇到乘除，则将符号前后的数字计算出来入栈（符号前的数字在栈中需要先出栈）
                case '*':
                    num = stack.pop() * num;
                    break;
                case '/':
                    num = stack.pop() / num;
                    break;
                default:
                    break;
            }
            stack.push(num);
            num = 0;
        }
        int res = 0;
        // 此时栈中全为数字，直接相加即可，考虑大于10的数字
        while (!stack.empty()) {
            res += stack.pop();
        }
        return res;
    }
}
