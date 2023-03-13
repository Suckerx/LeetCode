package SwordForOfferTwo.day11;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.lang.reflect.Array;
import java.util.*;

//剑指 Offer II 033. 变位词组
public class GroupAnagrams {

    //排序 + 哈希表
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0 || strs == null) return new ArrayList<List<String>>();
        HashMap<String,Integer> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        int i = 0;
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(!map.containsKey(key)) {
                map.put(key,i);
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                res.add(list);
                i++;
            }else{
                res.get(map.get(key)).add(str);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> res = new ArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("111");
        res.add(arrayList);
        res.get(0).add("222");
        System.out.println(res);
    }

}
