package SwordForOfferTwo.day31;

//剑指 Offer II 092. 翻转字符
public class MinFlipsMonoIncr {

    //https://leetcode.cn/problems/cyJERH/solutions/1592231/fan-zhuan-zi-fu-by-leetcode-solution-qkbu/
    public int minFlipsMonoIncr(String s) {
        int[][] dp = new int[s.length() + 1][2];
        dp[0][0] = dp[0][1] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = s.charAt(i-1) == '0' ? dp[i-1][0] : dp[i-1][0] + 1;
            dp[i][1] = s.charAt(i-1) == '1' ? Math.min(dp[i-1][1],dp[i-1][0]) : Math.min(dp[i-1][1],dp[i-1][0]) + 1;
        }
        return Math.min(dp[dp.length - 1][0],dp[dp.length - 1][1]);
    }

    //优化空间复杂度
    public int minFlipsMonoIncr2(String s) {
        int dp0 = 0,dp1 = 0;
        for (int i = 1; i < s.length(); i++) {
            int dp0New = dp0,dp1New = dp1;
            dp0New = s.charAt(i-1) == '0' ? dp0New : dp0New + 1;
            dp1New = s.charAt(i-1) == '1' ? Math.min(dp0New,dp1New) : Math.min(dp1New,dp0New) + 1;
            dp0 = dp0New;
            dp1 = dp1New;
        }
        return Math.min(dp0,dp1);
    }

}
