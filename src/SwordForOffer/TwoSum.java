package SwordForOffer;

import java.util.HashMap;
import java.util.Map;

// LeetCode 1. 两数之和
public class TwoSum {

    //解法1 ： 直接遍历得到，注意考虑溢出
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(target-nums[i]==nums[j]){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }


    //利用哈希表来做，省略一次遍历，因为我们知道，x+y = target
    //那么，x和y必定是一前一后出现，遍历到x的时候，发现哈希表中没有y，那么我们把x加入进去
    //那么直到遍历到y的时候，哈希表中一定存在target-y=x
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum2(nums, 6);
    }

}
