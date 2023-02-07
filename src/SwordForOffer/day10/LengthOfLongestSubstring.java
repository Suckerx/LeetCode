package SwordForOffer.day10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//剑指 Offer 48. 最长不含重复字符的子字符串
public class LengthOfLongestSubstring {

    //暴力
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 1;
        int max = 1;
        if(s.length()==1) return 1;
        if(s == null) return 0;

        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            map.put(s.charAt(i),1);
            int size = 1;
            for (int j = i+1; j <s.length() ; j++) {
                if(map.containsKey(s.charAt(j))) break;
                map.put(s.charAt(j),1);
                size++;
            }
            max = size > max ? size : max;
        }
        return max;
    }

    //滑动窗口
    public int lengthOfLongestSubstring2(String s) {
        int right = 1;
        int max = 1;
        HashSet<Character> map = new HashSet<>();

        if(s.length()==1) return 1;
        if(s.length() == 0) return 0;

        map.add(s.charAt(0));

        for (int i = 0; i < s.length(); i++) {
            if(i != 0) map.remove(s.charAt(i-1));
            while(right < s.length() && !map.contains(s.charAt(right))){
                map.add(s.charAt(right));
                right++;
            }
            max = Math.max(max,right-i);
        }
        return max;
    }

    //动态规划
    public int lengthOfLongestSubstring3(String s) {
        int tmp = 0,res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            int i = map.getOrDefault(s.charAt(j), -1);// 获取索引 i
            map.put(s.charAt(j),j);// 更新哈希表
            tmp = tmp < j-i ? tmp+1 : j-i; // dp[j - 1] -> dp[j]
            res = Math.max(tmp,res);// max(dp[j - 1], dp[j])
        }
        return res;
    }


    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        lengthOfLongestSubstring.lengthOfLongestSubstring2("au");
    }

}
