package Tencent50;

//70. 爬楼梯
public class ClimbStairs_070 {

    public int res = 0;

    public int climbStairs(int n) {
        process(n);
        return res;
    }

    public void process(int n){
        if(n == 0) res++;
        if(n - 1 >= 0) process(n - 1);
        if(n - 2 >= 0) process(n - 2);
    }

    //动态规划
    public int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
