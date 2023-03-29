package SwordForOfferTwo.day22;

import java.util.HashMap;
import java.util.Map;

//剑指 Offer II 066. 单词之和
public class MapSum {

    private MapSum[] children;
    private boolean isEnd;
    private Map<String,Integer> map;

    /** Initialize your data structure here. */
    public MapSum() {
        children = new MapSum[26];
        this.isEnd = false;
        map = new HashMap<String,Integer>();
    }

    public void insert(String key, int val) {
        map.put(key,val);
    }

    public int sum(String prefix) {
        int res = 0;
        for (String s : map.keySet()) {
            MapSum node = new MapSum();
            node.insertTree(s,node);
            if(searchPrefix(prefix,node) != null) res += map.get(s);
        }
        return res;
    }


    /** Inserts a word into the trie. */
    public void insertTree(String word,MapSum root) {
        MapSum node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(node.children[index] == null){
                node.children[index] = new MapSum();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public MapSum searchPrefix(String word,MapSum root){
        MapSum node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(node.children[index] == null) return null;
            node = node.children[index];
        }
        return node;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        mapSum.sum("ap");           // return 3 (apple = 3)
    }

}
