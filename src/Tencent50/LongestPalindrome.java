package Tencent50;

//5. 最长回文子串
public class LongestPalindrome {

    //https://leetcode.cn/problems/longest-palindromic-substring/solutions/255195/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/?orderBy=hot
    //动态规划  dp[i][j] = dp[i+1][j-1] && i == j
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2) return s;
        int maxLen = 1;
        int begin = 0;

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] str = s.toCharArray();

        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                int j = i + L - 1;
                if(j >= len) break;

                if(str[i] != str[j]) dp[i][j] = false;
                else{
                    if(j - i < 3) dp[i][j] = true;
                    else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if(dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }

            }
        }
        return s.substring(begin,begin + maxLen);
    }

}
