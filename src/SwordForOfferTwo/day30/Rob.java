package SwordForOfferTwo.day30;

import sun.text.resources.cldr.naq.FormatData_naq;

//剑指 Offer II 089. 房屋偷盗
public class Rob {

    public int rob(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];//dp【i】代表当前位置的最大金额
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i],dp[i - 1]);//当前房屋要么选择，要么不选择，选择就不能选 i - 1的，不选就是 i - 1的
        }
        return dp[nums.length - 1];
    }

    //滚动数据优化空间
    public int rob2(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        if(nums.length == 1) return nums[0];
        int cur = nums[0];
        int next = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = next;
            next = Math.max(cur + nums[i],next);//当前房屋要么选择，要么不选择，选择就不能选 i - 1的，不选就是 i - 1的
            cur = temp;
        }
        return next;
    }

}
