package SwordForOfferTwo.day21;

//剑指 Offer II 064. 神奇的字典
public class MagicDictionary {
    //使用字典树优化枚举
    //https://leetcode.cn/problems/US1pGT/solutions/1656424/shen-qi-de-zi-dian-by-leetcode-solution-uvh3/

    private MagicDictionary[] children;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        children = new MagicDictionary[26];
        this.isEnd = false;
    }

    public void buildDict(String[] dictionary) {
        MagicDictionary node = this;
        for (String s : dictionary) {
            this.insert(s);
        }
    }

    public boolean search(String searchWord) {
        return searchPrefixDFS(searchWord,this,0,false);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        MagicDictionary node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(node.children[index] == null){
                node.children[index] = new MagicDictionary();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean searchPrefixDFS(String word,MagicDictionary node,int pos,boolean modified){
        if(pos == word.length()) return modified && node.isEnd;
        int index = word.charAt(pos) - 'a';
        if(node.children[index] != null){
            if(searchPrefixDFS(word,node.children[index],pos + 1,modified)) return true;
        }
        if(!modified){
            for (int i = 0; i < 26; i++) {
                if(i != index && node.children[i] != null){
                    if(searchPrefixDFS(word,node.children[i],pos + 1,true))
                        return true;
                }
            }
        }
        return false;
    }

}
