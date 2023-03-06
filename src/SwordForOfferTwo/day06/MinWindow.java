package SwordForOfferTwo.day06;

import java.util.HashMap;

//剑指 Offer II 017. 含有所有字符的最短字符串
public class MinWindow {

    /**
     * 题解思路：利用双指针找到以下标right结尾，且含有t所有字符的最小长度区间[left,right].
     * 定义两个数组 cnt1与cnt2，将字母转化成数字，并以此为下标，出现次数作为值存进数组中，
     * 当cnt2[n]>=cnt1[n]，也就是cnt2中 n 所代表的字符出现次数，比cnt1中 n 所代表的字符出现次数多或相等，也就是含有。
     */
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        int left = 0,min = Integer.MAX_VALUE;
        String res = "";
        //cnt1为t的数组，cnt2为s的数组
        int[] cnt1 = new int[60];
        int[] cnt2 = new int[60];

        for (int i = 0; i < t.length(); i++) {
            cnt1[t.charAt(i) - 'A']++;
        }
        //diff标记不同，当为0时代表已找到
        int diff = 0;
        for (int i : cnt1) {
            if(i != 0) diff++;
        }
        //left，right双指针
        for (int right = 0; right < s.length(); right++) {
            //cnt2[x]++后如果等于cnt1[x],代表字符 * 已全部找到
            int x = s.charAt(right) - 'A';
            cnt2[x]++;
            if(cnt1[x] == cnt2[x]) diff--;

            while(diff == 0){
                //对比赋值res
                int l = right - left + 1;
                if(l < min){
                    min = l;
                    res = s.substring(left,right + 1);
                }
                //cnt1[y]!=0表示 t 含有此字符
                //只要cnt2[y]的值不小于cnt1[y]，那么结果不影响
                //如果小于则diff++;
                int y = s.charAt(left) - 'A';
                cnt2[y] -- ;
                if(cnt1[y]!=0 && cnt2[y] < cnt1[y]) diff++;
                left ++;
            }
        }
        return res;
    }

}
