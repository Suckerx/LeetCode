package SwordForOffer.day01_05;

import java.util.HashMap;

//剑指 Offer 03. 数组中重复的数字
public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                result = nums[i];
                break;
            }
            else map.put(nums[i],i);
        }
        return result;
    }

}
