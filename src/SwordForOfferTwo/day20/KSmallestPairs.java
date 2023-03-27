package SwordForOfferTwo.day20;

import java.sql.Array;
import java.util.*;

//剑指 Offer II 061. 和最小的 k 个数对
public class KSmallestPairs {

    //大根堆
    //https://leetcode.cn/problems/qn8gGX/solutions/1017149/offerii061he-zui-xiao-de-kge-shu-dui-by-k7r5h/
    /**
     * 由于 nums1 和 nums2 都是升序排序的，所以最小的k个数对肯定是在 nums1[0,k-1] 和 nums2[0,k-1] 中配对的，
     *
     * 创建一个大根堆，堆中元素排序按照数对和进行逆序排序。
     * nums1 取前k个数（长度 n 小于 k 则取 n 个，nums2 相同）与数组2取前 k 个数组成 k*k 个数对。
     * 每次都将当前配对的数对插入堆中，然后判断堆中元素总数是否超过 k , 如果超过 k 则将堆顶元素删除。
     * 不断重复 3 操作，最后剩下的堆中的数对，就是和最小的 k 个数对。
     * 时间复杂度：O(k^2logk) ，其中容量为k的堆的添加与删除是O(logK),循环k^2次，为O(k^2logk)。
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.get(0) + o2.get(1) - o1.get(0) - o1.get(1));
        int len1 = Math.min(nums1.length,k);
        int len2 = Math.min(nums2.length,k);
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                queue.offer(list);
                if(queue.size() > k) queue.poll();
            }
        }
        ArrayList<List<Integer>> res = new ArrayList<>();
        Iterator<List<Integer>> iterator = queue.iterator();
        while (iterator.hasNext()) res.add(iterator.next());
        return res;
    }

    /**
     * 小根堆
     * 时间复杂度更优化
     *https://leetcode.cn/problems/qn8gGX/solutions/1265881/he-zui-xiao-de-k-ge-shu-dui-by-leetcode-eoce6/
     * https://leetcode.cn/problems/qn8gGX/solutions/1017149/offerii061he-zui-xiao-de-kge-shu-dui-by-k7r5h/
     */
    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        // 创建一个小根堆，小根堆中存放 <nums1对应元素的索引，nums2对应元素的索引>
        ArrayList<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (pair1, pair2) -> nums1[pair1[0]] + nums2[pair1[1]] - nums1[pair2[0]] - nums2[pair2[1]]
        );
        // 对小根堆进行初始化，将 <0,0>, ... , <k-1,0> 插入栈中（如果长度 n 小于 k 则取 n 个）。
        for(int i = 0; i < Math.min(k, nums1.length); i++){
            heap.add(new int[]{i,0});
        }

        for ( ; k > 0 && !heap.isEmpty(); k--){
            // 选出和最小的数对【i,j】(堆顶)，将堆顶弹出，把 `{nums1[i], nums2[j]}` 保存到列表中。
            int[] pair = heap.poll();
            ans.add(Arrays.asList(nums1[pair[0]],nums2[pair[1]]));
            // 当 `j + 1 < nums2.length` 时， 才将【i,j+1】插入堆中
            if(pair[1] < nums2.length - 1){
                heap.add(new int[]{pair[0], pair[1] + 1});
            }

        }
        // 返回结果
        return ans;
    }

}
