package SwordForOffer.day29;

//剑指 Offer 19. 正则表达式匹配
public class IsMatch {

    //看自己笔记
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        char[] str = s.toCharArray();
        char[] e = p.toCharArray();
        if(!isValid(str,e)) return false;
        boolean[][] dp = initDPMap(str, e);
        for (int i = str.length-1 ; i >-1 ; i--) {
            for (int j = e.length-2 ; j >-1 ; j--) {
                if(e[j+1] != '*') dp[i][j] = (str[i] == e[j] || e[j] == '.') && dp[i+1][j+1];
                else{
                    int si = i;
                    while(si != str.length && (str[si] == e[j] || e[j] == '.')){
                        if(dp[si][j+2]){
                            dp[i][j] = true;
                            break;
                        }
                        si++;
                    }
                    if(dp[i][j]!=true) dp[i][j] = dp[si][j+2];
                }
            }
        }
        return dp[0][0];
    }

    public boolean isValid(char[] s,char[] p){
        for (int i = 0; i < s.length; i++) {
            if(s[i] == '*' || s[i] == '.') return false;
        }
        for (int i = 0; i < p.length; i++) {
            if(p[i] == '*' && (i==0 || p[i-1] == '*')) return false;
        }
        return true;
    }

    public boolean[][] initDPMap(char[] s,char[] e){
        int slen = s.length;
        int elen = e.length;
        boolean[][] dp = new boolean[slen+1][elen+1];
        dp[slen][elen] = true;
        for (int j = elen-2; j > -1; j = j - 2) {
            if(e[j] != '*' && e[j+1] == '*') dp[slen][j]=true;
            else break;
        }
        if(slen > 0 && elen > 0){
            if((e[elen-1] == '.' || s[slen-1] == e[elen-1])) dp[slen-1][elen-1] = true;
        }
        return dp;
    }

}
