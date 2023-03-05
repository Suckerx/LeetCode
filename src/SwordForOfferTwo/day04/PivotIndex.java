package SwordForOfferTwo.day04;

import java.util.Arrays;

//剑指 Offer II 012. 左右两边子数组的和相等
public class PivotIndex {

    /**
     * 方法一：前缀和
     * 记数组的全部元素之和为 total，当遍历到第 i 个元素时，设其左侧元素之和为 sum，则其右侧元素之和为 total−numsi−sum
     * 左右侧元素相等即为 sum=total−numsi−sum,即 2×sum+numsi=total
     * 当中心下标左侧或右侧没有元素时，即为零个项相加，这在数学上称作「空和」。在程序设计中我们约定「空和是零」。
     */
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(2 * sum + nums[i] == total) return i;
            sum += nums[i];
        }
        return -1;
    }

}
