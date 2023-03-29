package SwordForOfferTwo.day22;

import java.util.Arrays;

//剑指 Offer II 065. 最短的单词编码
public class MinimumLengthEncoding {

    private MinimumLengthEncoding[] children;
    private boolean isEnd;

    public MinimumLengthEncoding() {
        children = new MinimumLengthEncoding[26];
        this.isEnd = false;
    }

    public int minimumLengthEncoding(String[] words) {
        MinimumLengthEncoding node = new MinimumLengthEncoding();
        Arrays.sort(words,(o1, o2) -> o2.length() - o1.length());
        int res = 0;
        for (String word : words) {
            if(node.searchPrefix(word) != null) continue;
            else {
                node.insert(word);
                res += word.length() + 1;
            }
        }
        return res;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        MinimumLengthEncoding node = this;
        for (int i = word.length() - 1; i >= 0; i--) {
            int index = word.charAt(i) - 'a';
            if(node.children[index] == null){
                node.children[index] = new MinimumLengthEncoding();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public MinimumLengthEncoding searchPrefix(String word){
        MinimumLengthEncoding node = this;
        for (int i = word.length() - 1; i >= 0; i--) {
            int index = word.charAt(i) - 'a';
            if(node.children[index] == null) return null;
            node = node.children[index];
        }
        return node;
    }

}
