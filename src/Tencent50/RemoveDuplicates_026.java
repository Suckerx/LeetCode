package Tencent50;

//26. 删除有序数组中的重复项
public class RemoveDuplicates_026 {

    //双指针
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) return 1;
        int left = 0,right = 1;
        while(right < nums.length){
            if(nums[left] == nums[right]) right++;
            else if(nums[left] != nums[right]){
                nums[left+1] = nums[right];
                left++;
                right++;
            }
        }
        return left+1;
    }

}
