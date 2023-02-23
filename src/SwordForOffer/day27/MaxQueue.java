package SwordForOffer.day27;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//面试题59 - II. 队列的最大值
public class MaxQueue {

    Deque<Integer> deque;
    Queue<Integer> queue;

    public MaxQueue() {
        deque = new LinkedList<>();
        queue = new LinkedList<>();
    }

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while(!deque.isEmpty() && deque.peekLast() < value) deque.pollLast();
        deque.offerLast(value);
    }

    //queue 里面保存的是 Integer 而非 int ，peek() 返回的是 Integer 类型，没有自动拆箱，因此需要用 equals() 来比
    public int pop_front() {
        if(queue.isEmpty()) return -1;
        if(queue.peek().equals(deque.peekFirst())) deque.pollFirst();
        return queue.poll();
    }

}
