package 剑指offer;

import java.util.Stack;

/*
剑指 Offer 31. 栈的压入、弹出序列
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 */
public class JZ31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int m = pushed.length, n = popped.length;
        Stack<Integer> s = new Stack();
        int i = 0, j = 0;
        while (j < n) {
            // 栈顶等于popped[j]，则出栈，j向后进1
            if (!s.isEmpty() && s.peek() == popped[j]) {
                s.pop();
                j++;
            } else if (i >= m) {
                // 此时pushed已结束，popped无法和栈顶匹配，则可以判定不匹配
                return false;
            } else {
                // 否则，pushed继续进栈
                s.push(pushed[i]);
                i++;
            }
        }
        return s.isEmpty();
    }
}
