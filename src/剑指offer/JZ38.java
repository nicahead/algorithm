package 剑指offer;

import java.util.*;

/*
剑指 Offer 38. 字符串的排列
输入一个字符串，打印出该字符串中字符的所有排列。
你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
public class JZ38 {
    public String[] permutation(String s) {
        Set<String> res = new HashSet<>();
        Set<Integer> index = new HashSet<>();
        StringBuffer path = new StringBuffer();
        if (s.length() == 0) return new String[0];
        backtrack(s, path, res, index);
        // list转数组
        return res.toArray(new String[res.size()]);
    }

    private void backtrack(String s, StringBuffer path, Set<String> res, Set<Integer> index) {
        // 结束条件
        if (path.length() == s.length()) {
            res.add(path.toString());
            return;
        }
        // 可能存在相同字母，使用index存储已使用的字符的下标
        for (int i = 0; i < s.length(); i++) {
            // 剪枝
            if (index.contains(i))
                continue;
            // 做选择
            path.append(s.charAt(i));
            index.add(i);
            backtrack(s, path, res, index);
            // 撤销选择
            path.deleteCharAt(path.length() - 1);
            index.remove(i);
        }
    }
}
