package SwordForOffer.day09;

import SwordForOffer.day08.MaxProfit;

//剑指 Offer 42. 连续子数组的最大和
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSubArray maxProfit = new MaxSubArray();
        maxProfit.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }

}
