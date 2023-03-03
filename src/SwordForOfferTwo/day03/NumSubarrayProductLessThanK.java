package SwordForOfferTwo.day03;

//剑指 Offer II 009. 乘积小于 K 的子数组
public class NumSubarrayProductLessThanK {

    /**
     * 根据上面的分析，我们枚举子数组的右端点 j，
     * 并且左端点从 i=0 开始，用 prod 记录子数组 [i,j] 的元素乘积。每枚举一个右端点 j，
     * 如果当前子数组元素乘积 prod大于等于 k，那么我们右移左端点 i 直到满足当前子数组元素乘积小于 k 或者 i>j，
     * 那么元素乘积小于 k 的子数组数目为 j−i+1。返回所有数目之和。
     *
     * 关于为什么子数组数目为j-1+1。这时候就要理解解法二的第一段话的意思。
     * 我们采用滑动窗口的思路其实是枚举子数组的右端点，然后来找到满足条件的最小左端点。
     * 也即当得到满足条件的窗口时，就意味着得到了以 j 作为右端点时满足条件的左端点的最小值。
     * 那么此时满足条件的子数组个数当然就等于窗口能所有能作为左端点的位置个数，即j-i+1。
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0,sum = 1;
        if(k <= 1) return 0;
        for (int i = 0,j = 0; j < nums.length; j++) {
            sum *= nums[j];
            while(sum >= k) sum /=nums[i++];
            ans += j-i+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        NumSubarrayProductLessThanK minSubArrayLen = new NumSubarrayProductLessThanK();
        int[] a = new int[]{10,5,2,6};
        minSubArrayLen.numSubarrayProductLessThanK(a,100);
    }

}
