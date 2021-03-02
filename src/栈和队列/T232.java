package 栈和队列;

import java.util.Stack;

//232. 用栈实现队列
public class T232 {

    private Stack<Integer> s1;  // 逆序存储
    private Stack<Integer> s2;  // 顺序存储

    /**
     * Initialize your data structure here.
     */
    public T232() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        // 如果s2不为空，则先将其内容送回s1，保证顺序
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        // 新元素入栈
        s1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        if (s2.isEmpty()) return -1;
        return s2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        if (s2.isEmpty()) return -1;
        return s2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        T232 myQueue = new T232();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false
    }
}
