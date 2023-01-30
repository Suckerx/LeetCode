package SwordForOffer;

// 剑指 Offer 58 - II. 左旋转字符串
public class ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        String subStart = s.substring(0,n);
        String subEnd = s.substring(n,s.length());
        String result = subEnd+subStart;
        return result;
    }

}
