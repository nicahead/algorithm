package 搜索;

import java.util.*;

//17. 电话号码的字母组合
public class T17 {

    private Map<Character, char[]> map = new HashMap<>();
    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        // 选择列表
        char[] digit = digits.toCharArray();
        if (digit.length == 0) return res;
        // 路径
        StringBuffer path = new StringBuffer();
        backtrack(digit, path);
        return res;
    }

    /*
    ------回溯题套路----
    for 选择 in 选择列表:
        # 做选择
        将该选择从选择列表移除
        路径.add(选择)
        backtrack(路径, 选择列表)
        # 撤销选择
        路径.remove(选择)
        将该选择再加⼊选择列表
     */

    // digit是选择列表，实际上每个选择又对应一组选项，根据digit确定决策到哪一层
    // path是路径
    private void backtrack(char[] digit, StringBuffer path) {
        // 满足结束条件，递归出口
        if (path.length() == digit.length) {
            // 添加路径
            res.add(path.toString());
            // 返回上一层
            return;
        }
        // 根据数字确定有哪些可选字符
        // 当前得到的答案长度 -> 当前处理到哪个数字 -> 该数字对应的字符数组
        char[] choices = map.get(digit[path.length()]);
        for (int i = 0; i < choices.length; i++) {
            // 做选择
            path.append(choices[i]);
            backtrack(digit, path);
            // 撤销选择
            path.deleteCharAt(path.length() - 1);
        }
        return;
    }
}
