package SwordForOfferTwo.day06;

//剑指 Offer II 020. 回文子字符串的个数
public class CountSubstrings {

    //暴力枚举，O(n^3)
    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <s.length() ; j++) {
                if(check(i,j,s)) ans++;
            }
        }
        return ans;
    }

    public boolean check(int left , int right,String s){
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

    /**
     * 遍历字符串，对每个字符，都看作回文的中心，向两端延申进行判断直到非回文。
     * 回文的中心可能是一个字符，也可能是两个字符。
     * 注意双指针可能越界。
     */
    public int countSubstrings2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        //字符串的每个字符都作为回文中心进行判断，中心是一个字符或两个字符
        for (int i = 0; i < s.length(); ++i) {
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i, i+1);
        }
        return count;
    }

    //从字符串的第start位置向左，end位置向右，比较是否为回文并计数
    private int countPalindrome(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
        return count;
    }

    /**
     * Manacher算法
     */
    public int countSubstrings3(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] str = manacherString(s);//添加字符
        int[] pArr = new int[str.length];//回文半径数组
        int C = -1,R = -1;//C是中心，R是右边界的再右边一个位置！最右的有效区是R - 1
        int ans = 0;
        for (int i = 0; i != str.length; ++i) {
            // i 至少的回文半径区域
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            // 中心拓展,不管哪种情况直接扩展，就算是不需要拓展的情况也会直接失败
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if(str[i + pArr[i]] == str[i - pArr[i]]) pArr[i]++;
                else break;
            }
            // 动态维护 R 和 C
            if (i + pArr[i] > R) {
                C = i;
                R = i + pArr[i];
            }
            // 统计答案, 当前贡献为 (f[i] - 1) / 2 上取整
            ans += pArr[i] / 2;
        }

        return ans;
    }

    public char[] manacherString(String str){
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

}
