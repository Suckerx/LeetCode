package SwordForOffer.day13;

//剑指 Offer 58 - I. 翻转单词顺序
public class ReverseWords {

    //双指针
    public String reverseWords(String s) {
        if(s.length()==0 || s == null) return s;

        s.trim();//删除前后多余空格

        char[] chars = s.toCharArray();
        int left = chars.length-1,right = chars.length-1;
        String result = "";

        while(left>0){
            while(left > 0 && chars[left] != ' ') left--;
            if(left == 0) break;
            for (int i = left+1; i <= right; i++) {
                result+=String.valueOf(chars[i]);
            }
            result+=" ";
            left--;
            while(left > 0 && chars[left] == ' ') left--;
            right = left;
        }
        for (int i = left; i <= right ; i++) {
            result+=String.valueOf(chars[i]);
        }
        return result.trim();
    }

}
