package 剑指offer;

//剑指 Offer 05. 替换空格
public class JZ05 {
    public String replaceSpace(String s) {
        StringBuffer buffer = new StringBuffer();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ' ') {
                buffer.append("%20");
            } else {
                buffer.append(c);
            }
        }
        return new String(buffer);
    }
}
