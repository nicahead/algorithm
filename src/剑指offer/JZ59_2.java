package 剑指offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 */
public class JZ59_2 {

    private Queue<Integer> queue;
    // 单调不增队列
    private Deque<Integer> help;

    public JZ59_2() {
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }

    public int max_value() {
        return help.isEmpty() ? -1 : help.peekFirst();
    }

    public void push_back(int value) {
        while (!help.isEmpty() && help.peekLast() < value) {
            help.removeLast();
        }
        help.offerLast(value);
        queue.offer(value);
    }

    public int pop_front() {
        if (!queue.isEmpty()) {
            if (queue.peek().equals(help.peekFirst())) {
                help.removeFirst();
            }
            return queue.poll();
        } else {
            return -1;
        }
    }
}
