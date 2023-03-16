package SwordForOfferTwo.day14;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//剑指 Offer II 042. 最近请求次数
public class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while(queue.peek() < t - 3000) queue.poll();
        return queue.size();
    }

}
