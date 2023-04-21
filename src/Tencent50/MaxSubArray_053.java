package Tencent50;

//53. 最大子数组和
public class MaxSubArray_053 {

    //动态规划
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i-1] + nums[i] : nums[i];
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    //分治法
    //https://leetcode.cn/problems/maximum-subarray/solutions/9058/dong-tai-gui-hua-fen-zhi-fa-python-dai-ma-java-dai/?orderBy=hot&languageTags=java

}
