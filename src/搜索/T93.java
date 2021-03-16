package 搜索;

import java.util.ArrayList;
import java.util.List;

//93. 复原 IP 地址
public class T93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuffer path = new StringBuffer();
        // 记录当前已处理几个ip段
        int count = 0;
        backtrack(s, path, res, count);
        return res;
    }

    private void backtrack(String s, StringBuffer path, List<String> res, int count) {
        if (s.length() == 0 || s.length() > 12) {
            // 初始情况下s即为空，表示传进来的就是空串，直接返回
            // 处理完四个IP段之后s为空，表示此时已处理结束，将该结果加入到最后的结果集
            if (count == 4) {
                res.add(path.toString());
            }
            return;
        }
        // 否则，回溯处理
        // 遍历所有可能情况，向后最多取3位数字，最少取一位
        for (int end = 1; end <= 3; end++) {
            // 截取的位置超出s或首位为0的情况（02这种）直接终止循环
            if (end > s.length() || (end > 1 && s.charAt(0) == '0')) {
                break;
            }
            // 可能的IP段，substring左闭右开
            String part = s.substring(0, end);
            // 合法的ip段
            if (Integer.valueOf(part) >= 0 && Integer.valueOf(part) <= 255) {
                // 如果是后面的段，需要在前面加个点
                if (count > 0) {
                    part = '.' + part;
                }
                path.append(part);
                // 将s更新为截取掉part之后的
                // 已处理的IP段+1
                backtrack(s.substring(end, s.length()), path, res, count + 1);
                // 回溯
                path.delete(path.length() - part.length(), path.length());
            }
        }
    }
}
