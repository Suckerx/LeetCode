package SwordForOfferTwo.day06;

//剑指 Offer II 019. 最多删除一个字符得到回文
public class ValidPalindrome {

    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        int del = 0;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if(del < 2){
                    if(del == 0) right--;
                    else {
                        right++;
                        left++;
                    }
                    del ++;
                    continue;
                }
                else return false;
            }
            ++left;
            --right;
        }
        return true;
    }

}
