package SwordForOfferTwo.day32;

//剑指 Offer II 096. 字符串交织
public class IsInterleave {

    //https://leetcode.cn/problems/IY6buf/solutions/1401991/zi-fu-chuan-jiao-zhi-by-leetcode-solutio-i4ni/?orderBy=hot
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(),n = s2.length(),t = s3.length();
        if(n + m != t) return false;
        boolean[][] dp = new boolean[m + 1][n+1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(i > 0){
                    dp[i][j] = dp[i][j] || (dp[i-1][j] && s1.charAt(i-1) == s3.charAt( i+j - 1 ));
                }
                if(j > 0){
                    dp[i][j] = dp[i][j] || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt( i+j - 1 ));
                }
            }
        }
        return dp[m][n];
    }

}
