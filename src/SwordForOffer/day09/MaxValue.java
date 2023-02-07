package SwordForOffer.day09;

//剑指 Offer 47. 礼物的最大价值
public class MaxValue {

    public int maxValue(int[][] grid) {
        if(grid==null || grid.length==0) return 0;
        return process(grid,grid.length,grid[0].length);
    }

    //递归：只需要看成两个子问题的最大值，加上最后的那个位置
    public int process(int[][] grid,int i,int j){
        if(i < 0 || j < 0) return 0;
        return Math.max(process(grid,i-1,j),process(grid,i,j-1))+grid[i][j];
    }

    //动态规划
    public int maxValue2(int[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0]=grid[0][0];

        //初始化dp的最上面一行，从左到右累加
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        //初始化dp的最左边一列，从上到下累加
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[grid.length-1][grid[0].length];
    }

}
