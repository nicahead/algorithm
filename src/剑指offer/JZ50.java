package 剑指offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
剑指 Offer 50. 第一个只出现一次的字符
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class JZ50 {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            if (map.containsKey(s.charAt(i))) {
                count = map.get(s.charAt(i));
            }
            map.put(s.charAt(i), ++count);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
