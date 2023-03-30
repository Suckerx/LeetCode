package SwordForOfferTwo.day23;

//剑指 Offer II 070. 排序数组中只出现一次的数字
public class SingleNonDuplicate {

    //位运算解法,不满足时间复杂度
    public int singleNonDuplicate(int[] nums) {
        int eor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            eor ^= nums[i];
        }
        return eor;
    }

    // 二分
    //https://leetcode.cn/problems/skFtm2/solutions/1252765/pai-xu-shu-zu-zhong-zhi-chu-xian-yi-ci-d-jk8w/
    public int singleNonDuplicate2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == nums[mid ^ 1]) left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }


}
