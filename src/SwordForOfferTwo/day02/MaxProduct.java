package SwordForOfferTwo.day02;

//剑指 Offer II 005. 单词长度的最大乘积
public class MaxProduct {

    //位运算
    public int maxProduct(String[] words) {
        int[] masks = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                masks[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if((masks[i] & masks[j]) == 0) max = Math.max(max,words[i].length() * words[j].length());
            }
        }
        return max;
    }

}
