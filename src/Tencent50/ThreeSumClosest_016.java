package Tencent50;

import java.util.Arrays;

//16. 最接近的三数之和
public class ThreeSumClosest_016 {

    //https://leetcode.cn/problems/3sum-closest/solutions/301382/zui-jie-jin-de-san-shu-zhi-he-by-leetcode-solution/?orderBy=hot
    //双指针+排序
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int k = 0; k < nums.length - 2; k++) {
            if(k > 0 && nums[k] == nums[k-1]) continue;
            int i = k+1,j = nums.length - 1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if( sum == target) {
                    return target;
                }

                if(Math.abs(sum - target) <  Math.abs(res - target)) res = sum;

                if(sum > target){
                    while(i < j && nums[j] == nums[--j]);
                }
                else if(sum < target){
                    while(i < j && nums[i] == nums[++i]);
                }
            }
        }
        return res;
    }

}
