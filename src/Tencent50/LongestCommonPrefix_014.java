package Tencent50;

import java.util.Arrays;
import java.util.Comparator;

//14. 最长公共前缀
public class LongestCommonPrefix_014 {

    //https://leetcode.cn/problems/longest-common-prefix/solutions/288575/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/?orderBy=hot
    //横向扫描一遍
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs == null) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix,strs[i]);
            if(prefix.length() == 0) break;
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1,String str2){
        int length = Math.min(str1.length(),str2.length());
        int index = 0;
        while(index < length && str1.charAt(index) == str2.charAt(index)) index++;
        return str1.substring(0,index);
    }

}
