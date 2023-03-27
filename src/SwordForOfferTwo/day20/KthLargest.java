package SwordForOfferTwo.day20;

import java.util.Arrays;
import java.util.PriorityQueue;

//剑指 Offer II 059. 数据流的第 K 大数值
public class KthLargest {

    private PriorityQueue<Integer> queue;
    private int k;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            queue.add(num);
        }
    }

    public int add(int val) {
        queue.add(val);
        while(queue.size() > k) queue.poll();
        return queue.peek();
    }

}
