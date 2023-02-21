package SwordForOffer.day24;

//剑指 Offer 14- I. 剪绳子
public class CuttingRope {

    //归纳证明法
    //https://leetcode.cn/problems/jian-sheng-zi-lcof/solutions/1794015/jian-sheng-zi-by-leetcode-solution-xku9/
    public int cuttingRope(int n) {
        if(n <= 3) return n-1;
        if(n % 3 == 0) return (int) Math.pow(3,n/3);
        if(n % 3 == 1) return (int) (Math.pow(3,n/3-1)*4);
        return (int) (Math.pow(3,n/3)*2);
    }

    //动态规划思想：
    /**
     * 这道题给定一个大于 1 的正整数 n，要求将 n 拆分成至少两个正整数的和，并使这些正整数的乘积最大化，返回最大乘积。
     *
     * 令 x 是拆分出的第一个正整数，则剩下的部分是 n−x，n−x可以不继续拆分，或者继续拆分成至少两个正整数的和。
     * 由于每个正整数对应的最大乘积取决于比它小的正整数对应的最大乘积，因此可以使用动态规划求解。
     *
     * 创建数组 dp，其中 dp[i]表示将正整数 i 拆分成至少两个正整数的和之后，这些正整数的最大乘积。
     * 特别地，0 不是正整数，1 是最小的正整数，0 和 1 都不能拆分，
     * 因此 dp[0]=dp[1]=0
     *
     * 当 i≥2时，假设对正整数 i 拆分出的第一个正整数是 j, 1≤j<i），则有以下两种方案：
     * 将 i 拆分成 j 和 i−j 的和，且 i−j 不再拆分成多个正整数，此时的乘积是 j×(i−j)；
     *
     * 将 i 拆分成 j 和 i−j 的和，且 i−j 继续拆分成多个正整数，此时的乘积是 j×dp[i−j]。
     * 因此，当 j 固定时，有 dp[i]=max(j×(i−j),j×dp[i−j])
     * 由于 j 的取值范围是 1 到 i−1 需要遍历所有的 j 得到 dp[i] 的最大值
     */
    public int cuttingRope1(int n) {
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(max,Math.max(j*(i-j),j*dp[i-j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }

}
