package SwordForOfferTwo.day30;

//剑指 Offer II 090. 环形房屋偷盗
public class Rob2 {

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
    }

    public int robRange(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
    //链接：https://leetcode.cn/problems/PzWKhm/solutions/1412280/huan-xing-fang-wu-tou-dao-by-leetcode-so-p3ev/

}
