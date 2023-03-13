package SwordForOfferTwo.day12;

import java.util.*;

//dailyTemperatures
public class DailyTemperatures {

    //https://leetcode.cn/problems/iIQa4I/solutions/995032/shua-chuan-jian-zhi-offer-day18-zhan-ii-mdv06/
    //单调栈问题
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }

    //动态规划
    /**
     *  用dp[k]表示第k个元素到右侧第一个比他大的温度的距离
     * 当查找i的右侧温度时，如果i+1的温度比i的大，就直接找到了；
     * 否则，就根据dp[i+1]快速跳转到下一个位置，然后循环，直到跳到一个比i大的温度，或者dp为0的温度（表示右边已经没有更大的温度了）
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        int[] dp = new int[temperatures.length];
        dp[dp.length - 1] = 0;
        for (int i = dp.length-2; i >=0 ; i--) {
            int nextIdx = i + 1;
            while(true){
                if(temperatures[nextIdx] > temperatures[i]) {
                    dp[i] = nextIdx - i;
                    break;
                }
                else if(dp[nextIdx] == 0){
                    dp[i] = 0;
                    break;
                }
                nextIdx = nextIdx + dp[nextIdx];
            }
        }
        return dp;
    }

}
