package SwordForOfferTwo.day11;

import SwordForOfferTwo.day09.IsPalindrome;

import java.util.ArrayList;
import java.util.HashMap;

//剑指 Offer II 034. 外星语言是否排序
public class IsAlienSorted {

    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] orders = order.toCharArray();
        for (int i = 0; i < orders.length; i++) {
            map.put(orders[i],i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            boolean flag = false;
            if(map.get(words[i].charAt(0)) < map.get(words[i+1].charAt(0))) continue;
            if(map.get(words[i].charAt(0)) > map.get(words[i+1].charAt(0))) return false;
            for (int j = 0; j < Math.min(words[i].length(),words[i+1].length()); j++) {
                int x = map.get(words[i].charAt(j));
                int y = map.get(words[i+1].charAt(j));
                if(x > y) return false;
                else if(x < y) flag = true;
            }
            if(words[i].length() > words[i + 1].length() && flag == false) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsAlienSorted isAlienSorted = new IsAlienSorted();
        ArrayList<String> list = new ArrayList<>();
        list.add("apap");
        list.add("app");
        String[] arr = list.toArray(new String[list.size()]);
        isAlienSorted.isAlienSorted(arr, "abcdefghijklmnopqrstuvwxyz");
    }

}
