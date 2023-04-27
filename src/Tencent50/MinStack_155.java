package Tencent50;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

//155. 最小栈
public class MinStack_155 {

    public Deque<Integer> deque;
    public PriorityQueue<Integer> queue;

    public MinStack_155() {
        deque = new LinkedList<>();
        queue = new PriorityQueue<>();
    }

    public void push(int val) {
        deque.offerLast(val);
        queue.offer(val);
    }

    public void pop() {
        int a = deque.pollLast();
        queue.remove(a);
    }

    public int top() {
        return deque.peekLast();
    }

    public int getMin() {
        return queue.peek();
    }

}
