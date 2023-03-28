package SwordForOfferTwo.day21;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//剑指 Offer II 063. 替换单词
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Collections.sort(dictionary);
        String[] str = sentence.split(" ");
        for (int i = 0; i < str.length; i++) {
            Trie trie = new Trie();
            trie.insert(str[i]);
            for (String s : dictionary) {
                if(trie.startsWith(s)) {
                    str[i] = s;
                    break;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length-1; i++) {
            stringBuilder.append(str[i] + " ");
        }
        stringBuilder.append(str[str.length - 1]);
        return stringBuilder.toString();
    }

    class Trie {

        private Trie[] children;
        private boolean isEnd;

        /** Initialize your data structure here. */
        public Trie() {
            children = new Trie[26];
            this.isEnd = false;
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if(node.children[index] == null){
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node!=null && node.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        public Trie searchPrefix(String word){
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if(node.children[index] == null) return null;
                node = node.children[index];
            }
            return node;
        }

    }

    //哈希集合方法

    /**
     * 首先将 dictionary 中所有词根放入哈希集合中，然后对于 sentence 中的每个单词，
     * 由短至长遍历它所有的前缀，如果这个前缀出现在哈希集合中，则我们找到了当前单词的最短词根，
     * 将这个词根替换原来的单词。最后返回重新拼接的句子。
     */
    public String replaceWords2(List<String> dictionary, String sentence) {
        Set<String> dictionarySet = new HashSet<String>();
        for (String root : dictionary) {
            dictionarySet.add(root);
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if (dictionarySet.contains(word.substring(0, 1 + j))) {
                    words[i] = word.substring(0, 1 + j);
                    break;
                }
            }
        }
        return String.join(" ", words);
    }
}
