package SwordForOfferTwo.day31;

import java.util.Arrays;

//剑指 Offer II 091. 粉刷房子
public class MinCost {

    //https://leetcode.cn/problems/JEj789/solutions/1621250/fen-shua-fang-zi-by-leetcode-solution-q0kh/
    public int minCost(int[][] costs) {
        int[] dp = new int[3];
        for (int i = 0; i < 3; i++) {
            dp[i] = costs[0][i];
        }
        for (int i = 1; i < costs.length ; i++) {
            int[] newDp = new int[3];
            for (int j = 0; j < 3; j++) {
                newDp[j] = Math.min(dp[(j+1) % 3],dp[(j + 2) % 3]) + costs[i][j];
            }
            dp = newDp;
        }
        return Arrays.stream(dp).min().getAsInt();
    }

}
