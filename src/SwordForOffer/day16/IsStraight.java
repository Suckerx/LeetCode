package SwordForOffer.day16;

import java.util.Arrays;

//面试题61. 扑克牌中的顺子
public class IsStraight {

    public boolean isStraight(int[] nums) {
        int z = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if(z<0) return false;
            if(nums[i] == 0){
                z++;
                continue;
            }
            if(nums[i+1] - nums[i] == 0) return false;
            if(i+1!= nums.length && nums[i+1] - nums[i]-1 <= z){
                z-=nums[i+1] - nums[i]-1;
                continue;
            }
            if(i+1!= nums.length && nums[i+1] - nums[i]-1 > z) return false;
        }
        return true;
    }

}
