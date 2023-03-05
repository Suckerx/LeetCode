package SwordForOfferTwo.day05;

import java.util.HashSet;

//剑指 Offer II 016. 不含重复字符的最长子字符串
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int length = chars.length;
        int res = 0;
        int start = 0,end = 0;
        while(end < length){
            while(start < end && set.contains(chars[end])){
                set.remove(chars[start]);
                start++;
            }
            set.add(chars[end]);
            res = Math.max(res,end - start + 1);
            end++;
        }
        return res;
    }

}
