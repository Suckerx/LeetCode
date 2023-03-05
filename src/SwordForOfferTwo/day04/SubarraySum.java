package SwordForOfferTwo.day04;

import java.util.HashMap;

//剑指 Offer II 010. 和为 k 的子数组
public class SubarraySum {

    //有负数，不能使用滑动窗口

    /**
     * 前缀和 + 哈希表优化
     * https://leetcode.cn/problems/QTMn0o/solutions/1399223/he-wei-k-de-zi-shu-zu-by-leetcode-soluti-1169/
     * 以和为键，出现次数为值
     */
    public int subarraySum(int[] nums, int k) {
        int pre = 0,count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if(map.containsKey(pre - k)){
                count += map.get(pre - k);
            }
            map.put(pre,map.getOrDefault(pre,0) + 1);//次数+1
        }
        return count;
    }

}
