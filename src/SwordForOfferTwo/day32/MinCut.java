package SwordForOfferTwo.day32;

//剑指 Offer II 094. 最少回文分割
public class MinCut {

    //https://leetcode.cn/problems/omKAoA/solutions/1233796/javadong-tai-gui-hua-hui-wen-zi-chuan-yu-67mw/?orderBy=hot&languageTags=java
    public int minCut(String s) {
        int n = s.length();
        boolean[][] check = new boolean[n][n];
        for (int right = 0; right < n; right++) {
            for (int left = 0; left <= right; left++) {
                if(s.charAt(left) == s.charAt(right) && (right - left < 2 || check[left + 1][right - 1]) ){
                    check[left][right] = true;
                }
            }
        }

        int[] dp = new int[n + 1];
        dp[0] = -1;
        for (int i = 0; i <= n; i++) {
            dp[i] = i - 1;
            for (int j = 0; j < i; j++) {
                if(check[j][i-1]){
                    dp[i] = Math.min(dp[i],dp[j] + 1);
                }
            }
        }
        return dp[n];
    }

}
