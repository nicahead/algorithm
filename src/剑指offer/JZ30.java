package 剑指offer;

import java.util.Stack;

public class JZ30 {

    // 数据栈 s1 ： 栈 s1 用于存储所有元素，保证入栈 push() 函数、出栈 pop() 函数、获取栈顶 top() 函数的正常逻辑。
    private Stack<Integer> s1;
    // 辅助栈 s2 ： 栈 s2 中存储栈 s1 中所有 非严格降序 的元素，则栈 s1 中的最小元素始终对应栈 s2 的栈顶元素，即 min() 函数只需返回栈 s2 的栈顶元素即可。
    private Stack<Integer> s2;

    public JZ30() {
        s1 = new Stack<>();
        s2 = new Stack();
    }

    // 保持栈 s2 的元素是 非严格降序 的
    public void push(int x) {
        s1.push(x);
        // 如果新加入的x小于当前最小值，则加入单调栈s2
        if (s2.isEmpty() || s2.peek() >= x) {
            s2.push(x);
        }
    }
    //保持栈 s1, s2 的 元素一致性
    public void pop() {
        if (s1.pop().equals(s2.peek())) {
            s2.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }

    public static void main(String[] args) {
        JZ30 jz30 = new JZ30();
        jz30.push(1);
        jz30.push(2);
        System.out.println(jz30.top());
        System.out.println(jz30.min());
        jz30.pop();
        System.out.println(jz30.min());
        System.out.println(jz30.top());
    }
}
