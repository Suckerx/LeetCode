package SwordForOfferTwo.day04;

import java.util.HashMap;

//剑指 Offer II 011. 0 和 1 个数相同的子数组
public class FindMaxLength {

    //前缀和 + 哈希表

    /**
     * 根据题意，我们可以轻易发现如下性质：如果答案非 0，那么子数组长度必然为偶数，且长度至少为 2。
     *
     * 具体的，我们在预处理前缀和时，将 nums[i] 为 0 的值当做 −1 处理。
     *
     * 从而将问题转化为：如何求得最长一段区间和为 0 的子数组。 同时使用「哈希表」来记录「某个前缀和出现的最小下标」是多少。
     * 遍历阶段：如果当前位置的sum[i]值已经出现过，则说明从上一个sum[i]值出现的位置到 i 位置之间的元素和为0，
     * 如果当前位置的sum[i]值没有出现过，则记录下这个值的下标。
     */
    public int findMaxLength(int[] nums) {
        int n = nums.length,ans = 0;
        int[] sum = new int[n + 10];
        for (int i = 1; i <= n; i++) sum[i] = sum[i-1] + (nums[i-1] == 0 ? -1 : 1);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        for (int i = 1; i <= n; i++) {
            int t = sum[i];
            if(map.containsKey(t)) ans = Math.max(ans,i-map.get(t));
            if(!map.containsKey(t)) map.put(t,i);
        }
        return ans;
    }

}
