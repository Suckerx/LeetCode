package SwordForOffer.day13;

//剑指 Offer 57. 和为s的两个数字
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length == 0) return null;
        int[] result = new int[2];
        int left=0,right=nums.length-1;

        while(left<right){
            if(nums[left] + nums[right] == target){
                result[0] = nums[left];
                result[1] = nums[right];
                break;
            }
            else if(nums[left] + nums[right] < target) left++;
            else right--;
        }

        return result;
    }
}
