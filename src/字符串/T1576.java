package 字符串;


//1576. 替换所有的问号
public class T1576 {
    public static void main(String[] args) {
        String s = "??yw?ipkj?";
        T1576 t = new T1576();
        System.out.println(t.modifyString(s));
    }

    public String modifyString(String s) {
        char[] c = s.toCharArray();
        if (c.length == 1) {
            if (c[0] == '?') {
                c[0] = 'a';
            }
        }
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '?') {
                if (i == 0) {
                    if (i + 1 < c.length && c[i + 1] != '?') {
                        c[i] = (char) ((c[i + 1] + 1 - 'a') % 26 + 'a');
                    } else {
                        c[i] = 'a';
                    }
                } else {
                    c[i] = (char) ((c[i - 1] + 1 - 'a') % 26 + 'a');
                    if (i != c.length - 1 && c[i] == c[i + 1]) {
                        c[i] = (char) ((c[i - 1] + 2 - 'a') % 26 + 'a');
                    }
                }
            }
        }
        return new String(c);
    }

}
