package 栈和队列;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

//225. 用队列实现栈
public class T225 {

    private Queue<Integer> q1;  // 存储
    private Queue<Integer> q2;  // 暂存入栈元素

    /**
     * Initialize your data structure here.
     */
    public T225() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q2.offer(x);
        // 保证新加入的永远在最前面
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        // 转移回q1
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return q1.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return q1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        T225 myStack = new T225();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
        System.out.println(myStack.empty());
    }
}
