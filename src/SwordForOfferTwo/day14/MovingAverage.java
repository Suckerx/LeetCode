package SwordForOfferTwo.day14;

import java.util.Deque;
import java.util.LinkedList;

//剑指 Offer II 041. 滑动窗口的平均值
public class MovingAverage {

    private int size;
    private Deque<Integer> queue;
    private int sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        queue = new LinkedList<>();
        this.sum = 0;
    }

    public double next(int val) {
        queue.offerLast(val);
        sum += val;
        if(queue.size() > size) sum -= queue.pollFirst();
        return sum * 1.0 / queue.size() * 1.0;
    }

}
