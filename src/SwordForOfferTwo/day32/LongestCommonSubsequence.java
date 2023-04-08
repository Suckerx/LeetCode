package SwordForOfferTwo.day32;

//剑指 Offer II 095. 最长公共子序列
public class LongestCommonSubsequence {

    //https://leetcode.cn/problems/qJnOS7/solutions/1025575/zui-chang-gong-gong-zi-xu-lie-by-leetcod-ugg7/?orderBy=hot
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(),n = text2.length();
        int[][] dp = new int[m +  1][n + 1];
        for (int i = 1; i <= m; i++) {
            int c1 = text1.charAt(i-1);
            for (int j = 1; j <= n; j++) {
                int c2 = text2.charAt(j-1);
                if(c1 == c2) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][n];
    }

}
