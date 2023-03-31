package SwordForOfferTwo.day24;

import java.util.Random;

//剑指 Offer II 071. 按权重生成随机数
public class Solution {

    /**
     * 方法一：前缀和 + 二分查找
     * 设数组 w 的权重之和为 total。根据题目的要求，我们可以看成将 [1,total] 范围内的所有整数分成 n 个部分（其中 n 是数组 w 的长度），
     * 第 i 个部分恰好包含 w[i] 个整数，并且这 n 个部分两两的交集为空。随后我们在 [1,total]范围内随机选择一个整数 x，
     * 如果整数 x 被包含在第 i 个部分内，我们就返回 i。
     * https://leetcode.cn/problems/cuyjEf/solutions/1289958/hua-luo-yue-que-qian-zhui-he-ni-xiang-da-meph/
     */

    private final Random random = new Random();
    private int sum;
    private int[] prefix;

    public Solution(int[] w) {
        prefix = new int[w.length];
        sum = 0;
        for (int i = 0; i < w.length; i++) {
            prefix[i] =  sum + w[i];
            sum = prefix[i];
        }
        sum = prefix[w.length - 1];
    }

    public int pickIndex() {
        int target = random.nextInt(sum) + 1;
        int left = 0;
        int right = prefix.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(prefix[mid] < target) left = mid + 1;
            else right = mid;
        }
        return right;
    }

}
