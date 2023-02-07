package SwordForOffer.day08;

//剑指 Offer 10- II. 青蛙跳台阶问题
public class NumWays {

    public int numWays(int n) {
        if(n==0) return 1;
        if(n<0) return 0;
        int ways = (int) (numWays(n-1)%(1e9+7));
        ways += (int) (numWays(n-2)%(1e9+7));
        return ways;
    }

    public int numWays1(int n) {
        if(n==0) return 1;
        if(n<0) return 0;
        int[] dp = new int[n + 1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (int) ((dp[i-1]+dp[i-2])%(1e9+7));
        }
        return dp[n];
    }

}
