package SwordForOfferTwo.day20;

import java.util.*;

//剑指 Offer II 060. 出现频率最高的 k 个数字
public class TopKFrequent {

    //控制堆中数量，堆的复杂度为O(logK)
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.get(1) - o2.get(1));
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        for (Integer n : map.keySet()) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(n);
            list.add(map.get(n));
            if(queue.size() == k){
                if(queue.peek().get(1) < list.get(1)){
                    queue.poll();
                    queue.add(list);
                }
            }else queue.offer(list);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(queue.poll().get(0));
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

}
