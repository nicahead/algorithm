package 字符串;


import java.util.Arrays;

//242. 有效的字母异位词
public class T242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sItem = s.toCharArray();
        char[] tItem = t.toCharArray();
        Arrays.sort(sItem);
        Arrays.sort(tItem);
        return Arrays.equals(sItem, tItem);
    }

    public static void main(String[] args) {
        T242 t242 = new T242();
        String s = "anagram", t = "nagaram";
        System.out.println(t242.isAnagram(s, t));
    }
}
