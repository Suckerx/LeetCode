package Tencent50;

//122. 买卖股票的最佳时机 II
public class MaxProfit_122 {

    //动态规划
    //https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/solutions/38498/tan-xin-suan-fa-by-liweiwei1419-2/?orderBy=hot
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;//不买
        dp[0][1] = -prices[0];//买了股票,当前第0天买了股票手上剩余的现金数
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

}
