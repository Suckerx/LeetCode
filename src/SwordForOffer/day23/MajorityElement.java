package SwordForOffer.day23;

import java.util.Arrays;

//剑指 Offer 39. 数组中出现次数超过一半的数字
public class MajorityElement {

    //数组排序法
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * 摩尔投票法： 核心理念为 票数正负抵消 。此方法时间和空间复杂度分别为 O(N) 和 O(1) ，为本题的最佳解法。
     * 设输入数组 nums 的众数为 x ，数组长度为 n 。
     *
     * 推论一： 若记 众数 的票数为 +1 ，非众数 的票数为 −1 ，则一定有所有数字的 票数和 >0。
     *
     * 推论二： 若数组的前 a 个数字的 票数和 =0 ，则 数组剩余 (n−a) 个数字的 票数和一定仍 >0 ，即后 (n−a) 个数字的 众数仍为 x
     * 根据以上推论，记数组首个元素为 n1，众数为 x ，遍历并统计票数。当发生 票数和 =0时，剩余数组的众数一定不变 ，这是由于：
     * 当 n1=x： 抵消的所有数字中，有一半是众数 x 。
     * 当 n1≠x： 抵消的所有数字中，众数 x 的数量最少为 0 个，最多为一半。
     * 利用此特性，每轮假设发生 票数和 =0= 0=0 都可以 缩小剩余数组区间 。当遍历完成时，最后一轮假设的数字即为众数。
     *
     * 就是每次假设n1为众数，就算它不是众数，也会被抵消到0，最后还是会变成众数
     */

    public int majorityElement1(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }

}
