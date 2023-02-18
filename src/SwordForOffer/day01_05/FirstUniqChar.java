package SwordForOffer.day01_05;

import java.util.HashMap;

//剑指 Offer 50. 第一个只出现一次的字符
public class FirstUniqChar {

    public char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                Integer integer = map.get(s.charAt(i));
                map.put(s.charAt(i),integer+1);
            }
            else map.put(s.charAt(i),1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i))==1) return s.charAt(i);
        }
        return ' ';
    }

}
