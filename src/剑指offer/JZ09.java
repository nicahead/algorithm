package 剑指offer;

import java.util.Stack;

//剑指 Offer 09. 用两个栈实现队列
public class JZ09 {

    // 逆序存放
    private Stack<Integer> s1;
    // 顺序存放
    private Stack<Integer> s2;

    public JZ09() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(int value) {
        // 将s2中的内容还原到s1
        while (!s2.empty()) {
            s1.add(s2.pop());
        }
        // 再插入新数据
        s1.add(value);
    }

    public int deleteHead() {
        // 转移到s2，此时顺序存放
        while (!s1.empty()) {
            s2.add(s1.pop());
        }
        return s2.empty() ? -1 : s2.pop();
    }
}
