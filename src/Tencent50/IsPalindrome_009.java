package Tencent50;

//9. 回文数
public class IsPalindrome_009 {

    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int left = 0,right = str.length() - 1;
        while(left<right){
            if(str.charAt(left) != str.charAt(right)) return false;
            left ++;
            right --;
        }
        return true;
    }

}
