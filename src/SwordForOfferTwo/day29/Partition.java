package SwordForOfferTwo.day29;

import java.util.ArrayList;
import java.util.List;

//剑指 Offer II 086. 分割回文子字符串
public class Partition {

    private List<List<String>> res = new ArrayList<>();
    private List<String> path = new ArrayList<>();
    private String s;

    //https://leetcode.cn/problems/M99OJA/solutions/2156948/hui-su-bu-hui-xie-tao-lu-zai-ci-pythonja-q1yu/
    public String[][] partition(String s) {
        this.s = s;
        dfs(0,0);
        String[][] ans = new String[res.size()][];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i).toArray(new String[res.get(i).size()]);
        }
        return ans;
    }

    private boolean isPalindrome(int left, int right) {
        while (left < right)
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        return true;
    }

    public void dfs(int i,int start){
        if(i == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        if(i < s.length() - 1) dfs(i+1,start);
        if(isPalindrome(start,i)){
            path.add(s.substring(start,i+1));
            dfs(i + 1,i + 1);
            path.remove(path.size() - 1);
        }
    }

}
