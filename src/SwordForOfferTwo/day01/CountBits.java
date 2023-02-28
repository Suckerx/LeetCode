package SwordForOfferTwo.day01;

import java.util.ArrayList;

//剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
public class CountBits {

    //暴力解法
    public int[] countBits(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            int num = 0,tmp = 1;
            for (int j = 0; j < 32; j++) {
                if((tmp & i) == 1) num++;
                tmp <<= 1;
            }
            list.add(num);
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    //动态规划——最低有效位

    /**
     * 对于正整数 x，将其二进制表示右移一位，等价于将其二进制表示的最低位去掉，得到的数是 [x/2](x/2的向下取整)
     * 如果 bits[[x/2]]已知，可以得到 bit[x]的值
     * 如果 x 是偶数，则bit[x] = bit[x/2]，奇数就还要 + 1
     * 上述两种情况可以合并
     *  由于[x/2] 可以通过 x>>1 得到，x 除以 2 的余数可以通过 x&1 得到，因此有：bits[x]=bits[x>>1]+(x&1)
     * 遍历从 1 到 n 的每个正整数 i，计算 bits的值。最终得到的数组 bits 即为答案。
     */
    public int[] countBits1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(2 & 4);
    }

}
