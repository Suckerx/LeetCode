package SwordForOffer.day27;

import java.sql.Array;
import java.util.*;

//剑指 Offer 59 - I. 滑动窗口的最大值
public class MaxSlidingWindow {

    /**
     * 方法一：优先队列
     * 思路与算法
     *
     * 对于「最大值」，我们可以想到一种非常合适的数据结构，那就是优先队列（堆），
     * 其中的大根堆可以帮助我们实时维护一系列元素中的最大值。
     *
     * 对于本题而言，初始时，我们将数组 nums 的前 k 个元素放入优先队列中。
     * 每当我们向右移动窗口时，我们就可以把一个新的元素放入优先队列中，此时堆顶的元素就是堆中所有元素的最大值。
     * 然而这个最大值可能并不在滑动窗口中，在这种情况下，这个值在数组 nums 中的位置出现在滑动窗口左边界的左侧。
     * 因此，当我们后续继续向右移动窗口时，这个值就永远不可能出现在滑动窗口中了，我们可以将其永久地从优先队列中移除。
     *
     * 我们不断地移除堆顶的元素，直到其确实出现在滑动窗口中。
     * 此时，堆顶元素就是滑动窗口中的最大值。为了方便判断堆顶元素与滑动窗口的位置关系，
     * 我们可以在优先队列中存储二元组 (num,index)，表示元素 num在数组中的下标为 index。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return nums;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        ArrayList<Integer> res = new ArrayList<>();
        for (int j = 0; j < k; j++) {
            queue.add(new int[]{nums[j],j});
        }
        res.add(queue.peek()[0]);
        for (int i = k; i < nums.length; i++) {
            queue.add(new int[]{nums[i],i});
            while(queue.peek()[1] <= i-k) queue.poll();
            res.add(queue.peek()[0]);
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    //本题难点： 如何在每次窗口滑动后，将 “获取窗口内最大值” 的时间复杂度从 O(k) 降低至 O(1) 。

    /**
     * 窗口对应的数据结构为 双端队列 ，本题使用 单调队列 即可解决以上问题。遍历数组时，每轮保证单调队列 deque ：
     * 1.deque 内 仅包含窗口内的元素 ⇒ 每轮窗口滑动移除了元素 nums[i−1]，需将 deque 内的对应元素一起删除。
     * 2.deque 内的元素 非严格递减 ⇒每轮窗口滑动添加了元素 nums[j+1]，需将 deque 内所有 <nums[j+1]的元素删除。
     *
     * 滑动窗口： 左边界范围 i∈[1−k,n−k]，右边界范围 j∈[0,n−1]；
     * 若 i>0 且 队首元素 deque[0] = 被删除元素 nums[i−1]：则队首元素出队；
     * 删除 deque 内所有 <nums[j] 的元素，以保持 deque 递减；
     * 将 nums[j] 添加至 deque 尾部；
     * 若已形成窗口（即 i≥0）：将窗口最大值（即队首元素 deque[0] ）添加至列表 res ；
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null || nums.length == 0) return nums;
        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1-k,j = 0; j < nums.length; i++,j++) {
            // 删除 deque 中对应的 nums[i-1]
            if(i > 0 && queue.peekFirst() == nums[i-1]) queue.pollFirst();
            // 保持 deque 递减
            while(!queue.isEmpty() && queue.peekLast() < nums[j]) queue.pollLast();
            queue.addLast(nums[j]);
            // 记录窗口最大值
            if(i>=0) res.add(queue.peekFirst());
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(null);
        list.add(2);
        aVoid(list.toString());
    }

    public static void aVoid(String a){
        System.out.println(a);
    }

}
