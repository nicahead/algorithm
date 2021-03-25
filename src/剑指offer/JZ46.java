package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
剑指 Offer 46. 把数字翻译成字符串
给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 */
public class JZ46 {
    public int translateNum(int num) {
        List<LinkedList<String>> res = new ArrayList<>();
        LinkedList<String> path = new LinkedList<>();
        StringBuffer numStr = new StringBuffer(String.valueOf(num));
        backTrace(numStr, path, res);
        return res.size();
    }

    private void backTrace(StringBuffer numStr, LinkedList<String> path, List<LinkedList<String>> res) {
        if (numStr.length() == 0) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 1; i <= numStr.length(); i++) {
            int num = Integer.valueOf(numStr.substring(0, i));
            // 排除不合法的选择
            if ((i > 1 && numStr.charAt(0) == '0') || num > 25 || num < 0) continue;
            // 加入选项
            path.add(numStr.substring(0, i));
            String temp = numStr.substring(0, i);
            // 将该选择从选择列表移除
            numStr = numStr.delete(0, i);
            // 进⼊下⼀层决策树 backtrack(nums, t
            backTrace(numStr, path, res);
            // 撤销选择
            path.removeLast();
            // 将该选择再加⼊选择列表
            numStr.insert(0, temp);
        }
        return;
    }

    public static void main(String[] args) {
        JZ46 jz46 = new JZ46();
        System.out.println(jz46.translateNum(506));
    }
}
