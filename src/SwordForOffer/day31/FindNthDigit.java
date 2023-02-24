package SwordForOffer.day31;

//剑指 Offer 44. 数字序列中某一位的数字
public class FindNthDigit {

    //https://leetcode.cn/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/solutions/219252/mian-shi-ti-44-shu-zi-xu-lie-zhong-mou-yi-wei-de-6/
    //思路：迭代+求整/求余

    /**
     * 根据以上分析，可将求解分为三步：
     *
     * 确定 n 所在 数字 的 位数 ，记为 digit ；
     * 确定 n 所在的 数字 ，记为 num ；
     * 确定 n 是 num中的哪一数位，并返回结果。
     */
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while(n > count){
            n -= count;
            start *= 10;
            digit++;
            count = digit * start * 9;
        }
        long num = start + (n-1) / digit;
        return Long.toString(num).charAt((n-1) % digit) - '0';
    }

}
