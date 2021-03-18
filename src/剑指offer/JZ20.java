package 剑指offer;

//剑指 Offer 20. 表示数值的字符串
public class JZ20 {
    public boolean isNumber(String s) {
        if (s.endsWith("f") || s.endsWith("D")) return false;
        try {
            Double.valueOf(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
