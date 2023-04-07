package SwordForOfferTwo.day31;

import java.util.HashMap;
import java.util.HashSet;

//剑指 Offer II 093. 最长斐波那契数列
public class LenLongestFibSubseq {

    //https://leetcode.cn/problems/Q91FMA/solutions/1654337/zui-chang-fei-bo-na-qi-shu-lie-by-leetco-0pft/
    public int lenLongestFibSubseq(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],i);
        }
        int[][] dp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i] ; j--) {
                int k = map.getOrDefault(arr[i]-arr[j],-1);
                if(k>=0) dp[j][i] = Math.max(dp[k][j] + 1,3);
                res = Math.max(res,dp[j][i]);
            }
        }
        return res;
    }

}
