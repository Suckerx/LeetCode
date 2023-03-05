package SwordForOfferTwo.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//剑指 Offer II 015. 字符串中的所有变位词
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        List<Integer> list = new ArrayList<Integer>();
        if (p.length() > s.length()) {
            return list;
        }
        for (int i = 0; i < p.length(); i++) {
            arr1[p.charAt(i) - 'a']++;
            arr2[s.charAt(i) - 'a']++;
        }
        for (int i = p.length(); i < s.length() ; i++) {
            if (Arrays.equals(arr1, arr2)) {
                if(i == p.length()) list.add(0);
                else list.add(i-p.length() + 1);
            }
            arr2[s.charAt(i - p.length()) - 'a'] --;
            arr2[s.charAt(i) - 'a'] ++;
        }
        if(Arrays.equals(arr1, arr2)) list.add(s.length() - p.length() + 1);
        return list;
    }

    public static void main(String[] args) {
        FindAnagrams F = new FindAnagrams();
        F.findAnagrams("cbaebabacd","abc");
    }

}
