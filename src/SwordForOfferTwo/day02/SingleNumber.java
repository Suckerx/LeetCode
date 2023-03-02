package SwordForOfferTwo.day02;

//剑指 Offer II 004. 只出现一次的数字
public class SingleNumber {

    //有限状态自动机 + 位运算
    //https://leetcode.cn/problems/WGki4K/solutions/976992/jian-zhi-offer-ii-004-zhi-chu-xian-yi-ci-l3ud/
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

}
