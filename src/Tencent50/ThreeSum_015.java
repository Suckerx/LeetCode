package Tencent50;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//15. 三数之和
public class ThreeSum_015 {

    //双指针 + 排序
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if(nums[k] > 0) break;
            if(k > 0 && nums[k] == nums[k-1]) continue;
            int i = k+1,j = nums.length - 1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if( sum == 0) {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k],nums[i],nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
                else if(sum > 0){
                    while(i < j && nums[j] == nums[--j]);
                }
                else if(sum < 0){
                    while(i < j && nums[i] == nums[++i]);
                }
            }
        }
        return res;
    }

}
