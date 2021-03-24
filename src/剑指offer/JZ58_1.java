package 剑指offer;

import java.util.Stack;

/*
剑指 Offer 58 - I. 翻转单词顺序
输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 */
public class JZ58_1 {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuffer res = new StringBuffer();
        int i = s.length() - 1, j = s.length() - 1;
        // 逆序遍历
        while (i >= 0) {
            // 处理i指向单词末尾的情况
            if (s.charAt(i) != ' ') {
                // i指针不断左移，直到该单词结束
                while (i > 0 && s.charAt(i) != ' ') {
                    i--;
                }
                // 遇到空或者遍历到字符串最前面，则表示一个单词结束
                if (i == 0 || s.charAt(i) == ' ') {
                    if (i != 0) {
                        // substring前闭后开
                        res.append(s.substring(i + 1, j + 1));
                        res.append(" ");
                    } else {
                        // 特殊情况，到达边界，注意i--，否则死循环
                        res.append(s.substring(i, j + 1));
                        i--;
                    }
                }
            }
            // 处理i指向空格的情况
            else {
                // i指针不断左移，直到找到单词尾
                while (i > 0 && s.charAt(i) == ' ') {
                    i--;
                }
                j = i;
            }

        }
        return res.toString();
    }

    public static void main(String[] args) {
        JZ58_1 jz58_1 = new JZ58_1();
        System.out.println(jz58_1.reverseWords("  hello world!  "));
    }
}
