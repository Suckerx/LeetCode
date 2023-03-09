package SwordForOfferTwo.day10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//剑指 Offer II 032. 有效的变位词
public class IsAnagram {

    /**
     * 对于进阶问题，Unicode\text{Unicode}Unicode 是为了解决传统字符编码的局限性而产生的方案，
     * 它为每个语言中的字符规定了一个唯一的二进制编码。而 Unicode 中可能存在一个字符对应多个字节的问题，
     * 为了让计算机知道多少字节表示一个字符，面向传输的编码方式的 UTF−8 和 UTF−16 也随之诞生逐渐广泛使用，具体相关的知识读者可以继续查阅相关资料拓展视野，这里不再展开。
     * 回到本题，进阶问题的核心点在于「字符是离散未知的」，因此我们用哈希表维护对应字符的频次即可。
     * 同时读者需要注意 Unicode 一个字符可能对应多个字节的问题，不同语言对于字符串读取处理的方式是不同的。
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] str = s.toCharArray();
        char[] ttr = t.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();//次数
        boolean x = false;//位置是否有不同
        for (int i = 0; i < str.length; i++) map.put(str[i],map.getOrDefault(str[i],0)+1);
        for (int i = 0; i < str.length; i++) {
            if(str[i] != ttr[i]) x = true;
            if(!map.containsKey(ttr[i])) return false;
            map.put(ttr[i],map.get(ttr[i])-1);
        }
        if(x == false) return false;
        for (Character character : map.keySet()) {
            if(map.get(character)!=0) return false;
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }
        Map<Character, Integer> table = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) - 1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }

}
