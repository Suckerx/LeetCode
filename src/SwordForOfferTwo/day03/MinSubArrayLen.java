package SwordForOfferTwo.day03;

import java.util.Arrays;

//剑指 Offer II 008. 和大于等于 target 的最短子数组
public class MinSubArrayLen {

    //滑动窗口
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0,right = 0,sum = 0;
        int ans = Integer.MAX_VALUE;
        if(nums.length == 0) return 0;
        while(right < nums.length){
            sum += nums[right];
            while(sum >= target){
                ans = Math.min(ans,right-left+1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
