package SwordForOfferTwo.day05;

import java.util.HashMap;

//剑指 Offer II 014. 字符串中的变位词
public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        boolean res = true;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            map.put(chars1[i],map.getOrDefault(chars1[i],0)+1);
        }
        for (int i = 0; i < chars2.length- chars1.length + 1; i++) {
            res = true;
            HashMap<Character, Integer> tmpMap = new HashMap<>();
            for (Character character : map.keySet()) {
                tmpMap.put(character,map.get(character));
            }
            for (int j = i; j < i + chars1.length; j++) {
                if(!tmpMap.containsKey(chars2[j])) {
                    res = false;
                    break;
                }
                tmpMap.put(chars2[j],tmpMap.get(chars2[j])-1);
            }
            if(!res) continue;
            for (Character c : tmpMap.keySet()) {
                if(tmpMap.get(c)!=0) {
                    System.out.println("i = " +i);
                    System.out.println(c + " " +tmpMap.get(c));
                    res = false;
                    System.out.println(res);
                }
            }
            if(res) break;
        }
        return res;
    }

    public static void main(String[] args) {
        CheckInclusion checkInclusion = new CheckInclusion();
        System.out.println(checkInclusion.checkInclusion("adc", "dcda"));
    }

}
