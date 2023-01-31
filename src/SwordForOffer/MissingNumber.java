package SwordForOffer;

//剑指 Offer 53 - II. 0～n-1中缺失的数字
public class MissingNumber {

    public int missingNumber(int[] nums) {
        for (int i = 0; i <nums.length; i++) {
            if(nums[i]!=i) return i;
        }
        return nums.length-1;
    }

}
